public class Q48 {
    public static int getAge(int a) {
        if (a == 1)
            return 10;
        else
            return getAge(a -1)+2;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = getAge(a);
        System.out.println(b);
    }
}
