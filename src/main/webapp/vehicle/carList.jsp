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
							title : '车辆列表',
							fit : true,
							nowrap : true, // false:折行
							rownumbers : true, // 行号
							striped : true, // 隔行变色
							pagination : true,
							singleSelect : true,
							pageSize : 15,
							pageList : [ 1, 10, 15, 20, 30, 50 ],
							loadMsg : '数据加载中,请稍后……',
							columns : [ [
									{
										field : 'id',
										title : '车号'
									},
									{
										field : 'carNumber',
										title : '车牌号',
										width : 100
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
										field : 'installtime',
										title : '安装日期'
									},
									{
										field : 'fhtime',
										title : '车辆类型',
										formatter : function(value, row, index) {
											return row.classify + row.carType;
										}
									},
									{
										field : 'companyName',
										title : '所属公司'
									},
									{
										field : 'networkNo',
										title : '入网证明编号',
										width : 150
									},
									{
										title : '操作',
										field : '_operate',
										align : 'center',
										formatter : function(value, row, index) {
											var s = "";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">详细</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">安装记录</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:goBack('"
													+ index + "');\">编辑</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ index + "');\">删除</span></a>";
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
	function addCar() {
		parent.$("#cnIframe").attr("src", "hyAdd.jsp");
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
	function deleteRow(index){
		parent.$.messager.confirm('提示', '将删除该车辆所有信息，确认删除?', function(row) {
			if (row) {
				var data = grid.datagrid('getData').rows[index];
				$.ajax({
					url : basePath+'delete?id=' + data.id,
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
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>车号：<input name="lyr" class="easyui-textbox"
							style="width: 150px" /> 车牌号:<input name="carNumber"
							class="easyui-textbox" style="width: 150px" />
						</td>
					</tr>
					<tr height="3px"></tr>
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
		</div>
		<div>
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
	</div>
	<table id="dg"></table>
</body>
</html>