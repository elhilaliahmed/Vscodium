import java.util.*;

class CollectionsSortDemo {

    public static void main(String[] args) {
        ArrayList l = new ArrayList();

        l.add("Z");
        l.add("A");
        l.add("K");
        l.add("N");

       // l.add(new Integer(10)); => ClassCastException
       // l.add(null);    => NullPointerException
     
       System.out.println("Before Sorting: " + l);
       Collections.sort(l, new Comparator<String>() {
            public int compare(String a, String b) {
               
                String s1 = a.toString();
               String s2 = b.toString();

               return s1.compareTo(s2);
            }
       });
       System.out.println("After Sorting: " + l);
    } 
}


