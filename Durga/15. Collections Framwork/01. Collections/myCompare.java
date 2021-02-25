import java.util.*;
class myComparator implements Comparator {
    public int compare(Object a, Object b) {
        Integer x = (Integer) a;
        Integer y = (Integer) b;
        return y - x;
    }
}

class Main {

    public static void main(String[] args) {
        TreeSet t = new TreeSet(new myComparator());
        t.add(10);
        t.add(0);
        t.add(15);
        t.add(20);
        t.add(20);
        System.out.println(t);  
        System.out.println();  

        t = new TreeSet();
        t.add(10);
        t.add(0);
        t.add(15);
        t.add(20);
        t.add(20);
        System.out.println(t);  
    }
}