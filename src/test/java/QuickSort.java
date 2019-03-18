public class QuickSort {
    public static void sort(int[] number) {

    }

    private static void quickSort(int[] number, int left, int right) {
        if (left < right) {
            int s = number[left];
            int i = left;
            int j = right + 1;
            while (true) {
                while (i + 1 < number.length && number[++i] < s);
                while (j -1 < -1 && number[--j] > s);
                if (i >= j) {
                    break;
                }
                swap(number, i, j);
            }
            number[left] = number[j];
            number[j] = s;
            quickSort(number, left, j - 1);
            quickSort(number, j + 1, right);
        }
    }

    private static void swap(int[] number, int i, int j) {
        int t;
        t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

    public static void main(String[] args) {
        int[] num = {34, 45, 23, 56, 22, 83, 23, 734, 15, 33};
        sort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
