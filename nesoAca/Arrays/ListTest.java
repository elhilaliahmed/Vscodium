public class ListTest {

    public static void main(String[] args) {

        Student s = new Student("Ahmed", "0123456789", 25, new Address("Barenmatte", "Biel", "Switzerland"), "Math");

        Teacher t = new Teacher("Laila", "987654321", 32, new Address("Bahnhofmatte", "Biel", "Switzerland"), 5500);

        System.out.println(s);
        System.out.println("\n\n" + t);

    }
}

class Person {
    private String name;
    private String phoneNumber;
    private int age;
    private Address address;

    public Person(String name, String phoneNumber, int age, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name " + name + "\nPhoneNumber: " + phoneNumber + "\nAge: " + age + "\n" + address.toString();
    }
}

class Student extends Person {

    private String module;

    public Student(String name, String phoneNumber, int age, Address address, String module) {
        super(name, phoneNumber, age, address);
        this.module = module;
    }

    @Override
    public String toString() {
        return super.toString() + "\nModule: " + module;
    }

}

class Teacher extends Person {

    private int salary;

    public Teacher(String name, String phoneNumber, int age, Address address, int salary) {
        super(name, phoneNumber, age, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + salary;
    }
}

class Address {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Street " + street + "\nCity: " + city + "\ncountry: " + country;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
             
        }




        return false;
    }
}