(define (accum op inital ls)
  (if (null? ls) inital
      (op (car ls) (accum op inital (cdr ls)))
  )
)

; enum a list [low,high]  
(define (enum-interval low high)
  (if (> low high) '()
      (cons low (enum-interval (+ 1 low) high))
  )
)

(define (rogroup n)
  (accum append '() 
        (map (lambda (i) (map (lambda (j) (list i j)) (enum-interval 1 (- i 1))))
         (enum-interval 1 n)
        )
  )
)

(define (flatmap proc seq)
  (accum append '() (map proc seq))
)

; 素数检查
(define (is-prime n)
  (define (next x)
    (if (= x 2) (+ 1 x) (+ 2 x)
    )
  )

	(define (divisor0 x test)
	  (cond ((> (* test test) x) x)
		  ((divides? x test) test)
			(else (divisor0 x (next test)))
	  )
	)

	(define (divides? a b)
	    (= (remainder a b) 0)
	)
  
  (define (smallest-divisor2 x)
	  (divisor0 x 2)
  )
  (= n (smallest-divisor2 n))
)

; 检查和是否是素数
(define (prime-sum pair)
  (is-prime (+ (car pair) (cadr pair)))
)

(define (make-pair-sum pair)
  (list (car pair) (cadr pair) (+ (car pair) (cadr pair)))
)

(define (prime-sum-pairs n)
  (map make-pair-sum 
       (filter prime-sum 
               (flatmap (lambda (i) (map (lambda (j) (list i j)) (enum-interval 1 (- i 1)))) 
                        (enum-interval 1 n)
               )
       )
  )
)

; 2.40 
(define (prime-sum-pairs2 n)
  (define (unique-pairs num)
    (flatmap (lambda (i) (map (lambda (j) (list i j)) (enum-interval 1 (- i 1))))
             (enum-interval 1 num))
  )
  
  (map make-pair-sum 
       (filter prime-sum 
               (unique-pairs n)
       )
  )
)

(define (remove item seq)
  (filter (lambda (x) (not (= x item))) seq)
)

; 生成排列 (list x1 x2 ... xn)
(define (premutations s)
  (if (null? s) (list '())     ; 为一个含有空元素的空表 (())
      (flatmap (lambda (x) 
                       (map (lambda (p) (cons x p))
                            (premutations (remove x s))
                       )
               )
               s
      )
  )
)

; 2.41
(define (triple-group n s)
  (define (equals pair)
    (= (+ (car pair) (cadr pair) (car (cdr (cdr pair)))) s)
  )
  
  (filter equals
          (flatmap (lambda (i) (flatmap (lambda (j) (map (lambda (k) (list k j i))
                                                         (enum-interval 1 (- j 1))
                                                    )
                                        )
                                        (enum-interval 1 (- i 1))
                               )        
                  ) 
                  (enum-interval 1 n)
          )
  )
)
