(define (abs y)
    (cond ((< y 0) (- 0 y))
      (else y)
    )
)

(define (good x y)
  (< (/ (abs (- x y)) y) 0.001)
)

(define (square x)
  (* x x)
)

(define (next gus squ)
  (/ (+ (/ squ (square gus)) (* 2 gus)) 3)
)

(define (cuberoot x)  
  (define (sqrtiter guess)
    (if (good (next guess x) guess) guess
      (sqrtiter (next guess x))
    )
  )
  (sqrtiter 1.0)
)