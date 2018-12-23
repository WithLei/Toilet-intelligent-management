<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>IE-MANAGER管理平台</title>
<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${ctx}/layui/css/modules/code.css"
	media="all">
<link rel="stylesheet"
	href="${ctx}/layui/css/modules/laydate/laydate.css" media="all">
<link rel="stylesheet"
	href="${ctx}/layui/css/modules/layer/default/layer.css" media="all">
<link rel="stylesheet" href="${ctx}/css/base.css">
<link rel="stylesheet" href="${ctx}/css/main.css">
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-main">
				<a href="${ctx}/index" class="logo">智能厕位管理平台</a>
				<!-- 顶部右侧菜单 -->
				<ul class="layui-nav top_menu">
					<%-- <li class="layui-nav-item showNotice" id="showNotice" pc><a
						href="javascript:;"><i class="iconfont icon-gonggao"></i><cite><i
								class="layui-icon" style="font-size: 18px;">&#xe645;</i>系统公告</cite></a></li>
					<li class="layui-nav-item" mobile><a href="./logout.shtml"><i
							class="iconfont icon-loginout"></i><i class="layui-icon"
							style="font-size: 16px;">&#xe609;</i> 退出</a></li> --%>
					<li class="layui-nav-item" pc><a href="javascript:;"> <img
							src="${ctx}/images/userface4.jpg" class="layui-circle" width="35"
							height="35"> <cite>超级管理员</cite>
					</a>
						<dl class="layui-nav-child">
<%-- 							<dd>
								<a href="javascript:;" id="personal_data" data-url="page/user/userInfo.html"><i
									class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a>
							</dd> --%>
							<dd>
								<a href="javascript:;" id="changePass"><i
									class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a>
							</dd>
							<dd>
								<a href="login.shtml" class="noAddTab"><i
									class="iconfont icon-loginout"></i><cite>注销</cite></a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<c:forEach var="menu" items="${menus}">
						<li class="layui-nav-item"><a href="javascript:;">
						<i class="layui-icon" style="font-size: 16px;">${menu.icon}</i>&nbsp;${menu.name}</a>
						<dl class="layui-nav-child">
						<c:forEach var="childMenus" items="${menu.children}">
							<dd>
								<a class="meun_a" href="javascript:;" data-url="${ctx}${childMenus.dataUrl}" title="${childMenus.name}">&nbsp;&nbsp;<i
									class="layui-icon" style="font-size: 16px;">${childMenus.icon}</i>&nbsp;${childMenus.name}
								</a>
							</dd>
						</c:forEach>
						</dl></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div class="layui-tab layui-tab-brief">
				<ul class="layui-tab-title" id="tabTitle">
					<!-- title开始 -->
					<div class="layui-tab">
						<ul class="layui-tab-title">
							<li class="layui-this" id="breadcrumb_title">首页</li>
						</ul>
					</div>
				</ul>
			</div>
			<div id="mds_manager_body">
				<div class="dx-welcome"></div>
				<h5 class="dx-welcome-title">欢迎进入智能厕位管理平台，请点击左侧菜单开始操作吧！</h5>
			</div>
		</div>
		<div class="layui-footer footer">
			<div class="layui_main">
				<p>@2017 ToiletManager-Intelligent-Management管理平台</p>
			</div>
		</div>
	</div>
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript">
		var rootPath = '${ctx}';
	</script>
	<script src="${ctx}/js/index/index.js"></script>
	<script src="${ctx}/js/jfTable.js"></script>
</body>
</html>
