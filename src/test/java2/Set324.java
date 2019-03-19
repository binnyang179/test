import java.util.*;

public class Set324 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("zhao");
        set.add("lisi");
        set.add("yangbin");

        Iterator<String> ite = set.iterator();
        while (ite.hasNext()) {
            String egg = ite.next();
            System.out.println(egg);
        }
    }
}
