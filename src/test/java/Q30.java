import java.util.Scanner;

public class Q30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("Please input account");
            String name = scanner.nextLine();
            System.out.println("Please input password");
            String passwd = scanner.nextLine();
            if ("admin".equals(name) && "admin".equals(passwd)) {
                System.out.println("Success");
                break;
            } else {
                count++;
                if (count < 3) {
                    System.out.println("login failed,Please input again");
                } else {
                    System.out.println("u login times too many, failed");
                    break;
                }
            }
        }
    }
}
