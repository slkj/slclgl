<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回访车辆管理</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css" />
<!-- <link rel="stylesheet" type="text/css" href="../css/default.css" /> -->
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body class="easyui-layout">
	<table class="easyui-datagrid" title="回访车辆列表"
		data-options="fit : true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'productid'">编码</th>
				<th data-options="field:'productname'">车牌号</th>
				<th data-options="field:'unitcost'">业户名称</th>
				<th data-options="field:'status'">所属单位</th>
				<th data-options="field:'listprice'">联系时间</th>
				<th data-options="field:'attr1'">联系人员</th>
				<th data-options="field:'itemid'">联系结果</th>
				<th data-options="field:'itemid'">最后定位时间</th>
				<th data-options="field:'itemid'">值班人员</th>
				<th data-options="field:'itemid'">联系记录</th>
				<th data-options="field:'itemid'">维修情况</th>
				<th data-options="field:'itemid'">定位情况</th>
				<th data-options="field:'itemid'">定位时间</th>
				<th data-options="field:'itemid'">备注</th>
				<th data-options="field:'itemid'">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>