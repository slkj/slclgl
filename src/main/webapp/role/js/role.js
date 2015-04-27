var grid;
var basePath = "../role/";

$(function() {
	loadData();
});

function loadData() {
	grid = $('#grid').datagrid({
		url : basePath + 'list',
		width : 'auto',
		height : 'auto',
		nowrap : false,
		striped : true,
		collapsible : false,// 是否可折叠的
		fit : true,// 自动大小
		loadMsg : '正在加载请稍候...',
		remoteSort : false,
		singleSelect : true,// 是否单选
		pagination : true,// 分页控件
		rownumbers : true,// 行号
		pageSize : 10,// 默认选择的分页是每页5行数据
		pageList : [ 1, 10, 15, 20, 30, 50 ],// 可以选择的分页集合
		columns : [ [ {
			title : '角色名称',
			field : 'name',
			width : 150
		}, {
			title : '资源描述',
			field : 'dscript',
			width : 220
		}, {
			title : '排序',
			field : 'sort',
			width : 50
		}, {
			field : 'opt',
			title : '操作',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delRow('" + index + "');\">删除</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editFun('" + index + "');\">编辑</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:loadUser('" + row.name + "','" + row.id + "');\">用户</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:loadModlue('" + row.name + "','" + row.id + "');\">权限修改</span></a>";
				return s;
			}
		} ] ],
		toolbar : '#toolbar',
		onLoadSuccess : function() {
			$('#grid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}

	});
	var p = $('#grid').datagrid('getPager');
	$(p).pagination({
		// pageSize : 20,// 每页显示的记录条数，默认为10
		// pageList : [ 15, 20, 30, 50 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}
function addFun() {
	SL.showWindow({
		title : '角色信息',
		iconCls : 'icon-add',
		width : 500,
		height : 260,
		url : 'roleAdd.jsp',
		left : 100,
		top : 100,
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("save");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
};
function editFun(index) {
	var data = grid.datagrid('getData').rows[index];
	if (data == null) {
		top.SL.msgShow("提示", "请选择一行数据！", "warning");
		return;
	}
	SL.showWindow({
		title : '编辑角色信息',
		iconCls : 'icon-add',
		width : 500,
		height : 260,
		url : 'roleEdit.jsp',
		onLoad : function() {
			loadRoleData(data.id);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("edit");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function loadRoleData(id) {
	$.ajax({
		url : basePath + "queryOne?id=" + id,
		success : function(data) {
			if (data) {
				$("#roleForm").form('load', data);
			}
		}
	});
}
function fCallback(url) {
	if ($("#comForm").form('enableValidation').form('validate')) {
		var data = $("#roleForm").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : basePath + url,
			data : data,
			async : false,
			success : function(data) {
				if (data) {
					grid.datagrid('reload');
					SL.closeWindow();
				}
			}
		});
	}
}
var roleid, modlueid;
function loadUser(name, id) {
	$('#right-panel').panel({
		title : "[" + name + "]",
		href : 'allotUser.jsp',
		onLoad : function() {
			$('#userdg').datagrid({
				title : '用户列表',
				url : '../user/listByRole?id=' + id,
				loadMsg : '数据加载中....',
				fit : true,
				rownumbers : true, // 行号
				pagination : true,
				pageSize : 20,
				pageList : [ 1, 10, 15, 20, 30, 50 ],
				columns : [ [ {
					field : 'username',
					title : '用户名',
					width : 150
				}, {
					field : 'realname',
					title : '姓名',
					width : 150
				} ] ]

			});
			// 设置分页控件
			$('#userdg').datagrid('getPager').pagination({
				beforePageText : '第',// 页数文本框前显示的汉字
				afterPageText : '页    共 {pages} 页',
				displayMsg : ' {from} - {to} 共 {total} 条'
			});
		}
	});
}
function loadModlue(name, id) {
	roleid = id;
	$('#right-panel').panel({
		title : "[" + name + "]:当前权限",
		href : 'allotRes.jsp',
		onLoad : function() {
			$('#reslist').tree({
				url : '../module/role2Module?roleId=' + id,
				loadMsg : '数据加载中....',
				lines : true,
				checkbox : true,
				onClick : function(node) {
					modlueid = node.id;
					$('#permilist').datagrid({
						url : "../module/getPermission?id=" + node.id,
						fit : true,
						striped : true, // 隔行变色
						columns : [ [ {
							field : 'ck',
							checkbox : true
						}, {
							field : 'pName',
						} ] ],
						onLoadSuccess : function(data) {
							// 根据角色 和 菜单id 查询按钮列表
							$.ajax({
								url : "../module/getRolePer",
								type : "POST",
								data : {
									roleid : roleid,
									modlueid : modlueid
								},
								async : false,
								dataType : "json",
								cache : false,
								success : function(r) {
									for (var int = 0; int < data.rows.length; int++) {
										for (var int2 = 0; int2 < r.length; int2++) {
											if(data.rows[int].id = r[int2].id){
												$('#permilist').datagrid("selectRow", int);
											}
										}
									}
								}
							});
							
						}
					});
				}
			});
		}
	});
}
function roleModule() {
	var nodes = $('#reslist').tree('getChecked', [ 'checked', 'indeterminate' ]);
	var ids = [];
	for (var i = 0; i < nodes.length; i++) {
		ids.push(nodes[i].id);
	}
	if (ids.length > 0) {
		saveInfo(ids);
	} else {
		top.SL.msgShow('提示', '请选择分配资源!', 'warning');
	}
}
function rolePermi() {
	var selRow = $('#permilist').datagrid("getSelections");// 返回选中多行
	var ids = [];
	for (var i = 0; i < selRow.length; i++) {
		ids.push(selRow[i].id);
	}
	var param = {
		roleid : roleid,
		modlueid : modlueid,
		ids : ids
	};
	$.ajax({
		url : basePath + "saveRolePer",
		type : "POST",
		data : param,
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data) {
				top.SL.sysSlideShow({
					msg : '授权成功!'
				});
			} else {
				top.SL.sysSlideShow({
					msg : '授权失败!'
				});
			}
		}
	});
}
function saveInfo(ids) {
	var param = {
		roleid : roleid,
		ids : ids
	};
	$.ajax({
		url : basePath + "saveRoleRes",
		type : "POST",
		data : param,
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data) {
				top.SL.sysSlideShow({
					msg : '授权成功!'
				});
			} else {
				top.SL.sysSlideShow({
					msg : '授权失败!'
				});
			}
		}
	});
}

function delRow(index) {
	var data = grid.datagrid('getData').rows[index];
	if (data == null) {
		top.SL.msgShow("提示", "请选择要删除的数据！", "warning");
		return;
	}
	$.messager.confirm("操作提示", "您确定要执行操作吗？", function(s) {
		if (s) {
			$.ajax({
				url : "../role/delete?id=" + data.id,
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
