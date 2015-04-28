var url = "../driving/list";
$(function() {
	getData();
	$("#btn").click(function() {
		$('#grid').datagrid({
			queryParams : form2Json("searchForm")
		}); // 点击搜索
		// 清空表单
		$('#searchForm').form('clear');
	});
});
function getData() {
	$('#grid').datagrid(
			{
				width : 'auto',
				height : 'auto',
				url : url,
				fit : true,
				nowrap : true, // false:折行
				rownumbers : true, // 行号
				striped : true, // 隔行变色
				singleSelect : true, // 只允许选择一行
				pagination : true,
				pageSize : 15,
				pageList : [ 1, 10, 15, 20, 30, 50 ],
				loadMsg : '数据加载中,请稍后……',
				rowStyler : function(index, row) {
					var comDay = 20;
					if (row.endDate != null) {
						var curDate = DateUtil.curentTime();
						if(row.endDate > curDate){
							return;
						}
						var days = DateUtil.DiffLong(row.endDate,curDate) ;
						if(days > comDay){
							return 'color:#FF4040;font-weight:bold;';
						}
					}
				},
				columns : [ [
						{
							title : '车牌号',
							field : 'carNumber',
							formatter : function(value, row) {
								return '<a id="' + row.id
										+ '" href="javascript:void(0);" onclick="view(\'' + row.vId
										+ '\')">' + value + '</a> ';
							}
						},
						{
							title : '档案编号',
							field : 'fileNumber'
						},
						{
							title : '注册日期',
							field : 'driRegDate'
						},
						{
							title : '发证时间',
							field : 'driCertDate'
						},
						{
							title : '检测机关',
							field : 'testOrgan'
						},
						{
							title : '到期日期',
							field : 'endDate'
						},
						{
							title : '强制报废日期',
							field : 'baoFeiDate'
						},
						{
							title : '备注',
							field : 'remark'
						},
						{
							title : '是否到期',
							field : 'status',
							formatter : function(value, row) {
								if (row.endDate != null) {
									var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss",DateUtil.dateAdd('d',90,new Date()));
									if(row.endDate < curDate){
										return "<span style=\"color:red;\">是</span>";
									}
									return "";
								}
							}
						},
						{
							title : '操作',
							field : '_operate',
							align : 'center',
							formatter : function(value, row, index) {
								var s = "";
								if (row.fileNumber != null) {
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:derRecord('" + index + "');\">审验</span></a>";
									s += "&nbsp;|&nbsp;";
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editFun('" + index + "');\">编辑</span></a>";
									s += "&nbsp;|&nbsp;";
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delFun('" + index + "');\">删除</span></a>";
									
								}
								return s;
							}
						} ] ],
				toolbar : "#toolbar",
				onLoadSuccess : function() {
					$('#grid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					$('.roleCls').linkbutton({
						text : '详细 ',
						plain : true,
						iconCls : 'icons_35'
					});
				}
			});
	// 设置分页控件
	$('#grid').datagrid('getPager').pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
	
}

