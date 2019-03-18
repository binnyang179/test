public class sequelSearch {
    public int sequelsearch(String[] s, String key, int n) {
        int i;
        i = 0;
        while (i < n && s[i] != key) {
            i++;
            if (s[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("sfs");
    }
}
