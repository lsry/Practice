(define (cube x)
  (* x x x)
)

; sum(a,b) = f(a) + ... + f(b) 
(define (sum term a next b)
  (if (> a b) 0
	  (+ (term a) (sum term (next a) next b))
  )
)

; sum-i(a,b) = a + ... + b  
(define (sum-i a b)
  (sum (lambda (x) x) a (lambda (x) (+ x 1)) b)
)

; sum-cube(a,b) = a^3 + ... + b^3 
(define (sum-cube a b)
  (sum (lambda (x) (cube x)) a (lambda (x) (+ 1 x)) b
	)
)

; sum-pi(a,b) = 1/a(a+2) + ... + 1/b(b+2) = pi/8
(define (sum-pi a b)
  (sum (lambda (x) (/ 1.0 (* x (+ x 2)))) a (lambda (x) (+ x 4)) b)
)

; ¡Òf(a,b)  
(define (intergral f a b dx)
  (* (sum f (+ a (/ dx 2.0)) (lambda (x) (+ x dx)) b) dx)
)

; 1.29  
(define (sen-rule f a b n)
  ;compute the coefficient of each item
	(define (yi x m)
    (cond ((or (= x 0) (= x m)) 1)
		   ((= (remainder x 2) 0) 2)
       (else 4)
		)
  )
  
	(define h (/ (- b a) n))
  
	; next independent variable
	(define (xk t)
	  (+ a (* t h))
	)
  
	(* (/ h 3) (sum (lambda (s) (* (yi s n) (f (xk s)))) 0 (lambda (s) (+ s 1)) n))
)

; 1.30  
; sum(a,b) = term(a) + .... + term(b) 
; iter
(define (sumi term a next b)
  (define (iter x y result)
    (if (> x y) result (iter (next x) y (+ result (term x)))
    )
  )
  (iter a b 0)
)

; mul(a,b) = term(a) * ... * term(b) 
; recursion
(define (mulr term a next b)
  (if (> a b) 1
	  (* (term a) (mulr term (next a) next b))
  )
)

(define (muli term a next b)
  (define (iter x y result)
    (if (> x y) result (iter (next x) y (* result (term x)))
    )
  )
  (iter a b 1)
)


; 1.31 
; 2/3 * 4/3 * ...  = pi/4
; (a) (b)  
(define (factorial x y)
  (define (square s)
    (* s s)
  )
  
  (muli (lambda (s) (/ (* (* 2 s) (+ 2 (* 2 s))) (square (+ 1 (* 2 s))))) x 
	  (lambda (s) (+ 1 s)) y)
)

; 1.32 
; recursion
(define (accumulater combiner null-value term a next b)
  (if (> a b) null-value
    (combiner (term a) (accumulater combiner null-value term (next a) next b))
	)
)

; iter 
(define (accumulater combiner null-value term a next b)
  (define (iter a result)
    (if (> a b) result
      (iter (next a) (combiner result (term a)))
		)
  )
  (iter a null-value)
)

; suma
(define (suma term a next b)
  (accumulate + 0 term a next b)
)

;mula 
(define (mula term a next b)
  (accumulate * 1 term a next b)
)

; 1.33
; recursion
(define (filt-accum combiner null-value term pred a next b)
  (define (filt nuva pre x)
    (if (pre x) x nuva)
  )
  
	(if (> a b) null-value
    (combiner (filt null-value pred (term a)) 
		          (filt-accum combiner null-value term pred (next a) next b))
	)
)

; (a)
(define (sumprime a b)
  (define (prime? n)
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
    (= (smallest-divisor n) n)
  )
	(filt-accum + 0 (lambda (x) x) prime? a (lambda (x) (+ 1 x)) b)
)

; (b) 
(define (mulprime n)
  (define (gcd a b)
    (if (= 0 b) a (gcd b (remainder a b)))
  )
  (define (sat x)
    (if (= (gcd x n) 1) #t #f)
  )
  (filt-accum * 1 (lambda (x) x) sat 1 (lambda (x) (+ 1 x)) (- n 1))
)
