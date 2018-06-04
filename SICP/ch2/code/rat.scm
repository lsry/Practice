(define (make-rat n d)
  (define (gcd a b)
    (if (= 0 b) a (gcd b (remainder a b)))
  )
  (let ((g (gcd n d))) (if (< (/ d g) 0) (cons (* -1 (/ n g)) (* -1 (/ d g))) (cons (/ n g) (/ d g))))
)

(define (numer x)
  (car x)
)

(define (denom x)
  (cdr x)
)

(define (add-rat x y)
  (make-rat (+ (* (numer x) (denom y)) (* (numer y) (denom x))) (* (denom x) (denom y)))
)

(define (sub-rat x y)
  (make-rat (- (* (numer x) (denom y)) (* (numer y) (denom x))) (* (denom x) (denom y)))
)

(define (mul-rat x y)
  (make-rat (* (numer x) (numer y)) (* (denom x) (denom y)))
)

(define (div-rat x y)
  (make-rat (* (numer x) (denom y)) (* (numer y) (denom x)))
)

(define (equal-rat? x y)
  (= (* (numer x) (denom y)) (* (numer y) (denom x)))
)

(define (print-rat x)
  (newline)
  (display (numer x))
  (display "/")
  (display (denom x))
)

