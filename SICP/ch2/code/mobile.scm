; 2.29   
(define (make-mobile left right)
  (list left right)
)

(define (make-branch lengths struc)
  (list lengths struc)
)

; a 
(define (left-branch mo)
  (car mo)
)

(define (right-branch mo)
  (car (cdr mo))
)

(define (branch-length mo)
  (car mo)
)

(define (branch-struc mo)
  (if (pair? (cdr mo)) (car (cdr mo)) (cdr mo))
)

; b 
(define (total-weight mo)
  (cond ((null? mo) 0)
  )
)

