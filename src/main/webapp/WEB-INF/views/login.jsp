<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/css/login.css">
<body>
<div class="wrap">
	<header class="header-container">
		<h1><a href="/">BOARD</a></h1>
	</header>
	<main class="main-container">
		<form class="form-container" action="/login" method="POST">
			<ul class="config-container">
				<li class="row">
                  	<input name="id" type="text" placeholder="아이디">
                </li>
				<li class="row">
                   <input name="password" type="password" placeholder="비밀번호">
				</li>
			</ul>
			<ul class="btn-container">
				<li>
					<input class="btn" type="submit" value="로그인">
				</li>
				<li>
					 <input class="btn" type="button" onclick="join()" value="회원가입">
				</li>
			</ul>     
         </form>
	</main>
	 <footer class="footer-container"></footer>
</div>
</body>
<script>
function join() {
		location.href="/join"; 
	}
</script>
</html>