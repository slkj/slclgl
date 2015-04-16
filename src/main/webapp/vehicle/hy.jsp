<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/hycl.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'west'" style="width: 220px">
		<div id="tt" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="按公司">
				<ul class="easyui-tree" id="comtree"></ul>
			</div>
			<div title="按运管单位"></div>
		</div>
	</div>
	<div id="center" data-options="region:'center'">
		<iframe id="cnIframe" scrolling="auto" frameborder="0"
			style="width: 100%; height: 100%"></iframe>
	</div>
</body>
</html>