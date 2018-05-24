(define (gcd a b)
  (if (= 0 b) a (gcd b (remainder a b))
  )
)
