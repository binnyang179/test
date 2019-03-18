public class Q31 {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                System.out.println(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.println(num(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int num(int x, int y) {
        if (y == 1 || y == x) {
            return 1;
        }
        int c = num(x - 1, y - 1) + num(x - 1, y);
        return c;
    }
}
