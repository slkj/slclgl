<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限信息</title>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="center" style="padding: 1px;">
			<div class="easyui-panel"
				data-options="fit:true,border:false,title:'菜单列表',tools:'#tt'">
				<ul id="reslist"></ul>
			</div>
			<div id="tt">
				<a href="#" class="icon-save" onclick="roleModule()"></a>
			</div>
		</div>
		<div data-options="region:'east',split:true" style="width: 240px;">
			<div id="tt1">
				<a href="#" class="icon-save" onclick="javascript:alert('add')"></a>
			</div>
			<div class="easyui-panel"
				data-options="fit:true,border:false,title:'操作按钮列表',tools:'#tt1'">
				<table id="reslist"></table>
			</div>
		</div>
	</div>
</body>
</html>