; baisc queue   
(define (front-ptr ueu)
  (car ueu)
)

(define (rear-ptr ueu)
  (cdr ueu)
)

(define (set-front-ptr! ueu item)
  (set-car! ueu item)
)

(define (set-rear-ptr! ueu item)
  (set-cdr! ueu item)
)

(define (empty-ueu? ueu)
  (null? (front-ptr ueu))
)

(define (make-ueu)
  (cons '() '())
)

(define (front-ueu ueu)
  (if (empty-ueu? ueu) (error "FRONT called with an empty queue" ueu)
      (car (front-ptr ueu))
  )
)

(define (insert-ueu! ueu item)
  (let ((new-pair (cons item '()))) 
       (cond ((empty-ueu? ueu) (set-front-ptr! ueu new-pair)
                                   (set-rear-ptr! ueu new-pair)
                                   ueu
             )
             (else (set-cdr! (rear-ptr ueu) new-pair)
                   (set-rear-ptr! ueu new-pair)
                   ueu
             )
       )
  )
)

(define (delete-ueu! ueu)
  (cond ((empty-ueu? ueu) (error "DELETE! called with empty queue" ueu))
        (else (set-front-ptr! ueu (cdr (front-ptr ueu))) ueu) 
  )
)

(define (print-ueu ueu)
  (car ueu)
)

; agenda


; wire


; gate

(define (logical-not s)
  (cond ((= 0 s) 1)
        ((= 1 s) 0)
        (else (error "Invalid signal!" s))
  )
)

(define (inverter input output)
  (define (invert-input)
    (let ((new-value (logic-not (get-signal input))))
         (after-delay inverter-delay (lambda () (set-signal! output new-value)))
    )
  )
  (add-action! input invert-input)
  'ok
)

(define (logic-and s1 s2)
  (cond ((and (= 1 s1) (= 1 s2)) 1)
        ((or (= 0 s1) (= s2 0)) 0)
        (else (error "Invalid signal!" s))
  )
)

(define (and-gate a1 a2 output)
  (define (and-action-procedure)
    (let ((new-value (logic-and (get-signal a1) (get-signal a2))))
         (after-delay and-gate-delay (lambda () (set-signal! output new-value)))
    )
  )
  (add-action! a1 and-action-procedure)
  (add-action! a2 and-action-prccedure)
  'ok
)

; 3.28
(define (logic-or s1 s2)
  (cond ((and (= 0 s1) (= 0 s2)) 0)
        ((or (= 1 s1) (= s2 1)) 1)
        (else (error "Invalid signal!" s))
  )
)

(define (or-gate a1 a2 output)
  (define (or-action-procedure)
    (let ((new-value (logic-or (get-signal a1) (get-signal a2))))
         (after-delay or-gate-delay (lambda () (set-signal! output new-value)))
    )
  )
  (add-action! a1 or-action-procedure)
  (add-action! a2 or-action-prccedure)
  'ok
)

; 3.29    
(define (or-gate2 a1 a2 output)
  (let ((a3 (make-wire)) (a4 (make-wire)) (a5 (make-wire)))
       (or-agte a1 a3)
       (or-gate a2 a4)
       (and-gate a3 a4 a5)
       (or-gate a5 output)
       'ok
  )
)



; others

(define (half-adder a b s c)
  (let ((d (make-wire)) (e (make-wire)))
       (or-gate a b d) 
       (and-gate a b c)
       (inverter c e)
       (and-gate d e s)
       'ok
  )
)

(define (full-adder a b c-in sum c-out)
  (let ((s (make-wire)) (c1 (make-wire)) (c2 (make-wire)))
       (half-adder b c-in c1)
       (half-adder a s sum c2)
       (or-gate c1 c2 c-out)
       'ok
  )
)

; 3.30  tempatory error
(define (ripple-carry-adder Ak Bk Sk C)
  (cond ((null? Ak) 'ok)
        ((null? (cdr Ak)) (full-adder (car Ak) (car Bk) 0 (car Sk) C))
        (else (ripple-carry-adder (cdr Ak) (cdr Bk) (cdr Sk) C))
  )
)
