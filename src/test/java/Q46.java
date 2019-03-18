import java.util.Scanner;

public class Q46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input num:");

        long inputValueLong = scanner.nextLong();
        long temp = inputValueLong;
        long reverseLong = 0L;
        while (inputValueLong != 0) {
            reverseLong = reverseLong * 10 + inputValueLong % 10;
            inputValueLong = inputValueLong / 10;
        }
        if (reverseLong == temp) {
            System.out.println("u had input huiwen");
        } else {
            System.out.println("u don't imput huiwen");
        }
    }
}
