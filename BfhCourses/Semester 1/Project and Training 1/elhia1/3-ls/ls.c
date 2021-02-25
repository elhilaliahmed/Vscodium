/**
 * Author       : Ahmed Elhilali
 * Created      : 14/01/2021
 * Last updated : 18/01/2021
 * Description  : This program tries to imitate the behaviour of the ls command. It's specifically tries to behave like ls -1 -F.
 */


#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>    
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>


/**
 * This function checks if the provided path is regular file.
 * @param path is a directory or file path.
 */
int isRegularFile(const char* path); 

/**
 * This function checks if the provided path is an executable file.
 * @param path is a directory or file path.
 */
int isExecutable(const char* path); 

 /** 
 * This function tries to mimic the behaviour of the -F argument in the ls command.
 *      - It prints directories with a '/' symbole at the end.
 *      - It prints executable files with an '*' symbole at the end.
 *      - It prints symlink files with an '@' symbole at the end.
 * @param path is a directory or file path.
 */
void listDirectoryContent (const char* path); 


int main(int argc, char** argv) {
    char* directory;
    int length = 0;
    if (argc > 1) {
        directory = argv[1];
        if (isRegularFile(directory)) {
            printf("%s\n", directory);
            return 0;
        }

        length = strlen(directory);
    }

    if (length > 0) {
        listDirectoryContent (directory);
    }

    else {
        listDirectoryContent (".");
    }

    return 0;
}    

int isRegularFile(const char* path) {
    struct stat pstat;
    stat(path, &pstat);
    return S_ISREG (pstat.st_mode);
}

int isExecutable(const char* path) {
    struct stat pstat;
    stat(path, &pstat);
    return (((pstat.st_mode & S_IXUSR) || (pstat.st_mode & S_IEXEC)));
}

void listDirectoryContent (const char* path) {
    struct dirent* dir;
    DIR* folder = opendir(path);

    if(folder) {
        while ((dir = readdir(folder))) {
            char* line = dir -> d_name;
            
            if (line[0] == '.') {
                continue;
            }
            
            else if (dir -> d_type == DT_REG) {
                if (isExecutable(dir -> d_name)) {
                    printf("%s*\n", dir -> d_name);
                }
                else {
                    printf("%s\n", dir -> d_name);
                }    
            }

            else if (dir -> d_type == DT_DIR) {
                printf ("%s/\n", dir -> d_name);
            }

            else if (dir -> d_type == DT_LNK) {
                printf("%s@\n", dir -> d_name);
            }
        }
        closedir(folder);
    }
}
