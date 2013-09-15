<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
</head>
<body>
<div style="width: 1024px;margin: 0 auto;;">
	<struts:if test="%{loginStatus != null}">用户名或密码错误，请重新登录</struts:if>
	<form action="${ctx }/login/login.do" name="loginForm" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="user.loginName" placeholder="请输入用户名" required autofocus/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="user.password" placeholder="请输入密码"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="登录"/>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>