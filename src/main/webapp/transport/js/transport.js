var url = "../transport/list";
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
					if (row.endDate != null) {
						var curDate = DateUtil.dateToStr("yyyy-MM-dd HH:mm:ss",DateUtil.dateAdd('d',30,new Date()));
						if(row.endDate < curDate){
							return 'color:#FF4040;font-weight:bold;';
						}
						return;
					}
				},
				columns : [ [
						{
							title : '车牌号',
							field : 'carNumber'
						},
						{
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
						},
						{
							title : '冀交运管号(含字)',
							field : 'traCode',
								formatter : function(value, row) {
									if(row.traWord+row.traCode==0)
										return "";
									return row.traWord+row.traCode;
								}
						},
						{
							title : '经营许可证',
							field : 'traBusLicNo'
						},
						{
							title : '经营许可证核发日期',
							field : 'traBusLicDate'
						},
						{
							title : '经济类型',
							field : 'traEcoType'
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
							title : '备注',
							field : 'remark'
						},
						
						{
							title : '操作',
							field : '_operate',
							align : 'center',
							formatter : function(value, row, index) {
								var s = "";
								
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:addFun('" + row.vId + "');\">运输证</span></a>";
									s += "&nbsp;|&nbsp;";
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:derRecord('" + index + "');\">审验</span></a>";
									s += "&nbsp;|&nbsp;";
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:facRecord('" + row.vId + "');\">审验记录</span></a>";
									s += "&nbsp;|&nbsp;";
									
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editFun('" + index + "');\">编辑</span></a>";
									s += "&nbsp;|&nbsp;";
									s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:delFun('" + index + "');\">删除</span></a>";
							
								return s;
							}
						} ] ],
				toolbar : "#toolbar",
				onLoadSuccess : function() {
					$('#grid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					
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
	top.$.messager.confirm('提示', '将删除该车辆运输证所有信息，确认删除?', function(row) {
		if (row) {
			$.ajax({
				url : '../transport/delete?id=' + obj.id,
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
function addFun(vid) {
	
	SL.showWindow({
		title : '添加车辆运输证信息',
		iconCls : 'icon-add',
		width : 600,
		height : 400,
		url : 'add.jsp',
		onLoad : function() {
			$("#vId").val(vid);
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				var url = '../transport/saveTransport';
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
		top.$.messager.alert('提示', '该车辆没有运输证信息，请录入运输证信息。');
		return;
	}
	SL.showWindow({
		title : '编辑车辆运输证信息',
		iconCls : 'icon-edit',
		width : 600,
		height : 400,
		url : 'edit.jsp',
		onLoad : function() {
			
			$.ajax({
				url : '../transport/queryOne?id=' + obj.id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$("#dform").form('load', data);
						$("#introd").innerText=data.introd;
					}
				}
			});

		},
		buttons : [ {
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				var url = '../transport/editTransport';
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

// 车辆审验信息
function derRecord(index) {
	var obj = $('#grid').datagrid('getData').rows[index];
	if (obj.id == null) {
		top.$.messager.alert('提示', '该车辆没有运输证信息。');
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
				url : '../transport/queryOne?id=' + obj.id,
				async : false,
				cache : false,
				success : function(data) {
					if (data) {
						$('#vId').val(data.vId);
						$('#traWord').val(data.traWord);
						$('#traCode').val(data.traCode);
						$('#traEcoType').val(data.traEcoType);
						$('#traBusLicNo').val(data.traBusLicNo);
						$('#traBusLicDate').datebox({value: data.traBusLicDate});
					}
				}
			});
		},
		buttons : [ {
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				var url = '../transport/saveTransport';
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
function facRecord(vid) {
	
	SL.showWindow({
		title : '运输证审验信息',
		iconCls : 'icons_26',
		width : 650,
		height : 400,
		url : 'record.jsp',
		onLoad : function() {
			$('#facdg').datagrid({
				url : '../transport/listByVid?vId=' + vid,
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
					title : '车牌号'
				},{
					title : '冀交运管字',
					field : 'traWord'
				},
				{
					title : '冀交运管号',
					field : 'traCode'
				},
				{
					title : '经营许可证',
					field : 'traBusLicNo'
				},
				{
					title : '经营许可证核发日期',
					field : 'traBusLicDate'
				},
				{
					title : '经济类型',
					field : 'traEcoType'
				}, {
					field : 'testOrgan',
					title : '检测机关'
				}, {
					field : 'endDate',
					title : '到期日期'
				} ] ]
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