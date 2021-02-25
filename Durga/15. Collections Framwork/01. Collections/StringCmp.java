import java.util.*;
class myCmp implements Comparator {
    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 = b.toString();

        return s1.length()  < s2.length() ? -1 : s1.length()  > s2.length() ? 1 : s1.compareTo(s2);     
    }
}
class Main {
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new myCmp());
        t.add("A");
        t.add("ABC");
        t.add("AA");
        t.add("XX");
        t.add("ABCD");
        t.add("A");
        t.add("Ahmed");

        System.out.println(t); 
    }
}


/*class myCmp implements Comparator {
    public int compare(Object a, Object b) {

        String s1 = (String) a;
        String s2 = (String) b;

        // alernative method to casting
        String s1 = a.toString();
        String s2 = b.toString();

        return s2.compareTo(s1);
    } 
}
*/

/*
class myCmp implements Comparator {
    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 = b.toString();

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 < l2) {
            return -1;
        }
        if (l1 > l2) {
            return 1;
        }
        return s1.compareTo(s2);       
    }
}



*/