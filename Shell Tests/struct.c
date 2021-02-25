#include <stdio.h>

typedef struct {
    int basic;
    int bonus;
} Salary;
typedef struct {
    char* name;
    int age;
    int sold;
    Salary salary;
} Employee;

int main()  {
    Employee ahmed = {"Ahmed", 25, 4000, 1000, 50};
    
    printf("%s\t %s\t %s\t %s\t %s\t", "Name", "Age", "sold", "Basic", "Bonus");

    printf("\n%s\t %d\t %s\t %s\t %s\t", ahmed.name, ahmed.age, ahmed.sold, ahmed.salary.basic, ahmed.salary.bonus);

    Employee laila = {"Laila", 32, 5500, 2000, 500};
    Employee *l = &laila;

    //printf("\n%s\t %d\t %d\t %s\t %s\t", l -> name, l -> age, l -> sold, l -> salary.basic, l -> salary.bonus);

    printf("\n%s\t %d\t %d\t %s\t %s\t", laila.name, laila.age, laila.sold, laila.salary.basic, laila.salary.bonus);
    
    Employee julia = {'\0', 0, 0, 5000, 650};
    
    printf("\n%s\t %d\t %d\t %s\t %s\t", julia.name, julia.age, julia.sold, julia.salary.basic, julia.salary.bonus);

    return 0;

}

