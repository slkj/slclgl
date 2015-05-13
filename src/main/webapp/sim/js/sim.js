var grid;
var basePath = "";
var Request = new Object();
var type;
$(function() {
	Request = GetRequest();
	type = Request['t'];
	// 初始化页面
	initDataGrid();
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
function initDataGrid() {
	grid = $('#dg').datagrid({
		method : 'post',
		url : '../sim/list?type=' + type,
		// title : '联通卡列表',
		fit : true,
		nowrap : true, // false:折行
		rownumbers : true, // 行号
		striped : true, // 隔行变色
		pagination : true,
		pageSize : 15,
		pageList : [ 1, 10, 15, 20, 30, 50 ],
		loadMsg : '数据加载中,请稍后……',
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'state',
			title : '状态',
			formatter : function(value, row) {
				var s = "";
				if (value == "1") {
					s = "<span style=\"color:green;\">已用</span>";
				} else {
					s = "<span style=\"color:red;\">未用</span>";
				}
				return s;
			}
		}, {
			field : 'telnum',
			title : 'SIM号码'
		}, {
			field : 'listnum',
			title : '序列号'
		}, {
			field : 'kktime',
			title : '开卡日期'
		}, {
			field : 'gys',
			title : '供应商'
		}, {
			field : 'intime',
			title : '录入日期'
		}, {
			field : 'lrr',
			title : '操作人'
		}, {
			field : 'beizhu',
			title : '备注'
		}, {
			field : 'opt',
			title : '操作',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				s += "&nbsp;";
				// s += "<a href=\"javascript:void(0)\"><span
				// onclick=\"javaScript:simPay('" + row.id +
				// "');\">缴费</span></a>";
				// s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow(" + index + ");\">编辑</span></a>";
				// s += "&nbsp;|&nbsp;";
				// s += "<a href=\"javascript:void(0)\"><span
				// onclick=\"javaScript:deleteRow('" + row.id +
				// "');\">删除</span></a>";
				s += "&nbsp;|&nbsp;";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('" + row.id + "');\">缴费记录</span></a>";
				return s;
			}
		} ] ],
		toolbar : '#tb',
		getSelectedRow : function() {
			return $('#dg').datagrid('getSelected');
		}
	});
	// 设置分页控件
	var p = grid.datagrid('getPager');
	$(p).pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}

function addNew() {
	SL.showWindow({
		title : 'SIM卡信息',
		iconCls : 'icon-add',
		width : 550,
		height : 370,
		url : basePath + 'simAdd.jsp',
		onLoad : function() {
			$("#type").val("1");
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("../sim/addSim");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function fCallback(url) {
	if (top.$("#uform").form('enableValidation').form('validate')) {
		var data = $("#uform").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : url,
			data : data,
			async : false,
			success : function(data) {
				SL.closeWindow();
				if (data) {
					grid.datagrid('reload');
				} else {
					SL.msgShow("提示", "请检查SIM卡号是否已经存在!", "warning");
				}
			}
		});

	}
}
// 编辑
function editRow(index) {
	var data = grid.datagrid('getData').rows[index];
	SL.showWindow({
		title : 'SIM卡信息',
		iconCls : 'icon-edit',
		width : 550,
		height : 370,
		url : basePath + 'simEdit.jsp',
		onLoad : function() {
			$("#uform").form('load', data);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-save',
			handler : function() {
				fCallback("../sim/editSim");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
// 缴费
function simPay() {
	var selRow = grid.datagrid("getSelections");// 返回选中多行
	if (selRow.length == 0) {
		SL.msgShow("提示", "请至少选择一行数据!！", "warning");
		return false;
	}
	var ids = [];
	for (var i = 0; i < selRow.length; i++) {
		var id = selRow[i].id;
		ids.push(id);
	}
	var param = {
		ids : ids
	};
	$.ajax({
		cache : false,
		type : "POST",
		url : "../sim/simPay",
		data : param,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data) {
				grid.datagrid('reload');
			}
		}
	});
}

function outExcel() {
}
function excelMB() {
	window.location.href = "../download.do?name=sim.xls";
}
function openExcel() {
	$('#openExcel').dialog('open');
}
// 采用jquery easyui loading css效果
function ajaxLoading() {
	$("<div class=\"datagrid-mask\"></div>").css({
		display : "block",
		width : "100%",
		height : $(window).height()
	}).appendTo("body");
	$("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({
		display : "block",
		left : ($(document.body).outerWidth(true) - 190) / 2,
		top : ($(window).height() - 45) / 2
	});
}
function ajaxLoadEnd() {
	$(".datagrid-mask").remove();
	$(".datagrid-mask-msg").remove();
}
// 导入客户,在页面中引入 js/swfupload/ajaxfileupload.js
function ajaxFileUpload() {
	$("#msg").empty();
	if ($("#myfile").val().length > 0) {
		$.ajaxFileUpload({
			url : '../upload/excel/1', // 你处理上传文件的服务端
			secureuri : false, // 是否启用安全提交,默认为false
			fileElementId : 'myfile', // 文件选择框的id属性
			dataType : 'text', // 服务器返回的格式,可以是json或xml等
			beforeSend : ajaxLoading,// 发送请求前打开进度条
			success : function(data) { // 服务器响应成功时的处理函数
				ajaxLoadEnd();// 任务执行成功，关闭进度条
				grid.datagrid('reload');
				$('#openExcel').dialog('close');
				$("#myfile").val("");
			}
		});
	} else {
		$("#msg").append("请选择要导入的文件！");
	}
}