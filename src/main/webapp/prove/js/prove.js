var grid;
var basePath = "";
$(function() {
	$('#address').combotree({
		url : '../data/city_data.json',
		lines : true
	});
	// 初始化页面
	loadDataGrid();
	$("#search_btn").click(function() {
		$('#dg').datagrid({
			queryParams : form2Json("searchform")
		}); // 点击搜索
		// 清空表单
		$('#searchform').form('clear');
	});
	$("#high_search_btn").click(function() {
		var di = $('#highsearch').css("display");
		if (di == "none") {
			$('#highsearch').show();
		} else {
			$('#highsearch').hide();
		}

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
	grid = $('#dg').datagrid({
		method : 'post',
		url : basePath + 'list',
		// title : 'GPS设备列表',
		fit : true,
		nowrap : true, // false:折行
		rownumbers : true, // 行号
		striped : true, // 隔行变色
		pagination : true,
		fitColumns : true,
		// singleSelect : true,
		pageSize : 15,
		pageList : [ 1, 10, 15, 20, 30, 50 ],
		loadMsg : '数据加载中,请稍后……',

		columns : [ [ {
			field : 'ck',
			checkbox : true
		},{
			field : 'state',
			title : '出库状态',
			formatter : function(value, row) {
				var s = "";
				if (value == "0") {
					s = "<div  style='background-color:#CD3333;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>未出库</div>";
				} else if (value == "1") {
					s = "<div  style='background-color:#FF8C00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已出库</div>";
				}else if (value == "2") {
					s = "<div  style='background-color:#aaaaaa;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已作废</div>";
				}
				return s;
			}
		}, {
			field : 'address',
			title : '使用地区'
		}, {
			field : 'ustype',
			title : '使用类型'
		}, {
			field : 'number',
			title : '编号'
		},{
			field : 'usman',
			title : '领用人'
		},{
			field : 'usriqi',
			title : '领用日期'
		}, {
			field : 'inspector',
			title : '安检员'

		}, {
			field : 'wangjian',
			title : '网监员'

		}, {
			field : 'riqi',
			title : '测试日期'
		}, {
			field : 'ustate',
			title : '使用状态',
			formatter : function(value, row) {
				var s = "";
				if (value == "0") {
					s = "<div  style='background-color:#CD3333;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>未使用</div>";
				} else if (value == "1") {
					s = "<div  style='background-color:#FF8C00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已使用</div>";
				}else if (value == "2") {
					s = "<div  style='background-color:#00ff00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已回收</div>";
				}else if (value == "3") {
					s = "<div  style='background-color:#aaaaaa;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已作废</div>";
				}
				return s;
			}
		},
		{
			title : '操作',
			field : '_operate',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				if (row.id != null) {
					
					s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editFun('" + row.id + "','"+row.state+"');\">编辑</span></a>";
					s += "&nbsp;|&nbsp;";
					s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delFun('" + row.id + "');\">删除</span></a>";
					
				}
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
//删除操作
function delFun(id) { 
	
	top.$.messager.confirm('提示', '将删除该信息，确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : 'delete?id=' + id,
				success : function(data) {
					if (data) {
						$('#dg').datagrid('load');
						SL.sysSlideShow({
							msg : '成功删除!'
						});
					} else {
						top.$.messager.alert('提示', '删除失败，请联系管理员。');
					}
				}
			});
		}
	})
}  
// 弹出添加页面
function addFun() {

	SL.showWindow({
		title : '添加',
		iconCls : 'icon-add',
		width : 600,
		height : 400,
		url : 'proveAdd.jsp',
		onLoad : function() {
			
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				var url = 'save';
				saveAjax(url);
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
};
// ajax 表单提交审验信息
function saveAjax(url) {
	if (top.$("#dform").form('enableValidation').form('validate')) {
		var data = $("#dform").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : url,
			data : data,
			async : false,
			dataType : 'json',
			success : function(data) {
				if (data) {
					SL.closeWindow();
					$('#dg').datagrid('load');
					SL.sysSlideShow({
						msg : '保存成功'
					});
				} else {
					top.$.messager.alert('提示', '保存失败，请检查信息是否正确。');
				}
			}
		});
	}
}
// 编辑
function editFun(id,state) {
	if(state=="1"){
		SL.msgShow("提示", "证明已出库！", "warning");
		return;
	}else if (state == "2") {
		SL.msgShow("提示", "证明已作废！", "warning");
		return;
	}
	SL.showWindow({
		title : '编辑',
		iconCls : 'icon-edit',
		width : 600,
		height : 400,
		url : 'proveEdit.jsp',
		onLoad : function() {
			
			$.ajax({
				url : 'queryOne?id=' + id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#dform").form('load', data);
					}
				}
			});
			
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				var url = 'editSave';
				saveAjax(url);
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function outFun() {
	// 得到选中的行
	var selRow = grid.datagrid("getSelections");// 返回选中多行
	if (selRow.length == 0) {
		SL.msgShow("提示", "请选择至少一行数据!！", "warning");
		return false;
	}
	/*var id=selRow[0].id;
	if (selRow[0].state == "1") {
		SL.msgShow("提示", "证明已使用！", "warning");
		return;
	}
	if (selRow[0].state == "2") {
		SL.msgShow("提示", "证明已作废！", "warning");
		return;
	}*/
	var ids = [];
	for (var i = 0; i < selRow.length; i++) {
		if(selRow[i].state=="0"){
		var id = selRow[i].id;
		ids.push(id);
		}
	}
	var param = {
		ids : ids
	};
	SL.showWindow({
		title : '使用',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url :'proveUse.jsp',
		onLoad : function() {
			/*$.ajax({
				url : 'queryOne?id=' + ids[0],
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						//$("#dform").form('load', data);
						$('#id').val(data.id);
						$('#remark').textbox('setValue',data.remark);
					}
				}
			});*/
			
			$('#remark').textbox('setValue',selRow[0].remark);
			$('#address1').combotree({
				url : '../data/city_data.json',
				required : true,
				lines : true,
				onSelect:function(node) {
					$('#address11').val(node.text);
					  }
			});
			
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				/*var url = 'useSave?ids='+ids;
				saveAjax(url);*/
				var param = {
						ids : ids,
						//address : $('#address1').combotree('getValue'),
						address : $('#address11').val(),
						usman : $('#usman').val(),
						usriqi : $('#usriqi').datebox('getValue'),
						remark : $('#remark').textbox('getValue')
					};
					$.ajax({
						cache : false,
						type : "POST",
						url : "useSave",
						data : param,
						dataType : "json",
						cache : false,
						success : function(data) {
							if (data) {
								grid.datagrid('reload');
								SL.closeWindow();
							}
						}
					});
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function tovoid(ustate) {
	// 得到选中的行
	var selRow = grid.datagrid("getSelections");// 返回选中多行
	if (selRow.length == 0) {
		SL.msgShow("提示", "请至少选择一行数据！", "warning");
		return false;
	}
	var ids = [];
	for (var i = 0; i < selRow.length; i++) {
		var id = selRow[i].id;
		ids.push(id);
	}
	var param = {
		ids : ids,
		ustate:ustate
	};
	$.messager.confirm('提示框', '你确定要操作吗?', function(data) {
		if (data) {
			$.ajax({
				cache : false,
				type : "POST",
				url : "voidSave",
				data : param,
				dataType : "json",
				cache : false,
				success : function(data) {
					if (data) {
						grid.datagrid('reload');
						SL.sysSlideShow({
							msg : "操作成功"
						});
					}
				}
			});
		}
	});
}
function closedDiv() {
$('#listnum').show();
$('#listdiv').hide();
}
function showDiv() {
$('#listdiv').show();
$('#listnum').hide();
}