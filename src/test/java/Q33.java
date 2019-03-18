import jdk.nashorn.api.tree.ReturnTree;
import org.hamcrest.Condition;

import javax.swing.text.StyledEditorKit;

public class Q33 {
    private static boolean same(int[] p, int l, int n) {
        for (int i = 0; i < l; i++) {
            if (p[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static void play(int playerNum, int step) {
        int[] p = new int[playerNum];
        int counter = 1;
        while (true) {
            if (counter > playerNum * step) {
                break;
            }
            for (int i = 0; i < playerNum + 1; i++) {
                while (true) {
                    if (same(p, playerNum, i) == false)
                        break;
                    else
                        i = i + 1;
                }
                if (i > playerNum)
                    break;
                if (counter % step == 0) {
                    System.out.println(i + " ");
                    p[counter / step - 1] = i;
                }
                counter += 1;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        play(10, 7);
    }
}
