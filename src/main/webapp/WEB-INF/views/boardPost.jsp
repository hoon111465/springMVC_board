<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
 <link rel="shortcut icon" href="/images/favicon/favicon.ico" type="image/x-icon">
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<link rel="stylesheet" href="/css/boardPost.css">
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
		<div class="board-title-container">		
			<p class="name">작성자 : ${board.name }</p>
			<p class="date">작성일 : ${board.regdate }</p>
			<p class="title">${board.title }</p>
			<div class="board-update-container">
			<c:choose>
				<c:when test="${userConfig.idx==board.userNo }">
						<button class="update-btn" onclick="update()">수정</button>
				</c:when>
			</c:choose>
		</div>
		</div>
		<div class="board-contents-container">
			${board.contents }
		</div>
		<div class="comment-container">
			<div class="comment-white-container">
				<input class="board-comment" placeholder="댓글 작성...." />
				<input class="comment-userNo" type="hidden" value="${userConfig.idx}"/>
				<input class="comment-boardNo" type="hidden" value="${board.idx}" />
				<button class="comment-btn" onclick="commentInsert()">완료</button>
			</div>
			<div class="comment-list-container">
				<ul class="comment-list">
	                <script type="text/template" id="commentListTmp">
					<@ _.each(commentList,function(cList){ @>
						<li class="comment-contents">
                            <span class="comment-name">작성자 : <@=cList.name @></span>
							<span class="comment-date">작성일 : <@=cList.regdate @></span>
							<p><@=cList.contents @></p>
                        </li>
					<@ })@>
                    </script>
	             </ul>
			</div>
			<button class="add-btn" onclick="addComment()">더보기</button>
		</div>
	</main>
	 <footer class="footer-container"></footer>
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.9.1/underscore-min.js"></script>
<script src="/js/login.js"></script>
<script>
	function update() { 
		location.href="/update/"+${ board.idx }; 
	}

	_.templateSettings = {
			interpolate: /\<\@\=(.+?)\@\>/gim,
			evaluate: /\<\@([\s\S]+?)\@\>/gim,
			escape: /\<\@\-(.+?)\@\>/gim
			};
	
	var commentListTmp = _.template($("#commentListTmp").html());

	function commentInsert() {
		var userNo = $(".comment-userNo").val();
		var boardNo = $(".comment-boardNo").val();
		var contents =  $(".board-comment").val();
		console.log(contents);
		$.ajax({
		    url: "http://localhost:8080/ajax/comment", // 클라이언트가 요청을 보낼 서버의 URL 주소
		    data:{
		    		"userNo": userNo,
		    		"boardNo": boardNo,
		    		"contents": contents
		    },         // HTTP 요청과 함께 서버로 보낼 데이터
		    type: "GET",    // HTTP 요청 방식(GET, POST)
		    dataType: "json", // 서버에서 보내줄 데이터의 타입
		    contentType: "application/json; charset=UTF-8",
			success : function(data) {
				console.log("작성 성공");
				commentList();
			},
			error:function(req,status,err){
	            alert("실패 : "+req+", "+status+", "+err);
		    }
		})
	}
	
	var num = 1;
	
	function commentList() {
		console.log("commentList()");
		console.log(num);
		/* $(".board_comment_ul").children().remove(); */
		var boardNo = ${ board.idx};

		$.ajax({
		    url: "http://localhost:8080/ajax/commentList/"+boardNo, // 클라이언트가 요청을 보낼 서버의 URL 주소
		    data:{
	    		"num": num
	    },         // HTTP 요청과 함께 서버로 보낼 데이터
		    type: "GET",    // HTTP 요청 방식(GET, POST)
		    dataType: "json", // 서버에서 보내줄 데이터의 타입
		    contentType: "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data);
				$(".comment-list").append(commentListTmp({"commentList":data.cList}));
				num++;
			},
			error:function(req,status,err){
	            alert("commentList() 실패 : "+req+", "+status+", "+err);
		    }
		})
	}// commentList() end
	commentList();
	
	function addComment() {
		commentList();
	}
	
	
</script>
</html>