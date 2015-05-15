var basePath = "../vehicle/";
var grid;
var carType, tabid;
var Request = new Object();
$(function() {
	Request = GetRequest();
	carType = Request['ct'];
	tabid = Request['tabid'];
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
});
var listButton;
function loadButton() {
	$.ajax({
		url : "../module/getRolePer",
		type : "POST",
		data : {
			roleid : $("#roleId").val(),
			modlueid : tabid
		},
		async : false,
		dataType : "json",
		cache : false,
		success : function(r) {
			listButton = r;
			var str = "<tr>";
			$.each(r, function(i, o) {
				if (o.pLevel == 1) {
					str += "<td><a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'" + o.iconCls + "',plain:true\" onclick=\"" + o.pDesc + "()\">" + o.pName + "</a></td>";
				}
			});
			str += "</tr>"
			var targetObj = $("#toolbar").append(str);
			$.parser.parse(targetObj);
		}
	});
}
function loadDataGrid() {
	grid = $('#dg').datagrid({
		method : 'post',
		url : basePath + 'list?carUseNatu=' + carType,
		// title : '车辆列表',
		fit : true,
		fitColumns : true,
		nowrap : true, // false:折行
		rownumbers : true, // 行号
		striped : true, // 隔行变色
		pagination : true,
		singleSelect : true,
		autoRowHeight : false,// 设置行的高度，根据该行的内容。设置为false可以提高负载性能。
		pageSize : 15,
		pageList : [ 1, 10, 15, 20, 30, 50 ],
		loadMsg : '数据加载中,请稍后……',
		frozenColumns : [ [ {
			field : '_state',
			title : '使用状态',
			formatter : function(value, row, index) {
				var s = "";
				if (typeof (row.networkNo) != "undefined" && row.networkNo != "" && row.networkNo != null) {
					s = "<div style='background-color:#008B00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>入网</div>";
				}
				return s;
			}
		}, {
			title : '操作',
			field : '_operate',
			align : 'center',
			formatter : function(value, row, index) {
				var s = "";
				$.each(listButton, function(i, o) {
					if (o.pLevel == 2) {
						s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:" + o.pDesc + "('" + row.id + "');\">" + o.pName + "</span></a>";
						s += "&nbsp;|&nbsp;";
					}
				});
				return s;
			}
		}, {
			field : 'carNumber',
			title : '车牌号'
		}, {
			field : 'contacts',
			title : '联系人'
		}, {
			field : 'contactsTel',
			title : '联系电话'
		}, {
			field : 'fhtime',
			title : '车辆类型',
			formatter : function(value, row, index) {
				var calss = row.classify == null ? "" : row.classify;
				var carType = row.carType == null ? "" : row.carType;
				return calss + carType;
			}
		}, {
			field : 'companyName',
			title : '所属公司'
		} ] ],
		columns : [ [ {
			title : '车载终端',
			colspan : 5
		}, {
			title : '机动车行驶证',
			colspan : 2
		}, {
			title : '道路运输证',
			colspan : 3
		}, {
			title : '',
			colspan : 1
		}, {
			title : '保险信息',
			colspan : 3
		} ], [ {
			field : 'equitment',
			title : '设备号'
		}, {
			field : 'simNumber',
			title : 'SIM卡'
		}, {
			field : 'networkNo',
			title : '入网证明编号'
		}, {
			field : 'installtime',
			title : '安装日期'
		}, {
			field : 'feeseEnd',
			title : '检验有效期至',
			styler:cellStyler30
		}, {
			field : 'xszbh',
			title : '档案编号'
		}, {
			field : 'xszdqrq',
			title : '到期日期',
			styler:cellStyler90
		}, {
			field : 'ysz',
			title : '道路运输经营许可证'
		}, {
			field : 'jyxkz',
			title : '经营许可证'
		}, {
			field : 'xkzdqrq',
			title : '到期日期',
			styler:cellStyler30
		}, {
			field : 'ejwhDqTime',
			title : '二保到期日期',
			styler:cellStyler30
		}, {
			field : 'policy',
			title : '保单号'
		}, {
			field : 'bxType',
			title : '保险类型'
		}, {
			field : 'bxendTime',
			title : '到期日期',
			styler:cellStyler30
		} ] ],
		toolbar : '#tb',
	});
	// 设置分页控件
	grid.datagrid('getPager').pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}
function cellStyler30(value,row,index){
	var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss", DateUtil.dateAdd('d', 30, new Date()));
	if (value < curDate) {
		return 'background-color:#ffee00;color:red;font-weight:bold;';
	}
}
function cellStyler90(value,row,index){
    var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss", DateUtil.dateAdd('d', 30, new Date()));
	if (value < curDate) {
		return 'background-color:#ffee00;color:red;font-weight:bold;';
	}
}
function pos(index) {
	var data = grid.datagrid('getData').rows[index];
	window.open('../location.jsp')
}
function addCar() {
	window.location.href = 'vehicleAdd.jsp?ct=' + carType;
}
function vehicleInfo(id) {
	window.location.href = 'vehicleInfo.jsp?id=' + id;
}
function editRow(id) {
	window.location.href = 'vehicleEdit.jsp?id=' + id;
}
function approval(id) {
	window.location.href = 'approval.jsp?id=' + id;
}
function deleteRow(id) {
	$.messager.confirm('提示', '将删除该车辆所有信息，确认删除?', function(row) {
		if (row) {
			// var data = grid.datagrid('getData').rows[index];
			$.ajax({
				url : basePath + 'delete?id=' + id,
				success : function(data) {
					if (data) {
						grid.datagrid('reload');
						top.SL.sysSlideShow({
							msg : '成功删除!'
						});
					} else {
						SL.msgShow("提示", "操作错误，请联系管理员", "error");
					}
				}
			});
		}
	})
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