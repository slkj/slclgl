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
		<input name="state" value="2" type="hidden"/>
		<table class="grid" style="width: 100%">
			<tr>
				<th colspan="4" style="text-align: left;color: red;">*请检查设备ID、SIM卡号、入网证明编号是否已存在，已存在数据将重复无法保存。</th>
			</tr>
			<tr>
				<th style="width: 100px">设备包装：</th>
				<td>
					<label><input name="pack" type="radio" value="0"  checked="checked"/>全新</label>
					<label><input name="pack" type="radio" value="1" />返修</label> 
				</td>
				<th style="width: 100px">设备包装：</th>
				<td >
					<label><input name="addType" type="radio" value="0"  checked="checked" onclick="closedDiv()"/>单个加</label>
					<label><input name="addType" type="radio" value="1" onclick="showDiv()"/>批量加</label> 
				</td>
			</tr>
			<tr>
				<th style="width: 100px">设备ID：</th>
				<td  colspan="3" >	
					<div id="listnum" style="display: block;">
						<input id="listnum"  name="listnum" class="easyui-validatebox" data-options="required:'true'" style="width: 200px;">
					</div>
					<div id="listdiv" style="display: none;">
						<input name="listNo" class="easyui-validatebox" data-options="required:'true'" style="width: 200px">
						<br/>（不包括后四位，例如"CX201005031234"请输入"CX20100503"）
						<br/>	
						<input name="listnum_begin" class="easyui-validatebox" data-options="required:'true'" style="width: 100px">
						- 
						<input name="listnum_end" class="easyui-validatebox"  data-options="required:'true'" style="width: 100px">
					</div>
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th style="width: 100px">设   备 ID：</th> -->
<!-- 				<td> -->
<!-- 					<input name="listnum" class="easyui-numberbox" data-options="required:'true'"> -->
<!-- 				</td> -->
<!-- 				<th style="width: 100px">SIM 卡 号：</th> -->
<!-- 				<td> -->
<!-- 					<input id="phone" name="phone" class="easyui-combobox"  -->
<!-- 					data-options="loader: btsloader,mode: 'remote',valueField: 'id',textField: 'name'" /> -->
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<th>设备厂商：</th>
				<td>
					<select class="easyui-combobox"  name="firm"  style="width: 100%" data-options="required:'true'">
								<option value="神龙">神龙</option>
								<option value="华宝">华宝</option>
								<option value="博实结">博实结</option>
								<option value="鸿泉">鸿泉</option>
								<option value="中斗">中斗</option>
								<option value="赛格">赛格</option>
								<option value="航天无线">航天无线</option>
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
<!-- 			<tr> -->
<!-- 				<th>是否测试 ：</th> -->
<!-- 				<td> -->
<!-- 					<label><input name="test" type="radio" value="1" />是</label>  -->
<!-- 					<label><input name="test" type="radio" value="0" />否</label> -->
<!-- 				</td> -->
<!-- 				<th>测试结果：</th> -->
<!-- 				<td> -->
<!-- 					<label><input name="tresult" type="radio" value="1" />定位</label>  -->
<!-- 					<label><input name="tresult" type="radio" value="0" />不定位</label> -->
<!-- 				</td> -->
<!-- 			</tr> -->
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