<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备出入库信息</title>
</head>
<body>

	<form id="dform">
	<input id="id" name="id" type="hidden" />
		<table class="grid" style="width: 100%">
			
			<tr>
				<th>使用地区：</th>
				<td colspan="3">
					<input id="address1" name="address"/>  
					<span style="color: red;">*证明使用地区</span>
				</td>
			</tr>
			<tr>
				<th>领用人：</th>
				<td width="150px">
					<input id="usman" name="usman" class="easyui-validatebox" data-options="required:true">
				</td>
				<th>领用时间 ：</th>
				<td><input id="usriqi" name="usriqi" class="easyui-datebox" data-options="required:'true'"/></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" id="remark" name="remark"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
			<tr>
		</table>
	</form>
</body>
</html>