<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/syscss.css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
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
							url : '../devices/list',
							title : 'GPS设备列表',
							fit : true,
							nowrap : true, //false:折行
							rownumbers : true, //行号
							striped : true, //隔行变色
							pagination : true,
							fitColumns : true,
							pageSize : 15,
							pageList : [ 1, 10, 15, 20, 30, 50 ],
							loadMsg : '数据加载中,请稍后……',
							columns : [ [
									{
										field : 'ck',
										checkbox : true
									},
									{
										field : 'opt',
										title : '操作',
										align : 'center',
										formatter : function(value, row) {
											var s = "";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('"
													+ row.id + "');\">修改</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ row.id + "');\">删除</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ row.id + "');\">出库</span></a>";
											return s;
										}
									}, {
										field : 'listnum',
										title : '设备编号'
									}, {
										field : 'firm',
										title : '设备厂商'
									},

									{
										field : 'model',
										title : '厂牌型号'
									}, {
										field : 'genre',
										title : '设备类别'
									}, {
										field : 'rktime',
										title : '入库时间'
									}, {
										field : 'state',
										title : '使用状态',
										formatter : function(value, row) {
											var s = "";
											if (value == "1") {
												s = "<span style=\"color:green;\">已出库</span>";
											} else {
												s = "<span style=\"color:red;\">未出库</span>";
											}
											return s;
										}
									}, {
										field : 'fhtime',
										title : '返还时间'
									}, {
										field : 'lyr',
										title : '领用人'
									}, {
										field : 'lytime',
										title : '领用时间'
									}, {
										field : 'test',
										title : '测试',
										formatter : function(value, row, index) {
											var s = "";
											if (value == 1) {
												s = "<span style=\"color:green;\">已测试</span>";
											} else {
												s = "<span style=\"color:red;\">未测试</span>";
											}
											return s;
										}
									}, {
										field : 'phone',
										title : '卡号'
									}, {
										field : 'cstime',
										title : '测试时间'
									}, {
										field : 'tresult',
										title : '测试结果',
										formatter : function(value, row, index) {
											var s = "";
											if (value == 1) {
												s = "<span style=\"color:green;\">定位</span>";
											} else {
												s = "<span style=\"color:red;\">不定位</span>";
											}
											return s;
										}
									} ] ],
							// 							columns : [ [ {
							// 								field : 'intime',
							// 								title : 'Gps主机'
							// 							}, {
							// 								field : 'kktime',
							// 								title : 'Gps天线'
							// 							}, {
							// 								field : 'outtime',
							// 								title : 'Gsm天线	'
							// 							}, {
							// 								field : 'lyr',
							// 								title : '电源线'
							// 							}, {
							// 								field : 'fhtime',
							// 								title : '电源线'
							// 							}, {
							// 								field : 'lrr',
							// 								title : '防水袋'
							// 							}, {
							// 								field : 'beizhu',
							// 								title : '计算器'
							// 							}, {
							// 								field : 'beizhu',
							// 								title : '摄像仪'
							// 							}, {
							// 								field : 'beizhu',
							// 								title : '扬声器'
							// 							}, {
							// 								field : 'beizhu',
							// 								title : '麦克风'
							// 							},

							// 							{
							// 								field : 'beizhu',
							// 								title : '备注'
							// 							} ] ],
							view : detailview,
							detailFormatter : function(index, row) {
								var s = '<div style="padding:2px;hight:100px;"><table class="grid">'
										+ '<tr><th style="width: 80px">Gps主机：</th>' + '<td>'
										+ row.gpszj
										+ '</td>'
										+ '<th style="width: 80px">Gps天线：</th>'
										+ '<td>'
										+ row.gpstx
										+ '</td>'
										+ '<th style="width: 80px">Gsm天线：</th>'
										+ '<td>'
										+ row.gsmtx
										+ '</td>'
										+ '<th style="width: 80px">电源线：</th>'
										+ '<td>'
										+ row.dy
										+ '</td>'
										+ '<th style="width: 80px">防水袋：</th>'
										+ '<td>'
										+ row.fsd
										+ '</td></tr>'
										+ '<tr><th style="width: 80px">计算器：</th>'
										+ '<td>'
										+ row.jsq
										+ '</td>'
										+ '<th style="width: 80px">摄像仪：</th>'
										+ '<td>'
										+ row.sxy
										+ '</td>'
										+ '<th style="width: 80px">扬声器：</th>'
										+ '<td>'
										+ row.ysq
										+ '</td>'
										+ '<th style="width: 80px">麦克风：</th>'
										+ '<td>'
										+ row.mkf
										+ '</td>'
										+ '<th style="width: 80px"></th>'
										+ '<td></td></tr>' + '</table></div>';
								// 								return '<div style="padding:2px;hight:80px;"><table id="ddv-' + index + '"></table></div>';
								return s;
							},
							// 							onExpandRow : function(index, row) {
							// 								$('#ddv-' + index).empty();
							// 								var s = '<tr>'
							// 										+ '<td rowspan=2 style="border:0"><img src="images/' + row.id + '.png" style="height:50px;"></td>'
							// 										+ '<td style="border:0">' + '<p>Attribute: ' + row.id
							// 										+ '</p>' + '<p>Status: ' + row.id + '</p>' + '</td>'
							// 										+ '</tr>';
							// 								$('#ddv-' + index).append(s);
							// 							},
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
			title : '联通SIM卡出入库信息',
			iconCls : 'icon-add',
			href : 'sim/simAdd.jsp',
			width : 550,
			height : 400,
			closed : false,
			cache : false,
			modal : true,
			onLoad : function() {
				top.$("#type").val("1");
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
	// 	function addExcel() {
	// 		top.$('#dd').dialog({
	// 			title : '导入设备信息',
	// 			iconCls : 'icon-add',
	// 			href : 'devices/uploadExecl.jsp',
	// 			width : 550,
	// 			height : 400,
	// 			closed : false,
	// 			cache : false,
	// 			modal : true,
	// 			onLoad : function() {
	// 				top.$("#type").val("1");
	// 			},
	// 			buttons : [ {
	// 				text : '关闭',
	// 				handler : function() {
	// 					top.$('#dd').dialog('close');
	// 				}
	// 			} ]
	// 		});
	// 	}
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
						grid.datagrid('reload'); 
					}
				}
			});

		}
	}

	//导入客户,在页面中引入 js/swfupload/ajaxfileupload.js
	function ajaxFileUpload() {
		$.ajaxFileUpload({
			url : '../upload/excel', //你处理上传文件的服务端
			secureuri : false, //是否启用安全提交,默认为false
			fileElementId : 'myfile', //文件选择框的id属性
			dataType : 'text', //服务器返回的格式,可以是json或xml等
			success : function(data, status) { //服务器响应成功时的处理函数
				grid.datagrid('reload'); 
			}
		});
	}
