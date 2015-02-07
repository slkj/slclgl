<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据表格DataGrid</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#test").datagrid({
			loadMsg : '数据加载中....',
			title : '管理员信息一览表',
			iconCls : 'icon-edit',
			width : 1184,
			height : 530,
			url : 'userlist.do',
			nowrap : false,
			striped : true,
			collapsible : true,
			sortName : 'uid',
			sortOrder : 'desc',
			remoteSort : false,
			pagination : true,
			rownumbers : true,
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				title : '编号',
				field : 'id',
				width : 80,
				sortable : true
			} ] ],
			columns : [ [ {
				title : '基本信息',
				colspan : 3
			}, {
				field : 'opt',
				title : '操作',
				width : 100,
				align : 'center',
				rowspan : 2,
				formatter : function(value, rec) {
					return '<span style="color:red">编辑    删除</span>';
				}
			} ], [ {
				field : 'name',
				title : '用户名',
				width : 120
			}, {
				field : 'age',
				title : '年龄',
				width : 120
			}, {
				field : 'phone',
				title : '联系方式',
				width : 120
			} ] ],

			toolbar : [ {
				id : 'btnadd',
				text : '新增用户',
				iconCls : 'icon-add',
				handler : function() {
					openDialog_add();
				}
			}, '-', {
				id : 'btncut',
				text : '删除用户',
				iconCls : 'icon-cancel',
				handler : function() {
					batch('delete');
				}
			}, '-', {
				id : 'btnstart',
				text : '批量启用',
				iconCls : 'icon-ok',
				handler : function() {
					batch('delete');
				}
			}, '-', {
				id : 'btnstop',
				text : '批量禁用',
				iconCls : 'icon-remove',
				handle : function() {
					batch('invalid');
				}
			} ]
		});
		var p = $('#test').datagrid('getPager');
		if (p) {
			$(p).pagination({
				onBeforeRefresh : function() {
					alert('before refresh');
				}
			});
		}
	});
	function resize() {
		$('#test').datagrid('resize', {
			width : 700,
			height : 400
		});
	}
	function getSelected() {
		var selected = $('#test').datagrid('getSelected');
		if (selected) {
			alert(selected.code + ":" + selected.name + ":" + selected.addr
					+ ":" + selected.col4);
		}
	}
	function getSelections() {
		var ids = [];
		var rows = $('#test').datagrid('getSelections');
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].code);
		}
		alert(ids.join(':'));
	}
	function clearSelections() {
		$('#test').datagrid('clearSelections');
	}
	function selectRow() {
		$('#test').datagrid('selectRow', 2);
	}
	function selectRecord() {
		$('#test').datagrid('selectRecord', '002');
	}
	function unselectRow() {
		$('#test').datagrid('unselectRow', 2);
	}
	function mergeCells() {
		$('#test').datagrid('mergeCells', {
			index : 2,
			field : 'addr',
			rowspan : 2,
			colspan : 2
		});
	}
</script>
</head>
<body>
	<!-- 用户列表 -->
	<div id="tabs" class="easyui-tabs" fit="true" border="false">
		<div title="用户列表" style="padding: 0px; overflow: hidden; color: red;">
			<div id="test"></div>
		</div>
	</div>
</body>
</html>