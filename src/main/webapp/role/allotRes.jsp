<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-ok',plain:true" onclick="getChecked()">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-no',plain:true"
			onclick="javascript:window.parent.max.closedlg();">关闭</a>
	</div>
	<div class="easyui-panel" style="height: 370px">
		<!-- 		<ul id="tt" class="easyui-tree"></ul> -->
		<table id="tt" data-options="fit:true,border:false" class="easyui-treegrid" ></table>
	</div>
</body>
</html>