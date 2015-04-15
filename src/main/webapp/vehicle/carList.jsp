<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	var basePath = "../vehicle/";
	var grid;
	$(function() {
		// 初始化页面
		loadDataGrid();
		$("#search_btn").click(function() {
			$('#dg').datagrid({
				queryParams : form2Json("searchform")
			}); // 点击搜索
			// 清空表单
			$('#searchform').form('clear');
		});
	});
	function loadDataGrid() {
		grid = $('#dg')
				.datagrid(
						{
							method : 'post',
							url : basePath + 'list',
							fitColumns : false,
							title : '车辆列表',
							fit : true,
							nowrap : true, // false:折行
							rownumbers : true, // 行号
							striped : true, // 隔行变色
							pagination : true,
							singleSelect : true,
							autoRowHeight : false,//设置行的高度，根据该行的内容。设置为false可以提高负载性能。
							pageSize : 15,
							pageList : [ 1, 10, 15, 20, 30, 50 ],
							loadMsg : '数据加载中,请稍后……',
							columns : [ [
									{
										field : 'id',
										title : '车号'
									},{
										field : 'dw',
										title : '定位',
										formatter : function(value, row, index) {
											return "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:pos('"+ index + "');\">定位</span></a>";
										}
									},{
										field : '_state',
										title : '使用状态',
										formatter : function(value, row, index) {
											var s = "";
											if (typeof(row.networkNo)!="undefined" && row.networkNo !="" && row.networkNo != null ) {
												s = "<div style='background-color:#008B00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>入网使用</div>";
											}
											return s;
										}
									},
									{
										field : 'carNumber',
										title : '车牌号',
										width : 100
									},
									{
										field : 'carOwner',
										title : '车主',
										width : 100
									},
									{
										field : 'fhtime',
										title : '车辆类型',
										width : 110,
										formatter : function(value, row, index) {
											return row.classify + row.carType;
										}
									},
									{
										field : 'equitment',
										title : '设备号',
										width : 100
									},
									{
										field : 'simNumber',
										title : 'SIM卡',
										width : 100
									},
									{
										field : 'networkNo',
										title : '入网证明编号',
										width : 100
									},
									{
										field : 'installtime',
										title : '安装日期',
										width : 80,
									},
									{
										field : 'companyName',
										title : '所属公司'
									},
									{
										title : '操作',
										field : '_operate',
										align : 'center',
										width : 240,
										formatter : function(value, row, index) {
											var s = "";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">详细</span></a>";
											s += "&nbsp;|&nbsp;";

											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:inNet('"
													+ index + "');\">入网</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:goBack('"
													+ index + "');\">编辑</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ index + "');\">删除</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">安装记录</span></a>";
											return s;
										}
									} ] ],
							toolbar : '#tb',
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
	function pos(index) {
		var data = grid.datagrid('getData').rows[index];
		window.open('../location.jsp') 
	}
	function addCar() {
		parent.$("#cnIframe").attr("src", "hyAdd.jsp");
	}
	function inNet(index) {
		var data = grid.datagrid('getData').rows[index];
		if (data.state == 1) {
			SL.msgShow("提示", "设备已经出库！", "warning");
			return;
		}
		parent.SL.showWindow({
			title : '车辆入网',
			iconCls : 'icon-add',
			width : 850,
			height : 450,
			url : basePath + 'inNet.jsp',
			onLoad : function() {
				$("#form").form('load', data);
			},
			buttons : [ {
				text : '确定',
				iconCls : 'icon-add',
				handler : function() {
					inNet2();
				}
			}, {
				text : '关闭',
				handler : function() {
					parent.SL.closeWindow();
				}
			} ]
		});
		// 		parent.$("#cnIframe").attr("src", "inNet.jsp");
	}

	function inNet2() {
		if (parent.$("#form").form('enableValidation').form('validate')) {
			var data = parent.$("#form").serialize();
			$.ajax({
				cache : false,
				type : 'POST',
				url : basePath + 'activated',
				data : data,
				async : false,
				success : function(data) {
					if (data) {
						parent.SL.closeWindow();
						grid.datagrid('reload');
					} else {
						parent.SL.msgShow("提示", "入网失败！", "warning");
					}
				}
			});
		}
	}
	function detailCarInfo(index) {
		var data = grid.datagrid('getData').rows[index];
		parent.SL.showWindow({
			title : '车辆详细信息',
			iconCls : 'icon-add',
			width : 800,
			height : 500,
			url : 'detailCarInfo.jsp',
			onLoad : function() {
				// autoSIM("phone");
			},
			buttons : [ {
				text : '关闭',
				handler : function() {
					SL.closeWindow();
				}
			} ]
		});
	}
	function deleteRow(index) {
		parent.$.messager.confirm('提示', '将删除该车辆所有信息，确认删除?', function(row) {
			if (row) {
				var data = grid.datagrid('getData').rows[index];
				$.ajax({
					url : basePath + 'delete?id=' + data.id,
					success : function(data) {
						if (data) {
							grid.datagrid('reload');
							parent.SL.sysSlideShow({
								msg : '成功删除!'
							});
						} else {
							parent.SL.msgShow("提示", "操作错误，请联系管理员", "error");
						}
					}
				});
			}
		})
	}
	// 将表单数据转为json
	function form2Json(id) {
		var arr = $("#" + id).serializeArray()
		var jsonStr = "";
		jsonStr += '{';
		for (var i = 0; i < arr.length; i++) {
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += '}'
		var json = JSON.parse(jsonStr)
		return json
	}
</script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<form name="searchform" method="post" action="" id="searchform">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>车牌号:<input name="carNumber" class="easyui-textbox"
						style="width: 150px" /> 所属公司：<input name="companyName"
						class="easyui-textbox" style="width: 150px" />
					</td>
				<tr>
					<td>设备编号:<input name="listnum" class="easyui-textbox"
						style="width: 150px" /> SIM卡号:<input name="phone"
						class="easyui-numberbox" style="width: 150px" /> <a
						id="search_btn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:'true'">查询</a>
					</td>
				</tr>
			</table>
		</form>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onClick="javascript:addCar();">新加车辆</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" onclick="outExcel()" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_157',plain:true">导出</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_154',plain:true"
					onclick="return ajaxFileUpload();">导入</a></td>
			</tr>
		</table>
	</div>
	<table id="dg"></table>
</body>
</html>