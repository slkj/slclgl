var grid;
$(function() {
	// 初始化页面
	loadDataGrid();
	 $("#search_btn").click(function () { 
         $('#dg').datagrid({ queryParams: form2Json("searchform") });   //点击搜索 
         // 清空表单
 		 $('#searchform').form('clear');
     });
});
//将表单数据转为json
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
			url : '../devices/list',
			title : 'GPS设备列表',
			fit : true,
			nowrap : true, // false:折行
			rownumbers : true, // 行号
			striped : true, // 隔行变色
			pagination : true,
			fitColumns : true,
			pageSize : 15,
			pageList : [ 1, 10, 15, 20, 30, 50 ],
			loadMsg : '数据加载中,请稍后……',
			columns : [ [
					{
						field : 'ck',
						checkbox : true
					},
					{
						field : 'opt',
						title : '操作',
						align : 'center',
						formatter : function(value, row) {
							var s = "";
							s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('" + row.id + "');\">出库</span></a>";
							s += "&nbsp;|&nbsp;";
							s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('" + row.id + "');\">删除</span></a>";
							s += "&nbsp;|&nbsp;";
							s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('" + row.id + "');\">故障</span></a>";
							return s;
						}
					}, {
						field : 'listnum',
						title : '设备编号'
					}, {
						field : 'firm',
						title : '设备厂商'
					},

					{
						field : 'model',
						title : '厂牌型号'
					}, {
						field : 'genre',
						title : '设备类别'
					}, {
						field : 'rktime',
						title : '入库时间'
					}, {
						field : 'state',
						title : '使用状态',
						formatter : function(value, row) {
							var s = "";
							if (value == "1") {
								s = "<span style=\"color:green;\">已出库</span>";
							} else if (value == "2") {
								s = "<span style=\"color:red;\">未出库</span>";
							}else if (value == "3") {
								s = "<span style=\"color:blue;\">返回</span>";
							}
							return s;
						}
					}, {
						field : 'fhtime',
						title : '返还时间'
					}, {
						field : 'lyr',
						title : '领用人'
					}, {
						field : 'lytime',
						title : '领用时间'
					}, {
						field : 'test',
						title : '测试',
						formatter : function(value, row, index) {
							var s = "";
							if (value == 1) {
								s = "<span style=\"color:green;\">已测试</span>";
							} else {
								s = "<span style=\"color:red;\">未测试</span>";
							}
							return s;
						}
					}, {
						field : 'phone',
						title : '卡号'
					}, {
						field : 'cstime',
						title : '测试时间'
					}, {
						field : 'tresult',
						title : '测试结果',
						formatter : function(value, row, index) {
							var s = "";
							if (value == 1) {
								s = "<span style=\"color:green;\">定位</span>";
							} else {
								s = "<span style=\"color:red;\">不定位</span>";
							}
							return s;
						}
					} ] ],
			view : detailview,
			detailFormatter : function(index, row) {
				var s = '<div style="padding:2px;hight:100px;"><table class="grid">'
						+ '<tr><th style="width: 80px">Gps主机：</th>' + '<td>'
						+ row.gpszj
						+ '</td>'
						+ '<th style="width: 80px">Gps天线：</th>'
						+ '<td>' + row.gpstx + '</td>'
						+ '<th style="width: 80px">Gsm天线：</th>'
						+ '<td>' + row.gsmtx 	+ '</td>'
						+ '<th style="width: 80px">电源线：</th>'
						+ '<td>' + row.dy + '</td>'
						+ '<th style="width: 80px">防水袋：</th>'
						+ '<td>' + row.fsd + '</td></tr>'
						+ '<tr><th style="width: 80px">计算器：</th>'
						+ '<td>' + row.jsq + '</td>'
						+ '<th style="width: 80px">摄像仪：</th>'
						+ '<td>' + row.sxy + '</td>'
						+ '<th style="width: 80px">扬声器：</th>'
						+ '<td>' + row.ysq + '</td>'
						+ '<th style="width: 80px">麦克风：</th>'
						+ '<td>' 	+ row.mkf + '</td>'
						+ '<th style="width: 80px"></th>'
						+ '<td></td></tr>'
						+ '</table></div>';
				// return '<div
				// style="padding:2px;hight:80px;"><table id="ddv-'
				// + index + '"></table></div>';
				return s;
			},
			// onExpandRow : function(index, row) {
			// $('#ddv-' + index).empty();
			// var s = '<tr>'
			// + '<td rowspan=2 style="border:0"><img src="images/'
			// + row.id + '.png" style="height:50px;"></td>'
			// + '<td style="border:0">' + '<p>Attribute: ' + row.id
			// + '</p>' + '<p>Status: ' + row.id + '</p>' + '</td>'
			// + '</tr>';
			// $('#ddv-' + index).append(s);
			// },
			toolbar : '#tb',
			getSelectedRow : function() {
				return $('#dg').datagrid('getSelected');
			}
		});
	// 设置分页控件
	grid.datagrid('getPager').pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}

function addNew() {
	top.$('#dd').dialog({
		title : 'GPS设备出入库信息',
		iconCls : 'icon-add',
		href : 'sim/simAdd.jsp',
		width : 550,
		height : 400,
		closed : false,
		cache : false,
		modal : true,
		onLoad : function() {
			top.$("#type").val("1");
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback();
			}
		}, {
			text : '关闭',
			handler : function() {
				top.$('#dd').dialog('close');
			}
		} ]
	});
}
function fCallback() {
//	if (top.$("#uform").form('enableValidation').form('validate')) {
//		var data = top.$("#uform").serialize();
//		var url = "";
//		$.ajax({
//			cache : false,
//			type : "POST",
//			url : "../sim/addSim",
//			data : data,
//			async : false,
//			success : function(data) {
//				if (data) {
//					top.$('#dd').dialog('close');
//					grid.datagrid('reload');
//				}
//			}
//		});
//	}
}

// 导入客户,在页面中引入 js/swfupload/ajaxfileupload.js
function ajaxFileUpload() {
	$("#msg").empty();
	if($("#myfile").val().length > 0){
		$.ajaxFileUpload({
			url : '../upload/excel', // 你处理上传文件的服务端
			secureuri : false, // 是否启用安全提交,默认为false
			fileElementId : 'myfile', // 文件选择框的id属性
			dataType : 'text', // 服务器返回的格式,可以是json或xml等
			success : function(data, status) { // 服务器响应成功时的处理函数
				grid.datagrid('reload');
				$("#myfile").val("");
			}
		});
	}else{
		$("#msg").append("请选择要导入的文件！");
	}
}