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

<div>
    <form action="ChartServlet" method="post">
        <label>User</label>
        <input type="text" name="user" size="20">
        <label>Message</label>
        <input type="text" name="message">
        <input type="submit" value="Submit">
    </form>
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

</div>
<div>
    <%
        try{
            PrintWriter temp =response.getWriter();
            ArrayList<Object[]> result = (ArrayList<Object[]>) request.getAttribute("chatmessage");
            for(Object[] t: result){
                for(Object t1: t){
                    temp.println(t1);
                }
                temp.println("<br/>");
            }

        }
        catch (Exception e){

        }



    %>


</div>


</body>
</html>