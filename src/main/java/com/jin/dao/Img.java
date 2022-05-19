package com.jin.dao;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jin.dto.*;

/**
 * Servlet implementation class Search
 */
public class Img extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Img() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	   /**
	    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	    */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      //response.getWriter().append("Served at: ").append(request.getContextPath());
    	   request.setCharacterEncoding("UTF-8");
    	   response.setContentType("text/html; charset=UTF-8");
    	   PrintWriter out = response.getWriter();

    	   
    	      String realPath = request.getRealPath("img");
    	            
    	      View v = new View ();

  
    	         File dir = new File(realPath);
    	         String[] filenames = dir.list();
    	         out.println(filenames.length);
    	         for (int i = 0; i < filenames.length; i++) 
    	         {
    	         v.setPictureName(realPath+"\\"+filenames[i]);
    	         out.println(v.getPictureName());
    	         }
    	         

    	        
         
    	   //response.sendRedirect("/J1/first/first.jsp"); 
 
 	     
	   }
	    
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      //doGet(request, response);

	
	   }


	}   	
		


	
	
	
	


