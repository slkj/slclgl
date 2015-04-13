var grid;
$(function() {
	loadDataGrid();
});
function loadDataGrid() {
	grid = $("#tt")
			.datagrid(
					{ // title : '用户列表',
						url : '../user/list',
						loadMsg : '数据加载中....',
						fit : true,
						nowrap : true, // false:折行
						rownumbers : true, // 行号
						striped : true, // 隔行变色
						pagination : true,
						pageSize : 20,
						pageNumber : 1,
						fitColumns : true,
						frozenColumns : [ [ {
							field : 'ck',
							checkbox : true
						}, {
							title : '编号',
							field : 'id',
							sortable : true
						} ] ],
						columns : [
								[
										{
											title : '基本信息',
											colspan : 7
										},
										{
											field : 'opt',
											title : '操作',
											width : 100,
											align : 'center',
											rowspan : 2,
											formatter : function(value, row) {
												var s = "";
												s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('"
														+ row.id + "');\">修改</span></a>";
												s += "|";
												s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
														+ row.id
														+ "');\">删除</span>&nbsp;&nbsp;</a>";
												return s;
											}
										} ],
								[
										{
											field : 'username',
											title : '用户名',
											width : 150
										},
										{
											field : 'status',
											title : '状态',
											formatter : function(value, rec) {
												return value == 'enabled' ? '启用'
														: '<span style="color:red">禁用</span>';
											}
										}, {
											field : 'realname',
											title : '姓名',
											width : 150
										}, {
											field : 'phone',
											title : '联系方式',
											width : 90
										}, {
											field : 'company',
											title : '所属公司',
											width : 150
										}, {
											field : 'lastTime',
											title : '最后登录',
											width : 150
										}, {
											field : 'create_time',
											title : '创建时间',
											width : 150
										} ] ],

						toolbar : [ {
							id : 'btnadd',
							text : '新增用户',
							iconCls : 'icon-add',
							handler : function() {
								openDialog_add();
							}
						}, '-', {
							id : 'btnstart',
							text : '批量启用',
							iconCls : 'icon-ok',
							handler : function() {
								batch('delete');
							}
						}, '-', {
							id : 'btnstop',
							text : '批量禁用',
							iconCls : 'icon-remove',
							handle : function() {
								batch('invalid');
							}
						}, '-', {
							id : 'btncut',
							text : '密码重置',
							iconCls : 'icon-reload',
							handler : function() {
								batch('delete');
							}
						}, ],
						getSelectedRow : function() {
							return $('#test').datagrid('getSelected');
						}
					});

	// 设置分页控件
	grid.datagrid('getPager').pagination({
		pageSize : 15,// 每页显示的记录条数，默认为10
		pageList : [ 1, 10, 15, 20, 30, 50 ],// 可以设置每页记录条数的列表
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}

// 出库
function openDialog_add() {
	 //重新加载内容
//	parent.$("#tabiFrame").attr("src", "user/userAdd.jsp");
	window.location.href = 'userAdd.jsp';
	 
}