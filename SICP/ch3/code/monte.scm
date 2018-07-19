(define (rand-update x)
  (remainder (+ 5 (* 3 x)) 8)
)

(define (rand)
  (let ((x random-init))    ; random-init = 8
       (lambda () (set! x (rand-update x)) x)
  )
)

; 3.6?     
(define (rand2)
  (define random-init 10)
  (define (generate)
    (lambda () (set! random-init (rand-update random-init)) random-init)
  )
  (define (reset)
    (lambda (new-value) (set! random-init new-value) new-value)
  )
  
  (define (dispatch sig) 
     (cond ((eq? sig 'generate) (generate))
           ((eq? sig 'reset) (reset))
           (else (error "WRONG INSTRUCTION -- RAND2" sig))
     )
  )
  dispatch
)


(define (estimate-pi trials)
  (sqrt (/ 6 (monte-carlo trials cesero-test)))
)

(define (cesero-test)
  (= (gcd (rand) (rand)) 1)
)

(define (monte-carlo trials experiment)
  (define (iter trial-remaining trial-passed)
    (cond ((= trial-remaining 0) (/ trial-passed trials))
          ((experiment) (iter (- trial-remaining 1) (+ 1 trial-passed)))
          (else (iter (- trial-remaining 1) trial-passed))
    )
  )
  (iter trials 0)
)

(define (estimate2-pi trials)
  (sqrt (/ 6 (random-gcd-test trials random-init)))  ; random-init = 8
)

(define (random-gcd-test trials init-x)
  (define (iter trial-remaining trial-passed x)
    (let ((x1 (rand-update x))) 
         (let ((x2 (rand-update x1))) 
              (cond ((= trial-remaining 0) (/ trial-passed trials))
                    ((= (gcd x1 x2) 1) (iter (- trial-remaining 1) (+ 1 trial-passed) x2))
                    (else (iter (- trial-remaining 1) trial-passed x2))
              )
         )
    )
  )
  (iter trials 0 init-x)
)

; 3.5  
(define (random-in-range low high)
  (let ((range (- high low))) 
       (+ low (random range))
  )
)

(define (estimate-intergral x1 x2 y1 y2 trials)
  (define (in-circle? px py r x y)
    (<= (+ (square (- x px)) (square (- y py))) (square r))
  )
  (define (exper)
    (let ((x (random-in-range x1 x2))
          (y (random-in-range y1 y2))
          (px (/ (+ x1 x2) 2))
          (py (/ (+ y1 y2) 2))
         )
         (in-circle? px py 1 x y)
    )
  )
  (monte-carlo trials exper)
)
; (* 4.0 (estimate-intergral -1 1 -1 1 10000000))

; 3.8 
(define (f x)
  (let ((n 0)) (begin (set! n (+ n x)) (- n x)))
)

(+ (f 0) (f 1))