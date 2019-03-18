public class Q49 {
    public static void main(String[] args) {
        int count =0;
        for (int i = 0; i <= 100 * 3; i += 3) {
            for (int j = 0; j <= 100/3; j++) {
                for (int k = 0; k <= 100 / 5; k++) {
                    if (i / 3 + j * 3 + k * 5 == 100 && i + j + k == 100) {
                        count++;
                        System.out.println("small" + i + "man" + j + "woman" + k);
                    }
                }
            }
        }
        System.out.println("summary:" + count + "sort of buying");
    }
}
