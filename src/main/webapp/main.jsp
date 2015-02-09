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
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var grid;
	$(function() {
		var winSize = { width: $(window).width() - 4, height: $(window).height() - 40 };
		grid = $("#test").datagrid({
			url : 'user/list',
			loadMsg : '数据加载中....',
			title : '管理员信息一览表',
			iconCls : 'icon-edit',
		    width: winSize.width,
            height: winSize.height,
            nowrap: true, //false:折行
            rownumbers: true, //行号
            striped: true, //隔行变色
			pagination : true,
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				title : '编号',
				field : 'id',
				sortable : true
			} ] ],
			columns : [ [ {
				title : '基本信息',
				colspan : 4
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
				align : 'center',
				formatter : function(value, rec) {
					return value == 1 ? '男' : '女';
				}
			}, {
				field : 'phone',
				title : '联系方式',
				width : 120
			}, {
				field : 'time',
				title : '创建时间',
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
			} ],
			getSelectedRow : function() {
				return $('#test').datagrid('getSelected');
			}
		});

		// 设置分页控件
		var p = grid.datagrid('getPager');
		$(p).pagination({
			pageSize : 15,// 每页显示的记录条数，默认为10
			pageList : [ 1, 10, 15, 20, 30, 50 ],// 可以设置每页记录条数的列表
			beforePageText : '第',// 页数文本框前显示的汉字
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
	});
</script>
</head>
<body>
	<!-- 用户列表 -->
	<table id="test" data-options="fit:true,border:false"></table>
</body>
</html>