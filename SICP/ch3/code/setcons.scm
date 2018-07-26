(define (append-old x y)
  (if (null? x) y
      (cons (car x) (append-old (cdr x) y))
  )
)

(define (append-new! x y)
  (set-cdr! (last-pair1 x) y)
)

(define (last-pair1 x)
  (if (null? (cdr x)) x
      (last-pair1 (cdr x))
  )
)

(define (make-cycle x)
  (set-cdr! (last-pair x) x)
)

(define (mystery x)
  (define (loop x y)
    (if (null? x) y
        (let ((temp (cdr x))) 
             (set-cdr! x y)
             (loop temp x)
        )
    )
  )
  (loop x '())
)

; 3.16
(define (count-pairs x)
  (if (not (pair? x)) 0
      (+ (count-pairs (car x)) (count-pairs (cdr x)) 1)
  )
) 
; 3   
(define s1 (list 'a 'b 'c))
; 4 
(define  m (cons 'a 'b))
(define  m1 (cons 'a m))
(define s2 (cons m1 m))
; 7 
(define t (cons 'a 'b))
(define t1 (cons t t))
(define s3 (cons t1 t1))
; maxmum depth recursion  
(define s4 (list 'a 'b 'c))
(make-cycle s4)