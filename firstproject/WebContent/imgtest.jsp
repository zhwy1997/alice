<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/addSellGoods" id="uploadForm" method="post" enctype="multipart/form-data">  
    选择文件:<input type="file" name="goodIMG">  <br>
    所属用户ID:<input type="text" name="belongUsr"> <br>
   商品名字：<input type="text" name="goodName"> <br>
 <input type="submit" value="提交">     
</form> 
</body>
</html>