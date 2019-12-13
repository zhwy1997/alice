<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<!-- <script type="text/javascript">
	function testJson() {
		//获取输入的值pname为id
		var uid = $("#uid").val();


		$.ajax({
			//请求路径
			url : "${pageContext.request.contextPath }/usrSellGoods",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : JSON.stringify({uid:uid}),
			//定义发送请求的数据格式为JSON字符串
			contentType : "application/json;charset=utf-8",
			//定义回调响应的数据格式为JSON字符串，该属性可以省略
			dataType : "json",
			//成功响应的结果
			success : function(data){
				;
				}
			},
			error : function(data) {
				if(data==null) {
					alert("账号或密码错误");
				}
			}
		});
	} -->
<!-- </script> -->
</head>
<body>
	<form action="${pageContext.request.contextPath}/usrSellGoods" method="post" >
		ID：<input type="text" name="uid" id="uid"/><br>
		<input type="submit" value="测试" />
	</form>
</body>
</html>