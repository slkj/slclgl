var grid;
var basePath = "";
$(function() {
	loadButton();
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
function loadButton() {
	$.ajax({
		url : "../module/getRolePer",
		type : "POST",
		data : {
			roleid : $("#roleId").val(),
			modlueid : '14'
		},
		async : false,
		dataType : "json",
		cache : false,
		success : function(r) {
			listButton = r;
			var str="<tr>";
			$.each(r, function(i, o) {
				if(o.pLevel == 1){
					str +="<td><a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'"+o.iconCls+"',plain:true\" onclick=\""+o.pDesc+"()\">"+o.pName+"</a></td>";
				} 
			});
			str +="</tr>"
			var targetObj=$("#toolbar").append(str);
			$.parser.parse(targetObj);
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
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'pack',
			title : '包装',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				if (value == 0) {
					s = "<span style=\"color:green;\">全新</span>";
				} else if (value == 1) {
					s = "<span style=\"color:#525252;\">返修</span>";
				}
				return s;
			}
		// }, {
		// field : 'opt',
		// title : '操作',
		// align : 'center',
		// formatter : function(value, row, index) {
		// var s = "";
		// s += "<a href=\"javascript:void(0)\"><span
		// onclick=\"javaScript:outRepertory('" + index + "');\">出库</span></a>";
		// s += "&nbsp;|&nbsp;";
		// s += "<a href=\"javascript:void(0)\"><span
		// onclick=\"javaScript:goBack('" + index + "');\">退回</span></a>";
		// return s;
		// }
		}, {
			field : 'state',
			title : '使用状态',
			formatter : function(value, row) {
				var s = "";
				if (value == "4") {
					s = "<div style='background-color:#008B00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>入网使用</div>";
				} else if (value == "1") {
					s = "<div style='background-color:#FF8C00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已出库</div>";
				} else if (value == "2") {
					s = "<div  style='background-color:#CD3333;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>未出库</div>";
				} else if (value == "3") {
					s = "<div  style='background-color:#0000cd;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>退回</div>";
				}
				return s;
			}
		}, {
			field : 'areaName',
			title : '所在地区'
		}, {
			field : 'firm',
			title : '厂牌型号',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "<span style=\"font-weight:bold;\">" + row.firm + "</span>";
				if (row.model != "") {
					s = "<span style=\"font-weight:bold;\">" + row.firm + "(" + row.model + ")</span>";
				}
				return s;
			}
		}, {
			field : 'listnum',
			title : '设备编号'
		}, {
			field : 'phone',
			title : 'SIM卡号',
			sortable : true,
			order : 'desc',
		} ] ],
		columns : [ [ {
			field : 'lyr',
			title : '领用人'
		}, {
			field : 'lytime',
			title : '领用时间',
			sortable : true,
			order : 'desc',
		}, {
			field : 'carNumber',
			title : '车牌号',
		}, {
			field : 'installers',
			title : '安装人'
		}, {
			field : 'installtime',
			title : '安装时间'
		}, {
			field : 'company',
			title : '使用公司'
		}, {
			field : 'networkNo',
			title : '入网证明编号'
		}, {
			field : 'rktime',
			title : '入库时间'

		}, {
			field : 'fhtime',
			title : '返还时间'
		}, {
			field : 'test',
			title : '测试',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				if (value == 1) {
					s = "已检测";
				} else if (value == 0) {
					s = "<span style=\"color:red;\">未检测</span>";
				}
				return s;
			}
		}, {
			field : 'tresult',
			title : '测试结果',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				if (row.test == 1) {
					if (value == 1) {
						s = "定位";
					} else if (value == 0) {
						s = "<span style=\"color:red;\">不定位</span>";
					}
				}
				return s;
			}
		}, {
			field : 'remark',
			title : '备注'
		}, {
			field : '_opt',
			title : '入库记录',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:record('" + index + "');\">入库记录</span></a>";
				return s;
			}
		} ] ],
		toolbar : '#tb',
		// getSelectedRow : function() {
		// return $('#dg').datagrid('getSelected');
		// }
		onLoadSuccess : function() {
			grid.datagrid('clearSelections');
			// $('.roleCls').linkbutton({ text : '详细 ', plain :
			// true, iconCls : 'icons icons_35' });
			// $.parser.parse();
		}
	});
	// 设置分页控件
	grid.datagrid('getPager').pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}
