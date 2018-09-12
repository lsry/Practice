(define (append-old x y)
  (if (null? x) y
      (cons (car x) (append-old (cdr x) y))
  )
)

(define (append-new! x y)
  (set-cdr! (last-pair1 x) y)
)

(define (last-pair1 x)
  (if (null? (cdr x)) x
      (last-pair1 (cdr x))
  )
)

(define (make-cycle x)
  (set-cdr! (last-pair x) x)
)

(define (mystery x)
  (define (loop x y)
    (if (null? x) y
        (let ((temp (cdr x))) 
             (set-cdr! x y)
             (loop temp x)
        )
    )
  )
  (loop x '())
)

; 3.16
(define (count-pairs x)
  (if (not (pair? x)) 0
      (+ (count-pairs (car x)) (count-pairs (cdr x)) 1)
  )
) 
; 3   
(define s1 (list 'a 'b 'c))
; 4 
(define  m (cons 'a 'b))
(define  m1 (cons 'a m))
(define s2 (cons m1 m))
; 7 
(define t (cons 'a 'b))
(define t1 (cons t t))
(define s3 (cons t1 t1))
; maxmum depth recursion  
(define s4 (list 'a 'b 'c))
(make-cycle s4)

; 3.17  
(define (count-pairs-true ls)
  (define (add-cons x lis)
    (if (and (pair? x) (not (memq x lis)))
        (add-cons (car x) (add-cons (cdr x) (cons x lis)))
        lis
    )
  )
  (length (add-cons ls '()))
)

; 3.18
(define (is-cycle ls)
   (define me-ls '())
   (define (add-ls lis)
     (cond ((null? lis) #f)
           ((not (pair? lis)) #f)
           ((memq lis me-ls) #t)
           (else (begin (set! me-ls (cons lis me-ls)) (or (add-ls (car lis)) (add-ls (cdr lis)) #f)))
     )
   )
   (add-ls ls)
)

; 3.19  
(define (is-cycle2 ls)
  (define (walk num ls)
    (cond ((null? ls) '())
          ((= 0 num) ls)
          (else (walk (- num 1) (cdr ls)))
    )
  )
  
  (define (run ls1 ls2)
    (let ((p1 (walk 1 ls1))
          (p2 (walk 2 ls2))
         ) 
         (cond ((or (null? p1) (null? p2)) #f)
               ((eq? p1 p2) #t)
               (else (run p1 p2))
         ) 
     )
  )
  (run ls ls)
)

(define (my-cons x y)
  (define (set-x! v)
    (set! x v)
  )
  (define (set-y! v)
    (set! y v)
  )
  (define (dispatch m)
    (cond ((eq? m 'cxr) x)
          ((eq? m 'cyr) y)
          ((eq? m 'set-x!) set-x!)
          ((eq? m 'set-y!) set-y!)
          (else (error "WRONG -- DISPATCH" m))
    )
  )
  dispatch
)

(define (cxr z)
  (z 'cxr) 
)

(define (cyr z)
  (z 'cyr)
)

(define (set-x! z v)
  ((z 'set-x!) v)
)

(define (set-y! z v)
  ((z 'set-y!) v)
)
