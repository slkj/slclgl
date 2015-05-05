<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加模块</title>
</head>
<body>

	<form id="dform" >
		<input name="uid" type="hidden" value="${userSession.id }" />
		<table class="grid" style="width: 100%">
			<tr>
				<th>使用地区：</th>
				<td colspan="3"><input name="address" class="easyui-validatebox" style="width: 260px"></td>
			</tr>
			<tr>
				<th style="width: 100px">入网编号：</th>
				<td><input name="number" class="easyui-validatebox" style="width: 200px"></td>
				<th>测试日期：</th>
				<td><input name="riqi" class="easyui-datebox" editable="false"  style="width: 200px"></td>
			</tr>
			
			<tr>
				<th style="width: 100px">安检员：</th>
				<td><input name="inspector" class="easyui-validatebox" style="width: 200px"></td>
			<th style="width: 100px">网监员：</th>
				<td><input name="wangjian" class="easyui-validatebox" style="width: 200px"></td>
			</tr>
			
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="remark"
					data-options="multiline:true" style="height: 60px;width: 90%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>