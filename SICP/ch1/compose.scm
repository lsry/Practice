; 1.40
(define (cubic a b c)
  (define (cube m)
    (* m m m)
  )
  (define (sqre m)
    (* m m)
  )
  (lambda (x) (+ (cube x) (* a (sqre x)) (* b x) c))
)

; 1.41 
(define (double f)
  (lambda (x) (f (f x)))
)

; 1.42 
(define (compose f g)
  (lambda (x) (f (g x)))
)

(define (sqare x)
  (* x x)
)

; 1.43 
(define (repeated f n)
  (define (compose f g)
    (lambda (x) (f (g x)))
  )
	(if (= n 1) f
		(compose f (repeated f (- n 1)))
	)
)

; 1.44 
(define (smooth f n)
  (define dx 0.000001)
  (define (average3 x y z)
    (/ (+ x y z) 3.0)
  )
	(define (smoth1 g)
	  (lambda (x) (average3 (g (- x dx)) (g x) (g (+ x dx))))
	)
	((repeated smoth1 n) f)
)