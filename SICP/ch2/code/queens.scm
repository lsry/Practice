(define (accum op inital ls)
  (if (null? ls) inital
      (op (car ls) (accum op inital (cdr ls)))
  )
)

(define (flatmap proc seq)
  (accum append '() (map proc seq))
)

(define (enum-interval low high)
  (if (> low high) '()
      (cons low (enum-interval (+ 1 low) high))
  )
)

(define (queens1 board-size)
  (define empty-board '())

  (define (make-grid row col)
    (cons row col)
  )

  (define (grid-row g)
    (car g)
  )
  
  (define (grid-col g)
    (cdr g)
  )

  (define (adjoin-position row in restqueen)
    (cons (make-grid row in) restqueen)
  )
  
  (define (safe? in post)
    (define (check-row row pos)
      (if (null? pos) #t
          (and (not (= row (car (car pos)))) (check-row row (cdr pos)))
      )
    )

    (define (check-col col pos)
      (if (null? pos) #t
          (and (not (= col (cdr (car pos)))) (check-col col (cdr pos)))     
      )
    )

    (define (check-angle row col pos)
      (if (null? pos) #t
          (and (and (not (= -1 (/ (- (cdr (car pos)) col) (- (car (car pos)) row)))) 
                    (not (= 1 (/ (- (cdr (car pos)) col) (- (car (car pos)) row))))
               )
               (check-angle row col (cdr pos))
          )
      )
    )
    
    (and (check-row (car (car post)) (cdr post)) 
         (check-col (cdr (car post)) (cdr post)) 
         (check-angle (car (car post)) (cdr (car post)) (cdr post))
    )
  )
  
  (define (queen-cols k)
    (if (= k 0) (list empty-board)
        (filter (lambda (positions) (safe? k positions))
                (flatmap (lambda (rest-of-queens) 
                                 (map (lambda (new-row) (adjoin-position new-row k rest-of-queens))
                                      (enum-interval 1 board-size)
                                 )
                         )
                         (queen-cols (- k 1))
                )
        )
    )
  )
  (queen-cols board-size)
)

; 2.43
(define (queens2 board-size)
  (define empty-board '())

  (define (make-grid row col)
    (cons row col)
  )

  (define (grid-row g)
    (car g)
  )
  
  (define (grid-col g)
    (cdr g)
  )

  (define (adjoin-position row in restqueen)
    (cons (make-grid row in) restqueen)
  )
  
  (define (safe? in post)
    (define (check-row row pos)
      (if (null? pos) #t
          (and (not (= row (car (car pos)))) (check-row row (cdr pos)))
      )
    )

    (define (check-col col pos)
      (if (null? pos) #t
          (and (not (= col (cdr (car pos)))) (check-col col (cdr pos)))     
      )
    )

    (define (check-angle row col pos)
      (if (null? pos) #t
          (and (and (not (= -1 (/ (- (cdr (car pos)) col) (- (car (car pos)) row)))) 
                    (not (= 1 (/ (- (cdr (car pos)) col) (- (car (car pos)) row))))
               )
               (check-angle row col (cdr pos))
          )
      )
    )
    
    (and (check-row (car (car post)) (cdr post)) 
         (check-col (cdr (car post)) (cdr post)) 
         (check-angle (car (car post)) (cdr (car post)) (cdr post))
    )
  )
  
  (define (queen-cols k)
    (if (= k 0) (list empty-board)
        (filter (lambda (positions) (safe? k positions))
                (flatmap (lambda (new-row) 
                                 (map (lambda (rest-of-queens) (adjoin-position new-row k rest-of-queens))
                                      (queen-cols (- k 1))
                                 )
                         )
                         (enum-interval 1 board-size)
                )
        )
    )
  )
  (queen-cols board-size)
)

(newline)
(define a (runtime))
(queens1 6)
(define b (* 1000 (- (runtime) a)))

(newline)
(define a1 (runtime))
(queens2 6)
(define b1 (- (runtime) a1))