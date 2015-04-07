<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备测试</title>
</head>
<body>

	<form id="form">
		<input name="id" type="hidden"/>
		<table class="grid">
			<tr>
				<th colspan="5" style="text-align: left;color: red;">*如有特殊情况请备注。</th>
			</tr>
			<tr>
				<th style="width: 100px">设   备 包  装：</th>
				<td colspan="3">
					<label><input name="pack" type="radio" value="0"  disabled="ture"/>全新</label>
					<label><input name="pack" type="radio" value="1" disabled="ture"/>返修</label> 
				</td>
				
			</tr>
			<tr>
				<th style="width: 100px">设   备 ID：</th>
				<td>
					<input name="listnum" class="easyui-numberbox" data-options="required:'true'" disabled="ture">
				</td>
				<th style="width: 100px">SIM 卡 号：</th>
				<td>
					<input name="phone" class="easyui-numberbox" data-options="required:'true'">
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
				<td><input name="model" class="easyui-textbox" disabled="ture"></td>
			</tr>
			<script type="text/javascript">
	            function selectAll(checkbox) {
	                $('input[type=checkbox]').prop('checked', $(checkbox).prop('checked'));
	            }
	        </script>
			<tr>
				<th>配件清单：</th>
				<td colspan="3">
					<label style="color: blue;"><input type="checkbox"onclick="selectAll(this);" />全选 </label>
					<label><input name="gsmtx" type="checkbox" value="良好" />Gsm天线</label> 
					<label><input name="gpstx" type="checkbox" value="良好" />Gps天线</label> 
					<label><input name="gpszj" type="checkbox" value="良好" />Gps主机</label> 
					<br/>
					<label><input name="dy" type="checkbox" value="良好" />电源线</label> 
					<label><input name="fsd" type="checkbox" value="良好" />防水袋</label> 
					<label><input name="jsq" type="checkbox" value="良好" />继电器</label> 
					<label><input name="sxy" type="checkbox" value="良好" />摄像头</label> 
					<label><input name="ysq" type="checkbox" value="良好" />扬声器</label> 
					<label><input name="mkf" type="checkbox" value="良好" />麦克风</label> 
			</tr>
			<tr>
				<th>是否测试 ：</th>
				<td>
					<label><input name="test" type="radio" value="1" />是</label> 
					<label><input name="test" type="radio" value="0" />否</label>
				</td>
				<th>测试结果：</th>
				<td>
					<label><input name="tresult" type="radio" value="1"  />定位</label> 
					<label><input name="tresult" type="radio" value="0" />不定位</label>
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