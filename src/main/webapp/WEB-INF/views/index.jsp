<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index page</title>
</head>
<style>
  table, th, td {
    border: 1px solid #444444;
  }
  .idx {
    width: 50px;
  }
  .title {
    width: 150px;
  }
  .content {
    width: 250px;
  }
</style>
<body>
	<h1>Hello index page!</h1>
	<div>
	<h2>게시판</h2>
	<button onclick="localhost:8080/create">글쓰기</button>
	</div>
	<table>
		<tr>
			<th class="idx">번호</th>
			<th class="title">제목</th>
			<th class="content">내용</th>
			<th class="del">삭제</th>
			<th class="update">수정</th>
		</tr>
		<!-- <tr>
			<td class="idx"></td>
			<td class="title"></td>
			<td class="content"></td>
			<td class="del"><button value="">삭제</button></td>
			<td class="update"><button value="">수정</button></td>
		</tr> -->
<%-- 			<c:when test="${list > 0 }"> --%>
			<c:forEach  items="${list }" var="bList">
				<tr>
					<td class="idx">${bList.idx }</td>
					<td class="title">${bList.title }</td>
					<td class="content">${bList.content }</td>
					<td class="del"><button value="${bList.idx }">삭제</button></td>
					<td class="update"><button value="${bList.idx }">수정</button></td>
				</tr>
				</c:forEach>
		<%-- 	</c:when>
			<c:otherwise>
				<tr>
	               <td colspan="5">조회된 결과가 없습니다.</td>
	            </tr>
			</c:otherwise> --%>
			
	</table>
</body>
</html>