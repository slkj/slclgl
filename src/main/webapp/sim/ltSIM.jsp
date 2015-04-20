<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIM卡管理</title>
<%@ include file="/common/taglibs.jsp"%>

<script type="text/javascript">
	var grid;
	var basePath = "";
	$(function() {
		//初始化页面
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
			url : '../sim/list?type=1',
// 			title : '联通卡列表',
			fit : true,
			nowrap : true, //false:折行
			rownumbers : true, //行号
			striped : true, //隔行变色
			pagination : true,
			pageSize : 15,
			pageList : [ 1, 10, 15, 20, 30, 50 ],
			loadMsg : '数据加载中,请稍后……',
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'telnum',
				title : 'SIM号码'
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
				field : 'cardType',
				title : '卡类型'
			}, {
				field : 'business',
				title : '套餐业务'
			}, {
				field : 'kktime',
				title : '开卡日期'
			}, {
				field : 'renewtime',
				title : '续费日期'
			}, {
				field : 'intime',
				title : '录入日期'
			}, {
				field : 'lrr',
				title : '录入人'
			}, {
				field : 'gys',
				title : '供应商'
			}, {
				field : 'listnum',
				title : '序列号'
			}, {
				field : 'beizhu',
				title : '备注'
			}, {
				field : 'opt',
				title : '操作',
				align : 'center',
				formatter : function(value, row) {
					var s = "";
					s += "&nbsp;";
					s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('" + row.id + "');\">缴费</span></a>";
					s += "&nbsp;|&nbsp;";
					s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:editRow('" + row.id + "');\">编辑</span></a>";
					s += "&nbsp;|&nbsp;";
					s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('" + row.id + "');\">删除</span></a>";
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
			title : '联通SIM卡出入库信息',
			iconCls : 'icon-add',
			width : 550,
			height : 350,
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
					if (data) {
						grid.datagrid('reload'); // 重新载入所有行
						SL.closeWindow();
					}
				}
			});

		}
	}
</script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>入库时间从: <input id="intime" name="intime"
							class="easyui-datebox" style="width: 100px" editable="false">
							到: <input id="intime1" name="intime1" class="easyui-datebox"
							style="width: 100px"> 出库时间从: <input id="outtime"
							name="outtime" class="easyui-datebox" style="width: 100px"
							editable="false"> 到: <input id="outtime1" name="outtime"
							class="easyui-datebox" style="width: 100px">
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;使用状态: <select
							class="easyui-combobox" id="state" name="state"
							panelheight="auto" style="width: 100px">
								<option value="1">已用</option>
								<option value="0">未用</option>
						</select>
						</td>
						<td>卡类型 : <select class="easyui-combobox" id="cardType"
							name="cardType" panelheight="auto" style="width: 100px">
								<option value="GPRS卡">GPRS卡</option>
								<option value="短信卡">短信卡</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>开卡时间从: <input id="kktime" name="kktime"
							class="easyui-datebox" style="width: 100px"> 到: <input
							id="kktime1" name="kktime" class="easyui-datebox"
							style="width: 100px" editable="false"> 返回时间从: <input
							id="fhtime" name="fhtime" class="easyui-datebox"
							style="width: 100px"> 到: <input id="fhtime1"
							name="fhtime1" class="easyui-datebox" style="width: 100px"
							editable="false"></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;领用人：<input class="easyui-textbox"
							id="lyr" name="lyr" style="width: 150px">
						</td>
						<td><a id="search_btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:'true'">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onClick="javascript:addNew();">新增</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_221',plain:true"
					onClick="javascript:addNew();">开卡</a></td>
<!-- 				<td><div class="datagrid-btn-separator"></div></td> -->
<!-- 				<td><a href="#" class="easyui-linkbutton" -->
<!-- 					data-options="iconCls:'pic_22',plain:true" -->
<!-- 					onClick="javascript:addNew();">缴费</a></td> -->
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_48',plain:true"
					onClick="javascript:addNew();">返回</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_154',plain:true"
					onClick="javascript:addNew();">导入</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_157',plain:true"
					onClick="javascript:addNew();">导出</a></td>
			</tr>
		</table>
	</div>
	<table id="dg"></table>
</body>
</html>