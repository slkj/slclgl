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
		<input name="lrr" type="hidden" value="admin" />
		<input id="type" name="type" type="hidden"  />
		<table class="grid">
			<tr>
				<th colspan="5" style="text-align: center;">入库信息</th>
			</tr>
			<tr>
				<th style="width: 80px">卡类型：</th>
				<td><select class="easyui-combobox" id="Category"
					name="cardType" panelheight="auto" style="width: 100px">
						<option value="GPRS卡">GPRS卡</option>
						<option value="短信卡">短信卡</option>
				</select></td>
				<th>供应商：</th>
				<td><input name="gys" class="easyui-textbox"></td>
			</tr>
			<tr>
				<th>序列号：</th>
				<td><input name="listnum" class="easyui-validatebox"
					data-options="required:'true',validType:'Number'"></td>
				<th>卡号：</th>
				<td><input name="telnum" class="easyui-validatebox"
					data-options="required:true,validType:'Mobile'"></td>
			</tr>
			<tr>
				<th>入库日期：</th>
				<td><input name="intime" class="easyui-datebox"
					editable="false"></td>
				<th>开卡日期：</th>
				<td><input name="kktime" class="easyui-datebox"
					editable="false"></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="beizhu"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
			<tr>
				<th colspan="5" style="text-align: center;">出库信息</th>
			</tr>
			<tr>
				<th>出库时间 ：</th>
				<td><input name="outtime" class="easyui-datebox"
					editable="false"></td>
				<th>领用人 ：</th>
				<td><input name="lyr" class="easyui-datebox" editable="false"></td>
			</tr>
			<tr>
				<th>返回时间：</th>
				<td><input name="fhtime" class="easyui-datebox"
					editable="false"></td>
			</tr>
		</table>
	</form>
</body>
</html>