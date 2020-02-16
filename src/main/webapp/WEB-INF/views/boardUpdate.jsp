<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
</head>
 <link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<link rel="stylesheet" href="/css/boardUpdate.css">
<body>
<div class="wrap">
	<header class="header-container">
		<div class="login-container">
			<c:choose>
				<c:when test="${not empty userConfig.name}">
					<span class="header-user" value="${userConfig.idx }">${userConfig.name }님</span>
					<button class="header-btn logout-btn"  onclick="logout()">로그아웃</button>
				</c:when>
				<c:otherwise>	
				<button class="header-btn login-btn" onclick="loginGo()">로그인</button>
				</c:otherwise>	
			</c:choose>
		</div>	
	</header>
	<main class="main-container">
		<form class="boardUpdate-form" action="/update" onSubmit="check();return flase" method="POST">
			 <div class="title-container">
				<input name="title" type="text" value="${board.title }"/>
				<input name="userNo" type="hidden"  value="${board.userNo }"/>
				<input name="idx" type="hidden"  value="${board.idx }"/>
			 </div>
			 <div id="summernote">${board.contents }</div>
			 <input type="hidden" id="contents" name="contents" value=""/>
			 <div>
			 	<input class="submit-btn" type="submit" value="작성">
	            <input class="cencal-btn" type="button" onclick="back()" value="취소">
			 </div>
		 </form>
	</main>
	 <footer class="footer-container"></footer>
</div>	
</body>
<script src="/js/login.js"></script>
<script>
	 $(document).ready(function() {
	        $('#summernote').summernote({
	        	  height: 400,                 // set editor height
	        	  minHeight: null,             // set minimum height of editor
	        	  maxHeight: null,             // set maximum height of editor
	        	  focus: true                  // set focus to editable area after initializing summernote
	        	  });
	       
	    });
	function check() {
		var markupStr = $('#summernote').summernote('code');
		document.getElementById('contents').setAttribute('value',markupStr);
		var a = $('#contents').text;
		console.log(a);
	}
	function home() {
		location.href="/"; 
	}
	function back() {
		
		if(confirm('작성을 취소하시겠습니까?')){
			location.href="/"; 
		}
	}
	
</script>
</html>