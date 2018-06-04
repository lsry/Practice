; 2.2 
; point 
(define (make-point x y)
  (cons x y)
)

(define (x-point p)
  (car p)
)

(define (y-point p)
  (cdr p)
)

(define (print-point p)
  (newline)
  (display "(")
  (display (x-point p))
  (display ",")
  (display (y-point p))
  (display ")")
)


; line 
(define (make-segment p1 p2)
  (cons p1 p2)
)

(define (start-segment l)
  (car l)
)

(define (end-segment l)
  (cdr l)
)

(define (length-segment l)
  (define (square x)
    (* x x)
  )
  
  (let ((p1 (start-segment l)) (p2 (end-segment l))) 
    (sqrt (+ (square (- (x-point p2) (x-point p1))) (square (- (y-point p2) (y-point p1)))))
  )
)


(define (midpoint-segment l)
  (define (average v1 v2)
    (/ (+ v1 v2) 2.0)
  )
  (make-point (average (x-point (start-segment l)) (x-point (end-segment l))) 
              (average (y-point (start-segment l)) (y-point (end-segment l)))
  )
)

; 2.3 rectangle  
; A complement, using two points to describe 
(define (make-rec1 p1 p2)
  (cons p1 p2)
)

(define (start-rec1 r)
  (car r)
)

(define (end-rec1 r)
  (cdr r)
)

(define (width1 r)
  (define (abs x)
    (if (< x 0) (- 0 x) x)
  )
  (abs (- (x-point (end-rec1 r)) (x-point (start-rec1 r))))
)

(define (height1 r)
  (define (abs x)
    (if (< x 0) (- 0 x) x)
  )
  (abs (- (y-point (end-rec1 r)) (y-point (start-rec1 r))))
)

(define (area1 r)
  (* (height1 r) (width1 r))
)

(define (preime1 r)
  (* 2 (+ (height1 r) (width1 r)))
)

; B implement, using two lines that are perpendicular and have a common point
(define (make-rec2 row col)
  (cons row col)
)

(define (rec-row r)
  (car r)
)

(define (rec-col r)
  (cdr r)
)

(define (width2 r)
  (length-segment (rec-row r))
)

(define (height2 r)
  (length-segment (rec-col r))
)

(define (area2 r)
  (* (height2 r) (width2 r))
)

(define (preime2 r)
  (* 2 (+ (height2 r) (width2 r)))
)