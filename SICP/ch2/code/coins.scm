; 2.19
(define (change-charge amount coins-values)
  (define (first-denomination kinds-of-coins)
    (car kinds-of-coins)
  )

  (define (except-first-denomination kinds-of-values)
    (cdr kinds-of-values)
  )
  
  (define (no-more? kinds-of-values)
    (null? kinds-of-values)
  )

  ; if amount = 0 return 1
  ; amount = 0 OR not kins coins return 0
  ; if having amount , equals the number of kinds coins exclude the first and the amount - the value of 
  ; first kind coin should change 
  (cond ((= amount 0) 1)
    ((or (< amount 0) (no-more? coins-values)) 0)
    (else (+ (change-charge amount (except-first-denomination coins-values)) 
	           (change-charge (- amount (first-denomination coins-values)) coins-values)
	        )
    )        
  )
)

(define us-coins (list 25 10 1 5 50))
(define us1-coins (list 50 25 10 5 1))
(define uk-coins (list 20 50 0.5 1 5 2 100 10))
(define uk1-coins (list 100 50 20 10 5 2 1 0.5))

(display (change-charge 100 us-coins))
(newline)
(display (change-charge 100 us1-coins))
(newline)
(display (change-charge 40 uk-coins))
(newline)
(display (change-charge 40 uk1-coins))