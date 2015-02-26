package com.ac.test.servlet;

import con.ac.thetest.Library2IFace;
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

    @EJB
    LibraryIFace lb1;
    @EJB
    Library2IFace lb2;

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {

        lb1.setName("Filippo"); // nome comune
        lb1.setText("Testo lb1");
        lb2.setText( "Testo lb2" );

        Writer out = response.getWriter();
        out.append("1. Hello "+lb1.getName()+"!");
        out.append( "\n1. text:"+lb1.getText() );
        out.append("\n\n----------------\n");
        out.append("2. Hello "+lb2.getName()+"!");
        out.append( "\n2. text:"+lb2.getText() );
        out.close();

    }
}
