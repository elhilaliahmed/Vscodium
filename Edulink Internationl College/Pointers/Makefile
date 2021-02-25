# Makefile for building demo programs
# by ahmed elhilali
# -Wall give the warnings
# -Werror truns the warning into error
# -g sets up debugging options
# -std=c11 forces the compiler to use c11 version
# programs hold the name of the programs to be compiled
# compiler is the compiler to be used to compile the program
# compilerFlags has all the arguments we want to give the compiler
# all is used if we want to compile multiple programs,
# we can omit all if we have just one program
# $@ is the name of the program or programs.


programs = mallocSort calloc realloc

compiler = gcc

compilerFlags = -Wall -g -std=c11 -Werror

all: clean $(programs)

$(programs):
	$(compiler) $(compilerFlags) $@.c -o $@

clean:
	rm -f $(programs)
