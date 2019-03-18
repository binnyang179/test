public class Factorial {
    public static void main(String[] args) {
        long n = 5;
        System.out.println(doFactorial(n));
    }
    public static long doFactorial(long n) {
        if (n < 1) {
            System.out.println("ERROR");
            return 0;
        } else if (n == 1 | n==1) {
            return n;
        } else {
            return n * doFactorial(n - 1);
        }
    }
}
