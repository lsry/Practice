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
  (and (pair? e) (eq? (car e) '+))
)

; added number of e
(define (addend e)
  (cadr e)
)

; add number of e
(define (augend e)
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
        (else (list '+ a1 a2))        
  )
)

; is e a multiple?
(define (product? e)
  (and (pair? e) (eq? (car e) '*))
)

; muled of e
(define (multiplier e)
  (cadr e)
)

; mul number of e
(define (multiplicand e)
  (cond ((null? (cdr (cdr e))) 1)
        ((= (length (cdr (cdr e))) 1) (caddr e))
        (else (cons '* (cdr (cdr e))))
  )   
)

; 2.56 only used in exponent is not a variable
(define (exponentiation? e)
  (and (pair? e) (eq? (car e) '**))
)

(define (base e)
  (cadr e)
)

(define (exponent e)
  (caddr e)
)

(define (make-exponentiation b e)
  (cond ((and (number? e) (= e 0)) 1)
        ((and (number? e) (= e 1)) b)
        ((and (number? b) (number? e)) (expt b e))
        (else (list '** b e))
  )
)


; mul of m1 and m2
(define (make-product a1 a2)
  (cond ((or (and (number? a1) (= a1 0)) (and (number? a2) (= a2 0))) 0)  
        ((and (number? a1) (= a1 1)) a2)
        ((and (number? a2) (= a2 1)) a1)
        ((and (number? a1) (number? a2)) (* a1 a2))
        (else (list '* a1 a2))        
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
        ((exponentiation? exp) (make-product (make-product (exponent exp) 
                                                           (make-exponentiation (base exp) (- (exponent exp) 1))
                                             )
                                             (deriv (base exp) var)
                               )
        )
        (else (error "unknow expression type" exp))
  )
)

; 2.73   
(define (operator exp)
  (car exp)
)

(define (operands exp)
  (cdr exp)
)

(define (deriv2 exp var)
  (cond ((number? exp) 0)
        ((variable? exp) if (same-variable? exp var) 1 0)
        (else ((get 'derive (operator exp)) (operands exp) var))        
  )
)

; b c
(define (install-deriv)
  (define (der ep vr)
    (cond ((number? exp) 0)
          ((variable? exp) if (same-variable? exp var) 1 0)
          (else ((get 'derive (operator exp)) (operands exp) var))        
    )
  )
  (define (deriv-add ep vr)
    (make-sum (der (addend ep) vr) (der (augend ep) vr))
  )
  (define (deriv-mul ep vr)
    (make-sum (make-product (multiplier ep) (deriv (multiplicand ep) vr))
              (make-product (deriv (multiplier ep) vr) (multiplicand ep))
    )
  )
  (define (deriv-exp ep vr)
    (make-product (make-product (exponent ep) (make-exponentiation (base ep) (- (exponent ep) 1)))
                  (deriv (base ep) vr)
    )
  )
  
  (put 'deriv '(+) deriv-add)
  (put 'deriv '(*) deriv-mul)
  (put 'deriv '(**) deriv-exp)
)
