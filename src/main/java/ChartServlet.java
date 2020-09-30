import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    ChatManager chartManager = new ChatManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String message = request.getParameter("message");
        if(user==null || user=="") {
            chartManager.PostMessage("anonymous", message);
        }
        else {
            chartManager.PostMessage(user, message);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String finishDate = request.getParameter("finishDate");
        String xml = request.getParameter("xml");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clear = req.getParameter("clear");
        String startDate = req.getParameter("startDate");
        String finishDate = req.getParameter("finishDate");
        chartManager.ClearChat(null,null);
       // chartManager.ClearChat(startDate,finishDate);

    }


}
