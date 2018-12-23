<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
    <link rel="stylesheet" href="${ctx}/css/base.css">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
</head>
<body>
<div class="body_top_marger10">
    <div class="layui-main layui-form-pane" style="width: 550px">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label"><font color="red">*</font>手机号</label>
                <div class="layui-input-inline">
                    <input type="tel" id="phone"
                           name="phone" required onkeyup="value=value.replace(/[^\d]/g,'')"
                           lay-verify="phone" placeholder="请输入手机号"  maxlength="11" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><font color="red">*</font>密码</label>
                <div class="layui-input-inline">
                    <input type="text" id="password" name="password"
                           required lay-verify="password"
                           placeholder="请输入密码" autocomplete="off" maxlength="18" class="layui-input">
                </div>
                <div class="mds-form-input-aux">PS：请输入6-18位密码</div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="checkbox" id="status" checked="checked"
                           name="status" lay-skin="switch" lay-text="启用|禁用">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formSubmit">保存</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/layui/layui.js"></script>
<script type="text/javascript">
    var rootPath = '${ctx}';
</script>
<script src="${ctx}/js/jfTable.js"></script>
<script src="${ctx}/js/account/account_add.js"></script>
</body>
</html>