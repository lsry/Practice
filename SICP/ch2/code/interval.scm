; 2.7 
(define (make-interval x y)
  (cons x y)
)

(define (lower-bound i)
  (car i)
)

(define (high-bound i)
  (cdr i)
)

(define (add-interval i1 i2)
  (make-interval (+ (lower-bound i1) (lower-bound i2)) (+ (high-bound i1) (high-bound i2)))
)

; 2.8 
(define (sub-interval i1 i2)
  (make-interval 
    (- (lower-bound i1) (high-bound i2))
    (- (high-bound i1) (lower-bound i2))
  )
)

; 2.9  
(define (width-interval i)
  (- (cdr i) (car i))
)

; 2.10
(define (mul1-interval i1 i2)
  (let 
    ((p1 (* (lower-bound i1) (lower-bound i2)))
     (p2 (* (lower-bound i1) (high-bound i2)))
     (p3 (* (high-bound i1) (lower-bound i2)))
     (p4 (* (high-bound i1) (high-bound i2)))
    ) 
    (make-interval (min p1 p2 p3 p4) (max p1 p2 p3 p4))
  )
)

(define (div-interval i1 i2)
  (if (or (< (lower-bound i2) 0) (= 0 (lower-bound i2)))
      (error "dividing crossing 0 interval, = " i2)
      (mul1-interval i1
        (make-interval (/ 1.0 (high-bound i2)) (/ 1.0 (lower-bound i2)))
      )
  ) 
)

(define a (make-interval 2 3))
(define b (make-interval -1 2))
(define c (make-interval 2 4))

