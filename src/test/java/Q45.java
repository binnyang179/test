import java.net.Inet4Address;
import java.util.Arrays;

public class Q45 {
    public static void main(String[] args) {
        char[] chars = new char[36];
        for (int i = 0; i < 26; i++) {
            chars[i] =(char)( 65 + i);
            System.out.println(chars[i]);
        }
        for (int i = 0; i < 10; i++) {
            chars[26 + i] = (char) (48 + i);
            System.out.println(chars[26+i]);
        }

        boolean[] flags = new boolean[chars.length];

        char[] chs = new char[6];
        for (int i = 0; i < chs.length; i++) {
            int index;
            do {
                index = (int) (Math.random() * (chars.length));
            } while (flags[index]);
            chs[i] = chars[index];
            flags[index] = true;
        }
        String code = Arrays.toString(chs);
        System.out.println(code);
    }
}
