let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{ 
			this.save();
		});
		$("#btn-delete").on("click", ()=>{ 
			this.deleteById();
		});
		$("#btn-update").on("click", ()=>{ 
			this.update();
		});
	},
	
	// 상품 등록
	save:function(){
		let data = {
			productName:$("#productName").val(),
			price:$("#price").val(),
			stock:$("#stock").val(),
			content:$("#content").val(),
		};
		
		$.ajax({
			type:"POST",
			url:"/rest/products",
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
			alert("상품등록이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	// 상품 삭제
	deleteById:function(){
		let id = $("#id").text(); // 벨류 값이 아닌 텍스트 값을 뽑아옴
		
		$.ajax({
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json"
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			//location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	// 상품 수정
	update:function(){
		let id = $("#id").val();
		
		let data = {
			title:$("#title").val(),
			content:$("#content").val(),
		};
		
		$.ajax({
			type:"PUT",
			url:"/api/board/"+id,
			data:JSON.stringify(data), 
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp){
			alert("글수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	
}

index.init();