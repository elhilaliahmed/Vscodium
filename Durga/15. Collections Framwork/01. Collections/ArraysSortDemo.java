import java.util.*;
class ArraysSortDemo {

    public static void main(String[] args) {
        // Primitives 
        int[] a = {10, 5, 20, 11, 6};
        System.out.println("Primitive Array before sorting:");
        System.out.printf("[");
        for (int a1 : a) {
            System.out.printf("%d ", a1);
        }
        System.out.printf("]\n");

        Arrays.sort(a);
        System.out.println("Primitive Array after sorting:");
        System.out.printf("[");
        for (int a1 : a) {
            System.out.printf("%d ", a1);
        }
        System.out.printf("]");


        System.out.println();
        // Objects
        String[] s = {"A", "Z", "B", "F", "C"};
        System.out.println("Object Array before sorting:");
        System.out.printf("[");
        for (String s1 : s) {
            System.out.printf("%s ", s1);
        }
        System.out.printf("]\n");

        Arrays.sort(s);
        System.out.println("Object Array after sorting:");
        System.out.printf("[");
        for (String s1 : s) {
            System.out.printf("%s ", s1);
        }
        System.out.printf("]\n");
        Arrays.sort(s, new Desc());
        System.out.println("Object Array after sorting by Comparator:");
        System.out.printf("[");
        for (String s1 : s) {
            System.out.printf("%s ", s1);
        }
        System.out.printf("]");
    } 
}

class Desc implements Comparator {
    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 = b.toString();

        return -s1.compareTo(s2);
    }
}

