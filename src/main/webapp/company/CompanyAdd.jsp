<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增公司信息</title>
</head>
<body>

	<form id="comForm">
		<table class="grid">
			<tr>
				<th colspan="4" style="text-align: left; color: red;">*如实填写公司信息，联系人、联系电话要核实。</th>
			</tr>
			<tr>
				<th style="width: 120px">公司名称：</th>
				<td colspan="3">
					<input name="compName" class="easyui-validatebox" data-options="required:'true'" style="width: 330px">
				</td>
			</tr>
			<tr>
				<th>简称：</th>
				<td><input name="compSName" class="easyui-validatebox" data-options="required:'true'" style="width: 200px"></td>
				<th>组织机构代码：</th>
				<td><input name="organizationCode" class="easyui-validatebox" style="width: 200px"/></td>
			</tr>
			<tr>
				<th>法人：</th>
				<td><input name="corporate" class="easyui-validatebox" style="width: 200px"/></td>
				<th>联系人：</th>
				<td><input name="contactMenber" class="easyui-validatebox" data-options="required:'true'" style="width: 200px"></td>
			</tr>
			<tr>
				<th>联系方式：</th>
				<td><input name="contactWay" class="easyui-validatebox" data-options="required:'true'" style="width: 200px"></td>
				<th>邮箱Email：</th>
				<td><input name="email" class="easyui-validatebox" style="width: 200px"></td>
			</tr>
			<tr>
				<th>上级公司：</th>
				<td> 
					<select name="bCompany" class="easyui-combotree" style="width:200px;"
									data-options="url:'../company/getTreeList',required:true,lines:true"></select>  
				</td>
				<th>公司级别：</th>
				<td>
					<select id="level" name="level" class="easyui-combobox"  >
							<option value="2">二级公司</option>
							<option value="3">三级公司</option>
							<option value="4">四级公司</option>
							<option value="-1">普通公司</option>
							<option value="-2">车队</option>
						</select>
				</td>
			</tr>
			<tr>
				<th>营业执照号：</th>
				<td><input name="businessLicense" class="easyui-validatebox" style="width: 200px"></td>
				<th>注册资金：</th>
				<td><input name="registeredCapital" class="easyui-validatebox" style="width: 200px">万元</td>
			</tr>
			<tr>
				<th>公司地址：</th>
				<td colspan="3"><input name="compAddress" class="easyui-validatebox" style="width: 330px"></td>
			</tr>
			<tr>
				<th>简介</th>
				<td colspan="3"><input name="introduction" class="easyui-textbox" 
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td colspan="3"><input class="easyui-textbox" name="remark"
					data-options="multiline:true" style="height: 60px; width: 100%"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>