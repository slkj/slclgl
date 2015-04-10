var grid;
var basePath = "../devices/";
$(function() {
	// 初始化页面
	loadTree();
	loadDataGrid();
	$("#search_btn").click(function() {
		$('#dg').datagrid({
			queryParams : form2Json("searchform")
		}); // 点击搜索
		// 清空表单
		$('#searchform').form('clear');
	});
});
function loadTree() {
	$('#comtree').tree({
		url : '../company/getTreeList',
		lines : true,
		onClick : function(node) {
			if (node != null) {
				$('#dg').datagrid({
					queryParams : {
						company : "1"
					}
				});
			}
		}
	});
}
function loadDataGrid() {
	grid = $('#dg').datagrid(
			{
				method : 'post',
				url : basePath + 'list',
				title : 'GPS设备列表',
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
							field : 'id',
							title : '车号'
						},
						{
							field : 'carNumber',
							title : '车牌号'
						},
						{
							field : 'lytime',
							title : 'SIM卡'
						},
						{
							field : 'fhtime',
							title : '车牌类型'
						},
						{
							field : 'installers',
							title : '设备类型'
						},
						{
							field : 'installtime',
							title : '设备号'
						},
						{
							field : 'carNumber',
							title : '安装日期'
						},
						{
							field : 'company',
							title : '所属公司'
						},
						{
							field : 'networkNo',
							title : '入网证明编号',
							formatter : function(value, row, index) {
								var str = "<a id=\"btn" + index
										+ "\" href=\"#\"  onclick=\"networkNo(" + index + ")\">"
										+ value + "</a>";
								var btn = row.networkNo == null ? "" : str;
								return btn;
							}
						}, {
							field : 'remark',
							title : '备注'
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
//	parent.$('#tabs').tabs('add', {
//		title : '添加车辆',
//		content : '<iframe scrolling="no" frameborder="0"  src="vehicle/hyAdd.jsp" style="width:100%;height:100%;"></iframe>',
//		closable : true
//	});
	$('#center').panel({
//		title : '添加车辆',
	    href:'hyAdd.jsp'
	});  


}
function clearForm(){
    $('#ff').form('clear');
    $("#regName").combobox("setValue", "3");
    $("#selCarType").combobox("setValue", "黄牌");
    $("#classify").combobox("setValue", "大型");
    $("#carObtWay").combobox("setValue", "购买");
    
    $('input:radio[name=carProType]')[0].checked = true;
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