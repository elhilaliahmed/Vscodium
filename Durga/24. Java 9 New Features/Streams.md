# `Collection` vs `Stream`: 
- If we want to represent a group of objects as a single entity, then we should go `Collection`
- If we want to process objects from the `Collection` then we should go for `Stream`

# How to get a `Stream`?:
- To do that, we have use `stream()` method

``` java
    Stream s = c.stream();

    => c is a Collection
```
- `Stream` exist in `java.util.stream` package

**Example:**
- Select only even numbers from the following `ArrayList`
``` java 
    ArrayList<Integer> l = new ArrayList<Integer>();
    l.add(0);
    l.add(5);
    l.add(10);
    l.add(15);
    l.add(20);
    l.add(25);
    System.out.println(l);  => [0, 5, 10, 15, 20, 25]

    List<Integer> evenList = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    System.out.println(evenList);   => [0, 10, 20]
```
- Adding two marks to each student
``` java 
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<Integer>();
            marks.add(0);
            marks.add(5);
            marks.add(10);
            marks.add(15);
            marks.add(20);
            marks.add(25);
            System.out.println(marks);  => [0, 5, 10, 15, 20, 25] 
        
            List<Integer> marksUpdate = marks.stream().map(i -> i + 2).collect(Collectors.toList());
            System.out.println(marksUpdate); => [2, 7, 12, 17, 22, 27]
        }
        
    }  
```

``` java
    import java.util.*;
    import java.util.stream.*;

    public class Test {

        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<Integer>();
            marks.add(0);
            marks.add(5);
            marks.add(10);
            marks.add(15);
            marks.add(20);
            marks.add(25);
            System.out.println(marks); => [0, 5, 10, 15, 20, 25] 
            marks = new ArrayList<Integer>(marks.stream().map(i -> i + 2).collect(Collectors.toList()));

            System.out.println(marks); => [2, 7, 12, 17, 22, 27]

        } 
    }
```

``` java
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
            System.out.println(marks); => [0, 5, 10, 15, 20, 25] 
            marks = new ArrayList<>(marks.stream().map(i -> i + 2).collect(Collectors.toList()));

            System.out.println(marks); => [2, 7, 12, 17, 22, 27]

        } 
    }
```

#  `filter()`:
- Always takes a `Predicate` as an argument

# `map()`:
- Always takes a `Function` as an argument

- Number of failed students:

``` java
    import java.util.*;
    import java.util.stream.*;

    public class Test {

        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            int failedStudents = (int)(marks.stream().filter(x -> x < 50).count());

            System.out.println(failedStudents);  => 4
        } 
    }
```
- Sorting the list

``` java
    import java.util.*;
    import java.util.stream.*;

    public class Test {

        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            List<Integer> sortedList = marks.stream().sorted().count().collect(Collectors.toList());

            System.out.println(sortedList);  
        } 
    }
```
# `Comparator` and lambdas:
-   `Comparator` => `compare(obj1, obj2)`
    - returns -value iff obj1 has to come before obj2
    - returns +value iff obj1 has to come after obj2
    - returns 0 iff obj1 and obj2 are equal

- Descending oder:
`(i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0`

# sorted() vs sorted(Comparator c):
sorted() => if we don't provide any arguments then we will sort arrording to default natural sorting order
sorted(Comparator c) => Customized sorting 

``` java
    import java.util.*;
    import java.util.stream.*;

    public class Test {

        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            List<Integer> sortedList = marks.stream().sorted((x, y) -> (x < y) ? 1 : (x > y) ? -1 : 0).collect(Collectors.toList());

            System.out.println(sortedList); 
            
            Comparator<Integer> c = (x, y) -> (x < y) ? 1 : (x > y) ? -1 : 0;
            List<Integer> sortedList = marks.stream().sorted(c).collect(Collectors.toList());
        } 
    }
```
**Note:**
- Internally in the default natural sorting order, the method `compareTo()` from the `Comparable` interface is used to decided the order of the elements

- Calling sorted() with the default CompareTo() method
``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            List<Integer> sortedList = marks.stream().sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());

            System.out.println(sortedList); 
        } 
    }
```

- Reversing default natural order:
- We can do that either by reversing the sign 

``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            List<Integer> sortedList = marks.stream().sorted((x, y) -> -x.compareTo(y)).collect(Collectors.toList());

            System.out.println(sortedList); 
        } 
    }
```
- Or by reversing the order of the arguments

``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(35);
            marks.add(45);
            marks.add(10);
            marks.add(15);
            marks.add(80);
            marks.add(65);
            System.out.println(marks); 
            
            List<Integer> sortedList = marks.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());

            System.out.println(sortedList); 
        } 
    }
```

``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<String> names = new ArrayList<>();
            names.add("Ahmed");
            names.add("Laila");
            names.add("Julia");
            names.add("Asma");
            names.add("Yassine");
            names.add("Hassane");
            System.out.println(names); 
            
            List<String> sortedList = names.stream().sorted().collect(Collectors.toList());

            System.out.println(sortedList); => This will give the natural sorting order 
        } 
    }
```

``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<String> names = new ArrayList<>();
            names.add("Ahmed");
            names.add("Laila");
            names.add("Julia");
            names.add("Asma");
            names.add("Yassine");
            names.add("Hassane");
            System.out.println(names); 
            
            List<String> sortedList = names.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());

            System.out.println(sortedList); => This will give the reverse of natural sorting order 
        } 
    }
