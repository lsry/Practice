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

; using (n^(i/2))^2  recursion
(define (pow2r num counter)
  (define (even? n)
    (= (remainder n 2) 0)
  )
	(define (square x)
	  (* x x)
	)
	(cond ((= counter 0) 1)
	      ((even? counter) (square (pow2 num (/ counter 2))))
				(else (* num (pow2 num (- counter 1))))
	)
)

; using (n^(i/2))^2  iter
(define (pow2i num counter)
  (define (even? n)
    (= (remainder n 2) 0)
  )
	(define (square x)
	  (* x x)
	)
  (define (pow-iter a n i)
    (cond ((= i 0) a)
		      ((even? i) (square (pow-iter a n (/ i 2))))
					(else (pow-iter (* a n) n (- i 1)))
    )
  )
  (pow-iter 1 num counter)
)
