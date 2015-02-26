package com.ac.test.servlet;

import con.ac.thetest.LibraryIFace;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "test", urlPatterns = {"/test"})
public class DeServlet extends HttpServlet{

    @EJB(lookup="java:global/decore-1.0-SNAPSHOT/LibraryBean")
    LibraryIFace lb;

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {

        Writer out = response.getWriter();
        out.append( lb.getText() );
        out.append("Hello test!");
        out.close();

    }
}
