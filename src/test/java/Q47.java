public class Q47 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}

//for (int i = 1; i <=9; i++) {
//        for (int j = 1; j <=9; j++) {
//        System.out.print(j+"*"+i+"="+(i*j)+"\t");
//        }
//        System.out.println();
//        }

//for (int i = 1; i <=9; i++) {
//        for (int j = 1; j <=i; j++) {
//        System.out.print(j+"*"+i+"="+(i*j)+"\t");
//        }
//        System.out.println();
//        }
//for (int i=1; i<=9; i++) {
//        for (int j=i; j<=9; j++) {
//        System.out.print(j+"*"+i+"="+(i*j)+"\t");
//        }
//        System.out.println();
//        }
