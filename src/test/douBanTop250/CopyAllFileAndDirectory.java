
import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.sound.sampled.Line;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GetAll250PosterFromDouban {

    private static String[] eachdoubanUrl = new String[10];
    private static String[] eachPosterUrl = new String[250];
    private static String[] eachPosterName = new String[250];


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
            eachdoubanUrl[i] = "https://movie.douban.com/top250?start=" + i + "&filter=";
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
//
//    public static void getEachPosterName() {
//        List<String> nameList = new ArrayList<String>();
//        String regexForImageName = "alt";
//        String eachlineForRegex;
//        StringBuilder contentBuilder = new StringBuilder();
//
//
//        for (int i = 0; i < eachdoubanUrl.length; i++) {
//            try (Stream<String> stream = Files.lines( Paths.get("doubanWeb/"+i+".html")))
//            {
//                stream.forEach(s -> contentBuilder.append(s).append("\n"));
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            System.out.println("s");
//            eachlineForRegex = contentBuilder.toString();
//            System.out.println();
//            Pattern pattern = Pattern.compile(regexForImageName);
//
//            Matcher matcher = pattern.matcher(eachlineForRegex);
//
//            while(matcher.find()) {
//                System.out.println("it has found");
////                tempListForPosterStringArray.add(matcher.group());
//            }
////            System.out.println(tempListForPosterStringArray);
//        }
//
//    }

    public static void getPosterUrl() {
//        String regexForEachPosterUrl = "^(https)://img.*(.webp)$";
//        String regexForEachPosterName = "alt";
        List<String> listPosterUrl = new ArrayList<String>();
        List<String> listPosterName = new ArrayList<String>();


        try {
            for (int i = 0; i < eachdoubanUrl.length; i++) {
                BufferedReader reader;
                String eachlineForRegex;
                reader = new BufferedReader(new FileReader("doubanWeb/" + i + ".html"));
                eachlineForRegex = reader.readLine();
                while (eachlineForRegex != null) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//                    Pattern patternUrl = Pattern.compile(regexForEachPosterUrl);
//                    Matcher matcherUrl = patternUrl.matcher(eachlineForRegex);
//
//                    while (matcherUrl.find()) {
//
//                        ListForPosterUrl.add(matcherUrl.group());
//                        System.out.println(ListForPosterUrl);
//                    }
//
//                    //
//                    Pattern patternName = Pattern.compile(regexForEachPosterName);
//                    Matcher matcherName = patternName.matcher(eachlineForRegex);
//
//                    while (matcherName.find()) {
//                        ListForPosterName.add(eachlineForRegex.substring(matcherName.start()+5,matcherName.end()));
//                        System.out.println(ListForPosterName);
//                    }

                    // read next line


//        for (int i = 0; i < eachPosterUrl.length; i++) {
//            eachPosterUrl[i] = ListForPosterUrl.get(i).toString();
//
//        }
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
