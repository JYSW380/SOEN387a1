import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    ChatManager chartManager = new ChatManager(); // usebean store session

    private void w2file(HttpServletResponse response, String type, ArrayList<Object[]> chatmessage) throws IOException {
        //by default contenttype is text/HTML
        response.setContentType(!type.equals("xml")? "text/plain ": "text/xml" + ";charset=UTF-8" );

        String repName =  "ChatHistory."+type;
        response.setHeader("Content-disposition", "attachment; " +
                "filename=" + repName);

        ServletOutputStream res = response.getOutputStream();

        for(Object [] el: chatmessage){
            try {
                res.print("User: "+el[1]+ "\tMessage: " + el[2] + "\tAt: "+ el[0] +"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        res.flush();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String message = request.getParameter("message");
        ArrayList<Object[]> chatmessage;
        if(user==null || user=="") {
            chatmessage =chartManager.PostMessage("anonymous", message);
        }
        else {
            chatmessage= chartManager.PostMessage(user, message);
        }
        request.setAttribute("chatmessage", chatmessage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getbtn = request.getParameter("getbtn");
        String delbtn = request.getParameter("deletebtn");
        String startDate = request.getParameter("startDate");
        String finishDate = request.getParameter("finishDate");
        String isxml = request.getParameter("xml");
        if(delbtn != null){
            delete(request,response,startDate,finishDate);
        }
        else{
            ArrayList<Object[]> chatmessage = chartManager.ListMessages(startDate,finishDate);
        try{
            w2file(response, isxml!=null?"xml":"txt" ,chatmessage);
        }
        catch (IOException e){

        }
        }

//
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String clear = req.getParameter("clear");
//        String startDate = req.getParameter("startDate");
//        String finishDate = req.getParameter("finishDate");
//        chartManager.ClearChat(null,null);
//       // chartManager.ClearChat(startDate,finishDate);
//
//    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp, String startDate, String finishDate ) throws ServletException, IOException {
        chartManager.ClearChat(startDate,finishDate);
        ArrayList<Object[]> chatmes = chartManager.getallmessage();
        req.setAttribute("chatmessage",chatmes );
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
        // chartManager.ClearChat(startDate,finishDate);
    }
}
