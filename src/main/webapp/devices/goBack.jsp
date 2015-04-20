<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备出入库信息</title>
</head>
<body>
	<form id="form">
		<input id="back_id" name="id" type="hidden" /> 
		<input name="state" value="3" type="hidden" />
		<table class="grid" style="width: 100%">
			<tr>
				<th style="width: 100px">返回时间：</th>
				<td><input id="riqi" type="text" name="fhtime"
					onfocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					class="Wdate" style="width: 200px" /></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td><input class="easyui-textbox" name="remark"
					data-options="multiline:true" style="height: 60px; width: 80%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>