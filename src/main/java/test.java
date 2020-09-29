import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class test {
    public static void main(String[] args) {
        ChatManager cm = new ChatManager();
        cm.PostMessage("tom", "hello world1");
        cm.PostMessage("sara", "hello world2");
        ArrayList<Object [] >test = cm.PostMessage("jack", "hello world3");
        for(Object[] t: test){
//            System.out.println(t);
            for(Object t1: t){
                System.out.println(t1);
            }
        }
        test.removeIf( (t) ->{
            return t[1]=="tom";
        });
        System.out.println("after remove");
        for(Object[] t: test){
            for(Object t1: t){
                System.out.println(t1);
            }
        }


//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        System.out.println(cars);
//        ArrayList<Integer> t = new ArrayList<>();
//        System.out.println();
//        System.out.println(cm);
//        LocalDate ld = LocalDate.now();
//
//
//        LocalDateTime time = LocalDateTime.now();
//        System.out.println(time);








    }

}
