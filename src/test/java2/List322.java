import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class List322 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Tom");
        strings.add("Jerry");
        strings.add("Black");
        strings.add("Andy");
        strings.add("Lee");
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            System.out.println(str);
        }
    }
}
