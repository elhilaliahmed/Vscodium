import java.util.*;
class Employee implements Comparable {
    int id;
    String name;

    Employee (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Employee id: " + id +
               "\nEmployee name: " + name + "\n";
    }

    public int compareTo(Object obj) {
        Employee e = (Employee) obj;
        int id2 = e.id;
        if (id < id2) {
            return -1;
        }

        else if (id > id2) {
            return 1;
        }

        return 1;
    }
}

class myCmp implements Comparator {
    public int compare(Object a, Object b) {
        Employee e1 = (Employee) a;
        Employee e2 = (Employee) b;
        return e1.name.compareTo(e2.name);
    }
}

class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(2, "Laila");
        Employee e2 = new Employee(1, "Ahmed");
        Employee e3 = new Employee(3, "Julia");
        Employee e4 = new Employee(3, "Julia");
        Employee e5 = new Employee(5, "Julia");
        Employee e6 = new Employee(4, "Julia");


        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        System.out.println(employees);
    }
}