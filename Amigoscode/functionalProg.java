

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.*;

class main {
    public static void main(String[] args) {
        
        List<Person> people = List.of(
            new Person("Ahmed", Gender.MALE),
            new Person("Laila", Gender.FEMALE),
            new Person("Julia", Gender.FEMALE),
            new Person("Asma", Gender.FEMALE),
            new Person("Yassine", Gender.MALE),
            new Person("Hassane", Gender.MALE)
            );
            
            // Imperative approach
            List<Person> females = new ArrayList<>();
            for (Person person : people) {
                if (person.getGender().equals(Gender.FEMALE)) {
                    females.add(person);
                }
            }
            /*
            for (Person female : females) {
               System.out.println(female);
            }
            */

            // Declarative approach
            Predicate<Person> isFemale = person -> person.getGender().equals(Gender.FEMALE);
            Predicate<Person> isMale = person -> person.getGender().equals(Gender.MALE);
            

            /*
            people.stream()
                    .filter(isFemale)
                    .forEach(System.out::println);
            */

            people.stream().filter(isMale).forEach(System.out::println);
            
            //females.forEach(System.out::println);
            

    }

}












class Person {

    private final String name;
    private final Gender gender;

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + "\nGender: " + gender + "\n";
    }
}

enum Gender {
    MALE, FEMALE
}

