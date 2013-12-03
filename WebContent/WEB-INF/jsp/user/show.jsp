<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户${user.nickname }详细信息</title>
</head>
<body>

<sf:form method="post" modelAttribute="user">
	<table width="700" align="center" border="1">
		<tr>
			<td>用户名</td>
			<td>${user.username }</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>${user.password }</td>
		</tr>
		<tr>
			<td>昵称</td>
			<td>${user.nickname }</td>
		</tr>
		<tr>
			<td>邮箱 </td>
			<td>${user.email }</td>
		</tr>
		
	</table>

	
</sf:form>
</body>
</html>