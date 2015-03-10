package com.ac.test.servlet;

import com.ac.ejbsclient.entities.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "test", urlPatterns = {"/test"})
public class DeServlet extends HttpServlet{

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {

        MyObj myObj = new MyObj();

        Writer out = response.getWriter();

        out.append("1. Hello "+myObj.getName()+"!");
        out.append( "\n1. text:"+myObj.getText() );
        out.append("\n\n----------------\n");
        out.append("2. Hello "+myObj.getName2()+"!");
        out.append( "\n2. text:"+myObj.getText2() );

        out.append( "\n===========================================" );

        myObj.setName("Filippo"); // nome comune
        myObj.setText("Testo lb1");
        myObj.setText2("Testo lb2" );

        out.append("\n1. Hello "+myObj.getName()+"!");
        out.append( "\n1. text:"+myObj.getText() );
        out.append("\n\n----------------\n");
        out.append("2. Hello "+myObj.getName2()+"!");
        out.append( "\n2. text:"+myObj.getText2() );

        out.append( "\n===========================================" );


        boolean error = false;
        int bId = 0;
        try{
            bId = Integer.parseInt(request.getParameter("bId"));
        }catch(Exception e){
            error = true;
        }
        if( !error ){
            Book libro = myObj.getBook(bId);
            if( null!=libro ){
                out.append( "\nbId: " + bId );
                out.append( "\nBook name: "+libro.getName());
                out.append( "\nBook id: "+libro.getBookId());
            }else{
                out.append( "\nbId not assigned yet" );
            }
        }else{
            out.append( "\nbId required" );
        }

        out.close();

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws IOException {
        MyObj myObj = new MyObj();

        boolean error = false;
        int bId = 0;
        String bName = null;
        try{
            bId = Integer.parseInt(request.getParameter("bId"));
            bName = request.getParameter("bName");
        }catch(Exception e){
            error = true;
        }
        if( !error ){
            myObj.createBook(bId, bName);
        }else{
            Writer out = response.getWriter();
            out.append( "Error." );
            out.append( "\nbName required" );
            out.append( "\nbId required" );
            out.close();
        }
    }
}
