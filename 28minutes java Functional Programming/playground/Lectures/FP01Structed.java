import java.util.List;

class FP01Structured {

    public static void main(String[] args) {

        printAllNumsInListStructred(List.of(1, 10, 45, 12, 5, 6, 15, 12));

    }

    private static void printAllNumsInListStructred(List<Integer> numbers) {
        System.out.println("Functional way");

        numbers.stream().forEach(System.out::println);

        System.out.println("Imperative way");

        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("Imperative way with Object");

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
}
