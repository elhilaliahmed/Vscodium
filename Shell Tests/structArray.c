#include <stdio.h>

typedef struct {
    char* name;
    int age;
    int salary;
} Employee;

void display(Employee[], int);

int main() {

    printf("%s\t %s\t %s\t", "Name", "Age", "salary");

    Employee emp[3] = {
        {"Ahmed", 25, 4000},
        {"Laila", 32, 5000},
        {"Julia", 53, 6500},
    };
    display(emp, 3);

    return 0;
}

void display(Employee employee[], int size) {
    for(int i = 0; i < size; i++) {
        printf("\n%s\t %d\t %d\t", employee[i].name, employee[i].age, employee[i].salary);
    }
}