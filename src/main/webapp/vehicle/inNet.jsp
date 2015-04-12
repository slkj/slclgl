<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆入网</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
var carid= "5";
</script>
</head>
<body>
	<form id="form" metdod="post">
		<input id="carid" type="hidden" name="id" value="7">
		<div class="easyui-accordion"data-options="border:false">
			<div title="设备信息" data-options="collapsed:false,collapsible:false,border:false">
				<table >
					<tr>
						<th>设备号:</th>
						<td>
							<input name="equitment" class="easyui-combobox" style="width: 200px;" 
								data-options="loader: sbloader,mode: 'remote',valueField: 'id',textField: 'name',required:true"/></td>
						<th>SIM卡号:</th>
						<td>
							<input name="simNumber" class="easyui-combobox"  style="width: 200px;" 
								data-options="loader: btsloader,mode: 'remote',valueField: 'id',textField: 'name',required:true" />
						</td>
					</tr>
					<tr>
						<th>入网证明编号:</th>
						<td><input name="networkNo" class="easyui-validatebox" style="width: 200px;" data-options="required:true"/></td>
						<th>安装人:</th>
						<td><input name="installers" class="easyui-validatebox" style="width: 200px;" data-options="required:true"/></td>
					</tr>
					<tr>
						<th>安装日期:</th>
						<td><input name="installtime" class="easyui-datebox" style="width: 200px;" data-options="required:true"/></td>
						<th>安装地点:</th>
						<td><input name="installAddress" class="easyui-validatebox" style="width: 200px;" /></td>
					</tr>
				</table>
			</div>
			<div title="服务信息" data-options="collapsed:false,collapsible:false,border:false">
				<table >
					<tr>
						<th>服务费:</th>
						<td><input name="fees" class="easyui-numberbox" style="width: 200px;" data-options="min:0,precision:2,prefix:'￥'"/> (元/月)</td>
						<th>服务到期时间:</th>
						<td><input name="feeseEnd" class="easyui-datebox" style="width: 150px;"/> 
							<label><input id="ckISnotice" type="checkbox" name="ckISnotice">到期提醒</label>
						</td>
					</tr>
					<tr>
						<th>SIM卡缴费人 :</th>
						<td><input name="simPayer" class="easyui-validatebox" style="width: 200px;" /></td>
						<th>缴费时间:</th>
						<td><input name="payerTime" class="easyui-datebox" style="width: 150px;" />  
						</td>
					</tr>
				</table>
			</div>
			<div title="行业信息" data-options="collapsed:false,collapsible:false,border:false">
				<table >
					<tr>
						<th>营运线路:</th>
						<td><input name="CTradingLine" class="easyui-validatebox"  style="width: 200px;" /></td>
						<th>载客数:</th>
						<td><input id="CCatchMenbers" name="regNum"
							class="easyui-validatebox" style="width: 150px;" /></td>
					</tr>
				</table>
				<table >
					<tr>
						<th>备注:</th>
						<td colspan="3"><textarea rows="3" cols="30" name="remark" style="width:500px;"></textarea></td>
					</tr>
				</table>
			</div>
		</div>


	</form>
</body>
</html>