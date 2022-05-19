<html lang="ko" class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, ê·¸ë¦¬ê³  Bootstrap ê¸°ì—¬ìžë“¤">
    <meta name="generator" content="Hugo 0.87.0">
    <title>main</title>
    <%@ page import=  "java.io.*" %>
   <%@ page import=  "java.io.FileInputStream" %>



    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/cover/">

    

    <!-- Bootstrap core CSS -->
<link href="/J1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 <%@ page import="com.jin.dto.*" %>
 <%@ page import="com.jin.cl.*" %>
 <%@ page import="java.util.*" %>


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

    
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/J1/css/style.css">
  </head>
  
 <%@ include file="../common/header.jsp"%>

<%String content = (String)request.getAttribute("content");%>   
<%=content%>  
    <main class="px-3">
    <p class="lead">completed</p>
    <p class="lead">
      <form action="/J1/index.jsp">
      <input type="hidden" name="name" value="<%=content%>">
      <button type="submit" class="w-20 btn btn-dark btn-lg" >Home</button>
       </form>
    </p>
    
    
   



    </main>


  </footer>
</div>


    
  </body>
</html>
