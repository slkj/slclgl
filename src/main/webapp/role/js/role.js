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
		nowrap : true,
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
			width : 100
		}, {
			title : '资源描述',
			field : 'dscript',
			width : 150
		}, {
			title : '排序',
			field : 'sort',
			width : 100
		}, {
			field : 'opt',
			title : '操作',
			align : 'center',
			width : 150,
			formatter : function(value, row, index) {
				var s = "";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:loadTree('" + row.name + "','" + row.id + "');\">权限修改</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editFun('" + index + "');\">编辑</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delRow('" + index + "');\">删除</span></a>";
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
function loadTree(name, id) {
	$('#right-panel').panel({
		title : "[" + name + "]:当前权限"
	});
//	$('#reslist').treegrid({
//		url : '../module/list',
//		loadMsg : '数据加载中....',
//		nowrap : true, // false:折行
//		idField : 'id',
//		treeField : 'name',
//		animate : true,
//		fitColumns : true,
//		lines : true,
//		singleSelect : false,
//		columns : [ [ {
//			field : 'ck',
//			title : '选择',
//			checkbox : true
//		}, {
//			field : 'name',
//			title : '模块名称'
//		} ] ],
//		onClickRow : function(row) {
//			loadBtnTree(row.id);
//		}
//	});
	$('#reslist').tree({    
	    url:'../module/role2Module?roleId='+id,
	    loadMsg : '数据加载中....',
	    lines : true,
	    checkbox:true
	}); 
}
function loadBtnTree() {

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
