public class Q36 {
    public static void main(String[] args) {
        for (int i = 101; i < 200; i++) {
            boolean b = true;
            for (int n = 2; n < i; n++) {
                if (i % n == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println(i);
            }
        }
    }
}
