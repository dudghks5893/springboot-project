let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{ // function(){}를 사용안하고 , ()=>{}를 사용하는 이유는 this를 바인딩하기 위해서
			this.save();
		});
		$("#btn-update").on("click", ()=>{ // function(){}를 사용안하고 , ()=>{}를 사용하는 이유는 this를 바인딩하기 위해서
			this.update();
		});
	},
	// 회원가입
	save:function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val(),
		};
		
		$.ajax({
			type:"POST",
			url:"join",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
			if(resp.status === 500){
				alert("회원가입에 실패하였습니다.")
			} else{
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}
		
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	// 회원 수정
	update:function(){
		let data = {
			id:$("#id").val(),
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val(),
		};
		
		$.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	}
	
}

index.init();