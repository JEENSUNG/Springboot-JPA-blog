<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2 ">
			<div class="card-body">
				<h3 class="d-flex card-title">${board.title}</h3>
				<div class = "d-flex justify-content-between">
					<a href="/board/${board.id}" class="btn btn-primary">내용 보기</a> <span>작성자 : ${board.user.username} &nbsp;</span>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<ul class="pagination justify-content-center">
	<c:choose>
		<c:when test="${boards.first}">
			<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">이전 페이지</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">이전 페이지</a></li>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${boards.last}">
			<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">다음 페이지</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">다음 페이지</a></li>
		</c:otherwise>
	</c:choose>
</ul>
</div>
<br />

<%@include file="layout/footer.jsp"%>

