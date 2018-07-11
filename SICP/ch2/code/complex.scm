(define (add-complex z1 z2)
  (make-from-real-imag (+ (real-part z1) (real-part z2))
                       (+ (imag-part z1) (imag-part z2))
  )
)

(define (sub-complex z1 z2)
  (make-from-real-imag (- (real-part z1) (real-part z2))
                       (- (imag-part z1) (imag-part z2))
  )
)

(define (mul-complex z1 z2)
  (make-from-mag-ang (* (magnitude z1) (magnitude z2))
                     (+ (angle z1) (angle z2))
  )
)

(define (div-complex z1 z2)
  (make-from-mag-ang (/ (magnitude z1) (magnitude z2))
                     (- (angle z1) (angle z2))
  )
)

; Ben
(define (real-partB z)
  (car z)
)

(define (imag-partB z)
  (cdr z)
)

(define (magnitudeB z)
  (sqrt (+ (square (real-partB z)) (square (imag-partB z))))
)

(define (angleB z)
  (atan (imag-partB z) (real-partB z))
)


(define (make-from-real-imagB x y)
  (cons x y)
)

(define (make-from-mag-angB r a)
  (cons (* r (cos a)) (* r (sin a)))
)

; Alyssa
(define (real-partA z)
  (* (magnitudeA z) (cos (angleA z)))
)

(define (imag-partA z)
  (* (magnitudeA z) (sin (angleA z)))
)

(define (manitudeA z)
  (car z)
)

(define (angleA z)
  (cdr z)
)

(define (make-from-real-imagA x y)
  (cons (sqrt (+ (square x) (square y))) (atan y x))
)

(define (make-from-mag-angA r a)
  (cons r a)
)

; tag
(define (attach-tag type-tag contents)
  (cons type-tag contents)
)

(define (type-tag datun)
  (if (pair? datum) (car datum)
      (error "bad tagged datum -- TYPE-TAG" datum)
  )
)

(define (contents datum)
  (if (pair? datum) (cdr datum)
      (error "bad tagged datum -- CONTENTS" datum)
  )
)

