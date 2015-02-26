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
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/syscss.css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/devices.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;&nbsp;入库时间从: <input name="rktime"
							class="easyui-datebox" style="width: 100px" editable="false">
							到: <input name="rktime1" class="easyui-datebox"
							style="width: 100px"> 出库时间从: <input name="lytime"
							class="easyui-datebox" style="width: 100px" editable="false">
							到: <input name="lytime1" class="easyui-datebox"
							style="width: 100px">&nbsp;&nbsp;返还时间从: <input name="fhtime"
							class="easyui-datebox" style="width: 100px" editable="false">
							到: <input name="fhtime1" class="easyui-datebox"
							style="width: 100px">
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;使&nbsp;用&nbsp;状&nbsp;态: 
						<select class="easyui-combobox" name="state" panelheight="auto" style="width: 100px">
							<option value="" selected="selected"></option>
							<option value="1">已出库</option>
							<option value="2">未出库</option>
							<option value="3">返回</option>
						</select> &nbsp;&nbsp;设备厂商 : <input name="firm" class="easyui-textbox"
							style="width: 150px" /> &nbsp;&nbsp;领用人：<input name="lyr"
							class="easyui-textbox" style="width: 150px" /> <a
							id="search_btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:'true'">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-add',plain:true"
						onClick="javascript:addNew();">入库</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_48',plain:true"
						onClick="javascript:addNew();">返回</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right"><a href="outExcel.jsp"
						class="easyui-linkbutton"
						data-options="iconCls:'pic pic_157',plain:true">导出</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td style="text-align: right;"><input id="myfile"
						name="myfile" style="width: 200px" type="file"> <a
						href="#" class="easyui-linkbutton"
						data-options="iconCls:'pic pic_154',plain:true"
						onclick="return ajaxFileUpload();">导入</a>
						<span id="msg" style="color: red;"></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>