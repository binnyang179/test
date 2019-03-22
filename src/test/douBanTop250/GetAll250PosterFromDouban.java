
import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.sound.sampled.Line;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GetAll250PosterFromDouban {

    private static String[] eachdoubanUrl = new String[10];
    private static String[] eachPosterUrl = new String[250];
    private static String[] eachPosterName = new String[250];


    private static List<String> listPosterUrl = new ArrayList<>();
    private static List<String> listPosterName = new ArrayList<>();


    public static void main(String[] args) {

        getdouabnUrlArray();

        mkDirOfDouban();

        storeDoubanWebpage();

        mkDirOfPoster();

        getPosterUrl();

//        mkPosterFile();

    }


    public static void getdouabnUrlArray() {
        for (int i = 0; i < 10; i++) {
            eachdoubanUrl[i] = "https://movie.douban.com/top250?start=" + i*25 + "&filter=";
        }
    }

    public static void mkDirOfDouban() {
        String web = new String("doubanWeb");
        File webDir = new File(web);
        if (!webDir.exists()) {
            webDir.mkdir();
        }
    }

    public static void storeDoubanWebpage() {
        URL url;
        BufferedReader reader;
        BufferedWriter writer;
        String line;

        try {
            for (int i = 0; i < eachdoubanUrl.length; i++) {
                url = new URL(eachdoubanUrl[0]);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                writer = new BufferedWriter(new FileWriter("doubanWeb/" + i + ".html"));
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                reader.close();
                writer.close();
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            System.out.println("Those douban wenpage has stored");
        }
    }

    public static void mkDirOfPoster() {
        String Poster = new String("Poster");
        File wenDir = new File(Poster);
        if (!wenDir.exists()) {
            wenDir.mkdir();
        }
        System.out.println("Poster's dir has created");
    }

    public static void getPosterUrl() {


        try {
            for (int i = 0; i < 10; i++) {
                searchEachPage(new BufferedReader(new FileReader("doubanWeb/" + i + ".html")));
                System.out.println(i+"zheshi sfdasf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done");
        System.out.println(listPosterName);
        System.out.println(listPosterUrl);
        for (int i = 0; i < listPosterName.size(); i++) {
            eachPosterName[i] = listPosterName.get(i);
            System.out.println(eachPosterName[i]);
        }

    }
    public static void searchEachPage(BufferedReader reader) throws IOException {

        String eachlineForRegex;
        while ((eachlineForRegex = reader.readLine()) != null) {
            if (eachlineForRegex.contains("s_ratio_poster")) {
                String src = eachlineForRegex.substring(eachlineForRegex.indexOf("https"), eachlineForRegex.lastIndexOf("\" "));
                String temp = eachlineForRegex.substring(eachlineForRegex.indexOf("alt=\""), eachlineForRegex.lastIndexOf("\" src"));
                String name = temp.substring(5, temp.length());
                listPosterUrl.add(src);
                listPosterName.add(name);
                System.out.println(src);
                System.out.println(name);
            }
            eachlineForRegex = reader.readLine();
        }
    }

    public static void mkPosterFile() {

        Image image = null;
        InputStream in = null;
        ByteArrayOutputStream out = null;
        FileOutputStream fos = null;


        for (int i = 0; i < eachPosterUrl.length; i++) {
            try (InputStream inputStream = new URL(eachPosterUrl[i]).openStream()) {
                String posterName = String.valueOf(i + 250);
                Files.copy(inputStream, Paths.get("Poster/" + posterName + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            for (int i = 0; i < eachPosterUrl.length; i++) {
                URL url = new URL(eachPosterUrl[i]);
                image = ImageIO.read(url);
                in = new BufferedInputStream(url.openStream());
                out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                byte[] response = out.toByteArray();
                fos = new FileOutputStream("Poster/" + i + ".jpg");
                fos.write(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
