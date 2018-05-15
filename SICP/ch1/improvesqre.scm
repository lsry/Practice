(define (abs y)
    (cond ((< y 0) (- 0 y))
      (else y)
    )
  )
; improvement method ,
; let the ratio between the difference of guess value and next value and guess value below 0.001
(define (good x y)
  (< (/ (abs (- x y)) y) 0.001)
)

(define (average y z)
  (/ (+ y z) 2.0)
)

(define (next gus squ)
  (average gus (/ squ gus))
)

(define (sqrt x)  
  (define (sqrtiter guess)
    (if (good (next guess x) guess) guess
      (sqrtiter (next guess x))
    )
  )
  (sqrtiter 1.0)
)