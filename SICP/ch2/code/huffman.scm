(define (make-leaf symbol weight)
  (list 'leaf symbol weight)
)

(define (leaf? ob)
  (eq? (car ob) 'leaf)
)

(define (symbol-leaf ob)
  (cadr ob)
)

(define (weight-leaf ob)
  (caddr ob)
)

(define (make-code-tree left right)
  (list left right (append (symbols left) (symbols right)) (+ (weight left) (weight right)))
)

(define (left-branch tree)
  (car tree)
)

(define (right-branch tree)
  (cadr tree)
)

(define (symbols tree)
  (if (leaf? tree) (list (symbol-leaf tree)) (caddr tree))
)

(define (weight tree)
  (if (leaf? tree) (weight-leaf tree) (cadddr tree))
)

(define (decode bits tree)
  (define (decode-1 bits current-branch)
    (if (null? bits) '()  
        (let ((next-branch (choose-branch (car bits) current-branch))) 
             (if (leaf? next-branch)
                 (cons (symbol-leaf next-branch) (decode-1 (cdr bits) tree))
                 (decode-1 (cdr bits) next-branch)
             )
        )
    )
  )
  (decode-1 bits tree)
)

(define (choose-branch bit branch)
  (cond ((= bit 0) (left-branch branch))
        ((= bit 1) (right-branch branch))
        (else (error "bad bit -- CHOOSE-BRANCH" bit))       
  )
)

(define (adjoin-set x set)
  (cond ((null? set) (list x))
        ((< (weight x) (weight (car set))) (cons x set))
        (else (cons (car set) (adjoin-set x (cdr set))))      
  )
)

(define (make-leaf-set pairs)
  (if (null? pairs) '()
      (let ((pair (car pairs))) 
           (adjoin-set (make-leaf (car pair) (cadr pair))
                       (make-leaf-set (cdr pairs))
           )
      )
  )
)

; 2.67    
(define sample-tree 
  (make-code-tree (make-leaf 'A 4)  
    (make-code-tree (make-leaf 'B 2)
      (make-code-tree (make-leaf 'D 1) (make-leaf 'C 1))
    )
  )
)

(define sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

; 2.68
(define (encode message tree)
  (define (in-list? x ls)
    (cond ((null? ls) #f)
          ((equal? x (car ls)) #t)
          (else (in-list? x (cdr ls)))
    )
  )
  
  (define (encode-symbol mes tr)
    (cond ((and (leaf? tr) (eq? mes (symbol-leaf tr))) (list 0))
          ((leaf? tr) '())
          (else (let ((left (left-branch tr)) (right (right-branch tr))) 
                     (cond ((and (leaf? left) (eq? mes (symbol-leaf left))) (list 0))
                           ((and (leaf? right) (eq? mes (symbol-leaf right))) (list 1))
                           ((and (not (leaf? left)) (in-list? mes (symbols left))) 
                            (cons 0 (encode-symbol mes left))
                           )
                           ((and (not (leaf? right)) (in-list? mes (symbols right))) 
                            (cons 1 (encode-symbol mes right))
                           )
                           (else (error "NOT EXIST MES" mes))                         
                     )
                )
          )
    )
  )
  
  (if (null? message) '()
      (append (encode-symbol (car message) tree)
              (encode (cdr message) tree)
      )
  )
)

; 2.69
(define (generate-huffman-tree pairs)
  (define (successive-merge prs)
    (cond ((null? prs) '())
          ((null? (cdr prs)) prs)
          ((null? (cdr (cdr prs))) (make-code-tree (car prs) (cadr prs)))
          (else (let ((wet1 (weight (car prs)))
                      (wet2 (weight (cadr prs)))
                      (wet3 (weight (caddr prs)))
                     ) 
                     (if (> (+ wet1 wet2) wet3)
                         (successive-merge (cons (make-code-tree (cadr prs) (caddr prs))
                                             (cons (car prs) (cdr (cdr (cdr prs))))
                                           )
                         )
                         (successive-merge (cons (make-code-tree (car prs) (cadr prs)) (cdr (cdr prs))))
                     )
                )
          )  
    )
  )
  
  (successive-merge (make-leaf-set pairs))
)

(define x '((A 4) (B 2) (C 1) (D 1)))

; 2.70
(define song '((A 2) (NA 16) (BOOM 1) (SHA 3) (GET 2) (YIP 9) (JOB 2) (WAH 1))) 

(length (encode '(get a job 
                 sha na na na na na na na na 
                 get a job 
                 sha na na na na na na na na 
                 wah yip yip yip yip yip yip yip yip yip 
                 sha boom)
                 (generate-huffman-tree song)
       )                 
)