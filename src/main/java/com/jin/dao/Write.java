package com.jin.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import com.jin.cl.BoardController;
import com.jin.cl.BoardWrite;
import com.jin.dto.*;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.Enumeration;
import java.lang.String;


//import com.jslhrd.dto.LoginBean;

/**
 * Servlet implementation class Register
 */
@WebServlet("/write/Write")

public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		View bean = new View();
		//MultipartRequest mr = new MultipartRequest(request,realPath,10*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		//response.getWriter().append("Served at: ");
		
		PrintWriter out = response.getWriter();
		List<View> list = new ArrayList<View>();
		//Part part =(Part) request.getPart("Picture");
		//String content = request.getParameter("Content");
		

        //�� �ؿ� ������ ���������� �۵��ϸ� ���Ͼ��ε�� �̹� �� ���´�. �� �ؿ��� ������ ���� ���� �������� ��ο��� ������ ���ε� �Ǿ��ִ�.
       try {
		//String realPath = request.getRealPath("img");
    	   //String realPath = "C:\\Users\\���\\eclipse-workspace\\J1\\src\\main\\webapp\\img";
    	   String realPath = "/var/lib/tomcat9/webapps/J1/img";

    	   File dir = new File(realPath);
    	   String[] filenames = dir.list();
    	   
    	String filename= request.getParameter("Picture");
    	//String coment= request.getParameter("Coment");
    		
    	   
		//out.println(realPath);
		MultipartRequest mr = new MultipartRequest(request,realPath,10*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		String original = mr.getOriginalFileName("Picture");
		String coment= mr.getParameter("Coment");
		original= original.trim();
		
		//int num =filenames.length+1;
		
		
		
		

		BoardController bc = new BoardController();
		
		bean.setPictureNum(bc.select());
		list.add(bean);
		bean.setPictureName(original);
		bean.setContent(coment);
		//bean.setPictureNum(num);
		list.add(bean);

		
		
		
		
		

		
		
		
		//out.println("bean: "+list.get(0).getPictureName());
		//out.println(original);
		
		BoardWrite bw = new BoardWrite();
		//bw.write();
  
        request.setAttribute("content", original);
        
        //ServletContext context =getServletContext();
        //RequestDispatcher dispatcher = context.getRequestDispatcher("/write/success.jsp"); //�ѱ� ������ �ּ�
        //dispatcher.forward(request, response);



		
		//out.print(filename);
		
       }
       catch(Exception e) {System.out.println(e);}
       Connection con = null;
		//ResultSet rs =null;
		//PreparedStatement ptsm=null;
		SimpleDateFormat timedate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date time = new Date();
		View v = new View();
		//int cnt = 0;
		//List<View> list = new ArrayList<View>();
		 
		BoardController  bc = new  BoardController ();
		String url="jdbc:mysql://localhost:3306/yesjin";
		String id="yesjin";
		String pw="123456";

		try{   
		 Class.forName("com.mysql.cj.jdbc.Driver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection(url,id,pw);
		 System.out.println("����̹� �ε� ����");
		 System.out.println("�����ͺ��̽� ���� ����");
		 

		}catch(ClassNotFoundException e1) {
		System.out.println("����̹� �ε� ����");
		}catch(SQLException e2){
		System.out.println(e2.getMessage());
		}
		

		
		

		int num=0;

		
		
		if(list.size()!=0) {
		try {

		

				   System.out.println(list.get(0).getPictureNum());
				   System.out.println(list.get(0).getPictureName());
				   System.out.println(list.get(0).getContent());
				   System.out.println(timedate.format(time));
				   System.out.println(list.size());
				   
		Statement stmt =null;		   
		stmt = con.createStatement();   


			String Sql= "insert into content(idx,picture,coment,date) values";
			Sql+="('" +list.get(0).getPictureNum()+" ',' "+ list.get(0).getPictureName()+" ',' " +list.get(0).getContent()  + " ','"+timedate.format(time)+"')";
			System.out.println(Sql);
			
		    int i = stmt.executeUpdate(Sql);
           if(i == 1)
           {
              System.out.println("���ڵ� �߰� ����");
              System.out.println(Sql);
           }
		    

		    //System.out.println(list.get(5).getPictureNum());

		}catch(Exception e) {e.printStackTrace();}
			

		
		
		response.sendRedirect("/J1/index.jsp");
		
		}


		
	
	
	}
}
