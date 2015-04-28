var url = "../second/list";
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
					if (row.nextriqi != null) {
						// 获取当前时间，判断2个时间差是否大于全局变量comDay
						var curDate = DateUtil.curentTime();
						if(row.nextriqi > curDate){
							return
						}
						// 打印日期差
						var days = DateUtil.DiffLong(row.nextriqi,curDate) ;
						if(days > comDay){
							return 'color:#FF4040;font-weight:bold;';
						}
					}
				},
				columns : [ [
						{
							title : '车牌号',
							field : 'viotureNumber',
							formatter : function(value, row) {
								return '<a id="' + row.id
										+ '" href="javascript:void(0);" onclick="view(\'' + row.vid
										+ '\')">' + value + '</a> ';
							}
						},
						{
							title : '二保单位',
							field : 'keepaddress'
						},
						{
							title : '上次维护日期',
							field : 'lastriqi'
						},
						{
							title : '维护日期',
							field : 'riqi'
						},
						{
							title : '下次维护日期',
							field : 'nextriqi'
						},
						{
							title : '使用年限',
							field : 'life'
						},
						{
							title : '本次年审日期',
							field : 'examine'
						},
						
						{
							title : '备注',
							field : 'remark'
						},
						{
							title : '是否到期',
							field : 'status',
							formatter : function(value, row) {
								if (row.nextriqi != null) {
									var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss",DateUtil.dateAdd('d',30,new Date()));
									if(row.nextriqi < curDate){
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
								if (row.keepaddress != null) {
									
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
function checkRows() {
	var selRow = $('#grid').datagrid("getSelections");// 返回选中多行
	if (selRow.length != 1) {
		top.$.messager.alert('提示', '请选择一行数据!', 'info');
		return false;
	}
	return selRow[0];
}
//删除操作
function delFun(index) { 
	var obj = $('#grid').datagrid('getData').rows[index];
	if (obj.id == null) {
		return;
	}
	top.$.messager.confirm('提示', '将删除该车辆行驶证所有信息，确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : '../second/delete?id=' + obj.id,
				success : function(data) {
					if (data) {
						$('#grid').datagrid('load');
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
	if (!checkRows()) {
		return;
	}
	var obj = checkRows();
	SL.showWindow({
		title : '添加二级维护信息',
		iconCls : 'icon-add',
		width : 600,
		height : 400,
		url : 'add.jsp',
		onLoad : function() {
			// ajax查询单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vid,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vid").val(data.id);
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
				var url = '../second/save';
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
					$('#grid').datagrid('load');
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
function editFun(index) {
	var obj = $('#grid').datagrid('getData').rows[index];
	if (obj.id == null) {
		top.$.messager.alert('提示', '该车辆没有二级维护信息，请录入二级维护信息。');
		return;
	}
	SL.showWindow({
		title : '编辑二级维护信息',
		iconCls : 'icon-edit',
		width : 600,
		height : 400,
		url : 'edit.jsp',
		onLoad : function() {
			// ajax查询车辆单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vid,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vid").val(data.id);
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
					}
				}
			});
			$.ajax({
				url : '../second/queryOne?id=' + obj.id,
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
				var url = '../second/editSave';
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
// 详细信息
/*function view(id) {
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
						top.$("#uform").form('load', data);
						top.$('#uform input').attr("disabled", "disabled");
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
function listByCar(){
	if (!checkRows()) {
		return;
	}
	var obj = checkRows();
	if (obj.id == null) {
		top.$.messager.alert('提示', '该车辆没有保险信息。');
		return;
	}
	SL.showWindow({
		title : '保险信息',
		iconCls : 'icons_26',
		width : 650,
		height : 400,
		url : 'second/record.jsp',
		onLoad : function() {
			top.$('#facdg').datagrid({
				url : 'second/listByVid?vId=' + obj.vid,
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
					field : 'viotureNumber',
					title : '车牌号',
					width : 100
				},
				{
					title : '二保单位',
					field : 'keepaddress'
				},
				{
					title : '上次维护日期',
					field : 'lastriqi'
				},
				{
					title : '维护日期',
					field : 'riqi'
				},
				{
					title : '下次维护日期',
					field : 'nextriqi'
				},
				{
					title : '使用年限',
					field : 'life'
				},
				{
					title : '本次年审日期',
					field : 'examine'
				},
				
				{
					title : '备注',
					field : 'remark'
				}
				] ]
			});
			// 设置分页控件
			top.$('#facdg').datagrid('getPager').pagination({
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