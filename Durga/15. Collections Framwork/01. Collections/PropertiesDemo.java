import java.util.*;
import java.io.*;
class PropertiesDemo {
    public static void main(String[] args) throws Exception {
        
        Properties p = new Properties();

        FileInputStream fis = new FileInputStream("abc.txt");
        p.load(fis);

        System.out.println(p);

        String s = p.getProperty("ahmed");
        System.out.println(s);
        p.setProperty("nag", "88888");

        FileOutputStream fos = new FileOutputStream("abc.txt");

        p.store(fos, "Updated by Ahmed");
    }
}