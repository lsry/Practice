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

(define (branch-length bn)
  (car bn)
)

(define (branch-struc bn)
  (car (cdr bn))
)

; b 
(define (total-weight mo)
  (cond ((null? mo) 0)
        ((not (pair? mo)) mo)
        (else (+ (* (branch-length (left-branch mo)) (total-weight (branch-struc (left-branch mo))))
                 (* (branch-length (right-branch mo)) (total-weight (branch-struc (right-branch mo))))
              )
        )
  )
)

; c 
(define (balance? mo)
  (define (branch-weight bn)
    (* (branch-length bn) 
       (if (pair? (branch-struc bn)) (total-weight (branch-struc bn)) (branch-struc bn))
    )
  )
  (if (null? mo) #t
      (and (= (branch-weight (left-branch mo)) (branch-weight (right-branch mo))) 
           (if (pair? (branch-struc (left-branch mo))) (balance? (branch-struc (left-branch mo))) #t)
           (if (pair? (branch-struc (right-branch mo))) (balance? (branch-struc (right-branch mo))) #t)      
      )      
  )
)

; d   
(define (make-mobile2 left right)
  (cons left rgiht)
)

(define (make-branch2 lengths struc)
  (cons lengths struc)
)

; a 
(define (left-branch2 mo)
  (car mo)
)

(define (right-branch2 mo)
  (cdr mo)
)

(define (branch-length2 bn)
  (car bn)
)

(define (branch-struc2 bn)
  (cdr bn)
)

(define x (make-mobile (make-branch 2 3) (make-branch 4 5))) 
(define y (make-mobile (make-branch 2 6) (make-branch 4 3)))
(define z (make-mobile (make-branch 4 (make-mobile (make-branch 2 4) (make-branch 1 8))) (make-branch 8 8)))