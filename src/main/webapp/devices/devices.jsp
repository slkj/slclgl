<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css" />
<!-- <link rel="stylesheet" type="text/css" href="../css/default.css" /> -->
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div id="DIV_toolbar'" style=" margin :0px; padding :5px;"> |
	单据编号：XSD2013060001 &nbsp; 客户姓名：
	<select id="cc" class="easyui-combobox" name="state"
		style="width: 100px;" data-options="required:true">
		<option value="张三">张三</option>
		<option value="李四">李四</option>
		<option value="王五">王五</option>
	</select> &nbsp; 日期：
	<input id="Text4" type="text" class="Wdate"
		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	</div>
</body>
</html>