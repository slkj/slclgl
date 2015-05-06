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
		<input name="id" type="hidden" />
		<input name="uid" type="hidden" value="${userSession.id }" />
		<table class="grid" style="width: 100%">
			<tr>
				<th>使用类型：</th>
				<td colspan="3">
				<select class="easyui-combobox"  name="firm" style="width: 200px" data-options="required:'true'">
								<option value="邯郸安装">邯郸安装</option>
								<option value="邯郸使用">邯郸使用</option>
								<option value="石家庄安装">石家庄安装</option>
								<option value="石家庄使用">石家庄使用</option>
								<option value="廊坊专用">廊坊专用</option>
								<option value="抚宁专用">抚宁专用</option>
								<option value="山西专用">山西专用</option>
					</select></td>
			</tr>
			<tr>
				<th style="width: 100px">入网编号：</th>
				<td><input name="number" class="easyui-validatebox" style="width: 200px" data-options="required:'true'"></td>
				<th>测试日期：</th>
				<td><input name="riqi" class="easyui-datebox" editable="false"  style="width: 200px" data-options="required:'true'"></td>
			</tr>
			
			<tr>
				<th style="width: 100px">安检员：</th>
				<td><input name="inspector" class="easyui-validatebox" style="width: 200px" data-options="required:'true'"></td>
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