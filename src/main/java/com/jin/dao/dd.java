package com.jin.dao;

import java.io.BufferedInputStream;
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

import com.jin.dto.*;
import com.jin.dao.Img;

/**
 * Servlet implementation class Search
 */
@WebServlet("/write/dd")
public class dd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	PrintWriter out = response.getWriter();
    	String realPath = request.getRealPath("img");
        
 	   File dir = new File(realPath);
 	   String[] filenames = dir.list();
 	
 	int datacount= filenames.length;//총 글 수   
 	int pagesize = 9; //한페이지에 출력되는 것
 	int pagecount=datacount/pagesize+1;//총 페이지 수
 	int remcount=datacount/pagesize; //마지막 페이지 글 수
 	
 	int mypage=1;
 	int abpage=1;
 	if(request.getParameter("mypage")!=null) {
 	mypage=Integer.parseInt(request.getParameter("mypage"));
 	abpage=(mypage-1)*pagesize;
 	if(abpage <= 0) abpage=1; }
 	
 	
 	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


}}
