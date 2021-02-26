- Defining square root:
``` lisp
    (defun square(x)(* x x))
```
- Defining average value of two numbers: 
``` lisp
    (defun average (x y) ( / (+ x y) 2))
```
- Defining absolute value:
``` lisp
    (defun motl(x)(cond ((< x 0)(- x))((= x 0) 0)((> x 0) x)))
```
