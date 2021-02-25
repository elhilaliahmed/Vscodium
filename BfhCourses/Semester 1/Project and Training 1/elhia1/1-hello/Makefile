hello: hello.o
	ld -o hello hello.o

hello.o: hello.asm
	nasm -f elf64 -g -F dwarf hello.asm -l hello.lst

clean:
	rm -f hello hello.o hello.lst
