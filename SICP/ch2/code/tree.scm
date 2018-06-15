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


(define x (list (list 1 2) (list 3 4)))
