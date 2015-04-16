<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司信息</title>
</head>
<body>
	<form id="comForm">
		<table class="grid" style="width: 100%">
			<tr>
				<th style="width: 150px;">公司名称：</th>
				<td><span id="compName"></span></td>
			</tr>
			<tr>
				<th>公司简称：</th>
				<td><span id="compSName"></span></td>
			</tr>
			<tr>
				<th>企业组织机构代码：</th>
				<td><span id="organizationCode"></span></td>
			</tr>
			<tr>
				<th>法人：</th>
				<td><span id="corporate"></span></td>
			</tr>
			<tr>
				<th>联系人：</th>
				<td><span id="contactMenber"></span></td>
			</tr>
			<tr>
				<th>联系方式：</th>
				<td><span id="contactWay"></span></td>
			</tr>
			<tr>
				<th>Email：</th>
				<td><span id="email"></span></td>
			</tr>
			<tr>
				<th>公司级别：</th>
				<td><select id="level" name="level" class="easyui-combobox"
					disabled="disabled">
						<option value="1">一级公司</option>
						<option value="2">二级公司</option>
						<option value="2">二级公司</option>
						<option value="3">三级公司</option>
						<option value="4">四级公司</option>
						<option value="-1">普通公司</option>
						<option value="-2">车队</option>
				</select></td>
			</tr>
			<tr>
				<th>营业执照号：</th>
				<td><span id="businessLicense"></span></td>
			</tr>
			<tr>
				<th>企业注册资金：</th>
				<td><span id="registeredCapital"></span></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td><span id="compAddress"></span></td>
			</tr>
			<tr>
				<th>简介(公司营业范围)：</th>
				<td><span id="introduction"></span></td>
			</tr>
			<tr>
				<th>描述：</th>
				<td><span id="remarks"></span></td>
			</tr>
		</table>
	</form>
</body>
</html>