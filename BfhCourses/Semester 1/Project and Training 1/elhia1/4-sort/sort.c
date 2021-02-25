/**
 * Author       : Ahmed Elhilali
 * Created      : 16/01/2021
 * Last updated : 19/01/2021
 * Description  : This program takes several lines of input from standard input and prints them out in sorted order to standard output. 
 *                The program relies on the bubble sort algorithm to achieve this goal.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 128

/**
 * This function sorts the strings in a descending order. The function relies on strcmp() from <string.h> and performs a bubble sort.
 * @param strings is an array of character pointers (an array of strings).
 * @param size is the number of strings.
 */
void sortDescending(char** strings, const size_t size);

/**
 * This function sorts the strings in an ascending order. The function relies on strcmp() from <string.h> and performs a bubble sort.
 * @param strings is an array of character pointers (an array of strings).
 * @param size is the number of strings.
 */
void sortAscending(char** strings, const size_t size);

/**
 * This function takes two strings and swaps them.
 * @param a is the first string.
 * @param b is the second string.
 */
void swap(char** a, char** b);

/**
 * This function prints the strings on the screen.
 * @param strings is an array of character pointers (an array of strings).
 * @param size is the number of strings.
 */
void display(char** strings, const size_t size);	  

int main(int argc, char** argv) {

    char* strings[MAX_LENGTH];
    size_t size = 0;

    if (argc > 1) {
        if (strcmp(argv[1], "-r") != 0) {
            perror("You have entered the wrong argument, please try again with -r");
            exit(EXIT_FAILURE);
        }
    }

    while(1) {
        strings[size] = (char*)malloc(MAX_LENGTH);
        int ret = scanf("%s", strings[size]);
        if (ret == EOF) {
            break;
        }   
        size++;
    }

    if (argc > 1 ) {
		sortAscending(strings, size);
    }

    else {
        sortDescending(strings, size);
    }
    
    display(strings, size);
       
    exit(EXIT_SUCCESS);
}

void sortAscending(char** strings, const size_t size) {
	for (size_t i = 0; i < size - 1; i++) {
		for (size_t j = i + 1; j < size; j++) {
			if (strcmp(strings[i], strings[j]) < 0) {
			    swap(&strings[i], &strings[j]);
            }
		}
	}  
}

void sortDescending (char** strings, const size_t size) {
	for (size_t i = 0; i < size - 1; i++) {
		for (size_t j = i + 1; j < size; j++) {
			if (strcmp(strings[i], strings[j]) > 0) {
			    swap(&strings[i], &strings[j]);
			}
		}
	}
}

void swap(char** a, char** b) {
    char* temp = *a;
    *a = *b;
    *b = temp;
}

void display(char** strings, const size_t size) {
	for (size_t i = 0; i < size; i++) {
		printf("%s\n", strings[i]);
	}
}
