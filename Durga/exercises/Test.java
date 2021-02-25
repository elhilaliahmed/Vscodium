interface Interf {
    public int add(int a, int b);
}

public class Test {

    public static void main(String[] args) {
        Interf i = (a, b) -> a + b;
        int a = i.add(10, 20);
        System.out.println(a);

    }
}