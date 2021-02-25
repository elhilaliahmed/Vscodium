#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <fcntl.h>

#define MAX_WORD 10
#define MAX_CHAR 100
#define DEL " "

int inputRedirectionFlag = 0;
int outputRedirectionFlag = 0;
int pipingFlag = 0;
char* inputFile = NULL;
char* outputFile = NULL;

void removeEndOfLine(char line[]) {
    int i = 0;
    while (line[i] != '\n') {
        i++;
    }
    line[i] = '\0';
}


void readLine(char line[]) {
    char* ret = fgets(line, MAX_CHAR, stdin);
    removeEndOfLine(line);
    if (strcmp(line, "exit") == 0 || ret == NULL) {
        exit(0);
    }
}

int processLine(char* temp[], char line[]) {
        
    int i = 0;
    temp[i] = strtok(line, DEL);

    while (temp[i] != NULL) {
        i++;
        temp[i] = strtok(NULL, DEL);
    }

    return 1;
}

int pipeRedirectionCheck(char* temp[]){
    int i = 0;
    while(temp[i] != NULL) {
        if (strcmp(temp[i], ">") == 0) {
            outputRedirectionFlag = 1;
            outputFile = temp[i + 1];
            return i;
        }

        else if (strcmp(temp[i], ">") == 0) {
            inputRedirectionFlag = 1;
            inputFile = temp[i + 1];
            return i;
        }

        else if(strcmp(temp[i], "|") == 0) {
            pipingFlag = 1;
            return i;
        }
        i++;
    }
    return i;
}

void checkLine(char* temp[]) {
    int i = 0;
    int total = 0; 

    if (temp[i] == NULL) {
        printf("No command was found\n");
    }

    while(temp[i] != NULL) {

        if (strcmp(temp[i], ">") == 0) {
            total++;
        }

        else if (strcmp(temp[i], "<") == 0) {
            total++;
        }

        else if (strcmp(temp[i], "|") == 0) {
            total++;
        }

        i++;
    }
    if (total > 1) {
        printf("The shell doesn't handle multiple piping\n");
        temp[0] == NULL;
    } 

}

int readParseLine(char* args[], char* pipeArgs[], char line[]) {
    char* temp[MAX_WORD];
    int i = 0;
    int j = 0;

    readLine(line);
    processLine(temp, line);
    checkLine(temp);
    int position = pipeRedirectionCheck(temp);

    while(i < position) {
        args[i] = temp[i];
        i++;
    }
    args[i] == NULL;
    i++;
    if (pipingFlag == 1) {
        while(temp[i] != NULL) {
            pipeArgs[j] = temp[i];
            i++;
            j++;
        }
    }

    return 1;
}

void pipeHandle(char* args[], char* pipeArgs[], int* pipefd) {
    int pid;
    int i;

    pid = fork();

    if (pid == 0) {
        dup2(pipefd[1], 1);
        close(pipefd[0]);
        execvp(args[0], args);
        close (pipefd[1]);
        perror(args[0]);
        wait(NULL);
    }
    else {
        dup2 (pipefd[0], 0);
        close (pipefd[1]);
        execvp(pipeArgs[0], pipeArgs);
        close(pipefd[0]);
        perror(pipeArgs[0]);
        wait(NULL);

    }
}

int main() {

    char* args[MAX_WORD];
    char* pipeArgs[MAX_WORD];
    char line[MAX_CHAR];
    
    //
    int* pipefd[2];
    pipe(*pipefd);

    printf("$ ");

     while(readParseLine(args, pipeArgs, line)) {

        printf("$ ");
   
        pid_t pid = fork();
        
        wait(NULL);
        if (pid == 0) {
            if (inputRedirectionFlag == 1 && inputFile != NULL) {
                dup2(open(inputFile, O_RDWR | O_CREAT, 0644), 0);
            }

            else if (outputRedirectionFlag == 1 && outputFile != NULL) {
                dup2(open(outputFile, O_RDWR | O_CREAT, 0644), 0);
            }

            else if (pipingFlag == 1) {
                pipeHandle(args, pipeArgs, *pipefd);
                exit(0);
            }
            execvp(args[0], args);
        }

        else {
            waitpid(pid, 0, 0);
            inputRedirectionFlag = 0;
            outputRedirectionFlag = 0;
            pipingFlag = 0;
            inputFile = NULL;
            outputFile = NULL;
        }
    }

    return 0;
}