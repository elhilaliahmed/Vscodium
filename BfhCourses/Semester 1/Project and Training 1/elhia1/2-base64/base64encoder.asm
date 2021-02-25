; Executable name : base64encoder
; Created         : 30/11/2020
; Last updated	  : 04/12/2020
; Description	  : A simple program in assembly that can encode binary values to base64.

; Important registers:
; rax used to manipulate the bytes
; rbx used to manipulate the bytes
; r10 holds the first byte
; r11 holds the second byte
; r12 holds the third byte


SECTION .data           ; Section containing initialised data
	
	; Lookup table for Base64 characters
	Base64Table: db "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

	; Inizialize a buffer for writing to standard output	
	Result:		db "0000"		
	ResultLength:	equ $-Result
	
	; CONSTANTS
	SYS_READ	equ 0
	SYS_WRITE	equ 1
	SYS_EXIT	equ 60
	STDIN		equ 0
	STDOUT		equ 1
	EqualSign	equ '='

SECTION .bss            ; Section containing uninitialized data
	
	; Reserve a buffer forreading from standard input
	BufferLength:	equ 3
	Buffer:		resb BufferLength

SECTION .text           ; section containing code
global _start           ; linker needs this to find the entry point!

_start:


read:
	; Read from standard input to Buffer
	mov rax, SYS_READ	; sys_read
	mov rdi, STDIN		; file descriptor: standard input
	mov rsi, Buffer		; destination buffer
	mov rdx, BufferLength	; maximum number of bytes to read
	syscall
	
	cmp rax, 0	; check if we received any bytes
	je exit		; if no bytes are received, then exit the program

	; Prepare the registers for loop
	xor r10, r10		; clear r10
	xor r11, r11		; clear r11
	xor r12, r12		; clear r12
	
	cmp rax, 1		; compares value of rax with 1
	je convertOneByte	; if the value equals 1, jump to the convertOneByte procedure

	cmp rax, 2		; compares value of rax with 2
	je convertTwoBytes	; if the value equals 2, jump to the convertTwoBytes procedure 
	
	jmp convertThreeBytes	; else jump to the convertThreeBytes procedure
	
convertOneByte:
		
	; read one byte, example : 1001 1001
	mov al, byte [Buffer] 	; move the first byte from memory to rax
	mov r10, rax		; copy the first byte from rax to r10 for later use
	
	
	; extract the first 6 bits, i.e, 100 110 from [1001 10]01
	mov rax, r10				; copy r10 to rax ,i.e, 1001 1001 
	and al, 0fch				; mask out the last two bits to get the bits in brackets [1001 10]01
	shr al, 2h				; shift right to get the first 6 bits in al, i.e 00[10 0110]
	; convert the first 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result], al			; insert the character into Result
	
	
	; extract the second 6 bits , i.e, 010 000 from 1001 10[01]
	mov rax, r10				; copy r10 to rax, i.e, 1001 1001
	and al, 3h				; mask out the upper 6 bits in al to get the bits in brackets 1001 10[01]
	shl al, 4h				; shift left to insert 4 zeros to move the bits up to get 00[01] 0000
	; convert the second 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 1], al		; insert the character into Result
	
	
	; convert the third 6 bits
	; adding an equal sign in place of the first  000 000
	mov byte [Result + 2], EqualSign	; insert equal sign character into Result
	
	
	; convert the fourth 6 bits
	; adding an equal sign in place of the second 000 000
	mov byte [Result + 3], EqualSign	; insert equal sign character into Result
	
	jmp print

convertTwoBytes:

	; read two bytes, example:  1001 1001 - 1101 1010
	
	; read the first byte, i.e, 1001 1001, and save it into r10
	mov al, byte [Buffer]		; move the first byte from memory to rax
	mov r10, rax			; copy the first byte from rax to r10 for later use
	
	; read the second byte, i.e, 1101 1010, and save it into r11
	mov al, byte [Buffer + 1] 	; move the second byte from memory to rax
	mov r11, rax			; copy the second byte from rax to r11 for later use
		
	
	; extract and convert the first 6 bits
	; extract the first 6 bits, i.e,  100 110 from [1001 10]01 - 1101 1010
	mov rax, r10				; copy r10 to rax i.e, 1001 1001
	and al, 0fch				; mask out the last two bits to get the bits in brackets [1001 10]01
	shr al, 2h				; shift right to get the first 6 bits, i.e 00[10 0110]
	; convert the first 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result], al			; insert the character into Result

	
	; extract and convert the second 6 bits
	; extract the second 6 bits , i.e, 011 101 from 1001 10[01 - 1101] 1010
	mov rax, r10				; copy r10 to rax i,e 1001 1001
	mov rbx, r11				; copy r11 to rbx i,e 1101 1010
	and al, 3h				; mask out the upper 6 bits in al to get the bits in brackets 1001 10[01]
	shl al, 4h				; shift left to insert 4 zeros to get 00[01] 0000
	shr bl, 4h				; shift left to change 1101 1010 to 0000 [1101]
	or al, bl				; merge al and bl to get 00[01 1101]
	; convert the second 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 1], al		; insert the character into Result
	
	
	; extact and convert the third 6 bits
	; extract the third 6 bits , i.e, 101 000 from 1001 1001 - 1101 [1010]
	mov rax, r11				; copy r11 to rax i,e 1101 1010
	and al, 0fh				; mask out the upper 4 bits in al to get the bits in bracket 1101 [1010]
	shl al, 2h				; shift left to to get 00[10 10]00
	; convert the third 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 2], al		; insert the character into Result
	
	
	; convert the fourth 6 bits
	; adding an equal sign in place of 000 000
	mov byte [Result + 3], EqualSign	; insert equal sign character into Result
	
	jmp print

