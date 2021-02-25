#include <stdio.h>
#include <stdlib.h>

int main()
{
    char *buffer;
    size_t bufsize = 32;
    size_t characters;

    buffer = (char *)malloc(bufsize * sizeof(char));
    if( buffer == NULL)
    {
        perror("Unable to allocate buffer");
        exit(1);
    }

    while(1) {
    printf("$ ");
        characters = getline(&buffer,&bufsize,stdin);
        system(buffer);
    }

    return(0);
}