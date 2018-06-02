; n^i  

; recursion
(define (powr n i)
  (if (= i 0) 1
	   (* n (powr n (- i 1)))
  )
)

;iter
(define (powi num counter)
  (define (pow-iter x n i)
    (if (= i 0) x
		  (pow-iter (* x n) n (- i 1))
    )
  )
	(pow-iter 1 num counter)
)

; using (n^(i/2))^2 = (n^2)^(i/2) recursion
(define (pow2r num counter)
  (define (even? n)
    (= (remainder n 2) 0)
  )
	(define (square x)
	  (* x x)
	)
	(cond ((= counter 0) 1)
	      ((even? counter) (pow2r (square num) (/ counter 2)))
				(else (* num (pow2r num (- counter 1))))
	)
)

; using (n^(i/2))^2 = (n^2)^(i/2) iter
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
