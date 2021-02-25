import java.util.*;
class CollectionsSearchComparator {
    public static void main(String[] args) {

        ArrayList l = new ArrayList();

        l.add("Z");
        l.add("A");
        l.add("M");
        l.add("K");
        l.add("a");

        System.out.println(l);

        Collections.sort(l, new myCmp());

        System.out.println(l);

        System.out.println(Collections.binarySearch(l, "Z", new myCmp()));
        System.out.println(Collections.binarySearch(l, "J", new myCmp()));   
    } 
}

class myCmp implements Comparator {
    public int compare(Object a, Object b) {
        String s1 = a.toString();
        String s2 = b.toString();
        return s1.compareTo(s2);
    }
}
