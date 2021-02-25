public class StringExo {
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder(5);
        String s = "";

        if (sb.equals(s)) {
            System.out.println("Match 1");
        }

        else if (sb.toString().equals(s.toString())) {
            System.out.println("Match 2");
        }
        
        else {
            System.out.println("No match!");
        }

        sb.append("Ahmed Elhilali");
        System.out.println(sb);
        sb.delete(0, sb.length());
        System.out.println(sb.length());
        StringExo t = new StringExo();
        System.out.println("Hello " + new StringBuilder("Java SE 8"));
        System.out.println("Hello " + t);
    }
}

