<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险记录信息</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/list.js"></script>
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
					<td>所属公司:</td>
					<td><input id="regCompanyId" name="regCompanyId" style="width: 100px;" />
					</td>
					<td>保险到期时间:</td>
					<td>
						<input id="endDate" name="endDate"	class="easyui-datebox" editable="false" />至
							<input id="endDate1" name="endDate1" class="easyui-datebox" editable="false" />
					</td>
					<td><a id="btn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'">查询</a>
						<a href="#"
						onclick="outExcel()" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_157'">导出</a>
				</tr>
				<tr>
					<td colspan="7"><span style="color: #F00">【红色标记是保险到期的车辆，提前30天提醒。】</span></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>