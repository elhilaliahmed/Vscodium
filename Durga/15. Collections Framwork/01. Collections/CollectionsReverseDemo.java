import java.util.*;

class CollectionsReverseDemo {
   public static void main(String[]  args) {
       ArrayList l = new ArrayList();

       l.add(15);
       l.add(0);
       l.add(20);
       l.add(10);
       l.add(5);

       System.out.println(l);  
       Collections.reverse(l);
       System.out.println(l);   
   } 
}
