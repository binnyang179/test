public class Q38 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        a = b - a;
        b = b - a;
        a = a + b;
        b = c - b;
        c = c - b;
        b = c + b;
        System.out.println("a:" + a + " b:" + b + " c:" + c);
    }
}
