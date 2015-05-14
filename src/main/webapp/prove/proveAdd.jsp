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
				<th>使用类型：</th>
				<td>
				<select class="easyui-combobox"  name="ustype" style="width: 200px" data-options="required:'true'">
								<option value="邯郸安装">邯郸安装</option>
								<option value="邯郸使用">邯郸使用</option>
								<option value="石家庄安装">石家庄安装</option>
								<option value="石家庄使用">石家庄使用</option>
								<option value="廊坊专用">廊坊专用</option>
								<option value="抚宁专用">抚宁专用</option>
								<option value="山西专用">山西专用</option>
					</select>
					</td>
					<th>添加类型：</th>
					<td >
					<label><input name="addType" type="radio" value="0"  checked="checked" onclick="closedDiv()"/>单个加</label>
					<label><input name="addType" type="radio" value="1" onclick="showDiv()"/>批量加</label> 
				</td>
			</tr>
			<tr>
				<th style="width: 100px">入网编号：</th>
				<td colspan="3">
				<div id="listnum" style="display: block;">
				<input name="number" class="easyui-validatebox" style="width: 200px" data-options="required:'true'">
				</div>
				<div id="listdiv" style="display: none;">
						<input name="listNo" class="easyui-validatebox" data-options="required:'true'" style="width: 200px">
						<br/>（不包括后四位，例如"CX201005031234"请输入"CX20100503"）
						<br/>	
						<input name="listnum_begin" class="easyui-validatebox" data-options="required:'true'" style="width: 100px">
						- 
						<input name="listnum_end" class="easyui-validatebox"  data-options="required:'true'" style="width: 100px">
					</div></td>
				
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