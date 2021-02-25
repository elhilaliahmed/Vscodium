import java.util.*;

class WeakHashMapDemo {
    public static void main(String[] args) throws Exception{
        WeakHashMap m = new WeakHashMap();

        Temp t = new Temp();


        m.put(t, "Ahmed");
        System.out.println(m);
        t = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(m);
    }
}

class Temp {
    public String toString() {
        return "Hello";
    }

    public void finalize() {
        System.out.println("Finalize method called");
    }
}