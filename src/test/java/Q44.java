public class Q44 {
    public static void main(String[] args) {
        divide();
    }
    public static void divide() {
        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0 && i % 7 != 0 || i % 5 != 0 && i % 7 == 0) {
                System.out.println(i);
            }
        }
    }
}
