import java.util.*;

class HashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap m = new LinkedHashMap();

        m.put("Ahmed", 100);
        m.put("Laila", 200);
        m.put("Julia", 500);
        m.put("Asma", 300);

        System.out.println(m);

        System.out.println(m.put("Ahmed", 1000));
        
        Set s = m.keySet();
        System.out.println(s);
        
        Collection c = m.values();
        System.out.println(c);

        Set s1 = m.entrySet();
        System.out.println(s1);

        Iterator itr = s1.iterator();
        while (itr.hasNext()) {
            Map.Entry m1 = (Map.Entry) itr.next();
            System.out.println(m1.getKey() + ".........." + m1.getKey());
            if (m1.getKey().equals("Asma")) {
                m1.setValue(10000);
            }
        } 
        System.out.println(m);
    }
}