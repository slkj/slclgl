<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建用</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	var basePath = "../user/";
	var Request = new Object();
	$(function() {
		$('#roleId').combobox({
			url : '../role/queryAll',
			valueField : 'id',
			textField : 'name'
		});
		Request = GetRequest();
		uid = Request['id'];
		$.ajax({
			url : basePath + "queryOne?id=" + uid,
			success : function(data) {
				if (data) {
					$("#userForm").form('load', data);
						$("input").attr('disabled', 'disabled');
					$('.type').combobox('setValue', data.type);
					$('#companyid').combobox('setValue', data.company);
				}
			}
		});
	});
	function backPage() {
		window.location.href = 'users.jsp';
	}
</script>
</head>
<body class="easyui-layout">
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:backPage()">返回</a>
	</div>
	<form id="userForm" metdod="post">
		<input name="id" type="hidden" />
		<div class="easyui-accordion" data-options="border:false">
			<div title="用户基本信息"
				data-options="collapsed:false,collapsible:false,border:false"
				style="overflow: auto;">
				<table class="grid">
					<tr>
						<th style="width: 100px">用户类型 ：</th>
						<td><select name="type" class="easyui-combobox">
								<option value="1">个人用户</option>
								<option value="2" selected="selected">公司用户</option>
						</select></td>
						<th style="width: 100px">角色:</th>
						<td><input id="roleId" name="roleId" /></td>
					</tr>
					<tr>
						<th style="width: 100px">账号：</th>
						<td><input class=easyui-textbox name="username"
							data-options="required:true" /></td>
						<th style="width: 100px">密码：</th>
						<td><input class="easyui-textbox" name="password" type="password"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<th>用户姓名：</th>
						<td><input class="easyui-textbox" name="realname"
							data-options="required:true" /></td>
						<th>性别：</th>
						<td><label><input name="sex" type="radio" value="男"
								checked="checked" />男 </label> <label><input name="sex"
								type="radio" value="女" />女</label></td>
					</tr>
					<tr>
						<th>电子邮件：</th>
						<td><input name="email" class="easyui-textbox" /></td>
						<th>联系电话：</th>
						<td><input name="phone" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<th>有效期：</th>
						<td><input name="validTime" class="easyui-datebox"></input></td>
						<th>所属公司：</th>
						<td><select id="companyid" name="company"
							class="easyui-combotree" style="width: 200px;"
							data-options="url:'../company/getTreeList',lines:true"></select>
						</td>
					</tr>
					<tr>
						<th>备注：</th>
						<td colspan="3"><input class="easyui-textbox" name="remark"
							data-options="multiline:true" style="height: 60px; width: 100%" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<div style="height: 30px"></div>
</body>
</html>