<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form id="dform">
		<input name="id" type="hidden"/>
		<table class="grid" style="width: 100%">
			<tr>
				<th>部门名称：<span style="color: red;">*</span></th>
				<td><input name="d_name" class="easyui-validatebox"
					data-options="required:true" style="width: 80%"></td>
				<th>上级单位：</th>
				<td><input id="CCTree" name="parentid" /></td>

			</tr>
			<tr>

				<th>部门类型：<span style="color: red;">*</span></th>
				<td><select class="easyui-combobox" name="d_type"
					data-options="required:true">
						<option value="公司">公司</option>
						<option value="部门">部门</option>
				</select></td>
				<th>部门排序：</th>
				<td><input class="easyui-numberspinner" name="d_order"
					style="width: 80px;" required="required"
					data-options="min:10,max:10000" value="10"></td>
			</tr>
			<tr>
				<th>负责人：<span style="color: red;">*</span></th>
				<td><input data-options="required:true" name="d_fuzeren"
					class="easyui-validatebox" style="width: 80%"></td>
				<th>联系电话：<span style="color: red;">*</span></th>
				<td><input data-options="required:true" name="d_tel"
					class="easyui-validatebox" style="width: 80%"></td>
			</tr>
			<tr>
				<th>邮箱：</th>
				<td><input class="easyui-validatebox"
					data-options="validType:'email'" name="d_email" type="text"
					style="width: 80%"></td>
				<th>传真：</th>
				<td><input name="d_fax" class="easyui-validatebox" type="text"
					style="width: 80%"></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td colspan="3"><input name="d_add" class="easyui-validatebox"
					style="width: 80%"></td>
			</tr>
			<tr>
				<th>描述：</th>
				<td colspan="3"><input name="d_miaoshu"
					class="easyui-validatebox" style="width: 80%"></td>
			</tr>
		</table>

	</form>
</body>
</html>