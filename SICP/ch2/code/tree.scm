(define (count-leaves tree)
  (cond ((null? tree) 0)
        ((not (pair? tree)) 1)
        (else (+ (count-leaves (car tree)) (count-leaves (cdr tree))))
  )
)

; 2.27
(define (deep-reverse tree)
  (cond ((null? tree) ())
        ((not (pair? tree)) tree)
        ((and (not (null? (car tree))) (not (null? (cdr tree))))
         (list (deep-reverse (cdr tree)) (deep-reverse (car tree)))
        )
        ((null? (cdr tree)) (deep-reverse (car tree)))
  )
)

; 2.28
(define (fringex tree)
  (cond ((null? tree) ())
        ((not (pair? tree)) (list tree))
        ((and (not (null? (car tree))) (not (null? (cdr tree)))) 
         (append (fringex (car tree)) (fringex (cdr tree)))
        )
        ((null? (cdr tree)) (fringex (car tree)))
  )
)

(define (scale-tree1 tree fac)
  (cond ((null? tree) tree)
        ((not (pair? tree)) (* tree fac))
        (else (cons (scale-tree1 (car tree) fac) (scale-tree1 (cdr tree) fac)))
  )
)

(define (scale-tree2 tree fac)
  (map (lambda (sub-tree) (if (pair? sub-tree) (scale-tree2 sub-tree fac) (* fac sub-tree)))
       tree
  )
)

; 2.30 
(define (square-tree tree)
  (map (lambda (sub-tree) (if (pair? sub-tree) (square-tree sub-tree) (* sub-tree sub-tree)))
       tree
  )
)

; 2.31 
(define (tree-map1 proc tree)
  (map (lambda (sub-tree) (if (pair? sub-tree) (tree-map1 proc sub-tree) (proc sub-tree)))
       tree
  )
)

; 2.32  
(define (subsets s)
  (if (null? s) (list '()) 
      (let ((rest (subsets (cdr s)))) 
           (append rest 
             (map (lambda (sub) (cons (car s) sub)) rest)
           )
      )
  )
)


(define x (list 1 (list 2 (list 3 4) 5) (list 6 7)))

(subsets (list 1 2 3))