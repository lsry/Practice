(define (my-filter pre ls)
  (cond ((null? ls) '())
        ((pre (car ls)) (cons (car ls) (my-filter pre (cdr ls))))
        (else (my-filter pre (cdr ls)))
  )
)

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

; enum all leaves of a tree  
(define (enum-leaves tree)
  (cond ((null? tree) '())
        ((not (pair? tree)) (list tree))
        (else (append (enum-leaves (car tree)) (enum-leaves (cdr tree))))
  )
)

; comppute the sum of square of odd leaves of a tree 
(define (sum-odd-squares tree)
  (accum + 0 (map square (my-filter odd? (enum-leaves tree))))
)

; get a fib list where every element is even from 0 to nth 
(define (even-fibs n)
  (define (fib n)
	  (define (fib-ite1 a b p q count)
	    (cond ((= count 0) b)
		    ((even? count) (fib-ite1 a b (+ (* p p) (* q q)) (+ (* q q) (* 2 p q)) (/ count 2)))
			  (else (fib-ite1 (+ (* b q) (* a q) (* a p)) (+ (* b p) (* a q)) p q (- count 1)))
	    )
	  )
	  (fib-ite1 1 0 0 1 n)
  )
  (accum cons '() (my-filter even? (map fib (enum-interval 0 n))))
)

; 2.33
(define (my-map p ls)
  (accum (lambda (x y) (cons (p x) y)) '() ls)
)

(define (my-append seq1 seq2)
  (accum cons seq2 seq1)
)

(define (my-length ls)
  (accum (lambda (x y) (+ 1 y)) 0 ls)
)

; 2.34
(define (horner-eval x cs)
  (accum (lambda (this-coeff higer-terms) (+ this-coeff (* x higer-terms))) 0 cs)
)

; (horner-eval 2 (list 1 3 0 5 0 1))    

; 2.35 
(define (count-leaves tree)
  (accum + 0 (map (lambda (sub) (cond ((null? sub) 0)
                                      ((not (pair? sub)) 1)
                                      (else (count-leaves sub))
                                )
                  )
                  tree
             )
  )
)

; 2.36
(define (accum-n op init seqs)
  (if (null? (car seqs)) '()
      (cons (accum op init (map car seqs))
            (accum-n op init (map cdr seqs))
      )
  )
)

; 2.38 
(define (fold-left op init ls)
  (define (iter result rest)
    (if (null? rest) result
        (iter (op result (car rest)) (cdr rest))
    )
  )
  (iter init ls)
)

(newline)
(display (accum / 1 (list 1 2 3)))
(newline)
(display (fold-left / 1 (list 1 2 3)))
(newline)
(display (accum list '() (list 1 2 3)))
(newline)
(display (fold-left list '() (list 1 2 3)))

; 2.39  
(define (reverse-left ls)
  (fold-left (lambda (x y) (cons y x))
             '() ls
  )
)

(define (reverse-right ls)
  (accum (lambda (x y) (append y (list x)))
             '() ls
  )
)