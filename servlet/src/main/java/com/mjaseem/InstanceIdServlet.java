package com.mjaseem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jaseem
 */
public class InstanceIdServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Address: " + System.getenv("CF_INSTANCE_ADDR"));
        resp.getWriter().println("GUID: " + System.getenv("CF_INSTANCE_GUID"));
    }
}
