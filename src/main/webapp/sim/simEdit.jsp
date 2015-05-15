<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加模块</title>
</head>
<body>

	<form id="uform">
		<input name="lrr" type="hidden" value="${userSession.username }" /> <input
			name="state" type="hidden" /> <input id="type" name="type"
			type="hidden" /> <input name="id" type="hidden" />
		<table class="grid" style="width: 100%">
			<tr>
				<th colspan="4" style="text-align: left; color: red;">*请检查SIM卡号是否已存在，已存在数据将重复无法保存。</th>
			</tr>
			<tr>
				<th>SIM卡号：</th>
				<td><input name="telnum" class="easyui-validatebox"
					data-options="required:true,validType:'Mobile'"
					style="width: 260px"></td>
			</tr>
			<tr>
				<th>供应商：</th>
				<td><input name="gys" class="easyui-textbox"
					style="width: 260px"></td>
			</tr>
			<tr>
				<th style="width: 100px">序列号：</th>
				<td><input name="listnum" class="easyui-validatebox"
					style="width: 260px"></td>
			</tr>
			<tr>
				<th>开卡日期：</th>
				<td><input name="kktime" class="easyui-datebox"
					editable="false"></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td><input class="easyui-textbox" name="beizhu"
					data-options="multiline:true" style="height: 60px; width: 80%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>