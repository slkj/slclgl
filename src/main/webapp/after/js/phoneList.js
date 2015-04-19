var grid;
var basePath = "../phone/";
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
						title : '电话记录列表',
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
									title : '接听时间',
									field : 'riqi',
									/*formatter : function(value, row, index) {
										// 装机 维修 回访 其他
										return "2015-02-02 12:02:11";
									}*/
								},
								{
									title : '服务车辆',
									field : 'carNo'
								},
								{
									title : '客户单位',
									field : 'company'
								},
								{
									title : '联系人 ',
									field : 'linkman'
								},
								{
									title : '联系方式',
									field : 'telephone'
								},
								{
									title : '地址',
									field : 'address'
								},
								{
									title : '服务类型',
									field : 'serviceType',
									/*formatter : function(value, row, index) {
										// 装机 维修 回访 其他
										return "装机";
									}*/
								},
								{
									title : '服务状态',
									field : 'serviceStatus',
									/*formatter : function(value, row, index) {
										// 保内 保外 其他
										return "保内";
									}*/
								},
								{
									title : '设备故障及原因',
									field : 'error',
									/*formatter : function(value, row, index) {
										return "不定位";
									}*/
								},
								{
									title : '客服人员',
									field : 'customer'
								},
								{
									title : '派单时间',
									field : 'serviceRiqi'
								},
								{
									title : '服务人员',
									field : 'serviceMan'
								},
								{
									field : 'result',
									title : '服务结果',
									align : 'center',
									formatter : function(value, row, index) {
										var s = "";
										if (value =="已解决") {
											s = "<span style=\"color:green;\">已解决</span>";
										} else if (value == "未解决") {
											s = "<span style=\"color:red;\">未解决</span>";
										}
										return s;
									}
								},
								{
									field : 'opt',
									title : '操作',
									align : 'center',
									formatter : function(value, row, index) {
										var s = "";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:pd('"
											+ row.serviceMan + "','" + row.id + "');\">派单</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:ser('"
											+ row.id + "');\">服务记录</span></a>";
//										s += "&nbsp;|&nbsp;";
//										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:view('"
//												+ row.id + "');\">详细</span></a>";
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
function pd(name,id) {
	if(name==null||name==""||name=="null"){
		window.location.href = 'phoneService.jsp?id=' + id;
	
	}
	else{
		$.messager.alert('提示', '已派单，不能重复派单！');
	}
}
function add() {
	window.location.href = 'phoneAdd.jsp';
}
function edit(id) {
	window.location.href = 'phoneEdit.jsp?id=' + id;
}
function ser(id) {
	window.location.href = 'maintainView.jsp?id=' + id;
}
function view(id) {
	window.location.href = 'phoneView.jsp?id=' + id;
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