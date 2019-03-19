import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map325 {
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>();
        stringIntegerHashMap.put("zhanghao", 22);
        stringIntegerHashMap.put("guoyan", 22);
        stringIntegerHashMap.put("yangbin", 33);
        stringIntegerHashMap.put("whowever", 22);

        Set<Map.Entry<String, Integer>> entrySet = stringIntegerHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ";" + entry.getValue());
        }
    }
}
