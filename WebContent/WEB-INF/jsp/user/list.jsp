<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
<a href="add">添加</a>-->${loginUser.nickname }<br>
	<c:forEach items="${users }" var = "um">
		<a href="${um.value.username }">${um.value.username}</a>
		<a href="${um.value.username}/update">修改</a>
		<a href="${um.value.username }/delete">删除</a>
		<br/>
	</c:forEach>
</body>
</html>