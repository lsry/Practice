; prime  

; O(n^(1/2))
(define (smallest-divisor n)
  (define (divisor0 n test)
	  (cond ((> (* test test) n) n)
		  ((divides? n test) test)
			(else (divisor0 n (+ 1 test)))
	  )
	)

	(define (divides? a b)
	  (= (remainder a b) 0)
	)

	(divisor0 n 2)
)

(define (prime? n)
  (= (smallest-divisor n) n)
)

; base^(exp)%m
(define (expmod base exp m)
  (define (even? x)
    (= (remainder x 2) 0)
  )

	(define (square x)
	  (* x x)
	)
	
	(cond ((= exp 0) 1)
	  ((even? exp) (remainder (square (expmod base (/ exp 2) m)) m))
		(else (remainder (* base (expmod base (- exp 1) m)) m))
  )
)

(define (fermat-test n)
  (define (try-it a)
    (= (expmod a n n) a)
  )
  
  (try-it (+ 1 (random (- n 1))))
)

(define (fast-prime? n times)
  (cond ((= times 0) #t)
	  ((fermat-test n) (fast-prime? n (- times 1)))
		(else #f)
  )
)

