# `malloc()`:
```c
    void* malloc(size_t size);
```
- `malloc` returns a `void*`
- it allocates `size` of bytes and returns a *pointer* to the allocated memory.
- If `size` is 0, then `malloc()` returns either `NULL` or a unique pointer value that can later be successfully passed to `free()`
- `malloc()` initializes everything with garbage values
## `malloc()` example:
- This code will allocate memory for 5 integers and initializes each one of them with garbage values.
```c
    int* p = (int*) malloc(5 * sizeof(int));
```
# `calloc()`:
``` c
    void* calloc(size_t nmemb, size_t size);
```
- `calloc` returns a `void*` pointer. It takes two arguments
  - `nmemb` number of elements
  - `size` the size of each elements in bytes
- If `nmemb` or `size` are 0, then `calloc()` returns either `NULL` or a unique pointer value that can later be successfully passed to `free()`.
- `calloc()` initializes everything to **0**;
## `calloc()` example:
- This code will allocate memory for 5 integers and initializes each one of them to 0
``` c
    int* p = (int*)calloc(5, sizeof(int))
```
# `free()`:
- `free()` is used to deallocate the memory that was allocated by `malloc()` or `calloc()`

# `realloc()`:
``` c
    void* realloc(void* ptr, size_t size);
```
- `realloc()` takes two arguments. The first is the pointer referencing the memory we want to extend. The second is the total number of bytes we want to reallocate
## `realloc example`:
- suppose we have allocated memory to hold 5 integers:
``` c
    int* ptr = (int*)calloc(5, sizeof(int));
```
- If we want to insert a 6th `ptr[5] = 5` element, that will not be possible
- We have to *reallocate*
``` c
    ptr = (int*)realloc(ptr, 7 * sizeof(int));
```
- Now we can insert two more elements.

**Note:**
- We can use `realloc()` to **free** instead of using `free()`the memory as well:
``` c
    realloc(ptr, 0);
    
    // equivalent to:

    free(ptr);
```
