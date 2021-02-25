import java.util.List;
public class exo01 {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        
        /*
        System.out.println("Print odd numbers: ");
        nums.stream().filter( i -> i % 2 == 1).forEach(System.out::println);

        
        System.out.println("Print courses with the word \"Spring\": ");
        courses.stream().filter(s -> s.contains("Spring")).forEach(System.out::println);
        
        System.out.println("Print the courses who's name's length is over 4: ");
        courses.stream().filter(s -> s.length() >= 4).forEach(System.out::println);
        
        printCourseLength(courses);
        
        courses.stream().forEach(course -> System.out.println(course.length()));
        
        courses.stream().map(i -> i.length()).forEach(System.out::println);
        */

        nums.stream().map(i -> "square root of " + i + " is " + i * i).forEach(System.out::println);
        courses.stream().map(i -> "length of " + i + " is " + i.length()).forEach(System.out::println); 
    }

    private static void printCourseLength(List<String> courses) {
        courses.stream().forEach(course -> {
            System.out.println(course.length());
        });
    }
}
