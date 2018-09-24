; 3.26
; key - value entry
(define (make-entry key value)
  (cons key value)
)

(define (get-key entry)
  (car entry)
)

(define (get-value entry)
  (cdr entry)
)

(define (set-value! entry value)
  (set-cdr! entry value)
)

; tree defination
(define (get-entry tree)
  (car tree)
)

(define (left-branch tree)
  (cadr tree)
)

(define (right-branch tree)
  (caddr tree)
)

(define (set-left-branch! new-left tree)
  (set-car! (cdr tree) new-left)
)

(define (set-right-branch! new-right tree)
  (set-car! (cddr tree) new-right)
)

(define (make-tree entry left right)
  (list entry left right)
)

; look up value using key
(define (look-up key tree)
  (cond ((null? tree) #f)
        ((= key (get-key (get-entry tree))) (get-value (get-entry tree)))
        ((< key (get-key (get-entry tree))) (look-up key (left-branch tree)))
        (else (look-up key (right-branch tree)))
  )
)

(define (insert! key value tree)
  (cond ((null? tree) (make-tree (make-entry key value) '() '()))
        ((= key (get-key (get-entry tree))) (set-value! (get-entry tree) value) tree)
        ((< key (get-key (get-entry tree))) 
         (set-left-branch! (insert! key value (left-branch tree)) tree)      ;?
         tree
        )
        (else (set-right-branch! (insert! key value (right-branch tree)) tree) tree)
  )      
)

; bug
(define (insert2 key value tree)
  (cond ((null? tree) (make-tree (make-entry key value) '() '()))
        ((= key (get-key (get-entry tree))) 
         (make-tree (make-entry key value) (left-branch tree) (right-branch tree))      
        )
        ((< key (get-key (get-entry tree)))  
         ; the value has inserted,but tree doesn't change
         (make-tree (get-entry tree) (insert2 key value (left-branch tree)) (right-branch tree))      
        )
        (else (make-tree (get-entry tree) (left-branch tree) (insert2 key value (right-branch tree))))
  )      
)

(define tre (make-tree (make-entry 50 0) '() '()))