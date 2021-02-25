import java.util.*;

class PQcmp {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue(15, new Asce());

        q.offer("A");
        q.offer("Z");
        q.offer("L");
        q.offer("B");
        System.out.println(q);
    }

}

class Asce implements Comparator {

    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 =null b.toString();

        return s2.compareTo(s1);
    }
}
