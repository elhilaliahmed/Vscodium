import java.util.*;
class Employee {
    String name;
    int number;

    public int getNumber() {
        return number;
    }
    Employee (String name, int number) {
        this.name = name;
        this.number= number;
    }

    public String toString() {
        return "Name: " + name + "\nNumber: " + number + "\n";
    }

} 

class Test {

    public static void main(String[] args) {

        ArrayList<Employee> l = new ArrayList<>();
        l.add(new Employee("Ahmed", 1));
        l.add(new Employee("Laila", 2));
        l.add(new Employee("Julia", 3));
        l.add(new Employee("Asma", 4));

        System.out.println("Printing according to ascending numbers: ");
        Collections.sort(l, (e1, e2) -> (e1.number < e2.number) ? -1 : (e1.number > e2.number) ? 1 : 0);
        l.stream().forEach(System.out::println);

        System.out.println("Printing according to descending numbers: ");
        Collections.sort(l, (e1, e2) -> (e1.number < e2.number) ? 1 : (e1.number > e2.number) ? -1 : 0);
        l.stream().forEach(System.out::println);

        System.out.println("Printing according to ascending names: ");
        Collections.sort(l, (e1, e2) -> (e1.name.compareTo(e2.name)));
        l.stream().forEach(System.out::println);

        System.out.println("Printing according to descending name: ");
        Collections.sort(l, (e1, e2) -> (e2.name.compareTo(e1.name)));
        l.stream().forEach(System.out::println);

        int sum1 = l.stream().mapToInt(e -> e.number).sum();
        System.out.println(sum1);

        int sum2 = l.stream().mapToInt(Employee::getNumber).sum(); 
        System.out.println(sum2);
    }
}