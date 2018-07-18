(define balance 100)

(define (withdraw amount)
  (if (>= balance amount)
      (begin (set! balance (- balance amount)) balance)
      "Insufficient funds"
  )
)

(define (withdraw2 amount)
  (let ((balance 100)) 
       (if (>= balance amount)
           (begin (set! balance (- balance amount)) balance)
           "Insufficient funds"
       )
  )
)

(define (make-withdraw balance)
  (lambda (amount)
          (if (>= balance amount)
              (begin (set! balance (- balance amount)) balance)
              "Insufficient funds"
          )
  )
)

(define (make-account1 balance)
  (define (withdraw amount)
    (if (>= balance amount)
        (begin (set! balance (- balance amount)) balance)
        "Insufficient funds"
    )
  )
  (define (deposit amount)
    (set! balance (+ balance amount))
    balance
  )
  (define (dispatch m)
    (cond ((eq? m 'withdraw) withdraw)
          ((eq? m 'deposit) deposit)
          (else (error "Unkonow request -- MAKE-ACCOUNT" m))
    )
  )
  dispatch
)


; 3.3 
(define (make-account2 balance password)
  (define num 0)
  (define (withdraw amount)
    (if (>= balance amount)
        (begin (set! balance (- balance amount)) balance)
        "Insufficient funds"
    )
  )
  (define (deposit amount)
    (set! balance (+ balance amount))
    balance
  )
  ; 3.4   
  (define (call-the-cops)
    (display "WARNING")
  )
  (define (check-password word) 
    (if (eq? word password) (begin (set! num 0) #t) 
        (begin (set! num (+ 1 num)) (if (>= num 7) (call-the-cops)) #f)  
    )
  ) 
  (define (dispatch word ins)
    (if (check-password word)
        (cond ((eq? ins 'withdraw) withdraw)
              ((eq? ins 'deposit) deposit)
              (else (error "Unkonow request -- MAKE-ACCOUNT" ins))
        )
        (error "Incorect password")
    )
  )
  dispatch
)
(define acc (make-account2 100 'abc))

; 3.1 
(define (make-accum sum)
  (lambda (num) 
          (begin (set! sum (+ sum num)) sum)
  )
)

; 3.2
(define (make-monitored f)
  (define count 0)
  (define (dispatch mf)
    (cond ((eq? mf 'how-many-calls) count)
          ((eq? mf 'reset-count) (begin (set! count 0) count))
          ((number? mf) (begin (set! count (+ 1 count)) (f mf)))       
    )
  )
  dispatch  
)
(define s (make-monitored sqrt))