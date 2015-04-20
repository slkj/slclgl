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
		<input name="lrr" type="hidden" value="${userSession.username }" />
		<input name="state" type="hidden" value="0" />
		<input id="type" name="type" type="hidden"  />
		<table class="grid">
			<tr>
				<th colspan="4" style="text-align: left;color: red;">*请检查SIM卡号是否已存在，已存在数据将重复无法保存。</th>
			</tr>
			<tr>
				<th>SIM卡号：</th>
				<td><input name="telnum" class="easyui-validatebox" data-options="required:true,validType:'Mobile'"></td>
				<th>序列号：</th>
				<td><input name="listnum" class="easyui-validatebox"></td>
			</tr>
			<tr>
				<th style="width: 80px">卡类型：</th>
				<td><select class="easyui-combobox"  name="cardType" panelheight="auto">
						<option value="GPRS卡">GPRS卡</option>
						<option value="短信卡">短信卡</option>
				</select></td>
				<th>套餐业务：</th>
				<td>
					<select class="easyui-combobox" id="business" name="business" panelheight="auto" >
						<option value="30MB">30MB/月</option>
						<option value="50MB">50MB/月</option>
						<option value="300条">300条/月</option>
						<option value="500条">500条/月</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>供货商：</th>
				<td colspan="3"><input name="gys" class="easyui-textbox"style=" width: 260px"></td>
			</tr>
			<tr>
				<th>开卡日期：</th>
				<td><input name="kktime" class="easyui-datebox" editable="false" ></td>
				<th>续费日期：</th>
				<td><input name="renewtime" class="easyui-datebox" editable="false" data-options="required:'true'"></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="beizhu"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>