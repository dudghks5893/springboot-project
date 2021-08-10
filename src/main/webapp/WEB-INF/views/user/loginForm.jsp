<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 헤더  -->
<%@ include file="../layout/header.jsp"%>
<!-- 바디 시작-->
<div class="container">

	<form action="/login" method="POST">
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
	
	<br>
	<hr>
	<small><strong>간편 로그인</strong></small>
	<br><br>
	<a href="/oauth2/authorization/naver" >
		<img height="99px" src="/image/naver_login_button.png"/>
	</a>
	<a href="/oauth2/authorization/kakao">
		<img height="97px" src="/image/kakao_login_button.png"/>
	</a>
	<br>
	<a href="/oauth2/authorization/facebook" >
		<img height="97px" src="/image/facebook_login_button.png"/>
	</a>
	<a href="/oauth2/authorization/google" style="margin-left: 60px">
		<img height="68px" src="/image/google_login_button.png"/>
	</a>
	
</div>
<!-- 바디 끝 -->
<!-- 푸터 -->
<%@ include file="../layout/footer.jsp"%>


