<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 헤더  -->
<%@ include file="../../layout/header.jsp"%>
<!-- 바디 시작-->
<div class="container">

	<form>
		<div class="form-group">
			<label for="productName">상품이름</label> 
			<input type="text" class="form-control" placeholder="productName" id="productName">
		</div>
		<div class="form-group">
			<label for="price">가격</label> 
			<input type="text" class="form-control" placeholder="price" id="price">
		</div>
		<div class="form-group">
			<label for="stock">재고</label> 
			<input type="text" class="form-control" placeholder="stock" id="stock">
		</div>
		<div class="form-group">
			<label for="content">상품설명</label> 
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">상품 등록</button>

</div>
<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/products.js"></script>
<!-- 바디 끝 -->
<!-- 푸터 -->
<%@ include file="../../layout/footer.jsp"%>


