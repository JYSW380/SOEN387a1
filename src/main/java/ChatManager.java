import com.sun.org.apache.bcel.internal.generic.DADD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ChatManager {

    Map<LocalDateTime, String[]> userMessage = new HashMap<LocalDateTime, String[]>();

    public void PostMessage(String user, String message) {
        LocalDateTime date = LocalDateTime.now();
        userMessage.put(date, new String[]{user, message});
    }

    public Map<LocalDateTime, String[]> ListMessages(LocalDateTime startDate, LocalDateTime finishDate){
        Map<LocalDateTime, String[]> userMessageLists = new HashMap<LocalDateTime, String[]>();

        if(startDate==null  && finishDate==null) {
            return new HashMap<LocalDateTime, String[]>(userMessage);
        }
        else{
            userMessage.forEach((key, value) -> {
                if(key.isAfter(startDate) || key.isBefore(finishDate)) {
                    userMessageLists.put(key, value);
                }
            });
            return userMessageLists;
        }

    }

    public void ClearChat(LocalDateTime startDate, LocalDateTime finishDate) {
        if((startDate==null) && finishDate==null) {
            userMessage.clear();
        }
        else {
            userMessage.forEach((key, value) -> {
                if(key.isAfter(startDate) || key.isBefore(finishDate)) {
                    userMessage.remove(key);
                }
            });
        }
    }

    public String toString() {

        userMessage.forEach((key, value) -> {
            System.out.println(key+" "+ value[0] + value[1]);
        });
        return "";
    }













}
