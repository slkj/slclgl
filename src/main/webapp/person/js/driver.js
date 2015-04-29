var grid;
var basePath = "../person/";
var type="";
$(function() {
	var Request = new Object();
	Request = GetRequest();
	type = Request['type'];
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
						url : basePath + 'list?type='+type,
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
								title : '姓名',
								field : 'name'
							}, {
								title : '性别',
								field : 'sex'
							}, {
								title : '联系方式',
								field : 'telephone'
							}, {
								title : '身份证号',
								field : 'idcard_no'
							}, {
								title : '驾驶证号',
								field : 'driver_no'
							}, {
								title : '现服务车辆',
								field : 'fwcl'
							}, {
								title : '所属单位',
								field : 'companyname'
							}, {
								title : '从业资格证号',
								field : 'qualification_no'
							},{
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
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:del('"+row.id+"','"
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
	window.location.href='driverAdd.jsp?type='+type;
}
function edit(id){
	window.location.href='driverEdit.jsp?id='+id;
}
function view(id){
	window.location.href='driverView.jsp?id='+id;
}
function del(id, index) { // 删除操作
	$.messager.confirm('确认', '确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : basePath + 'delete?id=' + id,
				success : function(data) {
					var msg = "成功删除。";
					if (data) {
						$('#dg').datagrid('load');;
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