function phone(index) {
	var data = grid.datagrid('getData').rows[index];
	// alert(data.phone);
}
function carNumber(index) {
	var data = grid.datagrid('getData').rows[index];
	// alert(data.carNumber);
}
function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

function myparser(s) {
	if (!s)
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0], 10);
	var m = parseInt(ss[1], 10);
	var d = parseInt(ss[2], 10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
		return new Date(y, m - 1, d);
	} else {
		return new Date();
	}
}

// 出库
function outRepertory(index) {
	var data = grid.datagrid('getData').rows[index];
	if (data.state == 1) {
		SL.msgShow("提示", "设备已经出库！", "warning");
		return;
	} else if (data.state == 4) {
		SL.msgShow("提示", "设备已经入网使用！", "warning");
		return;
	} else if (data.test == 0) {
		SL.msgShow("提示", "设备未经过检测，无法出库！", "warning");
		return;
	}
	SL.showWindow({
		title : 'GPS设备出入库信息',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url : basePath + 'outRepertory.jsp',
		onLoad : function() {
			$('#txtarea').combotree({
				url : '../data/city_data.json',
				required : true,
				lines : true
			});
			$("#form").form('load', data);
			$('#txtarea').combotree('setValue', data.area);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("../devices/outRepertory");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function del() {
	// 得到选中的行
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
	$.messager.confirm('提示框', '你确定要删除吗?', function(data) {
		if (data) {
			$.ajax({
				cache : false,
				type : "POST",
				url : "../devices/deletes",
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
function ck() {
	// 得到选中的行
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
	SL.showWindow({
		title : 'GPS设备出入库信息',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url : basePath + 'ck.jsp',
		onLoad : function() {
			$('#txtarea').combotree({
				url : '../data/city_data.json',
				required : true,
				lines : true
			});
			// $("#form").form('load', data);
			// $('#txtarea').combotree('setValue', data.area);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				// fCallback("../devices/outRepertory");
				// if ($("#form").form('enableValidation').form('validate')) {
				// var data = $("#form").serialize();
				var param = {
					ids : ids,
					area : $('#txtarea').combotree('getValue'),
					lyr : $('#lyr').val(),
					lytime : $('#lytime').datebox('getValue'),
					remark : $('#remark').val()
				};
				$.ajax({
					cache : false,
					type : "POST",
					url : "../devices/outRep",
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
		// }
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
// 退回
function goBack() {
	// var data = grid.datagrid('getData').rows[index];
	// if (data.state == 2) {
	// SL.msgShow("提示", "设备未出库，请确认信息。", "warning");
	// return;
	// }
	// if (data.state == 3) {
	// SL.msgShow("提示", "设备未出库，请确认信息。", "warning");
	// return;
	// }
	var selRow = grid.datagrid("getSelections");
	SL.showWindow({
		title : '设备返回信息',
		iconCls : 'icon-add',
		width : 450,
		height : 220,
		url : basePath + 'goBack.jsp',
		onLoad : function() {
			$("#back_id").val(data.id);
			$("#riqi").val(CurentTime());
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("../devices/goBack");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
// 入库记录
function record(index) {
	var data = grid.datagrid('getData').rows[index];
	SL.showWindow({
		title : '设备返回信息',
		iconCls : 'pic_146',
		width : 650,
		height : 350,
		url : basePath + 'record.jsp',
		onLoad : function() {
			$('#fhdg').datagrid({
				method : 'post',
				url : basePath + 'recordList?dev_id=' + data.id,
				// title : 'GPS设备列表',
				fit : true,
				nowrap : true, // false:折行
				rownumbers : true, // 行号
				striped : true, // 隔行变色
				pagination : true,
				singleSelect : true,
				showPageList : false,
				showRefresh : false,
				loadMsg : '数据加载中,请稍后……',
				columns : [ [ {
					field : 'fhtime',
					title : '返还时间'
				}, {
					field : 'remark',
					title : '备注'
				} ] ]
			});
		},
	// buttons : [ {
	// text : '关闭',
	// handler : function() {
	// SL.closeWindow();
	// }
	// } ]
	});
}
// 测试
function testing(index) {
	var data = grid.datagrid('getData').rows[index];
	if (data.state == 1) {
		SL.msgShow("提示", "设备已经出库！", "warning");
		return;
	}
	SL.showWindow({
		title : 'GPS设备测试',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url : basePath + 'testing.jsp',
		onLoad : function() {
			$("#form").form('load', data);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("../devices/testing");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
// SIM卡号联想搜索
var btsloader = function(param, success, error) {
	// 获取输入的值
	var q = param.q || "";
	// 此处q的length代表输入多少个字符后开始查询
	if (q.length < 3)
		return false;
	$.ajax({
		url : "../sim/getList",
		// type : "post",
		data : {
			// 传值，还是JSON数据
			telnum : q
		},
		// 重要，如果写jsonp会报转换错误，此处不写都可以
		dataType : "json",
		success : function(data) {
			// 关键步骤，遍历一个MAP对象
			var items = $.map(data, function(item) {
				return {
					id : item.telnum,
					name : item.telnum
				};
			});
			// 执行loader的success方法
			success(items);
		}, // 异常处理
		error : function(xml, text, msg) {
			error.apply(this, arguments);
		}
	});
};
function autoSIM(vID) {
	$('#' + vID).combobox({
		valueField : 'telnum',
		textField : 'telnum',
		onChange : function(newValue, oldValue) {
			if (newValue.length < 3)
				return false;
			var telnum = encodeURIComponent($('#' + vID).combobox('getText')); // 搜索词
			var urlStr = "../sim/getList?telnum=" + telnum;
			$("#" + vID).combobox("reload", urlStr);
		},
		onSelect : function(obj) {
			$('#' + vID).combobox('setValue', obj.telnum);
		}
	});
}
// 入库
function closedDiv() {
	$('#listnum').show();
	$('#listdiv').hide();
}
function showDiv() {
	$('#listdiv').show();
	$('#listnum').hide();
}
function intoRepertory() {
	SL.showWindow({
		title : 'GPS设备出入库信息',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url : basePath + 'devicesAdd.jsp',
		onLoad : function() {
			// autoSIM("phone");
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("../devices/addDevices");
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
	// if ($("#form").form('enableValidation').form('validate')) {
	var data = $("#form").serialize();
	$.ajax({
		cache : false,
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(data) {
			if (data) {
				grid.datagrid('reload');
				SL.closeWindow();
			}
		}
	});
	// }
}
// 编辑
function edit() {
	var selRow = grid.datagrid("getSelections");// 返回选中多行
	if (selRow.length != 1) {
		SL.msgShow("提示", "请选择一行数据!！", "warning");
		return false;
	}
	SL.showWindow({
		title : 'GPS设备出入库信息',
		iconCls : 'icon-add',
		width : 550,
		height : 450,
		url : basePath + 'devicesEdit.jsp',
		onLoad : function() {
			$("#form").form('load', selRow[0]);
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				var data = $("#form").serialize();
				$.ajax({
					cache : false,
					type : "POST",
					url : '../devices/editDevices',
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
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function outExcel() {
//	window.location.href = "../download.do?name=GPS.xls";
}
function excelMB() {
	window.location.href = "../download.do?name=GPS.xls";
}
function openExcel() {
	$('#openExcel').dialog('open');
}
//采用jquery easyui loading css效果
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
			url : '../upload/excel/0', // 你处理上传文件的服务端
			secureuri : false, // 是否启用安全提交,默认为false
			fileElementId : 'myfile', // 文件选择框的id属性
			dataType : 'text', // 服务器返回的格式,可以是json或xml等
			beforeSend : ajaxLoading,// 发送请求前打开进度条
			success : function(data, status) { // 服务器响应成功时的处理函数
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
function CurentTime() {
	var now = new Date();
	var year = now.getFullYear(); // 年
	var month = now.getMonth() + 1; // 月
	var day = now.getDate(); // 日
	var hh = now.getHours(); // 时
	var mm = now.getMinutes(); // 分
	var ss = now.getSeconds(); // 秒
	var clock = year + "-";
	if (month < 10)
		clock += "0";
	clock += month + "-";
	if (day < 10)
		clock += "0";
	clock += day + " ";
	if (hh < 10)
		clock += "0";
	clock += hh + ":";
	if (mm < 10)
		clock += '0';
	clock += mm + ":";
	if (ss < 10)
		clock += '0';
	clock += ss;
	return (clock);
}