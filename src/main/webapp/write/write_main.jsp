<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>write</title>
    <script type="text/javascript" src="../js/function.js"></script>
    <!-- Bootstrap core CSS -->
<link href="/J1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <!-- Custom styles for this template -->
   
    
    
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
    
    
    

 <%@ include file="../common/header.jsp"%>
  <body class="bg-light">
 
<link href="/J1/css/form-validation.css" rel="stylesheet">	
<link rel="stylesheet" href="/J1/css/style.css">

    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <n class="medium"><h1>Write</h1>
      <p class="lead"></p>
    </div>


    

          <form method="post" action="./Write" enctype="multipart/form-data" >
          <form class="needs-validation" novalidate>
          
          <div class="row g-3">
          

          
          <div class="col-sm-12">
              <n class="medium"><label for="picture" class="form-label"></label>
              <input type="file" class="form-control" name="Picture" id="Picture" required>
              <div class="invalid-feedback">
                Please provide a valid University name.
              </div>
            </div>
         
  
              <div class="col-sm-12">
              <n class="medium"><label for="Name" class="form-label">Coment</label>
              <input type="text" class="form-control" name="Coment" placeholder="blah blah" value="" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
  
  
          
           <hr class="my-4">

          <div class="col-12">

          <n class="medium"><button type="submit" class="w-100 btn btn-dark btn-lg" >Submit form</button>
        </form>
        
      </div>
    </div>
    
  </main>
  
 <%@ include file="../common/footer.jsp"%>


     
  </body>
</html>