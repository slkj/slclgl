<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="roleForm">
		<input name="id" type="hidden">
		<table class="grid">
			<tr>
				<th style="width: 100px">角色名称：</th>
				<td><input name="name" class="easyui-textbox" data-options="required:'true'" style="width: 330px"></td>
			</tr>
			<tr>
				<th>排序：</th>
				<td><input type="text" class="easyui-numberbox" value="99" name="sort"></input>  </td>
			</tr>
			<tr>
				<th>描述：</th>
				<td><input class="easyui-textbox" name=dscript data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>