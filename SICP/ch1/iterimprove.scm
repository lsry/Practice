; 1.46
(define (iter-improve enough next)
  (lambda (guess) (if (enough guess (next guess)) guess 
	                   ((iter-improve enough next) (next guess))
									)
	)
)

(define (sqrt x)
  (define tolerance 0.000001)
	(define (abs y)
    (cond ((< y 0) (- 0 y))
      (else y)
    )
  )
  (define (close-enough? v1 v2)
    (if (< (/ (abs (- v1 v2)) v2) tolerance) #t #f)
  )
  (define (next v1)
    (/ (+ v1 (/ x v1)) 2.0)
  )  
	((iter-improve close-enough? next) 1.0)
)

(define (fixed-point f x)
  (define tolerance 0.000001)
	(define (abs y)
    (cond ((< y 0) (- 0 y))
      (else y)
    )
  )
  (define (close-enough? v1 v2)
    (if (< (/ (abs (- v1 v2)) v2) tolerance) #t #f)
  )
	(define (next m)
	  (f m)
	)
	
	((iter-improve close-enough? next) x)
)