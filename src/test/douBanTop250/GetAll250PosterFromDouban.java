
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class GetAll250PosterFromDouban {
    private static String[] eachdoubanUrl = new String[10];
    private static List<String> listPosterUrl = new ArrayList<>();
    private static List<String> listPosterName = new ArrayList<>();

    public static void main(String[] args) {

        getdouabnUrlList();

        mkDirOfDouban();

        storeDoubanWebpage();

        mkDirOfPoster();

        getPosterUrl();

        mkPosterFile();
    }

    public static void getdouabnUrlList() {
        for (int i = 0; i < 10; i++) {
            eachdoubanUrl[i] = "https://movie.douban.com/top250?start=" + i * 25 + "&filter=";
        }
    }

    public static void mkDirOfDouban() {
        String web = "doubanWeb";
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
                url = new URL(eachdoubanUrl[i]);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                writer = new BufferedWriter(new FileWriter("doubanWeb/" + i + ".html"));
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                reader.close();
                writer.close();
            }
        } catch (Exception mue) {
            mue.printStackTrace();
        } finally {
            System.out.println("Those douban wenpage has stored");
        }
    }

    public static void mkDirOfPoster() {
        String Poster = "Poster";
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public static void searchEachPage(BufferedReader reader) throws IOException {

        String eachlineForRegex;
        while ((eachlineForRegex = reader.readLine()) != null) {
            if (eachlineForRegex.contains("s_ratio_poster")) {
                String src = eachlineForRegex.substring(eachlineForRegex.indexOf("https"), eachlineForRegex.lastIndexOf("\" "));
                String temp = eachlineForRegex.substring(eachlineForRegex.indexOf("alt=\""), eachlineForRegex.lastIndexOf("\" src"));
                String name = temp.substring(5);
                listPosterUrl.add(src);
                listPosterName.add(name);
            }
            eachlineForRegex = reader.readLine();
        }
    }

    public static void mkPosterFile() {
        try {
            for (int i = 0; i < listPosterUrl.size(); i++) {
                URL url = new URL(listPosterUrl.get(i));
                InputStream in = new BufferedInputStream(url.openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream("Poster/" + listPosterName.get(i) + ".jpg"));
                for (int j; (j = in.read()) != -1; ) {
                    out.write(j);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
