package examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request
        , HttpServletResponse response
    )
        throws ServletException, IOException
    {
        PrintWriter writer = response.getWriter();
        
        if (request.getParameter ("name").equals ("John"))
            writer.println ("name parameter is John");
        else
            writer.println ("name is not John");
    }
}