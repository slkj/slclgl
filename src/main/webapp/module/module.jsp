<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源管理</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	var grid;
	$(function() {
		var winSize = {
			width : $(window).width() - 4,
			height : $(window).height() - 40
		};
		grid = $('#tt')
				.treegrid(
						{
							url : '../module/list',
							loadMsg : '数据加载中....',
							title : '系统资源管理列表',
							width : winSize.width,
							height : winSize.height,
							nowrap : true, //false:折行
							rownumbers : true, //行号
							striped : true, //隔行变色
							singleSelect : true, //单选
							checkOnSelect : true,
							idField : 'id',
							treeField : 'name',
							lines : true,
							animate : true,
							columns : [ [
									{
										field : 'id',
										title : '编号'
									},
									{
										field : 'name',
										title : '资源名称',
										width : 180
									},
									{
										field : 'url',
										title : 'url'
									},
									{
										field : 'icon',
										title : '图标',
										width : 80
									},
									{
										field : 'description',
										title : '说明'
									},
									{
										field : 'opt',
										title : '操作',
										width : 100,
										align : 'center',
										formatter : function(value, row) {
											var s = "";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('"
													+ row.id + "');\">修改</span></a>";
											s += "|";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ row.id + "');\">删除</span>&nbsp;&nbsp;</a>";
											return s;
										}
									} ] ],
							toolbar : [ {
								text : '新增',
								iconCls : 'icon-add',
								handler : function() {
									add();
								}
							} ]
						});
	});
	function add() {
		top.$('#dd').dialog({
			title : '添加模块（菜单）',
			iconCls : 'icon-add',
			href : 'module/moduleAdd.jsp',
			width : 450,
			height : 350,
			closed : false,
			cache : false,
			modal : true,
			onLoad : function() {
				top.$("#cc").combotree({
					url : 'module/getCombotree',
					lines : true,
					required : true
				});
			},
			buttons : [ {
				text : '确定',
				iconCls : 'icon-add',
				handler : function() {
					fCallback();
				}
			}, {
				text : '关闭',
				handler : function() {
					top.$('#dd').dialog('close');
				}
			} ]
		});
	}
	function fCallback() {
		if (top.$("#uform").form('enableValidation').form('validate')) {
			var data = top.$("#uform").serialize();
			$.ajax({
				cache : false,
				type : "POST",
				url : '../module/addModule',
				data : data,
				async : false,
				success : function(data) {
					if (data) {
						top.$('#dd').dialog('close');
						grid.treegrid('reload'); // 重新载入所有行
					}
				}
			});

		}
	}
	function deleteRow(id) {
		$.ajax({
			cache : false,
			type : "POST",
			url : '../module/deleteModule/' + id,
			async : false,
			success : function(data) {
				if (data) {
					grid.treegrid('reload'); // 重新载入所有行
				}
			}
		});
	}
	function editRow(id) {
		top.$('#dd').dialog({
			title : '修改模块（菜单）',
			iconCls : 'icon-add',
			href : 'module/moduleAdd.jsp',
			width : 450,
			height : 350,
			closed : false,
			cache : false,
			modal : true,
			onLoad : function() {
				top.$("#cc").combotree({
					url : 'module/getCombotree',
					lines : true,
					required : true
				});
				$.ajax({
					type : "POST",
					url : '../module/queryOne/'+id,
					async : false,
					cache : false,
					success : function(data) {
						if (data) {
							top.$("#uform").form('load',data);
						}
					}
				});
				
			},
			buttons : [ {
				text : '确定',
				iconCls : 'icon-add',
				handler : function() {
					fCallback();
				}
			}, {
				text : '关闭',
				handler : function() {
					top.$('#dd').dialog('close');
				}
			} ]
		});
	}
</script>
</head>
<body>
	<table id="tt" data-options="fit:true,border:false"></table>

</body>
</html>