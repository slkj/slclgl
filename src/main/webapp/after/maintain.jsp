<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>司机管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" >
var grid;
var basePath = "../maintain/";
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
function loadDataGrid() {
	grid = $('#dg')
			.datagrid(
					{
						method : 'post',
						url : basePath + 'list',
						title : '安装维修列表',
						fit : true,
						nowrap : true, // false:折行
						rownumbers : true, // 行号
						striped : true, // 隔行变色
						pagination : true,
						fitColumns : true,
						singleSelect : true,
						pageSize : 15,
						pageList : [ 1, 10, 15, 20, 30, 50 ],
						loadMsg : '数据加载中,请稍后……',
						columns : [ [
								{
									title : '服务时间',
									field : 'riqi',
									/* formatter : function(value, row, index) {
										// 装机 维修 回访 其他
										return "2015-02-02 12:02:11";
									} */
								},
								{
									title : '客户单位',
									field : 'company'
								},
								{
									title : '联系人',
									field : 'linkman'
								},
								{
									title : '联系方式',
									field : 'telephone'
								},{
									title : '地址',
									field : 'address'
								},
								{
									title : '服务类型',
									field : 'serviceType',
									/* formatter : function(value, row, index) {
										// 装机 维修 回访 其他
										return "装机";
									} */
								},
								{
									title : '服务状态',
									field : 'serviceStatus',
									/* formatter : function(value, row, index) {
										// 保内 保外 其他
										return "保内";
									} */
								},
								{
									title : '设备故障及原因',
									field : 'error',
									/* formatter : function(value, row, index) {
										return "不定位";
									} */
								},
								{
									title : '维修过程及结果',
									field : 'result',
									/* formatter : function(value, row, index) {
										return "更换天线";
									} */
								},
								{
									title : '配件更换记录',
									field : 'instead'

								},
								{
									title : '服务安装人员',
									field : 'serviceMan'
								},
								{
									field : 'opt',
									title : '操作',
									align : 'center',
									formatter : function(value, row, index) {
										var s = "";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:view('"
												+ row.id + "');\">详细</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:edit('"
												+ row.id + "');\">编辑</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:del('"
												+ row.id + "','" + index + "');\">删除</span></a>";
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
function add() {
	window.location.href = 'maintainAdd.jsp';
}
function edit(id) {
	window.location.href = 'maintainEdit.jsp?id=' + id;
}
function view(id) {
	window.location.href = 'maintainView.jsp?id=' + id;
}
function del(id, index) { // 删除操作
	$.messager.confirm('确认', '确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : basePath + 'delete?id=' + id,
				success : function(data) {
					var msg = "成功删除。";
					if (data) {
						$('#dg').datagrid('load');
						;
					} else {
						msg = "删除失败了。";
					}
					SL.sysSlideShow({
						msg : msg
					});
				}
			});
		}
	})
}
</script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>司机姓名: <input name="name" class="easyui-numberbox" style="width: 150px" />
							所属公司:<select id="companyid" name="companyid" class="easyui-combotree" style="width:200px;"
									data-options="url:'../company/getTreeList',lines:true"></select> 
							<a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查询</a> 
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:add();">添加</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right">
						<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>