package com.jin.cl;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.Math.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jin.dto.*;

public class BoardController 
{
public int selectCnt() {
	
	   //String realPath = "C:\\Users\\���\\eclipse-workspace\\J1\\src\\main\\webapp\\img";
	   String realPath = "/var/lib/tomcat9/webapps/J1/img";

	   File dir = new File(realPath);
	   String[] filenames = dir.list();
	   int result=filenames.length;
	   

	
	return result;
}


public int select() throws SQLException {
	int num=0;
	Connection con = null;
	ResultSet rs =null;
	//PreparedStatement ptsm=null;
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
	String Sql= "SELECT * FROM content";

	try {
	stmt = con.createStatement();
	rs=stmt.executeQuery(Sql);
	while(rs.next()) {
		View v = new View();
		num=rs.getInt("idx");

	    
		}
	    //System.out.println(list.get(5).getPictureNum());

	}catch(Exception e) {e.printStackTrace();}
		
	rs.close();
	//ptsm.close();
	stmt.close();
	con.close();
	return num+1;
	
	
}



public Connection makeConnection()
{
   /*
   String url="jdbc:mysql://localhost:3306/jdb";
   String id="root";
   String pw="123456";
   
   */
    String url="jdbc:mysql://localhost:3306/yesjin";
    String id="yesjin";
    String pw="123456";
    Connection con = null;
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
   return con;
}

public ArrayList<View> selectPage(int start, int pageCnt) throws SQLException
{


Connection con = null;
ResultSet rs =null;
PreparedStatement ptsm=null;
//Statement stmt =null; 
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
String Sql= "SELECT * FROM content limit ?, ?";
List<View> list = new ArrayList<View>();
try {
ptsm = con.prepareStatement(Sql);
ptsm.setInt(1, start);
ptsm.setInt(2, pageCnt);
int result=bc.selectCnt();
rs= ptsm.executeQuery();
while(rs.next()) {
	View v = new View();
	v.setPictureNum(rs.getInt("idx"));
	v.setPictureName(rs.getString("picture"));
	v.setContent(rs.getString("coment"));
	v.setDate(rs.getString("date"));
	//System.out.println(rs.getString("idx"));
    //System.out.println(v.getPictureNum());
    list.add(v);
    //System.out.println("size : "+list.get(0));
    
	}
    //System.out.println(list.get(5).getPictureNum());

}catch(Exception e) {e.printStackTrace();}
	
rs.close();
ptsm.close();
con.close();

  
return (ArrayList<View>) list;}




public static void main(String[] args) throws SQLException

{
	BoardController bc = new BoardController();
	bc.selectPage(2, 9);
	//bc.makeConnection();
}

}