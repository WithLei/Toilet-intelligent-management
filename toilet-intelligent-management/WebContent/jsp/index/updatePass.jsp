<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
<title>密码修改</title>
<link rel="stylesheet" href="${ctx}/css/base.css">
<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
</head>

<body>
	<div class="body_top_marger10">
		<div class="layui-main" style="width: 350px">
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">旧密码</label>
					<div class="layui-input-inline">
						<input type="password" id="pwd" name="password" required lay-verify="required"
							placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">重复密码</label>
					<div class="layui-input-inline">
						<input type="password" id="regPwd" name="regPassword" required lay-verify="regPwd"
							placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline">
						<input type="password" id="newPwd" name="newPassword" required lay-verify="newPwd"
							placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formSubmit">确定</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript">
		var rootPath = '${ctx}';
	</script>
	<script src="${ctx}/js/index/updatePass.js"></script>
</body>
</html>