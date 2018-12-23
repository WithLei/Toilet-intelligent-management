<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link rel="stylesheet" href="layui/css/modules/code.css" media="all">
<link rel="stylesheet" href="layui/css/modules/layer/default/layer.css" media="all">
<link rel="stylesheet" href="css/login.css" media="all">
</head>
<body>
	<div class="login">
	    <h1>智能厕位管理平台</h1>
	    <form class="layui-form" method="post" action="${ctx}/login">
	    	<div class="layui-form-item">
				<input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>
			<button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		</form>
		<span>${requestScope.get("msg")}</span>
	</div>
</body>
</html>
