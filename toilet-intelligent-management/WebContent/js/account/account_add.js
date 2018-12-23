layui.use([ 'element', 'form', 'laydate' ], function() {
    var form = layui.form();

    form.verify({
        phone : function(value) {
            var msg = "";
            if(!(/^1[3|4|5|7|8]\d{9}$/.test(value))){
                msg="手机号码有误，请重填!";
                return msg;
            }
            $.ajax({
                type : "post",
                url : rootPath + "/account/accountIsExist.shtml?phone="+value,
                cache : false,
                async : false,
                dataType : "json",
                success : function(obj) {
                    if (!obj.status) {
                        console.log(!obj.status+"===="+obj.message);
                        msg = obj.message;
                        return obj.message;
                    }
                }
            });
            if (msg!="") {
                return msg;
            }
        },password : function(value){
            if (value!="" && value!=null) {
                if (value.length < 6){
                    return "密码最少6位";
                }
            }
        }
    });

    form.on('submit(formSubmit)', function(data) {
        $.post(rootPath + "/account/accountAdd.shtml", data.field, function(result) {
            if (!result.status) {
                layer.msg(result.message, {
                    icon : 5,
                    shift : 6
                });
            } else {
                layer.msg('添加成功', {
                    icon : 1
                });
                parent.refreshUserList();
            }
        }, "json");
        return false;
    });
})