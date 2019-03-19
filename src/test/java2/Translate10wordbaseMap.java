import java.util.HashMap;
import java.util.Map;

public class Translate10wordbaseMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("jan", "一月");
        map.put("feb", "二月");
        String str = "jan";
        if (map.containsKey(str)) {
            System.out.println(map.get(str));
        } else {
            System.out.println("there isn't the word");
        }
    }
}