convertThreeBytes:

	; read three bytes, example:  1001 1001 - 1101 1010 - 1001 1111
	
	; read the first byte, i.e, 1001 1001,  and save it into r10
	mov al, byte [Buffer]		; mov the first byte from memory to rax
	mov r10, rax			; copy the first byte from rax to r10 for later use
	
	; read the second byte, i.e, 1101 1010,  and save it into r11
	mov al, byte [Buffer + 1] 	; move the second byte from memory to rax
	mov r11, rax			; copy the second byte from rax to r11 for later use
	
	; read the third byte, i.e, 1001 1111,  and save it into r12
	mov al, byte [Buffer + 2]	; move the third byte from memory to rax
	mov r12, rax			; copy the third byte from rax to r12 for later use
	
	
	; extract and convert the first 6 bits
	; extract the first 6 bits, i.e,  100 110 from [1001 10]01 - 1101 1010 - 1001 1111
	mov rax, r10				; copy r10 to rax i.e, 1001 1001
	and al, 0fch				; mask out the last two bits to get the bits in brackets [1001 10]01
	shr al, 2h				; shift right to get the first 6 bits, i.e 00[10 0110]
	; convert the first 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result], al			; insert the character into Result

	
	; extract and conevert the second 6 bits
	; extract the second 6 bits , i.e, 011 101 from 1001 10[01 - 1101] 1010 - 1001 1111
	mov rax, r10				; copy r10 to rax i,e 1001 1001
	mov rbx, r11				; copy r11 to rbx i,e 1101 1010
	and al, 3h				; mask out the upper 6 bits in al to get the bits in brackets   1001 10[01]
	shl al, 4h				; shift left to insert 4 zeros to get 00[01] 0000
	shr bl, 4h				; shift left to change 1101 1010 to 0000 [1101]
	or al, bl				; merge al and bl to get 00[01 1101]
	; convert the second 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 1], al		; insert the character into Result


	
	; extact and convert the third 6 bits
	; extract the third 6 bits , i.e, 101 000 from 1001 1001 - 1101 [1010 - 10]01 1111
	mov rax, r11				; copy r11 to rbx i,e. 1101 1010
	mov rbx, r12				; copy r12 to rbx i,e. 1001 1111
	and rax, 0fh				; mask out everything except the low 4 bits, get the bits in the brackets 1101 [1010]
	shl rax, 2h				; shift left to get 01[10 10]00
	and rbx, 0c0h				; mask out the lower 6 bits, get the bits in the brackets [10]01 1111
	shr rbx, 6h				; shift right to get 00[00 0010]
	or rax, rbx				; merge rax and rbx to get 00[10 1010]
	; convert the second 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 2], al		; insert the character into Result
	
	
	; extact and convert the fourth 6 bits
	; extract the fourth 6 bits , i.e, 011 100 from 1001 1001 - 1101 1010 - 10[01 1111]
	mov rax, r12				; copy r12 to rax i,e. 1001 1111
	and rax, 3fh				; mask out the upper two bits, get the bits in the brackets 10[01 1111]
	; convert the second 6 bits to base64
	mov al, byte [Base64Table + rax]	; look up Base64Table for the appropriate character
	mov byte [Result + 3], al		; insert the character into Result

print: 
	mov rax, SYS_WRITE	; sys_write
	mov rdi, STDOUT		; file descriptor: standard output
	mov rsi, Result		; source buffer
	mov rdx, ResultLength	; number of bytes to write
	syscall			; make kernel call

	jmp read		; go back to read the next bytes from input

exit: 

	; exit the program gracefully 
    	mov rax, SYS_EXIT   	; code for exit
    	mov rdi, 0         	; return a code of zero
    	syscall          	; make kernel call
