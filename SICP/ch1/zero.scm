; zero-point 
(define (half-zero f a b)
  (define (search f neg pos)
    (define (average x y)
      (/ (+ x y) 2.0)
    )
  
    (define (abs x)
      (if (< x 0) (- 0 x) x)
    )
  
	  (define (close-enough? x y)
	    (< (abs (- x y)) 0.001)
	  )
	

    (let ((mid-point (average neg pos))) 
	    (if (close-enough? neg pos) mid-point
		    (let ((test-value (f mid-point))) 
			    (cond ((> test-value 0) (search f neg mid-point))
				    ((< test-value 0) (search f mid-point pos))
					  (else mid-point)
			    )
		    )
	    )
    )
  )

  (let ((a-value (f a)) (b-value (f b))) 
	  (cond ((and (< a-value 0) (> b-value 0)) (search f a b))
		  ((and (< b-value 0) (> a-value 0)) (search f b a))
			(else (error "values are not of opposite sign" a b))
	  )
  )
)
