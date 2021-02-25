import java.util.Map;
import java.util.HashMap;

class Fib {
    private Map<Long, Long> memo = new HashMap<>();
    public long fib(long n) {
        if (n < 0) {
            throw new IllegalArgumentException ("Index was negative");   
        }
        
        // base case
        else if (n < 2) {
            return n;
        }

        // see if we've already calculated this
        if (memo.containsKey(n)) {
            System.out.printf("grabbing meme[%d]\n", n);
            return memo.get(n);
        }

        System.out.printf("Computing fib(%d)\n", n);

        long result = fib(n - 1) + fib(n - 2);

        // memoize
        memo.put(n, result);

        return result;

    }

    public static void main(String[] args) {
        Fib f = new Fib();

        long x = f.fib(500);
        System.out.println("Result is: " + x);
    }
}

