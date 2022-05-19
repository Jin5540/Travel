<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRAVEL</title>
</head>
<body>
<!doctype html>
<html lang="UTF-8" class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, ÃªÂ·Â¸Ã«Â¦Â¬ÃªÂ³Â  Bootstrap ÃªÂ¸Â°Ã¬Â Â¬Ã¬Â Â Ã«Â Â¤">
    <meta name="generator" content="Hugo 0.87.0">
    <script type="text/javascript" src="/J1/js/delete.js"></script>
    <title>HOME</title>

    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/cover/">
<%@ page import="com.jin.dto.View"%>
    

    <!-- Bootstrap core CSS -->
<link href="/J1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>


 </head>
  <body>
    
 <%@ include file="../common/header.jsp"%>
 <%@ page import="java.io.File" %>
 <%@ page import="com.jin.dto.*" %>
 <%@ page import="com.jin.cl.*" %>
 <%@ page import="java.util.*" %>

<main>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">TRAVEL</h1>
        <p class="lead text-muted">England, Switzerland, Austria, Italy, Czech Republic, Germany. The place where I traveled. The story about that.</p>
        <p><% if(session.getAttribute("id")!=null){%>
          <a href="/J1/write/write_main.jsp" class="btn btn-secondary my-2">write</a>
          <a href="/J1/delete/delete.jsp" class="btn btn-secondary my-2">delete</a>
        </p>
        <%}%>
      </div>
    </div>
  </section>
  
  <div class="album py-5 bg-light">
    <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      
<%
int count =0;
List<View> list= new ArrayList<View>();
BoardController dc = new BoardController();
count = dc.select();

String tempStart = request.getParameter("page");//현재페이지

int startPage=0;
int onePageCnt=9;

count= (int)Math.ceil((double)count/(double)onePageCnt); //페이지 수 저장

if (tempStart != null)
{
   startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
   }

list = dc.selectPage(startPage, onePageCnt);

%>      

<% 
for(int i=0; i<list.size(); i++){
	String s =list.get(i).getPictureName();
	s= s.trim();
%>
        <div class="col">
          <div class="card shadow-sm">
            <img src="<%="/J1/img/"+s%>" width="100%" height="320" ></img>

            <div class="card-body">
              <p class="card-text"><%=list.get(i).getContent()%></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 <button class="btn btn-sm btn-outline-secondary" onclick="window.open('<%="http://phoenixking.co.kr/J1/img/"+s%>','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">View</button>
                  <% if(session.getAttribute("id")!=null){%>
                  <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/J1/edit/edit.jsp'" >Edit</button>
                  <%} %>
                </div>
                <small class="text-muted"><%=list.get(i).getDate()%></small>
              </div>
            </div>
          </div>
        </div>

<%}; %>
    
 
  <% for(int i=1; i<=count; i++){ %>
   <a href="index.jsp?page=<%=i%>">[<%=i%>]
    </a>
 <% };%>     
 
    
</main>

<%@ include file="../common/footer.jsp"%>


   

      
  </body>
</body>
</html>