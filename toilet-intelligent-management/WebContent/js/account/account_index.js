layui.use(['element', 'form'], function () {
    var element = layui.element(), form = layui.form();
    var config = {
        url: rootPath + "/account/getAccountPage.shtml",// 获取数据的url
        page: true,
        select: true,
        columns: [{
            text: '用户名',
            name: 'id',
            width: 10
        }, {
            text: '手机号码',
            name: 'phone',
            width: 10
        }, {
            text: '创建时间',
            name: 'createTime',
            width: 10
        }, {
            text: '状态',
            name: 'status',
            width: 10,
            formatter: function (value, row, index) {
                if (value == 1) {
                    return "<div name='mds_switch1' onclick='mds_switch_click(this);' title='" + index + "' class='open1'>启用<div name='mds_switch2' class='open2'></div></div>";
                } else {
                    return "<div name='mds_switch1' onclick='mds_switch_click(this);' title='" + index + "' class='close1'>禁用<div name='mds_switch2' class='close2'></div></div>";
                }
            }
        }],
        // 事件 一定要return
        onBeforeLoad: function (param) {
            return param;
        },
        onLoadSuccess: function (data) {
            return data;
        },
        dataFilter: function (data) {
            return data;
        }
    };
    $("#table").jfTable(config);

    // 添加用户方法
    $('#userAdd').click(function () {
        layer.open({
            type: 2,
            move: false,
            title: '添加用户',
            area: ['700px', '650px'],
            content: rootPath + '/account/goAddAccountPage.shtml'
        });
    })

    // 删除用户方法
    $('#userDel').click(function () {
        var row = $("#table").jfTable("getSelected");
        if (row.length <= 0) {
            layer.msg("至少需要选择一行数据才能进行该操作", {
                icon: 5,
                shift: 6
            });
            return;
        }
        var ids = "";
        for (var i = 0; i < row.length; i++) {
            ids = ids + row[i].id;
            if (i != row.length - 1) {
                ids = ids + ",";
            }
        }

        layer.confirm('是否确定删除该数据？', {
            icon: 3,
            title: '系统提示',
            btn: ['删除', '取消']
        }, function (index, layero) {
            $.post(rootPath + "/account/accountDel.shtml", {
                ids: ids
            }, function (result) {
                if (result.status) {
                    layer.msg('删除成功', {
                        icon: 1
                    });
                } else {
                    layer.msg(result.message, {
                        icon: 5,
                        shift: 6
                    });
                }
            }, "json");
            refreshUserList();
        });
    })

    //导出
    $('#userExport').click(function () {
        layer.confirm('是否导出数据？', {
            icon: 3,
            title: '系统提示',
            btn: ['确定', '取消']
        }, function (index, layero) {
            var fullHref = rootPath + "/account/exportExcel.shtml";

            window.location.href = fullHref;
            layer.closeAll('dialog');
        });
    })

    // 更新用户方法
    $('#userRefresh').click(function () {
        refreshUserList();
    })

    form.on('submit(formQuery)', function (data) {
        console.log($('#query_id').val());
        console.log($('#query_phone').val());
        refreshUserList();
        return false;
    });
})

// 刷新用户列表
function refreshUserList() {
    var id = $('#query_id').val();
    var phone = $('#query_phone').val();
    var obj = {};
    obj.id = id;
    obj.phone = phone;
    $("#table").jfTable("reload", obj);
}

//开关点击事件
function mds_switch_click(obj) {
    var row = $("#table").jfTable("getRow", obj.title)
    var status = row.status == 1 ? 0 : 1;

    $.post(rootPath + "/account/updateStatus.shtml", {
        id: row.id,
        status: status
    }, function (result) {
        if (!result.status) {
            layer.msg(result.message, {
                icon: 5,
                shift: 6
            });
        } else {
            layer.msg('状态修改成功', {
                icon: 1
            });
            refreshUserList();
        }
    }, "json");
}
