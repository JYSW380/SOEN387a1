

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.sun.org.apache.xerces.internal.xs.ItemPSVI" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 9/28/2020
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include  file="./header.html" %>

<div class="bgimg"></div>

<div class="container">
    <div class="app">

        <div class="sidebar">
            <div class="menuicons">
                <i class="fad fa-stream slidebtn"></i>
                <i class="fad fa-adjust darkmode"></i>
            </div>
            <h2>JSP<br/> Chat App</h2>
            <div class="spacer"></div>
            <h6><i class="fad fa-user-alt"></i>Uriel Bitton<span>Client Name</span></h6>
            <h6><i class="fad fa-envelope"></i>urielas@hotmail.com<span>Client Email</span></h6>
            <h6><i class="fad fa-location-circle"></i>Montreal, Canada<span>Client Location</span></h6>
            <hr/>
            <h5 class="currentdate"></h5>

        </div>
        <div class="chatcontainer">
            <div class="chatwindow">

                <div class="msgsarea">
                    <div class="msgcont msgleft left">
                        <div class="msg"><i class="fad fa-comment-dots"></i>
                            <p>Welcome to the JSP Chat App. Send a message to start chatting.</p>
                        </div>
                        <div class="clear"></div>
                        <small class="timestamp">Just now</small>
                    </div>
                </div>

                <div class="clear"></div>
            </div>
            <div class="typecontainer">
                <div class="inputcont">
                    <img src="https://i.imgur.com/UBpqvP7.png" />
                    <form action="ChartServlet" method="post">
                        <input type="text" name="message" placeholder="Send a message...">
                    </form>
                    <i class="fad fa-paper-plane sendbtn" type="submit" value="Submit"></i>
                </div>
            </div>
        </div>

    </div>
</div>


<div style="display: none">
    <form action="ChartServlet" method="get">
        <label>Get message</label>
        <label>Start date</label>
        <input type="datetime-local" name="startDate">
        <label>End date</label>
        <input type="datetime-local" name="finishDate">
        <label>XML format</label>
        <input type="checkbox" value="xml" name="xml">
        <input type="submit" value="Get" name="getbtn">
    </form>
    <form action="ChartServlet" method="get">
        <label>Delete message</label>
        <label>Start date</label>
        <input type="datetime-local" name="startDate">
        <label>End date</label>
        <input type="datetime-local" name="finishDate">
        <input type="submit" value="Delete" name="deletebtn">
    </form>
    <form action="ChartServlet" method="get">
        <label>Refresh</label>
        <input type="submit" value="Refresh" name="refresh">
    </form>

</div>

<div>
    <%
        try{
            PrintWriter temp =response.getWriter();
            String err = (String) request.getAttribute("errmessage");
            if(err !=null ){
                temp.println(err);
            }
            else{
                ArrayList<Object[]> result = (ArrayList<Object[]>) request.getAttribute("chatmessage");
                for(Object[] t: result){
                    for(Object t1: t){
                        temp.println(t1);
                    }
                }
            }
        }
        catch (Exception e){

        }
    %>
</div>


</body>
</html>