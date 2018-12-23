layui.use(['element','form'], function() {
	var element = layui.element(),
	form = layui.form();
	
	$('a.meun_a').click(function() {
		var url = $(this).data('url');
		$('#breadcrumb_title').text($(this).attr('title'));
		$("#mds_manager_body").empty().load(url, function() {
			form.render();
		});
	});
	
	$('#lockbt').click(function (){
		layer.prompt({
			title : '请输入登录密码解锁',
			formType : 1,
			closeBtn: 0,
			move : false,
			shade : 0.9,
			cancel : function(index, layero) {
				return false;
			}  
		}, function(pass, index) {
			
			$.post(rootPath+"/index/unlock.shtml", {pass : pass}, function(result) {
				debugger;
				if (!result.status) {
					layer.msg(result.message, {
						icon : 5,
						shift : 6
					});
				}else {
					layer.close(index);
				}
			}, "json");
		});
		$(window).keydown(function (event) {
			if(event.keyCode === 13) {
				$('.layui-layer-btn0').click();
			}
		});
	});
	
	$('#changePass').click(function(){
		layer.open({
			type: 2,
			move : false,
			title : '密码修改',
			area: ['450px', '280px'],
			content: './index/goUpdatePassPage.shtml',
		});
	})
	
	$('#personal_data').click(function (){
		$("#mds_manager_body").empty().load(rootPath+"/index/gopersonalDataPage.shtml", function() {
			form.render();
		});
	})
});


