import java.util.Arrays;
import java.util.Scanner;

public class Q29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        System.out.println("Please Input a number");
        nums[0] = sc.nextInt();
        System.out.println("Please Input second numbr");
        nums[2] = sc.nextInt();
        Arrays.sort(nums);
        int sums = 0;
        for (int begin = nums[0] + 1; begin < nums[1]; begin++) {
            if (begin % 5 == 0) {
                sums += begin;
            }
        }
        System.out.println(sums);
    }
}
