; 1.37 recursion 
(define (cont-fracr n d k)
  (define (cf t n d k)
    (if (= k 0) 0 (/ (n t) (+ (d t) (cf (+ t 1) n d (- k 1)))))
  )
	(let ((temp 1)) 
	  (cf temp n d k)
	)
)

; (a)
(define (fai k)
  (cont-fracr (lambda (x) 1.0) (lambda (x) 1.0) k)
)
