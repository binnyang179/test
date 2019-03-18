public class Q43 {
    public static void main(String[] args) {
        String hex = hexConvert(7);

    }

    public static String hexConvert(int d) {
        String s = "";
        do {
            int f = d % 2;
            if (f == 1) {
                s = "1" + s;
            } else if (f == 0) {
                s = "0" + s;
            }
            d /= 2;
        } while (d != 0);
        return s;
    }
}
