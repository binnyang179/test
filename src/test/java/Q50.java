public class Q50 {
    public static void main(String[] args) {
        int i ;
        int num = 1020;
        for (i = 1; ; i++) {
            num = num - (num / 2 + 2);
            System.out.println("the" + i + "day left" + num + "s");
            if (num == 0)
                break;
        }
        System.out.println(i + "day sold out");
    }
}
