import com.sun.deploy.panel.AdvancedNetworkSettingsDialog;

import javax.print.DocFlavor;
import javax.xml.crypto.Data;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tt {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.ensureCapacity(20);
        int i = stringBuffer.capacity();
        System.out.println(i);
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        System.out.println("it's " + simpleDateFormat.format(date));
        String ss = "I am noob" + "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(ss, pattern);
        System.out.println(isMatch);
        String line = "This order was placed for Qt3000! OK!?";
        for (String arg : args) {
            
        }
    }
}
