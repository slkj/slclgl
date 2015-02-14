<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIM卡管理</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/syscss.css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	var grid;
	$(function() {
		//初始化页面
		initDataGrid();
		//加载数据
		loadData();
	});

	function loadData() {
		// 		var obj = {};
		// 		obj.page = pageNumber;
		// 		obj.rows = pageSize;
		// 		obj.type = 2;
		// 		grid.datagrid({
		// 			method : 'post',
		// 			url : '../sim/list?type=1'
		// 		});
	}
	function initDataGrid() {
		grid = $('#dg')
				.datagrid(
						{
							method : 'post',
							url : '../sim/list?type=2',
							title : '联通卡列表',
							fit : true,
							nowrap : true, //false:折行
							rownumbers : true, //行号
							striped : true, //隔行变色
							pagination : true,
							pageSize : 15,
							pageList : [ 1, 10, 15, 20, 30, 50 ],
							loadMsg : '数据加载中,请稍后……',
							columns : [ [
									{
										field : 'ck',
										checkbox : true
									},
									// 									{
									// 										field : 'id',
									// 										title : '编码'
									// 									},
									{
										field : 'gys',
										title : '供应商'
									},
									{
										field : 'listnum',
										title : '序列号'
									},

									{
										field : 'cardType',
										title : '卡类型'
									},
									{
										field : 'telnum',
										title : '车载号码'
									},
									{
										field : 'state',
										title : '状态',
										formatter : function(value, row) {
											var s = "";
											if (value == "1") {
												s = "<span style=\"color:green;\">已用</span>";
											} else {
												s = "<span style=\"color:red;\">未用</span>";
											}
											return s;
										}
									},
									{
										field : 'intime',
										title : '入库时间'
									},
									{
										field : 'kktime',
										title : '开卡时间'
									},
									{
										field : 'outtime',
										title : '出库时间'
									},
									{
										field : 'lyr',
										title : '领用人'
									},
									{
										field : 'fhtime',
										title : '返回时间'
									},
									{
										field : 'lrr',
										title : '录入人'
									},
									{
										field : 'beizhu',
										title : '备注'
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
							toolbar : '#tb',
							getSelectedRow : function() {
								return $('#dg').datagrid('getSelected');
							}
						});
		// 设置分页控件
		var p = grid.datagrid('getPager');
		$(p).pagination({
			beforePageText : '第',// 页数文本框前显示的汉字
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	}

	function addNew() {
		top.$('#dd').dialog({
			title : '移动SIM卡出入库信息',
			iconCls : 'icon-add',
			href : 'sim/simAdd.jsp',
			width : 550,
			height : 400,
			closed : false,
			cache : false,
			modal : true,
			onLoad : function() {
				top.$("#type").val("2");
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
			$.ajax({
				cache : false,
				type : "POST",
				url : "../sim/addSim",
				data : data,
				async : false,
				success : function(data) {
					if (data) {
						top.$('#dd').dialog('close');
						grid.datagrid('reload'); // 重新载入所有行
					}
				}
			});

		}
	}
</script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>入库时间从: <input id="StartTime" name="StartTime"
						class="easyui-datebox" style="width: 100px" editable="false">
						到: <input id="EndTime" name="EndTime" class="easyui-datebox"
						style="width: 100px"> 出库时间从: <input id="StartTime"
						name="StartTime" class="easyui-datebox" style="width: 100px"
						editable="false"> 到: <input id="EndTime" name="EndTime"
						class="easyui-datebox" style="width: 100px">
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;使用状态: <select
						class="easyui-combobox" id="Category" name="Category"
						panelheight="auto" style="width: 100px">
							<option value="Yes">已用</option>
							<option value="No">未用</option>
					</select>
					</td>
					<td>卡类型 : <select class="easyui-combobox" id="Category"
						name="Category" panelheight="auto" style="width: 100px">
							<option value="Yes">GPRS卡</option>
							<option value="No">短信卡</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>开卡时间从: <input id="StartTime" name="StartTime"
						class="easyui-datebox" style="width: 100px"> 到: <input
						id="EndTime" name="EndTime" class="easyui-datebox"
						style="width: 100px" editable="false"> 返回时间从: <input
						id="StartTime" name="StartTime" class="easyui-datebox"
						style="width: 100px"> 到: <input id="EndTime"
						name="EndTime" class="easyui-datebox" style="width: 100px"
						editable="false"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;领用人：<input class="easyui-textbox"
						style="width: 150px">
					</td>
					<td><a id="btn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:'true'">查询</a></td>
				</tr>
			</table>
		</div>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onClick="javascript:addNew();">新增</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_221',plain:true"
					onClick="javascript:addNew();">开卡</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_229',plain:true"
					onClick="javascript:addNew();">出库</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_48',plain:true"
					onClick="javascript:addNew();">返回</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_154',plain:true"
					onClick="javascript:addNew();">导入</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_157',plain:true"
					onClick="javascript:addNew();">导出</a></td>
			</tr>
		</table>
	</div>
	<table id="dg"></table>
</body>
</html>