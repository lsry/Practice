; return the ith element of list
; 0 <= i <= n-1
(define (list-ref1 items i)
  (if (= 0 i) (car items) (list-ref1 (cdr items) (- i 1)))
)

; return the length of list
; recursion  
(define (list-lengthr items)
  (if (null? items) 0 (+ 1 (list-lengthr (cdr items))))
)

; return the length of list
; iter
(define (list-lengthi items)
  (define (lengthi st num)
    (if (null? st) num (lengthi (cdr st) (+ 1 num)))
  )
  (lengthi items 0)
)

; combine list-a and list-b
(define (append1 la lb)
  (if (null? la) lb (cons (car la) (append1 (cdr la) lb)))
)

; 2.17
; return the list haveing only the last element of a list
(define (last-pair1 items)
  (cond ((or (null? items) (null? (cdr items))) items)
        (else (last-pair1 (cdr items)))
  )
)

; 2.18 
; reverse a list  
(define (reverse1 items)
  (if (or (null? items) (null? (cdr items))) items  
      (append (reverse1 (cdr items)) (list (car items)))
  )
)

; 2.20
(define (same-parity first . rest) 
   (define (same-parity-iter source dist remainder-val) 
     (if (null? source) 
         dist 
         (same-parity-iter (cdr source) 
                           (if (= (remainder (car source) 2) remainder-val) 
                               (append dist (list (car source))) 
                               dist) 
                           remainder-val))) 
    
   (same-parity-iter rest (list first) (remainder first 2))) 