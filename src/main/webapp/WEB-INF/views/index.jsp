<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 헤더  -->
<%@ include file="layout/header.jsp"%>
<!-- 바디 시작-->
<div class="container">
	<c:forEach var="products" items="${products.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${products.productName}</h4>
				<h4 class="card-title">${products.content}</h4>
				<a href="/products/${products.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${products.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${products.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${products.number-1}">Previous</a></li>
			</c:otherwise>
			
		</c:choose>
				<c:choose>
			<c:when test="${products.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${products.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${products.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<!-- 바디 끝 -->

<!-- 푸터 -->
<%@ include file="layout/footer.jsp"%>


