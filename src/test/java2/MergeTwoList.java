import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MergeTwoList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(7);
        list.add(25);
        list.add(5);
        list.add(7);
        list.add(2);

        List<Integer> list1 = new ArrayList<Integer>();
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(7);
        list.add(25);
        list.add(5);
        list.add(7);
        list.add(2);

        TreeSet<Integer> set = new TreeSet<Integer>(list);
        set.addAll(list1);
        List<Integer> ss = new ArrayList<Integer>(set);
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < ss.size(); i += 2) {
            list2.add(ss.get(i));
        }
        for (int i = (ss.size()) / 2 * 2 - 1; i < 0; i++) {
            list2.add(ss.get(i));
        }
        System.out.println(list2);
    }
}
