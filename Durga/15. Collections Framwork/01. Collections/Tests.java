import java.util.*;
class ListIteratorDemo {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add("Ahmed");
        l.add("Laila");
        l.add("Julia");
        l.add("Asma");
        
        System.out.println(l);

        ListIterator itr = l.listIterator();
        while(itr.hasNext()) {
            String s = (String)itr.next();

            if (s.equals("Laila")) {
                itr.remove();      
            }

            else if (s.equals("Asma")) {
                itr.add("Laila");   
            }

            else if (s.equals("Julia")) {
                itr.set("Yassine");
            }
        }
        System.out.println(l);
    }
}


/*import java.util.*;
class EnumerationDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i <= 10; i++) {
            v.addElement(i);
        }

        System.out.println(v); 
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Integer I = (Integer)e.nextElement();
            if (I % 2 == 0) {
                System.out.println(I); 
            }
        }
        System.out.println(v); 
    }
}*/