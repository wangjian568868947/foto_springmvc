<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户列表页面</title>
</head>
<body>


	<%--<a href="add">用户添加</a>-->${loginUser.nickname }<br>
	    <c:forEach items="${users }" var = "um">
		<a href="${um.value.username }">${um.value.username}</a>
		<a href="${um.value.username}/update">修改</a>
		<a href="${um.value.username }/delete">删除</a>
		<br/>
	</c:forEach> --%>
	<table width="700px" align="center" border="1">
		<tr>
			<td>用户标识</td><td>用户名</td><td>用户昵称</td><td>用户密码</td><td>用户邮箱</td><td>操作</td>
		</tr>
		<c:if test="${pages.total le 0 }">
			<tr>
				<td colspan="6">目前还没有数据</td>
			</tr>
		</c:if>
		<c:if test="${pages.total gt 0 }">
		<c:forEach items="${pages.datas }" var = "u">
		<tr>
			<td>${u.id}</td><td>${u.username}</td><td>${u.nickname }</td><td>${u.password }</td><td>${u.email }</td>
			<td><a href="">更新</a><a href="">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<jsp:include page="/inc/pager.jsp">
					<jsp:param value="users" name="url"/>
					<jsp:param value="${pagers.total }" name="items"/>
				</jsp:include>
			
			</td>
		</tr>
		</c:if>
	</table>
</body>
</html>