</script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>&nbsp;&nbsp;入库时间从: <input id="StartTime" name="StartTime"
						class="easyui-datebox" style="width: 100px" editable="false">
						到: <input id="EndTime" name="EndTime" class="easyui-datebox"
						style="width: 100px"> 出库时间从: <input id="StartTime"
						name="StartTime" class="easyui-datebox" style="width: 100px"
						editable="false"> 到: <input id="EndTime" name="EndTime"
						class="easyui-datebox" style="width: 100px">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;使用状态: <select class="easyui-combobox"
						id="Category" name="Category" panelheight="auto"
						style="width: 100px">
							<option value="Yes">已出库</option>
							<option value="No">出库</option>
					</select> &nbsp;&nbsp;设备厂商 : <input class="easyui-textbox"
						style="width: 150px" /> &nbsp;&nbsp;领用人：<input
						class="easyui-textbox" style="width: 150px" /> <a id="btn"
						href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:'true'">查询</a></td>
				</tr>
			</table>
		</div>
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-add',plain:true"
						onClick="javascript:addNew();">新增</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_48',plain:true"
						onClick="javascript:addNew();">返回</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right"><a href="outExcel.jsp" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_157',plain:true" >导出</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td style="text-align: right;"><input id="myfile"
						name="myfile" style="width: 200px" type="file"> <a
						href="#" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_154',plain:true"
						onclick="return ajaxFileUpload();">导入</a></td>
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>