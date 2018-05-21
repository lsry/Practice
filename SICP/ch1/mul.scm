; a * b  

; recursion
(define (mulr a b)
  (if (= b 0) 0
	  (+ a (mulr a (- b 1)))
  )
)

; recursion, using a * b = (a * (b/2)) * 2 
(define (mulor a b)
  (define (even? n)
    (= (remainder n 2) 0)
  )
  (define (double m)
    (+ m m)
  )
	(define (halve k)
    (/ k 2)
  )
  (cond 
	  ((= b 0) 0)
	  ((= b 1) a)
		((even? b) (double (mulor a (halve b))))
		(else (+ a (mulor a (- b 1))))
  )
)

; iter, using a * b = (a * (b/2)) * 2 
(define (muloi a b)
  (define (even? n)
    (= (remainder n 2) 0)
  )
  (define (double m)
    (+ m m)
  )
	(define (halve k)
    (/ k 2)
  )
  (define (mulo-iter x y z)
    (cond ((= z 0) x)
			((even? z) (mulo-iter x (double y) (halve z)))
			(else (mulo-iter (+ x y) y (- z 1)))
		)
  )
  (mulo-iter 0 a b)
)


