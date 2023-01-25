<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<article style="position:absolute; top:50%;left:50%;height:300px; width:400px;margin:-150px 0px 0px -200px">
		<div class="container">
		  <div class="row">
			<div class="col">
				<div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title">ID입력</h5>
				    <input id="userName" type="text" />
				    <input type="button" class="btn btn-primary" id="login_id" value = 'Enter' onclick="login()"/>
				  </div>
				</div>
			 </div>
		  </div>
		</div>
	</article>
</body>

<script>
	function login(id){
		const user_id = document.getElementById('userName').value;
		var data = {"userId": user_id};
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/login", true);
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.send(JSON.stringify(data));
		
		xhr.onreadystatechange = function () {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) { //200은 에러가 없다는 뜻
	                console.log("연결 성공");
	                /*연결이 성공 되었다면 받아온 데이터 처리 */
	                const response = xhr.responseText;
	                alert(response);
	            } else {
	                console.log("연결 실패");
	            }
	        }
	    }
	}
</script>
</html>