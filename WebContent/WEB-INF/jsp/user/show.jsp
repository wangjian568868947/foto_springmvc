<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sf:form method="post" modelAttribute="user">
	用户名：${user.username }<br/>
	密码     ：${user.password }<br/>
	昵称     ：${user.nickname }<br/>
	邮箱     ：${user.email }<br/>
</sf:form>
</body>
</html>