(define (rectangular? z)
  (eq? (type-tag z) 'rectangular)
)

(define (polar? z)
  (eq? (type-tag z) 'polar)
)

; Ben, rectangular
(define (real-part-rect z)
  (car z)
)

(define (imag-part-rect z)
  (cdr z)
)

(define (magnitude-rect z)
  (sqrt (+ (square (real-part-rect z)) (square (imag-part-rect z))))
)

(define (angle-rect z)
  (atan (imag-part-rect z) (real-part-rect z))
)

(define (make-from-real-imag-rect x y)
  (attach-tag 'rectangular (cons x y))
)

(define (make-from-mag-ang-rect r a)
  (attach-tag 'rectangular (cons (* r (cos a)) (* r (sin a))))
)

; Alyssa, polar
(define (real-part-polar z)
  (* (magnitude-polar z) (cos (angle-polar z)))
)

(define (imag-part-polar z)
  (* (magnitude-polar z) (sini (angle-polar z)))
)

(define (magnitude-polar z)
  (car z)
)

(define (angle-polar z)
  (cdr z)
)

(define (make-from-real-imag-polar x y)
  (attach-tag 'polar (cons (sqrt (+ (square x) (square y))) (atan y x)))
)

(define (make-from-mag-ang-polar r a)
  (attach-tag 'polar (cons r a))
)

; choose and construct function based on tag
(define (real-part-tag z)
  (cond ((rectangular? z) (real-part-rect (contents z)))
        ((polar? z) (real-part-polar (contents z)))
        (else (error "Unknow type -- REAL-PART" z))
  )
)

(define (imag-part-tag z)
  (cond ((rectangular? z) (imag-part-rect (contents z)))
        ((polar? z) (imag-part-polar (contents z)))
        (else (error "Unknow type -- IMAG-PART" z))
  )
)

(define (magnitude-tag z)
  (cond ((rectangular? z) (magnitude-rect (contents z)))
        ((polar? z) (magnitude-polar (contents z)))
        (else (error "Unknow type -- MAGNITUDE" z))
  )
)

(define (angle-tag z)
  (cond ((rectangular? z) (angle-rect (contents z)))
        ((polar? z) (angle-polar (contents z)))
        (else (error "Unknow type -- ANGLE" z))
  )
)

(define (make-from-real-imag-tag x y)
  (make-from-real-imag-rect x y)
)

(define (make-from-mag-ang-tag r a)
  (make-from-mag-ang-polar r a)
)

(define (install-rect-package)
  (define (real-part z) (car z))
  (define (imag-part z) (cdr z))
  (define (make-from-real-imag x y) (cons x y))
  (define (magnitude z) (sqrt (+ (square (real-part z)) (square (imag-part z)))))
  (define (angle z) (atan (imag-part z) (real-part z)))
  (define (make-from-mag-ang r a) (cons (* r (cos a)) (* r (sin a))))
  ; interface to the rest of system
  (define (tag x) (attach-tag 'rectangular x))
  (put 'real-part '(rectangular) real-part)
  (put 'imag-part '(rectangular) imag-part)
  (put 'magnitude '(rectangular) magnitude)
  (put 'angle '(rectangular) angle)
  (put 'make-from-real-imag 'rectangular (lambda (x y) (tag (make-from-real-imag x y))))
  (put 'make-from-mag-ang 'rectangular (lambda (r a) (tag (make-from-mag-ang r a))))
  'done
)

(define (install-polar-package)
  (define (magnitude z) (car z))
  (define (angle z) (cdr z))
  (define (make-from-mag-ang r a) (cons r a))
  (define (real-part z) (* (magnitude z) (cos (angle z))))
  (define (imag-part z) (* (magnitude z) (sin (angle z))))
  (define (make-from-real-imag x y) (cons (sqrt (+ (square x) (square y))) (atan y x)))
  ; interfac to the rest of system
  (define (tag x) (attach-tag 'polar x))
  (put 'real-part '(polar) real-part)
  (put 'imag-part '(polar) imag-part)
  (put 'magnitude '(polar) magnitude)
  (put 'angle '(polar) angle)
  (put 'make-from-real-imag 'polar (lambda (x y) (tag (make-from-real-imag x y))))
  (put 'make-from-mag-ang 'polar (lambda (r a) (tag (make-from-mag-ang r a))))
  'done
)

(define (apply-generic op . args)
  (let ((type-tags (map type-tag args))) 
       (let ((proc (get op type-tags))) 
            (if proc (apply proc (map contents args))
                (error "NO METHOD FOR THIS TYPE -- APPLY-GENERIC" (list op type-tags))
            )
       )
  )
)

(define (real-part z)
  (apply-generic 'real-part z)
)

(define (imag-part z)
  (apply-generic 'imag-part z)
)

(define (magnitude z)
  (apply-generic 'magnitude z)
)

(define (angle z)
  (apply-generic 'angle z)
)

(define (make-from-real-imag x y)
  ((get 'make-from-real-imag 'rectangular) x y)
)


(define (make-from-mag-ang1 r a)
  ((get 'make-from-mag-ang 'polar) r a)
)

; ÏûÏ¢´«µÝ    
(define (make-from-real-imag-mess x y)
  (define (dispatch op)
    (cond ((eq? op 'real-part) x)
          ((eq? op 'imag-part) y)
          ((eq? op 'magnitude) (sqrt (+ (square x) (square y))))
          ((eq? op 'angle) (atan y x))
          (else (error "Unknow op -- make-from-real-imag-mess" op))
    )
  )
  dispatch
)

; 2.75
(define (make-from-mag-angg-mess r a)
  (define (dispatch op)
    (cond ((eq? op 'real-part) (* r (cos a)))
          ((eq? op 'imag-part) (* r (sin a)))
          ((eq? op 'magnitude) r)
          ((eq? op 'angle) a)
          (else (error "Unknow op -- make-from-mag-ang-mess" op))
    )
  )
  dispatch
)