<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备出入库信息</title>
</head>
<body>

	<form id="uform">
		<input name="state" value="2" type="hidden"/>
		<table class="grid">
			<tr>
				<th colspan="5" style="text-align: center;">入库信息</th>
			</tr>
			<tr>
				<th style="width: 80px">设   备 ID：</th>
				<td>
					<input name="listnum" class="easyui-validatebox" data-options="required:'true'">
				</td>
				<th>入库时间：</th>
				<td>
					<input id="rktime" name="rktime" class="easyui-datebox" required="true" editable="false"></input>
				</td>
			</tr>
			<tr>
				<th>设备厂商：</th>
				<td>
					<select class="easyui-combobox"  name="firm" panelheight="auto" style="width: 100%">
						<option value="珠海天琴">珠海天琴</option>
						<option value="华宝">华宝</option>
					</select>
				</td>
				<th>厂牌型号：</th>
				<td><input name="model" class="easyui-textbox"></td>
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
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="remark"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
			<tr>
				<th colspan="5" style="text-align: center;">出库信息</th>
			</tr>
			<tr>
				<th>出库时间：</th>
				<td><input name="lytime" class="easyui-datebox" editable="false"></td>
				<th>领用人 ：</th>
				<td><input name="lyr" class="easyui-textbox"></td>
			</tr>
			<tr>
				<th>返回时间：</th>
				<td><input name="fhtime" class="easyui-datebox" editable="false"></td>
			</tr>
		</table>
	</form>
</body>
</html>