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
		<input id="id" name="id" type="hidden" />
		<table class="grid">
			<tr>
				<th style="width: 80px">资源名称：</th>
				<td><input name="name" style="width: 300px"
					class="easyui-textbox" data-options="required:true"></td>
			</tr>
			<tr>
				<th>上级菜单：</th>
				<td><input id="cc" value="01" name="parent_id"
					style="width: 300px"></td>
			</tr>
			<tr>
				<th>资源路径：</th>
				<td><input class="easyui-textbox" name="url"
					style="width: 300px"></td>
			</tr>
			<tr>
				<th>图标：</th>
				<td><input class="easyui-textbox" name="icon"
					style="width: 300px"></td>
			</tr>
			<tr>
				<th>顺序：</th>
				<td><input type="text" name="priority" class="easyui-numberbox" value="99" data-options="min:0"></input></td>
			</tr>
			<tr>
				<th>说明：</th>
				<td>
					<input class="easyui-textbox" name="description" data-options="multiline:true" style="height: 60px; width:300px"></input>	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>