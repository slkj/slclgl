<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆入网</title>
</head>
<body>
	<form id="dform" metdod="post">
		<input id="id" name="id" type="hidden" /> 
		<table class="grid">
			<tr>
				<th>服务运营商:</th>
				<td colspan="3"><select class="easyui-combobox"
					name="facilitator" style="width: 200px;">
						<option value="神龙科技" selected="selected">神龙科技</option>
						<option value="启明信息技术">启明信息技术</option>
				</select></td>
			</tr>
			<tr>
				<th style="width: 120px">设备号:</th>
				<td style="width: 280px"><input name="equitment"
					class="easyui-combobox" style="width: 200px;"
					data-options="loader: sbloader,mode: 'remote',valueField: 'id',textField: 'name',required:true" /></td>
				<th style="width: 120px">SIM卡号:</th>
				<td style="width: 280px"><input name="simNumber"
					class="easyui-combobox" style="width: 200px;"
					data-options="loader: btsloader,mode: 'remote',valueField: 'id',textField: 'name',required:true" />
				</td>
			</tr>
			<tr>
				<th>入网证明编号:</th>
				<td><input name="networkNo" class="easyui-textbox"
					style="width: 200px;" data-options="required:true" /></td>
				<th>安装证明编号:</th>
				<td><input name="azzm" class="easyui-textbox"
					style="width: 200px;" /></td>
			</tr>
			<tr>
				<th>安装人:</th>
				<td><input name="installer" class="easyui-textbox"
					style="width: 200px;" data-options="required:true" /></td>

				<th>安装日期:</th>
				<td><input name="installtime" class="easyui-datebox"
					style="width: 200px;" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>安装地点:</th>
				<td colspan="3"><input name="insAdderss" class="easyui-textbox"
					style="width: 80%;" /></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>服务费:</th> -->
<!-- 				<td style="width: 280px"><input name="fees" -->
<!-- 					class="easyui-numberbox" style="width: 170px;" -->
<!-- 					data-options="min:0,precision:2,prefix:'￥'" /> (元/月)</td> -->
<!-- 				<th>缴费时间:</th> -->
<!-- 				<td><input id="payerTime" name="payerTime" -->
<!-- 					class="easyui-datebox" style="width: 150px;" /></td> -->
<!-- 			</tr> -->
			<tr>
				<th>SIM卡缴费人 :</th>
				<td><input name="simPayer" class="easyui-textbox"
					style="width: 200px;" /></td>
				<th>检验有效期至:</th>
				<td style="width: 280px"><input name="endriqi"
					class="easyui-datebox" style="width: 150px;"
					data-options="required:true" /> <!-- 					<label> <input id="ckISnotice" type="checkbox" name="ckISnotice">到期提醒</label> -->
				</td>
			</tr>
			<tr>
				<th>备注:</th>
				<td colspan="3"><textarea rows="3" cols="20" name="remark"
						style="width: 80%;"></textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>