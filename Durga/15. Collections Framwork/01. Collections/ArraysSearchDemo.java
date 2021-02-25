import java.util.*;
class ArraysSearchDemo {
    public static void main(String[] args) {
        int[] a = {10, 5, 20, 11, 6};
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, 6));  
        System.out.println(Arrays.binarySearch(a, 14));

        String[] s = {"A", "Z", "B"};
        Arrays.sort(s);
        System.out.println(Arrays.binarySearch(s, "Z"));    
        System.out.println(Arrays.binarySearch(s, "S"));    

        Arrays.sort(s, new Desc());
        System.out.println(Arrays.binarySearch(s, "Z", new Desc()));  
        System.out.println(Arrays.binarySearch(s, "S", new Desc()));   
        //System.out.println(Arrays.binarySearch(s, "N"));    => unpredictable result, we have to pass a Comparator object to the method

    }
    
}

class Desc implements Comparator {
    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 = b.toString();
        return -s1.compareTo(s2);
    }
}
