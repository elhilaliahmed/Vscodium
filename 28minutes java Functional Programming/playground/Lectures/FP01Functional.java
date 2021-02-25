import java.util.List;
public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        /*
        printAllNumsInListFunctional(numbers);
        
        printEvenNumber(numbers);
        
        printOddNumber(numbers);

        incList(numbers);

        printEvenSquare(numbers);
*/
        numbers
            .stream()
            .filter(number -> number % 2 != 0)
            .map(number -> number * number * number)
            .forEach(System.out::println);
    }

    private static void printEvenSquare(List<Integer> numbers) {
        numbers
            .stream()
            .filter(number -> number % 2 == 0)
            .map(number -> number * number)
            .forEach(System.out::println);
    }

    private static void print(int number) {
        System.out.println("This is cool: " + number);
    }

    private static void doubleAndPrint(int number) {
        number = number * 2;
        print(number);

    }

    private static void incList(List<Integer> numbers) {
        numbers.stream().map(FP01Functional::incremente).forEach(System.out::println);
    }

    private static void printAllNumsInListFunctional(List<Integer> numbers) {

        numbers.stream().forEach(FP01Functional::doubleAndPrint);
    }

    private static void printEvenNumber(List<Integer> numbers) {
        numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
    }

    private static void printOddNumber(List<Integer> numbers) {
        numbers.stream().filter( x -> x % 2 == 1).forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static int incremente(int number) {
        return number + 1;
    }
}
