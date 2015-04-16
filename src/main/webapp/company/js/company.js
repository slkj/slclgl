var grid;
var basePath = "../company/";
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
						title : '公司列表',
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
									field : 'compName',
									title : '公司名称'
								},
								{
									field : 'contactMenber',
									title : '联系人'
								},
								{
									field : 'contactWay',
									title : '联系电话'
								},
								{
									field : 'email',
									title : '邮箱'
								},
								{
									field : 'organizationCode',
									title : '组织机构代码'
								},
								{
									field : 'opt',
									title : '操作',
									align : 'center',
									formatter : function(value, row, index) {
										var s = "";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:comInfo('"
												+ index + "');\">详细</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editCompany('"
												+ index + "');\">编辑</span></a>";
										s += "&nbsp;|&nbsp;";
										s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delCompany('"
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
function addCompany() {
	SL.showWindow({
		title : '新增公司',
		iconCls : 'icon-add',
		width : 700,
		height : 550,
		url : basePath + 'CompanyAdd.jsp',
		onLoad : function() {
			// autoSIM("phone");
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("save");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function editCompany(index) {
	var data = grid.datagrid('getData').rows[index];
	if(data == null){
		top.SL.msgShow("提示", "请选择要编辑的公司！", "warning");
		return;
	}
	SL.showWindow({
		title : '编辑公司',
		iconCls : 'icon-add',
		width : 700,
		height : 550,
		url : basePath + 'CompanyEdit.jsp',
		onLoad : function() {
			loadCompanyData(data.id);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("editCompany");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}

function comInfo(index) {
	var data = grid.datagrid('getData').rows[index];
	if(data == null){
		top.SL.msgShow("提示", "请选择要查看的公司！", "warning");
		return;
	}
	SL.showWindow({
		title : '公司信息',
		iconCls : 'icon-add',
		width : 700,
		height : 550,
		url : basePath + 'CompanyInfo.jsp',
		onLoad : function() {
			$.ajax({
				url : basePath + "queryOne?id="+data.id,
				success : function(data) {
					if (data) {
						$("#compName").text(data.compName);
						$("#compSName").text(data.compSName);
						$("#organizationCode").text(data.organizationCode);
						$("#corporate").text(data.corporate);
						$("#contactMenber").text(data.contactMenber);
						$("#contactWay").text(data.contactWay);
						$('#level').combobox('setValue', data.level);
						$("#businessLicense").text(data.businessLicense);
						$("#registeredCapital").text(data.registeredCapital + "万元");
						$("#email").text(data.email);
						$("#compAddress").text(data.compAddress);
						$("#introduction").text(data.introduction);
						$("#remarks").text(data.remarks);
					}
				}
			});
		},
		buttons : [{
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function loadCompanyData(id){
	$.ajax({
		url : basePath + "queryOne?id="+id,
		success : function(data) {
			if (data) {
				$("#comForm").form('load', data);
				$("#level").combobox('setValue',data.level);
			}
		}
	});
}
function fCallback(url) {
	if ($("#comForm").form('enableValidation').form('validate')) {
		var data = $("#comForm").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : basePath + url,
			data : data,
			async : false,
			success : function(data) {
				if (data) {
					grid.datagrid('reload');
					SL.closeWindow();
				}
			}
		});
	}
}
function delCompany(index) {
	var data = grid.datagrid('getData').rows[index];
	if(data == null){
		top.SL.msgShow("提示", "请选择要删除的公司！", "warning");
		return;
	}
	top.$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		if (r) {
			$.ajax({
				url : basePath + "delete?id=" + data.id,
				success : function(data) {
					if (data) {
						grid.datagrid('reload');
						top.SL.sysSlideShow({
							msg : '成功删除!'
						});
					} else {
						top.$.messager.alert('提示', '删除失败，请联系管理员。');
					}
				}
			});
		}
	});
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
