(define (scale-list1 ls factor)
  (if (null? ls) (list) (cons (* (car ls) factor) (scale-list1 (cdr ls) factor)))
)

(define (map1 proc ls)
  (if (null? ls) (list) (cons (proc (car ls)) (map1 proc (cdr ls))))
)

(define (scale-list2 ls factor)
  (map1 (lambda (x) (* x factor)) ls)
)

; 2.21  
(define (square-list1 items)
  (if (null? items) (list)
      (let ((x (car items))) (cons (* x x) (square-list1 (cdr items))))
  )
)

(define (square-list2 items)
  (map (lambda (x) (* x x)) items)
)

; 2.22
(define (square-listi1 items)
  (define (iter things answer)
    (if (null? things) answer
      (iter (cdr things) (cons (* (car things) (car things)) answer))
    )
  )
  
  (iter items (list))
)

(define (square-listi2 items)
  (define (iter things answer)
    (if (null? things) answer
      (iter (cdr things) (cons answer (* (car things) (car things))))
    )
  )
  
  (iter items (list))
)

; 2.23 
(define (for-each1 proc ls)
  (if (not (null? ls)) 
    ((lambda (p s) (p (car s)) (for-each1 p (cdr s))) proc ls)
  )
)

(for-each1 (lambda (x) (newline) (display x)) (list 1 2 3 4))


