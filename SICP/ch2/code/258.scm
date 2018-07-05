; is e a variable?
(define (variable? e)
  (symbol? e)
)

; same variable? 
(define (same-variable? v1 v2)
  (and (variable? v1) (variable? v2) (eq? v1 v2))
)

; is e a sum expression?  
(define (sum? e)
  (and (pair? e) (eq? (cadr e) '+))
)

; added number of e
(define (addend e)
  (car e)
)

; add number of e
(define (augend e)
  (caddr e)
)

(define (augend1 e)
  (cond ((null? (cdr (cdr e))) 0)
        ((= (length (cdr (cdr e))) 1) (caddr e))
        (else (cons '+ (cdr (cdr e))))
  )      
)

; the sum of a1 and a2
(define (make-sum a1 a2)
  (cond ((and (number? a1) (= a1 0)) a2)
        ((and (number? a2) (= a2 0)) a1)
        ((and (number? a1) (number? a2)) (+ a1 a2))
        (else (list a1 '+ a2))        
  )
)

; is e a multiple?
(define (product? e)
  (and (pair? e) (eq? (cadr e) '*))
)

; muled of e
(define (multiplier e)
  (car e)
)

; mul number of e
(define (multiplicand e)
  (caddr e)
)

(define (multiplicand1 e)
  (cond ((null? (cdr (cdr e))) 1)
        ((= (length (cdr (cdr e))) 1) (caddr e))
        (else (cons '* (cdr (cdr e))))
  )   
)

; mul of m1 and m2
(define (make-product a1 a2)
  (cond ((or (and (number? a1) (= a1 0)) (and (number? a2) (= a2 0))) 0)  
        ((and (number? a1) (= a1 1)) a2)
        ((and (number? a2) (= a2 1)) a1)
        ((and (number? a1) (number? a2)) (* a1 a2))
        (else (list a1 '* a2))        
  )
)

; derive
(define (deriv exp var)
  (cond ((number? exp) 0)
        ((variable? exp) (if (same-variable? exp var) 1 0))
        ((sum? exp) (make-sum (deriv (addend exp) var) (deriv (augend exp) var)))
        ((product? exp) (make-sum (make-product (multiplier exp) (deriv (multiplicand exp) var))
                                  (make-product (deriv (multiplier exp) var) (multiplicand exp))
                        )
        )  
        (else (error "unknow expression type" exp))
  )
)