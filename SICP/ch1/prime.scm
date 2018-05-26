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

; 1.22 exame time
(define (search-for-primes n t)
  (define (report-prime x elapsed-time)
	  (newline)
	  (display x)
    (display " *** ")
		(display elapsed-time)
  )

	(define (start-time-prime x start-time)
	  (if (prime? x) (report-prime x (- (runtime) start-time))
	  )
	)

	(define (isprime x y)
	  (start-time-prime x (runtime))
    (search-for-primes (+ 1 x) (- y 1))
	)
	
	(cond ((and (> t 0) (prime? n)) (isprime n t))
	  ((> t 0) (search-for-primes (+ n 1) t))
	)
)

; 1.23 
; next: using x = x + 2 (x != 2) 
(define (is-prime n)
  (define (next x)
    (if (= x 2) (+ 1 x) (+ 2 x)
    )
  )

	(define (divisor0 x test)
	  (cond ((> (* test test) x) x)
		  ((divides? x test) test)
			(else (divisor0 x (next test)))
	  )
	)

	(define (divides? a b)
	    (= (remainder a b) 0)
	)
  
  (define (smallest-divisor2 x)
	  (divisor0 x 2)
  )
  (= n (smallest-divisor2 n))
)

(define (search-primes1 n t)
  (define (report-prime x elapsed-time)
	  (newline)
	  (display x)
    (display " *** ")
		(display elapsed-time)
  )

	(define (start-time-prime x start-time)
	  (if (is-prime x) (report-prime x (- (runtime) start-time))
	  )
	)

	(define (isprime x y)
	  (start-time-prime x (runtime))
    (search-primes1 (+ 1 x) (- y 1))
	)
	
	(cond ((and (> t 0) (is-prime n)) (isprime n t))
	  ((> t 0) (search-primes1 (+ n 1) t))
	)
)
