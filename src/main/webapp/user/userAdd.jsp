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

	$(function() {
		showCom();

		$('#ctype').combobox({
			onSelect : function(param) {
				if (param.value == '2') {
					$('#depCombobox').combobox('clear');
					showCom();
				} else {
					$('#comCombobox').combobox('clear');
					showDep();
				}
			}
		});
		$('#roleId').combobox({
			url : '../role/queryAll',
			valueField : 'id',
			textField : 'name'
		});
	});
	function submitForm() {
		if ($("#userForm").form('enableValidation').form('validate')) {
			var data = $("#userForm").serialize();
			$.ajax({
				cache : false,
				type : 'POST',
				url : basePath + 'save',
				data : data,
				async : false,
				success : function(data) {
					if (data.success) {
						backPage();
						top.SL.sysSlideShow({
							msg : '保存成功!'
						});
					} else {
						SL.msgShow("提示", "该账户已经存在，请更换账户！", "warning");
					}

				}
			});
		}
	}
	function showDep() {
		$('#TDep').show(); //可用
		$('#TCom').hide(); //不可用
		$('#depCombobox').attr("disabled",false);
		$('#comCombobox').attr("disabled",true);
		$('#depCombobox').combotree({
			url : '../dep/getDepTree',
			editable : false,
			lines : true,
			required:true
		});
	}
	function showCom() {
		$('#TCom').show(); //可用
		$('#TDep').hide(); //不可用
		$('#comCombobox').attr("disabled",false);
		$('#depCombobox').attr("disabled",true);
		$("#comCombobox").combobox({
			url : '../company/queryComList',
			editable : false,
			required:true,
			valueField : 'id',
			textField : 'compName'
		});
	}

	function clearForm() {
		$('#userForm').form('clear');
	}
	function backPage() {
		window.location.href = 'users.jsp';
	}
</script>
</head>
<body class="easyui-layout">
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="button white medium"
			onclick="javascript:submitForm()">保存</a> <a href="javascript:void(0)"
			class="button white medium" onclick="javascript:clearForm()">重置</a> <a
			href="javascript:void(0)" class="button white medium"
			onclick="javascript:backPage()">返回</a>
	</div>
	<form id="userForm" metdod="post">
		<div class="easyui-panel" title="用户基本信息">
			<table class="grid" style="width: 500px">
				<tr>
					<th style="width: 100px">用户类型 ：</th>
					<td><select id="ctype" name="type" style="width: 200px;">
							<option value="1">平台用户</option>
							<option value="2" selected="selected">公司用户</option>
					</select></td>

				</tr>
				<tr>
					<th style="width: 100px">角色:</th>
					<td><input id="roleId" name="roleId" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th style="width: 100px">用户名：</th>
					<td><input class="easyui-textbox" name="username"
						data-options="required:true" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th style="width: 100px">密码：</th>
					<td><input class="easyui-textbox" name="password"
						type="password" data-options="required:true" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>真实姓名：</th>
					<td><input class="easyui-textbox" name="realname"
						data-options="required:true" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>性别：</th>
					<td><label><input name="sex" type="radio" value="男"
							checked="checked" />男 </label> <label><input name="sex"
							type="radio" value="女" />女</label></td>
				</tr>
				<tr>
					<th>联系电话：</th>
					<td><input name="phone" class="easyui-textbox"
						data-options="required:true" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>电子邮件：</th>
					<td><input name="email" class="easyui-textbox"
						style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>有效期：</th>
					<td><input name="validTime" class="easyui-datebox"
						style="width: 200px;"></input></td>
				</tr>
				<tr id="TCom">
					<th>所属公司：</th>
					<td><input id="comCombobox" name="companyid"
						style="width: 200px;"></input></td>
				</tr>
				<tr id="TDep">
					<th>所属机构：</th>
					<td><input id="depCombobox" name="departcode"
						style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>备注：</th>
					<td><input class="easyui-textbox" name="remark"
						data-options="multiline:true" style="height: 60px; width: 100%" /></td>
				</tr>
			</table>
		</div>
	</form>
	<div style="height: 30px"></div>
</body>
</html>