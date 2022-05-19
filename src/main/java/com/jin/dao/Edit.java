package com.jin.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.cl.BoardController;
import com.jin.dto.View;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/edit/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		String edit = request.getParameter("edit");
		String num = request.getParameter("num");
		out.println(edit);
		out.print(num);
		
		
		Connection con = null;
		Statement stmt =null;	
		//ResultSet rs =null;
		//PreparedStatement ptsm=null;
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
		
		try {
			stmt = con.createStatement();
			String sql="UPDATE content SET coment = '"+edit+"' WHERE idx ="+num;
			out.print(sql);
			 int i = stmt.executeUpdate(sql);
		       if(i == 1)
		       {
		          System.out.println("���ڵ� ���� ����");
		          System.out.println(sql);
		       }
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
         


		response.sendRedirect("/J1/index.jsp");
		
	   

		



		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
