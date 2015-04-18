<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/role.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'center'" style="padding: 1px;">
			<div id="toolbar" style="padding: 5px; height: auto">
				<div>
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-add'" onclick="addFun()">添加</a></td>
						</tr>
					</table>
				</div>
			</div>
			<table id="grid"></table>
		</div>
		<div id="right-panel" data-options="region:'east',title:'权限设置',split:true"
			style="width: 600px;">
			<div class="easyui-layout" fit="true">
				<div region="center" style="padding: 1px;">
					<div class="easyui-panel" data-options="fit:true,border:false,title:'菜单列表',tools:'#tt'">
						<table id="reslist"></table>
					</div>
					<div id="tt">
						<a href="#" class="icon-save" onclick="javascript:alert('add')"></a>
					</div>
				</div>
				<div data-options="region:'east',split:true" style="width: 240px;">
					<div id="tt1">
						<a href="#" class="icon-save" onclick="javascript:alert('add')"></a>
					</div>
					<div class="easyui-panel" data-options="fit:true,border:false,title:'操作按钮列表',tools:'#tt1'">
						<table id="reslist"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>