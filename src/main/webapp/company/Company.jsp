<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司信息管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/company.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td> 公司名称:<input name="compName" type="text" style="width: 150px" /> 
							组织机构代码:<input name="organizationCode" type="text" style="width: 150px" /> 
							<a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查询</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addCompany()">添加</a></td>
<!-- 					<td><div class="datagrid-btn-separator"></div></td> -->
<!-- 					<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="delCompany()">删除</a> </td> -->
<!-- 					<td><div class="datagrid-btn-separator"></div></td> -->
<!-- 					<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editCompany()">编辑</a></td> -->
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>