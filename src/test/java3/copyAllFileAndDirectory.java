import java.io.*;
import java.util.Scanner;

public class CopyAllFileAndDirectory {

    MyThread[] threads = new MyThread[10];
    int n = 0;

    public CopyAllFileAndDirectory() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String inputDirectory = new String();
        String outputDirectory = new String();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input directory location");
        inputDirectory = scanner.nextLine();
        outputDirectory = scanner.nextLine();
        new CopyAllFileAndDirectory().copyDirectory(new File(inputDirectory), new File(outputDirectory));
        scanner.close();
    }

    public void copyDirectory(File sourceDir, File targetDir) throws InterruptedException {
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }
        File[] file = sourceDir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                File targetFile = new File(targetDir.getAbsolutePath() +
                        File.separator + file[i].getName());
                MyThread myThread = threads[n++ % 10];
                myThread.set(file[i], targetFile);
                myThread.start();
                myThread.join();
                threads[n % 10] = new MyThread();
            }
            if (file[i].isDirectory()) {
                String dir2 = targetDir.getAbsolutePath() + File.separator +
                        file[i].getName();
                copyDirectory(file[i], new File(dir2));
            }
        }
    }

    class MyThread extends Thread {
        private File src;
        private File desc;

        public MyThread() {
        }

        public void set(File src, File desc) {
            this.src = src;
            this.desc = desc;
        }

        @Override
        public void run() {
            try {
                copyFile(src, desc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(File src, File desc) throws IOException {
        if (!desc.exists()) {
            desc.mkdir();
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);

        int b = -1;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
    }
}