// 判断是否选择行，返回这一行数据 obj
function checkRows(index) {
	
	var data = $('#grid').datagrid('getData').rows[index];
	if (data == null) {
		top.SL.msgShow("提示", "请选择一行数据！", "warning");
		return;
	}
	return data;
}
//删除操作
function delFun(index) { 
	if (!checkRows(index)) {
		return;
	}
	var obj = checkRows(index);
	if (obj.id == null) {
		return;
	}
	$.messager.confirm('提示', '将删除该车辆行驶证所有信息，确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : '../driving/delete?id=' + obj.id,
				success : function(data) {
					if (data) {
						$('#grid').datagrid('load');
						SL.sysSlideShow({
							msg : '成功删除!'
						});
					} else {
						$.messager.alert('提示', '删除失败，请联系管理员。');
					}
				}
			});
		}
	})
}  
// 弹出添加页面
function addFun() {
	var selRow = $('#grid').datagrid("getSelections");// 返回选中多行
	if (selRow.length != 1) {
		top.$.messager.alert('提示', '请选择一行数据!', 'info');
		return false;
	}
	var obj = selRow[0];
	SL.showWindow({
		title : '添加车辆行驶信息',
		iconCls : 'icon-add',
		width : 600,
		height : 400,
		url : 'addDriving.jsp',
		onLoad : function() {
			// ajax查询单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vId,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vId").val(data.id);
						$("#carNumber").text(data.carNumber);
						$("#regCompanyName").text(data.regCompanyName);
						$("#address").text(data.address);
						$("#wkcc").text(
								data.carOutLength + "*" + data.carOutWidth + "*"
										+ data.carOutHeight);
						$("#ppxh").text(data.carBrand + data.carModel);
						$("#cllx").text(data.classify + data.carType);
						$("#carVin").text(data.carVin);
						$("#carEngNum").text(data.carEngNum);
						$("#carApprGuest").text(data.carApprGuest);
						$("#carTotalmass").text(data.carTotalmass);
						$("#carTrac").text(data.carTrac);
						$("#carNumbers").text(data.carNumber);
					}
				}
			});
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				var url = '../driving/saveDriving';
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

	if ($("#dform").form('enableValidation').form('validate')) {
		var data = $("#dform").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : url,
			data : data,
			async : false,
			success : function(data) {
				if (data) {
					$('#grid').datagrid('reload');
					SL.closeWindow();
				}
			}
		});
	}
}
// 编辑
function editFun(index) {
	if (!checkRows(index)) {
		return;
	}
	var obj = checkRows(index);
	if (obj.id == null) {
		$.messager.alert('提示', '该车辆没有行驶证信息，请录入行驶证信息。');
		return;
	}
	SL.showWindow({
		title : '编辑车辆行驶信息',
		iconCls : 'icon-edit',
		width : 600,
		height : 400,
		url : 'editDriving.jsp',
		onLoad : function() {
			// ajax查询车辆单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vId,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vId").val(data.id);
						$("#carNumber").text(data.carNumber);
						$("#regCompanyName").text(data.regCompanyName);
						$("#address").text(data.address);
						$("#wkcc").text(
								data.carOutLength + "*" + data.carOutWidth + "*"
										+ data.carOutHeight);
						$("#ppxh").text(data.carBrand + data.carModel);
						$("#cllx").text(data.classify + data.carType);
						$("#carVin").text(data.carVin);
						$("#carEngNum").text(data.carEngNum);
						$("#carApprGuest").text(data.carApprGuest);
						$("#carTotalmass").text(data.carTotalmass);
						$("#carTrac").text(data.carTrac);
//						$("#carNumbers").text(data.carNumber);
					}
				}
			});
			$.ajax({
				url : '../driving/queryOne?id=' + obj.id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#dform").form('load', data);
						$("#remark").innerText=data.remark;
					}
				}
			});

		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				var url = '../driving/editDriving';
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
/*// 详细信息
function view(id) {
	SL.showWindow({
		title : '车辆信息',
		iconCls : 'icon-search',
		width : 1000,
		height : 640,
		closed : false,
		cache : false,
		modal : true,
		url : 'vehicle/vehicleView.jsp',
		onLoad : function() {
			// ajax查询单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#uform").form('load', data);
						$('#uform input').attr("disabled", "disabled");
					}
				}
			});
		},
		buttons : [ {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
};*/
// 车辆审验信息
function derRecord(index) {
	if (!checkRows(index)) {
		return;
	}
	var obj = checkRows(index);
	if (obj.fileNumber == null) {
		$.messager.alert('提示', '该车辆没有行驶证信息。');
		return;
	}
	SL.showWindow({
		title : '审验信息',
		iconCls : 'icons_26',
		width : 650,
		height : 400,
		url : 'der.jsp',
		onLoad : function() {
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vId,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vId").val(data.id);
						$("#carNumber").text(data.carNumber);
						$("#regCompanyName").text(data.regCompanyName);
						$("#address").text(data.address);
						$("#wkcc").text(
								data.carOutLength + "*" + data.carOutWidth + "*"
										+ data.carOutHeight);
						$("#ppxh").text(data.carBrand + data.carModel);
						$("#cllx").text(data.classify + data.carType);
						$("#carVin").text(data.carVin);
						$("#carEngNum").text(data.carEngNum);
						$("#carApprGuest").text(data.carApprGuest);
						$("#carTotalmass").text(data.carTotalmass);
						$("#carTrac").text(data.carTrac);
						$("#carNumbers").text(data.carNumber);
					}
				}
			});
			$.ajax({
				url : '../driving/queryOne?id=' + obj.id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$('#vId').val(data.vId);
						$('#carNumbers').val(data.carNumbers);
						$('#fileNumber').val(data.fileNumber);
						$('#driRegDate').datebox({value: data.driRegDate});  
						$('#driCertDate').datebox({value: data.driCertDate});  
						$('#baoFeiDate').datebox({value: data.baoFeiDate}); 
						
					}
				}
			});
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icons_45',
			handler : function() {
				var url = '../driving/saveDriving';
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
// 审验记录
function facRecord() {
	var selRow = $('#grid').datagrid("getSelections");// 返回选中多行
	if (selRow.length != 1) {
		top.$.messager.alert('提示', '请选择一行数据!', 'info');
		return false;
	}
	var obj = selRow[0];
	if (obj.fileNumber == null) {
		$.messager.alert('提示', '该车辆没有行驶证信息。');
		return;
	}
	SL.showWindow({
		title : '行驶证审验信息',
		iconCls : 'icons_26',
		width : 650,
		height : 400,
		url : 'record.jsp',
		onLoad : function() {
			$('#facdg').datagrid({
				url : '../driving/listByVid?vId=' + obj.vId,
				width : 'auto',
				height : 'auto',
				fit : true,
				nowrap : true, // false:折行
				rownumbers : true, // 行号
				striped : true, // 隔行变色
				singleSelect : true, // 只允许选择一行
				pagination : true,
				pageSize : 15,
				pageList : [ 1, 10, 15, 20, 30, 50 ],
				loadMsg : '数据加载中,请稍后……',
				columns : [ [ {
					field : 'carNumber',
					title : '车牌号',
					width : 100
				}, {
					field : 'fileNumber',
					title : '档案编号',
					width : 100
				}, {
					field : 'driRegDate',
					title : '注册日期',
					width : 70
				}, {
					field : 'driCertDate',
					title : '发证时间',
					width : 70
				}, {
					field : 'testOrgan',
					title : '检测机关',
					width : 150
				}, {
					field : 'endDate',
					title : '到期日期',
					width : 70
				} ] ]
			});
			// 设置分页控件
			$('#facdg').datagrid('getPager').pagination({
				beforePageText : '第',// 页数文本框前显示的汉字
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});
		},
		buttons : [ {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
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