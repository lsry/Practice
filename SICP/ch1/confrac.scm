; 1.37 recursion top to bottom
(define (cont-fracr n d k)
  (define (cf t n d k)
    (if (= k 0) 0 (/ (n t) (+ (d t) (cf (+ t 1) n d (- k 1)))))
  )
	(let ((temp 1)) 
	  (cf temp n d k)
	)
)

; iter bottom to top
(define (cont-fraci n d k)
  (define (cf n d k res)
    (if (= k 0) res
		  (cf n d (- k 1) (/ (n k) (+ (d k) res)))
    )
  )
	(cf n d k 0)
)

; (a)
(define (fai k)
  (cont-fraci (lambda (x) 1.0) (lambda (x) 1.0) k)
)

; 1.38  
(define (e-value k)
  (define (di x)
    (if (= (remainder x 3) 2) (* 2.0 (+ 1 (quotient x 3))) 1.0)
  )
	(+ 2 (cont-fraci (lambda (x) 1.0) di k))
)

; 1.39  
(define (tan-cf x k)
  (define (cont-fraci n d k)
    (define (cf n d k res)
      (if (= k 0) res
		    (cf n d (- k 1) (/ (n k) (- (d k) res)))))
	  (cf n d k 0)
  )  
  (define (ni i)
    (if (= i 1) x (* x x))
  )
  (define (Di i)
    (- (* 2 i) 1)
  )
  (cont-fraci ni di k)
)
