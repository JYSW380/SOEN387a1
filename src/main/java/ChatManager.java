

import java.time.LocalDateTime;
import java.util.ArrayList;



public class ChatManager {

    // add property by order
    private  ArrayList<Object[]> userMessage= new ArrayList<Object[]>();

    public ArrayList<Object[]> PostMessage(String user, String message) {
        LocalDateTime date = LocalDateTime.now();
        Object[] el = {date,user, message};
        userMessage.add(el);
        return new ArrayList<Object[]>(userMessage);

    }
    public ArrayList<Object [] > getallmessage(){
        return new ArrayList<Object[]>(userMessage);
    }


    public ArrayList<Object[]> ListMessages(String startDate, String finishDate){
        ArrayList<Object[]> userMessageLists = new ArrayList<Object[]>();

        if(startDate.equals("")  && finishDate.equals("") ) {
            return new ArrayList<Object[]>(userMessage);
        }
        else{
            for(Object[] t: userMessage){
                LocalDateTime date = (LocalDateTime) t[0];
                if(date.isAfter(LocalDateTime.parse(startDate))|| date.isBefore(LocalDateTime.parse(finishDate))){
                    Object [] el = {t[1],t[2]};
                    userMessageLists.add(el);
                }

            }
            return userMessageLists;
        }

    }

    public void ClearChat(String startDate, String finishDate) {
        if((startDate.equals("") ) && finishDate.equals("") ) {
            userMessage.clear();
        }
        else {
            userMessage.removeIf( (message) ->{
                LocalDateTime date = (LocalDateTime) message[0];
                return (date.isAfter(LocalDateTime.parse(startDate))|| date.isBefore(LocalDateTime.parse(finishDate)));
            });
        }
    }

}
