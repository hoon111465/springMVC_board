<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생</title>
</head>
 <link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/css/error.css">
<body>
	<div class="error-page">
	<h1>에러가 발생하였습니다. 다시 시도해 주세요.</h2>
	<button onclick="home()"></button>
	</div>
</body>
<script>
	function home() {
			location.href="/"; 
	}
</script>
</html>