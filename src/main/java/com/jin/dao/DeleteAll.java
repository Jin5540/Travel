package com.jin.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAll
 */
@WebServlet("/delete/DeleteAll")
public class DeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAll() {
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
	    //int idx =  Integer.parseInt(request.getParameter("num1"));
	    
	    //out.println("������ �� : "+idx);
		Connection con = null;
		ResultSet rs =null;
		//PreparedStatement ptsm=null;
		Statement stmt =null; 
		//BoardController  bc = new  BoardController ();
		String url="jdbc:mysql://localhost:3306/yesjin";
		String id="yesjin";
		String pw="123456";

		try{   
		 Class.forName("com.mysql.cj.jdbc.Driver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection(url,id,pw);
		out.println("����̹� �ε� ����");
		out.println("�����ͺ��̽� ���� ����");
		 

		}catch(ClassNotFoundException e1) {
		out.println("����̹� �ε� ����");
		}catch(SQLException e2){
		out.println(e2.getMessage());
		}
		String sql1 = "truncate table content";
		//List<View> list = new ArrayList<View>();
		try {
		stmt = con.createStatement();
	    stmt.executeUpdate(sql1);



        response.sendRedirect("/J1/index.jsp");

		}catch(Exception e) {e.printStackTrace();}
			
		try {
			//rs.close();
			//ptsm.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
