<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/js/account/account_index.js"></script>
<script>
    var rootPath = "${ctx}";
</script>
<div class="body_center">

    <div class="colla-panel">
        <div class="colla-content">
            <form class="layui-form">

                <div class="layui-form-item">
                    <label class="layui-form-label">楼层名：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="query_id" name="id" placeholder="请输入需要查询楼层名"
                               autocomplete="off" class="layui-input">
                    </div>
                    <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formQuery">
                        <i class="iconfont">&#xe741;</i>查询
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">
                        <i class="iconfont">&#xe6f8;</i>重置
                    </button>
                </div>

            </form>
        </div>
    </div>
    <div class="empty-line"></div>
    <div class="div_centent_right">
        <div class="layui-btn-group">
            <button class="layui-btn layui-btn-primary" id="userAdd" onclick="window.location.href='${ctx}/floor_add'" target="body">
                <i class="iconfont">&#xe6e2;</i> 添加
            </button>
            <button class="layui-btn layui-btn-primary" id="userDel">
                <i class="iconfont">&#xe6f7;</i> 删除
            </button>
            <button class="layui-btn layui-btn-primary" id="userRefresh">
                <i class="iconfont">&#xe71e;</i> 刷新
            </button>
            <button class="layui-btn layui-btn-primary" id="userExport">
                <i class="iconfont">&#xe71e;</i> 导出
            </button>
        </div>
    </div>

    <div id="table"></div>
</div>
