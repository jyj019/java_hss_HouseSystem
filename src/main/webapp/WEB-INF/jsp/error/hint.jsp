<%@ page pageEncoding="utf-8"%>
<%
	String basePath = 
			request.getScheme() + "://" + 
			request.getServerName() + ":" + 
			request.getServerPort() + 
			request.getContextPath() + "/";
%>
<!doctype html>
<html>
	<head>
		<base href="<%= basePath%>">
		<meta charset="utf-8">
	</head>
	<body>
		<h1>系统正在升级维护</h1>
		<a href="home">返回首页</a>
	</body>
</html>