```
``` java
    (s1, s2) -> s1.compareTo(s2) => natural sorting order
   (s1, s2) -> -s2.compareTo(s1) => natural sorting order

    
    (s1, s2) -> -s1.compareTo(s2) => reverse natural sorting order
    (s1, s2) -> s2.compareTo(s1) =>  reverse natural sorting order
```

- Sort according to ascending length order

``` java
    import java.util.*;
    import java.util.stream.*;
    public class Test {
        public static void main(String[] args) {
            ArrayList<String> names = new ArrayList<>();
            names.add("Ahmed");
            names.add("Laila");
            names.add("Julia");
            names.add("Asma");
            names.add("Yassine");
            names.add("Hassane");
            System.out.println(names); 
            
            Comparator<String> c = (a, b) -> (a.length() < b.length()) ? -1 : (a.length() > b.length() ? 1 : 0); 
            List<String> sortedList = names.stream().sorted(c).collect(Collectors.toList());

            System.out.println(sortedList); => This will give the reverse of natural sorting order 
        } 
    }
```
- We can also write the `Comparator` like this:

``` java
    Comparator<String> slength = (a, b) -> {
        int s1 = a.length();
        int s2 = b.length();
        return s1 - s2;
    }
```

# `min()` and `max()`:
- In sorting, minimum and maximum values are not defined according the the actual value, but rather they are based on the sorting order
  - The first element is the min
  - The last value is the max

- We can't talk about minimun and maximum without talking about sorting
- Both min and max take a `Comparator` object
``` java
    min(Comparator c);
    max(Comparator c);
```

**Example:**

``` java
    import java.util.*;
    import java.util.stream.*;
    class Test {
        public static void main(String[] args) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(10);
            l.add(0);
            l.add(15);
            l.add(5);
            l.add(20);

            Integer minValue = l.stream().min((x, y) -> x.compareTo(y)).get();
            System.out.println(minValue); => 0
            Integer maxValue = l.stream().max((x, y) -> -x.compareTo(y)).get();
            System.out.println(maxValue); => 20

            Integer maxValue = l.stream().max((x, y) -> x.compareTo(y)).get();
            System.out.println(maxValue); => 20
            Integer maxValue = l.stream().min((x, y) -> -x.compareTo(y)).get();
            System.out.println(maxValue); => 20
        }
    }
```

# Printing all elements:
``` java
    import java.util.*;
    import java.util.stream.*;
    class Test {
        public static void main(String[] args) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(10);
            l.add(0);
            l.add(15);
            l.add(5);
            l.add(20);

            for (Integer i : l) {
                System.out.println(i);
            }

            l.stream().forEach(System.out::println);
        }
    }
```

- `l.stream().forEach(Consumer);` For every element in the stream, some function will be executed

- Inside the `forEarch` we can call any `Consumer`

``` java
    import java.util.*;
    import java.util.stream.*;
    import java.util.function.*;
    class Test {
        public static void main(String[] args) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(10);
            l.add(0);
            l.add(15);
            l.add(5);
            l.add(20);

            // First way
            Consumer<Integer> c = i -> {
                System.out.println("The square of " + i + " is: " + i * i);
            };
            l.stream().forEach(c);

            // Second way
             Consumer<Integer> c = i -> System.out.println("The square of " + i + " is: " + i * i);
            l.stream().forEach(c);

             // Third way
            l.stream().forEach(i ->System.out.println("The square of " + i + " is: " + i * i));
        }
    }
```
# `toArray()`:

- Used to convert stream of objects into an array

``` java
    import java.util.*;
    import java.util.stream.*;
    import java.util.function.*;
    class Test {
        public static void main(String[] args) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(10);
            l.add(0);
            l.add(15);
            l.add(5);
            l.add(20);

            // Using constructor reference
            Integer[] ar = l.stream().toArray(Integer[]::new);
        }
    }
```
- `Test::new` would create an object of Test
- `Integer[]::new` would create a new Integer[] object

# Getting a Stream from an Array:

``` java
    import java.util.*;
    import java.util.stream.*;
    import java.util.function.*;
    class Test {
        public static void main(String[] args) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(10);
            l.add(0);
            l.add(15);
            l.add(5);
            l.add(20);

            // Using constructor reference
            Integer[] nums = l.stream().toArray(Integer[]::new);
            Stream.of(nums).forEach(System.out::println);
        }
    }
```
- When we finish processing the data and don't want to add any new elements, then it is better to convert it to an array, because arrays are much more efficient

- Any collection of values or objects can be converted to a Stream

**Example:**
``` java
    import java.util.*;
    import java.util.stream.*;
    import java.util.function.*;
    class Test {
        public static void main(String[] args) {

            Stream<Integer> s= Stream.of(9, 99, 999, 9999, 99999);
            s.forEach(System.out::println);

            Integer[] i = {10, 20, 30, 40, 50};
            
            // Print the elements one by one
            Stream.of(i).forEach(System.out::println);

            //Print the elements and their square value
            Stream.of(i).forEach(i -> System.out.println("Square of " + i + " is: " + i * i))
        }
    }
```



