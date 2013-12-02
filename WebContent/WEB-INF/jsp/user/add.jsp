<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户添加</title>
</head>
<body>

<sf:form method="post" modelAttribute="user" enctype="multipart/form-data">
	用户名：<sf:input path="username"/><sf:errors path="username"/><br/>
	密码     ：<sf:password path="password"/><sf:errors path="password"/><br/>
	昵称     ：<sf:input path="nickname"/><br/>
	邮箱     ：<sf:input path="email"/><sf:errors path="email"/><br/>
	Attach1:<input type="file" name="attachs"><br>
	Attach2:<input type="file" name="attachs"><br>
	Attach3:<input type="file" name="attachs"><br>
	<input type="submit" value="添加用户"/>
</sf:form>
</body>
</html>