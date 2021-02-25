interface Interf {
    public int square(int n);
}

public class Square {
    public static void main(String[] args) {
        
        Interf i = n -> n * n;
        i.square(5);
        System.out.println(i.square(10));
    }
}