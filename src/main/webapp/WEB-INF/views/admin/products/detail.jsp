<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 헤더  -->
<%@ include file="../../layout/header.jsp"%>
<!-- 바디 시작-->
<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${principal.user.role eq 'ROLE_ADMIN' or principal.user.role eq 'ROLE_MANAGER'}">
		<a href="/admin/products/${product.id}/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /> <br />
	<div>
		글 번호 : <span id="id"><i>${product.id} </i></span> 작성자 : <span><i>${product.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${product.productName}</h3>
	</div>
	<hr />
	<div>
		<div>${product.content}</div>
	</div>
	<!-- 리뷰 영역 -->
</div>
<script src="/js/products.js"></script>
<!-- 바디 끝 -->
<!-- 푸터 -->
<%@ include file="../../layout/footer.jsp"%>
