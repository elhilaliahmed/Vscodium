class Highlander {
    private static Highlander instance;
    private Highlander() {} // prevent instantiation
    public static Highlander getInstance() {
        if (instance == null) {
            instance = new Highlander();
        }
        return instance;
    }


    public int add (int a, int b) {
        return a + b;
    }

    public int mul (int a, int b) {
        return a * b;
    }
}

class Calculate {
    private static Calculate instance = new Calculate();
    private Calculate() {}

    public static Calculate getInstance() {
        return instance;
    }
    public int add (int a, int b) {
        return a + b;
    }

    public int mul (int a, int b) {
        return a * b;
    }
}

class Mathe {
    public final static Mathe INSTANCE = new Mathe();
    private Mathe() {}

    public int add (int a, int b) {
        return a + b;
    }

    public int mul (int a, int b) {
        return a * b;
    }
}

class Main {
    public static void main(String[] args) {
        Calculate calculate = Calculate.getInstance();
        int x = calculate.add(5, 5);
        int y = calculate.mul(5, 5);

        Mathe calc = Mathe.INSTANCE;
        
        System.out.println(calc.add(15,15));
        System.out.println(calc.mul(15, 15));

    }
}





