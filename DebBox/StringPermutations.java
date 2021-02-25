import java.util.List;
import java.util.ArrayList;
class Permutations {
    
    public static void calcualte(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        }

        else {
            for (int i = left; i <= right; i++) {
                String swapped = swap(str, left, i);
                calcualte(swapped, left + 1, right);
            }
        }

    }

    public static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}

class Main {
    public static void main(String[] args) {
        String s = "ABC";
        int n = s.length();
        Permutations.calcualte(s, 0, n - 1); 
    }
}