; is e a variable?
(define (variable? e)
  ()
)

; same variable? 
(define (same-variable v1 v2)
  ()
)

; is e a sum?  
(define (sum? e)
  ()
)

; added number of e
(define (addend e)
  ()
)

; add number of e
(define (augend e)
  ()
)

; the sum of a1 and a2
(define (make-sum a1 a2)
  ()
)

; is e a multiple?
(define (product? e)
  ()
)

; muled of e
(define (multiplier e)
  ()
)

; mul number of e
(define (multiplicand e)
  ()
)

; mul of m1 and m2
(define (make-product m1 m2)
  ()
)

; derive
(define (deriv exp var)
  (cond ((number? exp) 0)
        ((variable? exp) (if (same-variable? exp var) 1 0))
        ((sum? exp) (make-sum (derive (addend exp) var) (derive (augend exp) var)))
        ((product? exp) (make-sum (make-product (multiplier exp) (derive (multiplicand exp) var))
                                  (make-product (deriv (multiplier exp) var) (multiplicand exp))
                        )
        )
        (else (error "unknow expression type" exp))
  )
)
