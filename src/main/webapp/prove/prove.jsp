<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/prove.js"></script>
</head>
<body>
<input id="roleId" type="hidden" value="${userSession.roleId }">
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td> 证明编号:<input name="number" class="easyui-textbox"
							style="width: 150px" /> 使用地区:<input id="address" name="address"/> 领用人:<input
							name="usman" class="easyui-textbox" style="width: 150px" />
							使用类型：<select class="easyui-combobox"  name="ustype" >
							<option value=""></option>
								<option value="邯郸安装">邯郸安装</option>
								<option value="邯郸使用">邯郸使用</option>
								<option value="石家庄安装">石家庄安装</option>
								<option value="石家庄使用">石家庄使用</option>
								<option value="廊坊专用">廊坊专用</option>
								<option value="抚宁专用">抚宁专用</option>
								<option value="山西专用">山西专用</option>
					</select>
							 <a
							id="search_btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:'true'">查询</a>
						</td>
					</tr>
					<tr height="3px"></tr>
					
				</table>
			</form>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:addFun();">入库</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_115',plain:true" onClick="javascript:outFun();">出库</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_115',plain:true" onClick="javascript:tovoid(1);">使用</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_115',plain:true" onClick="javascript:tovoid(2);">回收</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_156',plain:true" onClick="javascript:tovoid(3);">作废</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right">
						<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
					</td>
				</tr>
			</table>
		</div>
		
	</div>
	<table id="dg"></table>

</body>
</html>