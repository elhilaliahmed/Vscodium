# Makefile for building demo applications.
# by Brian Fraser

# Edit this file to compile extra C files into their own programs.
#TARGETS= sum_on_thread sum_on_many_threads sum_malloc

# -std=c99 use c99 to compile, before that we can create variables inside a for loop
# -Wall give the warning
# -Werror turn the warning into error
# -g sets up debugging option

TARGETS= fork forkloop

CROSS_TOOL = 
CC_CPP = $(CROSS_TOOL)g++
CC_C = $(CROSS_TOOL)gcc

CFLAGS = -Wall -g -std=c11 -Werror

all: clean $(TARGETS)

$(TARGETS):
	$(CC_C) $(CFLAGS) $@.c -o $@ 

clean:
	rm -f $(TARGETS)