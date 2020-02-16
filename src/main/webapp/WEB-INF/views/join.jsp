<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
 <link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/css/join.css">
<body>
<div class="wrap">
	<header class="header-container">

	</header>
	<main class="main-container">
		<form class="join-form" action="/joinCreate" method="post">
				 <h1  class="title-text">회원가입</h1>
                  <label class="legend">아이디</label><br>
                  <input name="id1" type="text"><label >@</label>
                  <select name="id2">
                  	<option value='email' selected>-- 선택 --</option>
  					<option value='gmail.com'>gmail.com</option>
 					<option value='naver.com'>naver.com</option>
  					<option value='daum.net'>daum.net</option>
                  </select><br>
                  <label class="legend">비밀번호</label> <br>
                  <input name="password" type="password"><br>
                  <label class="legend">닉네임</label> <br>
                  <input name="name" type="text"> <br>
                  <div class="btn-container">
	                  <input class="btn" type="submit" value="회원가입">
	                  <input class="btn" type="button" onclick="back()" value="취소">
                  </div>
                  
         </form>
	</main>
	 <footer class="footer-container"></footer>
</div>
	<div class="join_box">
		 
	</div>
	
</body>
<script>
	function back() {
		
		if(confirm('작성을 취소하시겠습니까?')){
			location.href="/"; 
		}
	}
</script>
</html>