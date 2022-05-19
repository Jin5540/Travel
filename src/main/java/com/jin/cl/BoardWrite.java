package com.jin.cl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jin.cl.*;
import com.jin.dao.*;
import com.jin.dto.View;

public class BoardWrite {
	
	BoardController bc = new BoardController ();
	
	public ArrayList<View> write() throws Exception{
		
		Write w = new Write();
		Connection con = null;
		ResultSet rs =null;
		//PreparedStatement ptsm=null;
		SimpleDateFormat timedate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date time = new Date();
		View v = new View();
		int cnt = 0;
		List<View> list = new ArrayList<View>();
		Statement stmt =null; 
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
		

		
		if(list.size()!=0) {
		try {
		stmt = con.createStatement();
	
		
		   System.out.println(list.get(0).getPictureNum());
		   System.out.println(list.get(0).getPictureName());
		   System.out.println(list.get(0).getContent());
		   System.out.println(timedate.format(time));
		   System.out.println(list.size());
		   
		

		for(View vw : list) {

			String Sql= "insert into content(idx,picture,coment,date) values";
			Sql+="('" +list.get(0).getPictureNum()+" ',' "+ list.get(0).getPictureName()+" ',' " +list.get(0).getContent()  + " ','"+timedate.format(time)+"')";
		    
		    int i = stmt.executeUpdate(Sql);
            if(i == 1)
            {
               System.out.println("���ڵ� �߰� ����");
               System.out.println(Sql);
            }
		    
			}
		    //System.out.println(list.get(5).getPictureNum());

		}catch(Exception e) {e.printStackTrace();}
			
		rs.close();
		stmt.close();
		con.close();
		
		

		}
		return (ArrayList<View>) list;
		
	}
	
}
