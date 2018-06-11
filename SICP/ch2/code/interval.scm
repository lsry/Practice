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

(define (print-interval i)
  (newline)
  (display "[")
  (display (lower-bound i))
  (display " ")
  (display (high-bound i))
  (display "]")
)


(define (make-center-width c w)
  (make-interval (- c w) (+ c w))
)

(define (center i)
  (/ (+ (lower-bound i) (high-bound i)) 2.0)
)

(define (width i)
  (/ (- (high-bound i) (lower-bound i)) 2.0)
)

; 2.12 p%
(define (make-center-percent c p)
  (let ((w (* c (/ p 100)))) 
    (make-center-width c w)
  )
)

(define (percent i)
  (let ((c (center i)) (w (width i))) (* 100 (/ w c)))
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

; 2.11
(define (mul2-interval i1 i2)
  (define (sign-interval i)
    (cond ((or (< (high-bound i) 0)  (= (high-bound i) 0)) -1)
          ((or (> (lower-bound i) 0) (= (lower-bound i) 0)) 1)
          (else 0)
    )
  )
  
  (let ((p1 (sign-interval i1)) (p2 (sign-interval i2))
        (i1-l (lower-bound i1)) (i1-h (high-bound i1))
        (i2-l (lower-bound i2)) (i2-h (high-bound i2))
       ) 
       (cond ((= p1 1)  (cond ((= p2 1)  (make-interval (* i1-l i2-l) (* i1-h i2-h)))
                              ((= p2 0)  (make-interval (* i1-h i2-l) (* i1-h i2-h)))
                              ((= p2 -1) (make-interval (* i1-h i2-l) (* i1-l i2-h)))
                        )
             )
             ((= p1 0)  (cond ((= p2 1)  (make-interval (* i1-l i2-h) (* i1-h i2-h)))
                              ((= p2 0)  (make-interval (* i1-l i2-h) (* i1-h i2-h)))
                              ((= p2 -1) (make-interval (* i1-h i2-l) (* i1-l i2-l)))
                        )
             )
             ((= p1 -1) (cond ((= p2 1)  (make-interval (* i1-l i2-h) (* i1-h i2-l)))
                              ((= p2 0)  (make-interval (* i1-l i2-h) (* i1-l i2-l)))
                              ((= p2 -1) (make-interval (* i1-h i2-h) (* i1-l i2-l)))
                        )            
             )
       )
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

(define a (make-center-percent 6.8 10))

