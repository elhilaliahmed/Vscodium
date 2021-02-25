import java.util.Scanner;

class Anything {

    public static void main(String[] arguments) {
        boolean keepGoing = true;

        while (keepGoing) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int size = input.nextInt();

            if (size < 0) {

                keepGoing = false;
            }

            for (int i = 0; i < size; i++) {
                System.out.printf("Number: %d\n", (i + 1));
            }
        }
    } 
}