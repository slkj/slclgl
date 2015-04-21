<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>年检记录信息</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/transport.js"></script>
</head>
<body>
	<table id="grid"></table>
	<div id="toolbar" style="padding: 5px; height: auto">
		<form id="searchForm">
			<table>
				<tr>
					<td>车牌号:</td>
					<td><input id="carNumber" name="carNumber" style="width: 100px;" />
					</td>
					<td>公司名称:</td>
					<td><input id="regCompanyId" name="regCompanyId" style="width: 100px;" />
					</td>
					<td>年检日期:</td>
					<td>
						<input class="Wdate" type="text" id="endDate"  onClick="WdatePicker()"/>至
						<input class="Wdate" type="text" id="endDate1"  onClick="WdatePicker()"/>
					</td>
					<td><a id="btn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'">查询</a>
				</tr>
			</table>
		</form>
		<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:addFun();">添加</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right">
						<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
					</td>
				</tr>
			</table>
		<!-- <table id="toolbars" cellspacing="0" cellpadding="0"></table>
		<div style="color: #F00">【①点击车牌号查询车辆详细信息，②红色标记是需要审验的车辆】</div> -->
	</div>
</body>
</html>