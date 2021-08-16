let index = {
	init : function() {
		$("#btn-save").on("click", ()=>{
			this.save();
		});
		$("#btn-update").on("click", ()=>{
			this.update();
		});
	},
	save:function() {
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email:$("#email").val()
		};
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax호출시 default가 비동기 호출
		//AJAX가 통신 성공하고 서버가 JSON을 리턴해주면 	자동으로 자바 오브젝트로 변환 
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지
			dataType : "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String (생긴게 json이면 -> 자바스크립트 오브젝트로 변경)
		}).done(function() {
			if(resp.status === 500) {
				alert("this username exists now");
			}else {
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}
				
		}).fail(function(error){
				alert(JSON.stringify(error));
		});
	},
	update: function() {
		let data = {
			username : $("#username").val(),
			id : $("#id").val(),
			password : $("#password").val(),
			email:$("#email").val()
		};
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax호출시 default가 비동기 호출
		//AJAX가 통신 성공하고 서버가 JSON을 리턴해주면 	자동으로 자바 오브젝트로 변환 
		$.ajax({
			type:"PUT",
			url:"/user",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지
			dataType : "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String (생긴게 json이면 -> 자바스크립트 오브젝트로 변경)
		}).done(function() {
				alert("회원 수정이 완료되었습니다.");
				location.href = "/";
		}).fail(function(error){
				alert(JSON.stringify(error));
		});
	},
}
index.init();