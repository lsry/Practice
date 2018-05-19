;recursion
(define (f n)
  (if (< n 3) n 
      (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))  
  )
)

;iter
(define (f1 n)
  (define (f0 x y z s)
    (cond ((= s 0) x)
          ((= s 1) y)
	  ((= s 2) z)
          (else (f0 y z (+ (* 3 x) (* 2 y) z) (- s 1)))
    )
  )
  (f0 0 1 2 n)
)
