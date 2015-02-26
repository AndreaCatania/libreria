package com.ac.test.servlet;

import con.ac.thetest.LibraryIFace;
import con.ac.thetest.SingBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "test", urlPatterns = {"/test"})
public class DeServlet extends HttpServlet{

    @EJB
    LibraryIFace lb;
    @EJB
    SingBean sb;

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {

        Writer out = response.getWriter();
        out.append("Hello "+sb.getName()+"!");
        out.append("\n");
        out.append( lb.getText() );
        out.close();

    }
}
