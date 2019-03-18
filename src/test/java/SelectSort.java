import java.util.concurrent.ForkJoinPool;

public class SelectSort {
    public static void selectionSort(int[] number) {
        for (int i = 0; i < number.length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[j] < number[m])
                    m = j;
            }
            if (i != m)
                swap(number, i, m);
        }
    }

    public static void swap(int[] number, int i, int j) {
        int t;
        t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100) + 1;
        }
        selectionSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
