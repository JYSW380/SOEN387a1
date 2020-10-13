

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
            <h2>JSP Chat App</h2>
            <hr/>
            <h5 class="currentdate"></h5>
            <div class="spacer"></div>
<%--            <h6><i class="fad fa-user-alt"></i>Uriel Bitton<span><input placeholder="Client Name"></span></h6>--%>
<%--            <h6><i class="fad fa-envelope"></i>urielas@hotmail.com<span><input placeholder="Client Email"></span></h6>--%>
<%--            <h6><i class="fad fa-location-circle"></i>Montreal, Canada<span><input placeholder="Client Location"></span></h6>--%>

            <div class="navigator">
                <h4>Chat Options</h4>

                <ul>
                    <li><form action="ChartServlet" method="get">
                        <h6>Get Messages</h6>
                        <label>Start date</label><br/>
                        <input type="datetime-local" name="startDate">
                        <label>End date</label>
                        <input type="datetime-local" name="finishDate">
                        <label>XML format</label>
                        <input type="checkbox" value="xml" name="xml"><br/>
                        <input type="submit" value="Get" name="getbtn">
                        </form>
                    </li>
                    <li><form action="ChartServlet" method="get">
                        <h6>Delete Message</h6>
                        <label>Start date</label>
                        <input type="datetime-local" name="startDate">
                        <label>End date</label>
                        <input type="datetime-local" name="finishDate">
                        <input type="submit" value="Delete" name="deletebtn">
                    </form>
                    </li>
                    <li>
                        <form action="ChartServlet" method="get">
                            <h6>Refresh Chat</h6>
                            <button type="submit" value="Refresh" name="refresh">Refresh</button>
                        </form>
                    </li>
                    <li>
                        <!-- curl http://localhost:8080/soen387A1_war/ChartServlet?clearbtn=Clear -->
                        <form action="ChartServlet" method="get">
                            <label>Clear</label>
                            <input type="submit" value="Clear" name="clearbtn">
                        </form>
                    </li>
                </ul>
            </div>

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
                    <div class="spacer"></div>
                    <%
                        try{
                            //PrintWriter temp =response.getWriter();
                            String err = (String) request.getAttribute("errmessage");
                            if(err !=null ){
                                out.println("<div class=\"msgcont msgleft left\">"+err+"</div>");
                            }
                            else{
                                ArrayList<Object[]> result = (ArrayList<Object[]>) request.getAttribute("chatmessage");
                                for(Object[] t: result){
                                    out.println("<div class=\"msgcont msgright right\"><div class=\"msg\"><img src=\"https://i.imgur.com/UBpqvP7.png\" />"+t[2]+"</div>" +
                                            "<small>"+t[1]+"</small><small class=\"timestamp\">"+t[0]+"</small></div>");
//
                                }
                                }
                        }
                        catch (Exception e){
                        }
                    %>

                </div>

                <div class="clear"></div>
            </div>
            <div class="typecontainer">
                <div class="inputcont">
                    <img src="https://i.imgur.com/UBpqvP7.png" />
                    <form action="ChartServlet" method="post" id="postmessage">
                        <input class="maininp" type="text" name="message" placeholder="Send a message...">
                        <input class="personinp" type="text" name="user" size="20" placeholder="Your Username">
                        <button type="submit" value="Submit" form="postmessage"><i class="fad fa-paper-plane sendbtn"></i></button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>




<script src="index.js"></script>

</body>
</html>