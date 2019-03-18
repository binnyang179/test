public class Q40 {
    public static void main(String[] args) {
        System.out.println("first month rabbit's sum: 1");
        System.out.println("second month rabbit's sum: 1");
        int f1 = 1, f2 = 1, f, m = 24;
        for (int i = 3; i < m; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("The " + i + "month rabbit's sum: " + f2);
        }
    }
}
