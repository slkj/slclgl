<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备出入库信息</title>
</head>
<body>

	<form id="form">
		<input name="id" type="hidden"/>
		<table class="grid">
			<tr>
				<th colspan="5" style="text-align: left;color: red;">*如有特殊情况请备注。</th>
			</tr>
			<tr>
				<th>所在地区：</th>
				<td colspan="3">
<!-- 					 <select class="easyui-combotree" url="../data/city_data.json" -->
<!-- 					  name="area" style="width:260px;" data-options="lines:'true',required:'true'"></select> -->
					<input id="txtarea" name="area"/>  
					<span style="color: red;">*设备使用地区</span>
				</td>
			</tr>
			<tr>
				<th style="width: 100px">设备包装：</th>
				<td>
					<label><input name="pack" type="radio" value="0"  disabled="ture"/>全新</label>
					<label><input name="pack" type="radio" value="1"  disabled="ture" />返修</label> 
				</td>
				<th style="width: 100px">设   备 ID：</th>
				<td>
					<input name="listnum" class="easyui-numberbox" data-options="required:'true'" disabled="ture"/>
				</td>
			</tr>
			<tr>
				<th>设备厂商：</th>
				<td width="150px">
					<input name="firm" class="easyui-textbox" disabled="ture"/>
				</td>
				<th>厂牌型号：</th>
				<td><input name="model" class="easyui-textbox" disabled="ture"/></td>
			</tr>
			<tr>
				<th>配件清单：</th>
				<td colspan="3">
					<label><input name="gsmtx" type="checkbox" value="良好" disabled="ture"/>Gsm天线</label> 
					<label><input name="gpstx" type="checkbox" value="良好" disabled="ture"/>Gps天线</label> 
					<label><input name="gpszj" type="checkbox" value="良好" disabled="ture"/>Gps主机</label> 
					<label><input name="dy" type="checkbox" value="良好" disabled="ture"/>电源线</label> 
					<br/>
					<label><input name="fsd" type="checkbox" value="良好" disabled="ture"/>防水袋</label> 
					<label><input name="jsq" type="checkbox" value="良好" disabled="ture"/>继电器</label> 
					<label><input name="sxy" type="checkbox" value="良好" disabled="ture"/>摄像头</label> 
					<label><input name="ysq" type="checkbox" value="良好" disabled="ture"/>扬声器</label> 
					<label><input name="mkf" type="checkbox" value="良好" disabled="ture"/>麦克风</label> 
			</tr>
			<tr>
				<th>是否测试 ：</th>
				<td>
					<label><input name="test" type="radio" value="1" disabled="ture"/>是</label> 
					<label><input name="test" type="radio" value="0" disabled="ture"/>否</label>
				</td>
				<th>测试结果：</th>
				<td>
					<label><input name="tresult" type="radio" value="1"  disabled="ture"/>定位</label> 
					<label><input name="tresult" type="radio" value="0" disabled="ture"/>不定位</label>
				</td>
			</tr>
			<tr>
				<th>领用人：</th>
				<td width="150px">
<!-- 					<select class="easyui-combobox"  name="lyr" panelheight="auto" style="width: 100%" data-options="required:'true'"> -->
<!-- 						<option value="马续辉">马续辉</option> -->
<!-- 						<option value="李磊">李磊</option> -->
<!-- 						<option value="代辉">代辉</option> -->
<!-- 					</select> -->
					<input name="lyr" class="easyui-validatebox" data-options="required:true">
				</td>
				<th>领用时间 ：</th>
				<td><input name="lytime" class="easyui-datebox" data-options="required:'true'"/></td>
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