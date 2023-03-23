import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/mycookie"})
public class myCookie extends HttpServlet {
protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
    Cookie  lastName = new Cookie("last_name", request.getParameter("last_name"));
    
    //Set expiry date after 24 hrs for both the cookies
    firstName.setMaxAge(60*60*24);
    lastName.setMaxAge(60*60*24);
    
    //Add both the cookie in response header
    response.addCookie(firstName);
    response.addCookie(lastName);
    
    //Set response content type  
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println(
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n"
                );
}
}
