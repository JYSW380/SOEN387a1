

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    ChatManager chartManager = new ChatManager(); // usebean store session
    private void checkreferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if(referer== null){
            request.setAttribute("errmessage", "cannot preceed the request");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }

    }
    private void redirectdata(HttpServletRequest request, HttpServletResponse response, ArrayList<Object[]> chatmessage) throws ServletException, IOException {
        request.setAttribute("chatmessage", chatmessage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
    private void refresh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Object[]> chatmes = chartManager.getallmessage();
        redirectdata(request,response,chatmes);
    }


    private void w2file(HttpServletResponse response, String type, ArrayList<Object[]> chatmessage) throws IOException {
        //by default contenttype is text/HTML
        response.setContentType(!type.equals("xml")? "text/plain ": "text/xml" + ";charset=UTF-8" );

        String repName =  "ChatHistory."+type;
        response.setHeader("Content-disposition", "attachment; " +
                "filename=" + repName);

        ServletOutputStream res = response.getOutputStream();
        if(type.equals("xml")){
            res.print("<?xml version='1.0'?>");
            res.print("<root>");
            for(Object [] el: chatmessage){
                try {
                    res.print("<user> User: "+el[1]+"</user>");
                    res.print("<message> Message: "+el[2]+"</message>");
                    res.print("<time> time: "+el[0]+"</time>");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            res.print("</root>");
        }
        else    {
            for(Object [] el: chatmessage){
                try {
                    res.print("User: "+el[1]+ "\tMessage: " + el[2] + "\tAt: "+ el[0] +"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        res.flush();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkreferer(request,response);
        String user = request.getParameter("user");
        String message = request.getParameter("message");
        ArrayList<Object[]> chatmessage;
        if(user==null || user=="") {
            chatmessage =chartManager.PostMessage("anonymous", message);
        }
        else {
            chatmessage= chartManager.PostMessage(user, message);
        }
            redirectdata(request,response,chatmessage);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkreferer(request,response);

        String ref = request.getParameter("refresh");
        String delbtn = request.getParameter("deletebtn");
        String startDate = request.getParameter("startDate");
        String finishDate = request.getParameter("finishDate");
        String isxml = request.getParameter("xml");
        if (ref != null) {
            refresh(request, response);
        } else if (delbtn != null) {
            delete(request, response, startDate, finishDate);
        } else {
            ArrayList<Object[]> chatmessage = chartManager.ListMessages(startDate, finishDate);
            try {
                    w2file(response, isxml != null ? "xml" : "txt", chatmessage);
                } catch (IOException e) {

                }
        }


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response, String startDate, String finishDate ) throws ServletException, IOException {
        chartManager.ClearChat(startDate,finishDate);
        ArrayList<Object[]> chatmes = chartManager.getallmessage();
        redirectdata(request,response,chatmes);
        // chartManager.ClearChat(startDate,finishDate);
    }
}