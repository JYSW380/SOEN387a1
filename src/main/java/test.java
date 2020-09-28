import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        ChatManager cm = new ChatManager();
        cm.PostMessage("tom", "hello world1");
        cm.PostMessage("sara", "hello world2");
        cm.PostMessage("jack", "hello world3");


        System.out.println(cm);
        LocalDate ld = LocalDate.now();


        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);








    }

}
