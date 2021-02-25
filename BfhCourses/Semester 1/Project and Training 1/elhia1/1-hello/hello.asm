SECTION .data           ; Section containing initialised data

		

	HelloWorld : db "Hello world!", 10
	HelloWorldLength : equ $-HelloWorld ; Computer the length of the string


SECTION .bss            ; Section containing uninitialized data

SECTION .text           ; Section containing code

global _start           ; Linker needs this to find the entry point!

_start:

    ;; Add *your code* here to make this program print "Hello world"!
	
	mov rax, 1			; Code for sys-write call
	mov rdi, 1			; Specify File Descriptor 1: Standard Output
	mov rsi, HelloWorld		; Pass offfset of the message
	mov rdx, HelloWorldLength	; Pass the length of the message
	syscall				; Make kernel call




		

    mov rax, 60         ; Code for exit
    mov rdi, 0          ; Return a code of zero
    syscall             ; Make kernel call
