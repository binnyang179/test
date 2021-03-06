import javax.lang.model.element.VariableElement;
import java.io.*;
import java.net.URL;
import java.util.*;

class ThreadDownLoad extends Thread {
    private File src;
    private File desc;
    public ThreadDownLoad() {
    }

    public void set(InputStreamReader inputStreamReader, FileWriter fileWriter) {
        BufferedReader reader;
        BufferedWriter writer;
        String line;

        try {
            reader = new BufferedReader(inputStreamReader);
            writer = new BufferedWriter(fileWriter);
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fa() {

    }
}

public class GetAllPosterFromDoubanMultiThread {
    private static String[] eachdoubanUrl = new String[10];
    static Map<String, String> movieMapImageAndName = new HashMap<String, String>();

    /////////////
    static ThreadDownLoad[] tenMultiThreadDownload = new ThreadDownLoad[10];
    public int n = 0;

    public GetAllPosterFromDoubanMultiThread() {
        for (int i = 0; i < tenMultiThreadDownload.length; i++) {
            tenMultiThreadDownload[i] = new ThreadDownLoad();
        }
    }
///////////////////////

    public static void main(String[] args) {


        getdouabnUrlList();
        mkDirOfDoubanData();
        storeDoubanWebpage();
        getPosterUrl();
        mkPosterFile();
    }

    public static void getdouabnUrlList() {
        for (int i = 0; i < 10; i++) {
            eachdoubanUrl[i] = "https://movie.douban.com/top250?start=" + i * 25 + "&filter=";
        }
    }

    public static void mkDirOfDoubanData() {
        String webDir = "data/doubanWeb";
        String PosterDir = "data/Poster";
        File webDirFile = new File(PosterDir);
        File posterDirFile = new File(webDir);
        if (!webDirFile.exists()) {
            webDirFile.mkdirs();
        }
        if (!posterDirFile.exists()) {
            posterDirFile.mkdir();
        }
    }

    public static void storeDoubanWebpage() {
        URL url;
        BufferedReader reader;
        BufferedWriter writer;
        String line;
        try {
            for (int i = 0; i < eachdoubanUrl.length; i++) {
                url = new URL(eachdoubanUrl[i]);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                writer = new BufferedWriter(new FileWriter("data/doubanWeb/" + i + ".html"));
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                reader.close();
                writer.close();

                //there will be a little priblem
                ThreadDownLoad threadDownWebPage = tenMultiThreadDownload[i++ % 10];
                threadDownWebPage.set(new InputStreamReader(url.openStream()), new FileWriter("data/doubanWeb/" + i + ".html"));

                ////////////////////////


            }
        } catch (Exception mue) {
            mue.printStackTrace();
        } finally {
            System.out.println("Those douban wenpage has stored");
        }
    }

    public static void getPosterUrl() {
        try {
            for (int i = 0; i < 10; i++) {
                searchEachPage(new BufferedReader(new FileReader("data/doubanWeb/" + i + ".html")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public static void searchEachPage(BufferedReader reader) throws IOException {
        String eachlineForRegex;
        while ((eachlineForRegex = reader.readLine()) != null) {
            if (eachlineForRegex.contains("poster")) {
                String src = eachlineForRegex.substring(eachlineForRegex.indexOf("https"), eachlineForRegex.lastIndexOf("\" "));
                String temp = eachlineForRegex.substring(eachlineForRegex.indexOf("alt=\""), eachlineForRegex.lastIndexOf("\" src"));
                String name = temp.substring(5);
                movieMapImageAndName.put(src, name);
            }
        }
    }

    public static void mkPosterFile() {
        try {
            for (String key : movieMapImageAndName.keySet()) {
                URL url = new URL(key);
                InputStream in = new BufferedInputStream(url.openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream("data/Poster/" + movieMapImageAndName.get(key) + ".jpg"));
                for (int j; (j = in.read()) != -1; ) {
                    out.write(j);
                }
                in.close();
                out.close();
            }
        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
}
