<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑车辆二级维护信息</title>
<%-- <%@ include file="/common/taglibs.jsp"%> --%>
</head>
<body>
	<div id="aa" class="easyui-tabs" data-options="border:false">
		<div title=车辆信息>
			<!-- 车辆信息 开始-->
			<form id="form" method="post">
				<table class="grid">
					<tr>
						<th width="100px">号牌号码：</th>
						<td width="150px"><label id="carNumber"></label></td>
						<th width="100px">车辆类型：</th>
						<td width="150px"><label id="cllx"></label></td>
					</tr>
					<tr>
						<th>业户名称：</th>
						<td colspan="3"><label id="regCompanyName"></label></td>
					</tr>
					<tr>
						<th>地址：</th>
						<td colspan="3"><label id="address"></label></td>
					</tr>
					<tr>
						<th>使用性质：</th>
						<td><select class="easyui-combobox" name="carUseNatu"
							data-options="readonly:true" style="width: 120px">
								<option></option>
								<option value="001">公路客运</option>
								<option value="002">货运</option>
								<option value="003">公交客运</option>
								<option value="004">出租客运</option>
								<option value="005">旅游客运</option>
								<option value="006">非营运</option>
						</select></td>
						<th>品牌型号：</th>
						<td><label id="ppxh"></label></td>
					</tr>
					<tr>
						<th>车辆识别代号：</th>
						<td><label id="carVin"></label></td>

						<th>发动机号：</th>
						<td><label id="carEngNum"></label></td>
					</tr>
					<tr>
						<th>核定人数：</th>
						<td><label id="carApprGuest"></label>人</td>
						<th>总质量：</th>
						<td><label id="carTotalmass"></label>kg</td>
					</tr>
					<tr>
						<th>外廓尺寸：</th>
						<td><label id="wkcc" type="text"></label>&nbsp;&nbsp;mm</td>
						<th>准牵引总质量：</th>
						<td><label id="carTrac"></label>kg</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 车辆信息 结束-->
		<div title="二级维护信息" selected="true">
			<form id="dform" method="post">
				<input id="id" name="id" type="hidden" /> 
				<input id="vid" name="vId" type="hidden" /> 
				<!-- 二级维护信息 开始-->
				<table class="grid" id="drivingtab">
						<tr>
						<th width="100px">入网证明编号：</th>
						<td width="250px"><input name="qzsyzm" class="easyui-validatebox"  data-options="required:true" /></td>
						<th width="100px">状态：</th>
						<td width="250px">
							&nbsp;&nbsp;
							<label> 
								<input type="radio" id="sbqz" name="qzsy" value="0"/>前置
							</label> 
							&nbsp;&nbsp;
							<label for="sbsy"> 
								<input type="radio" id="sbsy" name="qzsy" value="1" checked="checked"/>使用
							</label> 
   							
						</td>
					</tr>
					<tr>
						<th>运&nbsp;&nbsp;营&nbsp;&nbsp;商：</th>
						<td> <input name="facilitator" class="easyui-validatebox"  data-options="required:true" /> </td>
						<th>服务电话：</th>
						<td><input name="phone" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>安装单位：</th>
						<td><input  id="install" name="install" class="easyui-combobox"
data-options="required:true,valueField:'id',textField:'compName',url:'../company/queryComList'" /></td>
						<th>安装人员：</th>
						<td><input name="installer" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>服务期限：</th>
						<td colspan="3"><input name="installriqi" class="easyui-datebox" data-options="required:true" /> 至
							<input name="endriqi" class="easyui-datebox" data-options="required:true"  /></td>
					</tr>
					<tr>
						<th>设备厂牌型号：</th>
						<td><input name="zdtype" class="easyui-validatebox" data-options="required:true" /></td>
						<th>终端ID：</th>
						<td><input name="zdid" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>SIM卡号：</th>
						<td><input name="sim" class="easyui-validatebox" data-options="required:true" /></td>
						<th>安装证明编号：</th>
						<td><input name="azzm" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<script type="text/javascript">
			            function selectAll(checkbox) {
			                $('input[type=checkbox]').prop('checked', $(checkbox).prop('checked'));
			            }
			        </script>
					<tr>
						<th>检验测试项目</th>
						<td colspan="5">
							<label style="color: blue;"><input type="checkbox"onclick="selectAll(this);" />全选 </label>&nbsp;&nbsp;
							<label><input type="checkbox" name="zdy" value="良好"/>正电源</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="fdy" value="良好"/>负电源</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="acc" value="良好"/>ACC线</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="scx" value="良好"/>刹车线</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="zzx" value="良好"/>左转向</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="yzx" value="良好"/>右转向</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="ygd" value="良好"/>远光灯</label> &nbsp;&nbsp;
							<label><input type="checkbox" name="jgd" value="良好"/>近光灯</label> 
						</td>
					</tr>
					<tr>
						<th>备注：</th>
						<td colspan="3"><textarea id="remark" name="remark" cols="20"
								rows="2" style="width: 100%"> </textarea></td>
					</tr>
				</table>
				<!-- 二级维护信息 结束-->
			</form>
		</div>
	</div>
</body>
</html>