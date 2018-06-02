;fixed-point
(define (fixed-point f guess)
  (define tolerance 0.000001)
	(define (abs y)
    (cond ((< y 0) (- 0 y))
      (else y)
    )
  )
  (define (close-enough? v1 v2)
    (if (< (/ (abs (- v1 v2)) v2) tolerance) #t #f)
  )
  (define (try g)
    (let ((next (f g))) 
		  (if (close-enough? g next) next (try next))
    )
  ) 
	(try guess)
)

; compute y^2 = x -> y = ?
(define (sqrt0 x)
  (fixed-point (lambda (y) (/ (+ y (/ x y)) 2.0)) 1.0)
)

; 1.36 compute y^y = x -> y = ?
(define (xx x)
  (define (fixed-point f guess)
    (define tolerance 0.000001)
	  (define (abs y)
      (cond ((< y 0) (- 0 y))
        (else y)
      )
    )
    (define (close-enough? v1 v2)
      (if (< (/ (abs (- v1 v2)) v2) tolerance) #t #f)
    )
		(define (discre t m n)
		  (newline)
			(display m)
			(t n)
		)
    (define (try g)
      (let ((next (f g))) 
		    (if (close-enough? g next) next (discre try g next))
      )
    ) 
	  (try guess)
  )
  (fixed-point (lambda (y) (/ (+ y (/ (log x) (log y))) 2.0)) 2.0)
)

(define (average-damp f)
  (define (average a b)
    (/ (+ a b) 2.0)
  )
	(lambda (x) (average x (f x)))
)

(define (sqrt1 x)
  (fixed-point (average-damp (lambda (y) (/ x y))) 1.0)
)

(define (cube-root x)
  (fixed-point (average-damp (lambda (y) (/ x (* y y)))) 1.0)
)

; NewTon Method 
(define (derive g)
  (define dx 0.000001)
	(lambda (x) (/ (- (g (+ x dx)) (g x)) dx))
)

(define (newton-iter f guess)
  (define (newton-transform g)
    (lambda (x) (- x (/ (g x) ((derive g) x))))
  )
	(fixed-point (newton-transform f) guess)
)

(define (sqrt2 x)
  (newton-iter (lambda (y) (- (* y y) x)) 1.0)
)

(define (fixed-point-of-transform g transform guess)
  (fixed-point (transform g) guess)
)

; 1.45
(define (repeated f n)
  (define (compose f g)
    (lambda (x) (f (g x)))
  )
	(if (= n 1) f
		(compose f (repeated f (- n 1)))
	)
)

(define (rootn x m)
  (define (pow2i num counter)
    (define (even? n)
      (= (remainder n 2) 0)
    )
	  (define (square x)
	    (* x x)
	  )
    (define (pow-iter a n i)
      (cond ((= i 0) a)
		      ((even? i) (pow-iter a (square n) (/ i 2)))
					(else (pow-iter (* a n) n (- i 1)))
      )
    )
    (pow-iter 1 num counter)
  )
  (define (lg n)
    (cond ((> (/ n 2) 1) (+ 1 (lg (/ n 2))))
          ((< (/ n 2) 1) 0)
          (else 1)
		)
	)
  (fixed-point ((repeated average-damp (lg m)) (lambda (y) (/ x (pow2i y (- m 1))))) 1.0)
)


