layui.use([ 'form', 'jquery' ], function() {
	var $ = layui.jquery;
	var form = layui.form();
	form.verify({
		regPwd : function(value) {
			// 获取密码
			var pwd = $("#pwd").val();
			if (pwd != value) {
				return '两次输入的密码不一致';
			}
		},
		newPwd : function(value) {
			if (value.length < 6) {
				return '密码长度最少6个字符';
			}
		}
	});
	form.on('submit(formSubmit)', function(data) {
		$.post(rootPath+"/system/updatePass.shtml", data.field, function(result) {
			if (!result.status) {
				$('#pwd').focus();
				$('#pwd').addClass("layui-form-danger");
				layer.msg(result.message, {
					icon : 5,
					shift : 6
				});
			}else {
				layer.msg('修改成功', {icon: 1},function () {
                    //当在iframe页面关闭自身时，在iframe页执行以下js脚本
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                });
			}
		}, "json");
		return false;
	});
});