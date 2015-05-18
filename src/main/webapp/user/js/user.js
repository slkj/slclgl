var grid;
var basePath = "../user/";
$(function() {
	loadDataGrid();
	$("#search_btn").click(function() {
		$('#gird').datagrid({
			queryParams : form2Json("searchform")
		}); // 点击搜索
		// 清空表单
		$('#searchform').form('clear');
	});
});
function loadDataGrid() {
	grid = $("#gird").datagrid({ // title : '用户列表',
		url : basePath + 'list',
		loadMsg : '数据加载中....',
		fit : true,
		nowrap : true, // false:折行
		rownumbers : true, // 行号
		striped : true, // 隔行变色
		singleSelect : true,// 是否单选
		pagination : true,
		pageSize : 20,
		pageList : [ 1, 10, 15, 20, 30, 50 ],
		fitColumns : true,
//		frozenColumns : [ [ {
//			field : 'ck',
//			checkbox : true
//		}, {
//			title : '编号',
//			field : 'id',
//			sortable : true
//		} ] ],
		columns : [ [ {
			title : '基本信息',
			colspan : 9
		}, {
			field : 'opt',
			title : '操作',
			width : 150,
			align : 'center',
			rowspan : 2,
			formatter : function(value, row, index) {
				var s = "";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:show('" + index + "');\">详细</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('" + index + "');\">编辑</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('" + index + "');\">删除</span>&nbsp;&nbsp;</a>";
				return s;
			}
		} ], [ {
			field : '_opt',
			title : '用户类型',
			formatter : function(value, row) {
				if(row.type == '1'){
					return '<span style="color:blue">平台用户</span>';
				}
				if(row.type == '2'){
					return "公司用户";
				}
			}
		},{
			field : 'username',
			title : '用户名',
			width : 150
		}, {
			field : 'status',
			title : '状态',
			formatter : function(value, rec) {
				return value == 'enabled' ? '启用' : '<span style="color:red">禁用</span>';
			}
		}, {
			field : 'realname',
			title : '姓名',
			width : 150
		}, {
			field : 'phone',
			title : '联系方式',
			width : 90
		}, {
			field : 'companyName',
			title : '所属公司',
			width : 150
		}, {
			field : 'lastTime',
			title : '最后登录',
			width : 150
		}, {
			field : 'create_time',
			title : '创建时间',
			width : 150
		}, {
			field : 'validTime',
			title : '有效时间',
			formatter : function(value, rec) {
				return value == "" ? '长期有效' : value;
			}
		} ] ],

		toolbar : [ {
			id : 'btnadd',
			text : '新增用户',
			iconCls : 'icon-add',
			handler : function() {
				openDialog_add();
			}
		}, '-', {
			id : 'btnstart',
			text : '批量启用',
			iconCls : 'icon-ok',
			handler : function() {
				batch('enabled');
			}
		}, '-', {
			id : 'btnstop',
			text : '批量禁用',
			iconCls : 'icon-remove',
			handler : function() {
				batch('disabled');
			}
		}, '-', {
			id : 'btnreast',
			text : '密码重置',
			iconCls : 'icon-reload',
			handler : function() {
				batch('reast');
			}
		} ],
		onLoadSuccess : function() {
			grid.datagrid('clearSelections');
		}
	});

	// 设置分页控件
	grid.datagrid('getPager').pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}

function openDialog_add() {
	// 重新加载内容
	// parent.$("#tabiFrame").attr("src", "user/userAdd.jsp");
	window.location.href = 'userAdd.jsp';
}
function editRow(index) {
	var data = grid.datagrid('getData').rows[index];
	window.location.href = 'userEdit.jsp?id=' + data.id;
}
function show(index) {
	var data = grid.datagrid('getData').rows[index];
	window.location.href = 'show.jsp?id=' + data.id;
}

function deleteRow(index) {
	var data = grid.datagrid('getData').rows[index];
	top.$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		if (r) {
			$.ajax({
				url : basePath + "delete?id=" + data.id,
				success : function(data) {
					if (data) {
						grid.datagrid('reload');
						top.SL.sysSlideShow({
							msg : '成功删除!'
						});
					} else {
						top.$.messager.alert('提示', '删除失败，请联系管理员。');
					}
				}
			});
		}
	});
}
function batch(key) {
	$.messager.confirm("操作提示", "您确定要执行操作吗？", function(data) {
		var rows = grid.datagrid('getSelections');
		if (!rows || rows.length == 0) {
			top.$.messager.alert('提示', '请选择要修改的数据!', 'info');
			return;
		}
		var ids = [];
		$.each(rows, function(i, n) {
			var id = rows[i].id; // id这个是你要在列表中取的单个id
			ids.push(id); // 然后把单个id循环放到ids的数组中

		});
		if (data) {
			switch (key) {
			case 'reast':
				var param = {
					ids : ids
				};
				reastPwd(param);
				break;
			default:
				var param = {
					ids : ids,
					status : key
				};
				valid(param);
				break;
			}
		}
	});
}
function reastPwd(param) {
	$.ajax({
		url : basePath + "resetPwd",
		type : "POST",
		data : param,
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data) {
				top.SL.sysSlideShow({
					msg : "操作成功"
				});
			} else {
				top.SL.sysSlideShow({
					msg : "操作失败"
				});
			}
		}
	});
}
function valid(param) {
	$.ajax({
		url : basePath + "valid",
		type : "POST",
		data : param,
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data) {
				grid.datagrid('reload');
				top.SL.sysSlideShow({
					msg : "操作成功"
				});
			} else {
				top.SL.sysSlideShow({
					msg : "操作失败"
				});
			}
		}
	});
}
