<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备入网</title>
</head>
<body>

	<form id="form">
		<input name="id" type="hidden"/>
		<table class="grid">
			<tr>
				<th colspan="5" style="text-align: left;color: red;">*如有特殊情况请备注。</th>
			</tr>
			<tr>
				<th style="width: 100px">设   备 ID：</th>
				<td>
					<input name="listnum" class="easyui-numberbox" data-options="required:'true'">
				</td>
				<th style="width: 100px">SIM 卡 号：</th>
				<td>
					<input name="phone" class="easyui-numberbox" data-options="required:'true'" disabled="ture">
				</td>
			</tr>
			<tr>
				<th>设备厂商：</th>
				<td width="150px">
					<select class="easyui-combobox"  name="firm" panelheight="auto" style="width: 100%" disabled="ture">
						<option value="珠海天琴">珠海天琴</option>
						<option value="华宝">华宝</option>
						<option value="博实杰">博实杰</option>
					</select>
				</td>
				<th>厂牌型号：</th>
				<td><input name="model" class="easyui-textbox" disabled="ture"/></td>
			</tr>
			<tr>
				<th>安装人：</th>
				<td width="150px">
					<input name="installers" class="easyui-validatebox" data-options="required:'true'"/>
				</td>
				<th>安装时间 ：</th>
				<td><input name="installtime" class="easyui-datebox" data-options="required:'true'"/></td>
			</tr>
				<tr>
				<th>车牌号：</th>
				<td width="150px">
					<input name="carNumber" class="easyui-validatebox" data-options="required:'true'"/>
				</td>
				<th>入网证明编号 ：</th>
				<td><input name="networkNo" class="easyui-validatebox" data-options="required:'true'"/></td>
			</tr>
				<tr>
				<th>使用公司：</th>
				<td colspan="3">
					<select class="easyui-combobox"  name="company" panelheight="auto" style="width: 100%" data-options="required:'true'">
						<option value="华鑫">华鑫</option>
						<option value="华恒">李磊</option>
						<option value="博实杰">代辉</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="remark"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
			<tr>
		</table>
	</form>
</body>
</html>