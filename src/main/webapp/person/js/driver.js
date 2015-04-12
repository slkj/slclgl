var grid;
var basePath = "";
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
//						url : basePath + 'list',
						title : '司机列表',
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
									field : 'areaName',
									title : '档案号'
								},{
									field : 'pack',
									title : '姓名'
								},
								{
									field : 'firm',
									title : '联系方式'
								},
								{
									field : 'state',
									title : '身份证号'
								},
								{
									field : 'listnum',
									title : '驾驶证号'
								},
								{
									field : 'rktime',
									title : '发证日期 '
								}, 
								{
									field : 'test',
									title : '车牌号',
								}, {
									field : 'cstime',
									title : '所属公司',
									sortable : true,
									order : 'desc'
								},{
									field : 'opt',
									title : '操作',
									align : 'center',
									formatter : function(value, row, index) {
										var s = "";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:testing('"
												+ index + "');\">详细</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:testing('"
											+ index + "');\">编辑</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:testing('"
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
function add() {
	window.location.href='driverAdd.jsp';
}