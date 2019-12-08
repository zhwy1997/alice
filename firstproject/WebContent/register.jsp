<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function testJson() {
		//获取输入的值pname为id
		var uAccount = $("#uAccount").val();
		var password = $("#password").val();

		$.ajax({
			//请求路径
			url : "${pageContext.request.contextPath }/usr/register",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : JSON.stringify({uAccount:uAccount,password:password}),
			//定义发送请求的数据格式为JSON字符串
			contentType : "application/json;charset=utf-8",
			//定义回调响应的数据格式为JSON字符串，该属性可以省略
			dataType : "json",
			//成功响应的结果
			success : function(data){
				if(data.messageCode ==1){
					alert("输入的用户名:" + data.myUsr.uAccount + "，密码：" + data.myUsr.password);
				} else {
					alert("账号或密码错误");
				}
			},
			error : function(data) {
				if(data==null) {
					alert("账号或密码错误");
				}
			}
		});
	}
</script>
</head>
<body>
	<form action="">
		用户名：<input type="text" name="uAccount" id="uAccount"/><br>
		密码：<input type="password" name="password" id="password"/><br>
		<input type="button" value="测试" onclick="testJson()"/>
	</form>
</body>
</html>