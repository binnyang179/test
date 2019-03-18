public class JudegNum {
    public static void main(String[] args) {
        boolean b = judge(10, 21);
        System.out.println(b);
    }

    public static boolean judge(int x, int y) {
        return (x < y ? y % x : x % y) == 0;
    }
}
