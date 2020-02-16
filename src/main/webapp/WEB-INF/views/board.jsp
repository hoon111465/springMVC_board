<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
 <link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<body>
<div class="wrap">
	<header class="header-container">
		<div class="login-container">
			<c:choose>
				<c:when test="${not empty userConfig.name}">
					<span class="header-user" value="${userConfig.idx }">${userConfig.name }님</span>
					<button class="header-btn logout-btn"  onclick="logout()">로그아웃</button>
					<button class="header-btn white-btn" onclick="boardWhite()">글쓰기</button>
				</c:when>
				<c:otherwise>	
				<button class="header-btn login-btn" onclick="loginGo()">로그인</button>
				</c:otherwise>	
			</c:choose>
		</div>	
	</header>
	<main class="main-container">
	<h1 class="title-text">게시판</h1>
	<table>
			<tr>
				<th class="idx">번호</th>
				<th class="title">제목</th>
				<th class="name">작성자</th>
				<th class="regdate">작성일</th>
			</tr>
				<c:forEach  items="${list }" var="bList">
					<tr>
						<td class="idx">${bList.idx }</td>
						<td class="title"><a href="/post/${bList.idx }">${bList.title }</a></td>
						<td class="name">${bList.name }</td>
						<td class="regdate">${bList.regdate }</td>
					</tr>
				</c:forEach>
		</table>
		<div class="paginate-container">${paginate }</div>
	</main>
	 <footer class="footer-container"></footer>
</div>
</body>
<script src="/js/login.js"></script>
<script>
	function boardWhite() {
		location.href="/boardWhite"; 
	}	
</script>
</html>