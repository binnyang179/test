import com.sun.org.apache.bcel.internal.generic.GotoInstruction;

import javax.imageio.IIOException;
import javax.lang.model.element.VariableElement;
import java.io.*;

public class Q39 {

    public int n = 0;
    MyThreaad[] threads = new MyThreaad[10];

    public Q39() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThreaad();
        }
    }

    class MyThreaad extends Thread {
        private File src;
        private File desc;
        public MyThreaad() {
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

    public static void copyFile(File src, File desc ) throws IOException {
        if (!desc.exists()) {
            desc.createNewFile();
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            FileInputStream fis= new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(desc);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            int b = -1;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        }finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.flush();
                bos.close();
            }

        }
    }

    public void copyDirectory(File sourceDir, File targetDir ) throws Exception {
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        File[] file = sourceDir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                File targetFile = new File(targetDir.getAbsolutePath() + File.separator + file[i].getName());
                MyThreaad t = threads[n++ % 10];
                t.set(file[i], targetFile);
                t.start();
                t.join();
                threads[n % 10] = new MyThreaad();
            }
            if (file[i].isDirectory()) {
                String dir2 = targetDir.getAbsolutePath() + File.separator + file[i].getName();
                copyDirectory(file[i], new File(dir2));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Q39().copyDirectory(new File("C:\\Users\\server20\\Documents\\a"), new File("C:\\Users\\server20\\Documents\\b"));
    }

}
