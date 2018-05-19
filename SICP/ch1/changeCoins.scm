(define (change-charge amount)
  ; if amount = 0 return 1
  ; amount = 0 OR not kins coins return 0
  ; if having amount , equals the number of kinds coins exclude the first and the amount - the value of 
  ; first kind coin should change 
  (define (cc amount kinds-of-coins)
    (cond ((= amount 0) 1)
      ((or (< amount 0) (= kinds-of-coins 0)) 0)
      (else (+ (cc amount (- kinds-of-coins 1)) 
	       (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins)
	    )
      )        
    )
  )

  (define (first-denomination kinds-of-coins)
    (cond ((= kinds-of-coins 1) 1)
          ((= kinds-of-coins 2) 5)
          ((= kinds-of-coins 3) 10)
	  ((= kinds-of-coins 4) 25)
	  ((= kinds-of-coins 5) 50)
    )
  )
  (cc amount 5)
)





