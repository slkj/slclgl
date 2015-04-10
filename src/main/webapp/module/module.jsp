<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源管理</title>
<%@ include file="/common/taglibs.jsp"%>
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
// 							rownumbers : true, //行号
							striped : true, //隔行变色
							singleSelect : true, //单选
							checkOnSelect : true,
							idField : 'id',
							treeField : 'name',
							lines : true,
							animate : true,
							columns : [ [
// 									{
// 										field : 'id',
// 										title : '编号'
// 									},
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
											s += "<a class=\"editcls\" href=\"javascript:void(0)\" onclick=\"editRow('"
													+ row.id + "');\">编辑</a>";
// 											s += "|";
// 											s += "<a href=\"javascript:void(0)\" onclick=\"javaScript:deleteRow('"
// 													+ row.id + "');\"> 删除 </a>";
											if (row.parent_id == "0") {
												return "";
											}
											return s;
										}
									} ] ],
							toolbar : [ {
								text : '新增',
								iconCls : 'icon-add',
								handler : function() {
									add();
								}
							} ],
							onLoadSuccess : function(data) {
								$('.editcls').linkbutton({
									text : '编辑',
									plain : true,
									iconCls : 'icon-edit'
								});
							}
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
			var url = "";
			if (top.$("#id").val().length <= 0) {
				url = '../module/addModule';
			} else {
				url = '../module/editModule';
			}
			$.ajax({
				cache : false,
				type : "POST",
				url : url,
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

				$.ajax({
					type : "POST",
					url : '../module/queryOne/' + id,
					async : false,
					cache : false,
					success : function(data) {
						if (data) {
							top.$("#uform").form('load', data);
						}
					}
				});
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
</script>
</head>
<body>
	<table id="tt" data-options="fit:true,border:false"></table>

</body>
</html>