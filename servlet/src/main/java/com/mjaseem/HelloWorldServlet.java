package com.mjaseem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jaseem
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter()
                .println(
                        "<html>" +
                                "<body>" +
                                "<img width=\"500\" src=\"https://media0.giphy.com/media/3og0IQCfsZXScpvKhi/200w.webp\" alt=\"\">" +
                                "</body>" +
                                "</html>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
