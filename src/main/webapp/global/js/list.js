var url = "../global/list";
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
					if (row.endriqi != null) {
						var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss",DateUtil.dateAdd('d',30,new Date()));
						if(row.endriqi < curDate){
							return 'color:#FF4040;font-weight:bold;';
						}
						return;
					}
					
				},
				columns : [ [
						{
							title : '车牌号',
							field : 'carNumber',
							formatter : function(value, row) {
								return '<a id="' + row.id
										+ '" href="javascript:void(0);" onclick="view(\'' + row.vid
										+ '\')">' + value + '</a> ';
							}
						},
						{
							title : '运营商',
							field : 'facilitator'
						},
						{
							title : '终端ID',
							field : 'zdid'
						},
						{
							title : '终端型号',
							field : 'zdtype'
						},
						{
							title : 'SIM卡',
							field : 'facilitator'
						},
						{
							title : '安装单位',
							field : 'install'
						},
						{
							title : '安装人',
							field : 'installer'
						},
						{
							title : '安装日期',
							field : 'installriqi'
						},
						{
							title : '维保日期',
							field : 'endriqi'
						},
						{
							title : '安装证明编号',
							field : 'azzm'
						},
						{
							title : '证明编号',
							field : 'qzsyzm'
						},
						{
							title : '备注',
							field : 'remark'
						},
						{
							title : '是否到期',
							field : 'status',
							formatter : function(value, row) {
								if (row.endriqi != null) {
									var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss",DateUtil.dateAdd('d',30,new Date()));
									if(row.endriqi < curDate){
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
								if (row.zdid != null) {
									
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
				url : '../global/delete?id=' + obj.id,
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
		title : '添加',
		iconCls : 'icon-add',
		width : 750,
		height : 500,
		url : 'add.jsp',
		onLoad : function() {
			// ajax查询单个信息，form回填数据
			$.ajax({
				url : '../vehicle/queryOne?id=' + obj.vId,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#form").form('load', data);
						$("#vid").val(data.id);alert($("#vid").val());
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
				var url = '../global/saveGlobal';
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
		title : '编辑',
		iconCls : 'icon-edit',
		width : 750,
		height : 500,
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
				url : '../global/queryOne?id=' + obj.id,
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
				var url = '../global/editGlobal';
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

function listByCar(){
	if (!checkRows()) {
		return;
	}
	var obj = checkRows();
	if (obj.id == null) {
		top.$.messager.alert('提示', '该车辆没有历史记录信息。');
		return;
	}
	SL.showWindow({
		title : '历史记录',
		iconCls : 'icons_26',
		width : 750,
		height : 500,
		url : 'global/record.jsp',
		onLoad : function() {
			top.$('#facdg').datagrid({
				url : 'global/listByVid?vId=' + obj.vid,
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
					title : '运营商',
					field : 'facilitator'
				},
				{
					title : '终端ID',
					field : 'zdid'
				},
				{
					title : '终端型号',
					field : 'zdtype'
				},
				{
					title : 'SIM卡',
					field : 'facilitator'
				},
				{
					title : '安装单位',
					field : 'install'
				},
				{
					title : '安装人',
					field : 'installer'
				},
				{
					title : '安装日期',
					field : 'installriqi'
				},
				{
					title : '维保日期',
					field : 'endriqi'
				},
				{
					title : '安装证明编号',
					field : 'azzm'
				},
				{
					title : '证明编号',
					field : 'qzsyzm'
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