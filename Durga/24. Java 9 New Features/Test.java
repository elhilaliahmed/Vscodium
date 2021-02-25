import java.util.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {
      
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(0);
        marks.add(5);
        marks.add(10);
        marks.add(15);
        marks.add(20);
        marks.add(25);
        System.out.println(marks);  
        marks = new ArrayList<>(marks.stream().map(i -> i + 2).collect(Collectors.toList()));
        System.out.println(marks); 

    } 
}
