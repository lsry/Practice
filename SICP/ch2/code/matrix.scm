(define (accum op init ls)
  (if (null? ls) init 
      (op (car ls) (accum op init (cdr ls)))
  )
)

(define (accum-n op init seqs)
  (if (null? (car seqs)) '()
      (cons (accum op init (map car seqs))
            (accum-n op init (map cdr seqs))
      )
  )
)


(define (dot-product v w)
  (accum + 0 (map * v w))
)

(define (matrix-mul-vector m v)
  (map (lambda (x) (dot-product v x)) m)
)

(define (transpose mat)
  (accum-n cons '() mat)
)

(define (matrix-mul-matrix m n)
  (let ((cols (transpose n))) 
       (map (lambda (x) (matrix-mul-vector cols x))
            m
       )
  )
)
