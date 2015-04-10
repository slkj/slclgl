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
	<div data-options="region:'west',title:'公司列表',split:true"
		style="width: 220px">
		<ul class="easyui-tree" id="comtree">
		</ul>
	</div>
	<div id= "center" data-options="region:'center'">
		<div id="tb" style="padding: 5px; height: auto">
			<div>
				<form name="searchform" method="post" action="" id="searchform">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td>
								车号：<input name="lyr" class="easyui-textbox" style="width: 150px" /> 
								车牌号:<input name="carNumber" class="easyui-textbox" style="width: 150px" />
							</td>
						</tr>
						<tr height="3px"></tr>
						<tr>
							<td>
								设备编号:<input name="listnum" class="easyui-textbox" style="width: 150px" /> 
								SIM卡号:<input name="phone" class="easyui-numberbox" style="width: 150px" /> 
								 <a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查询</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:addCar();">新加车辆</a>
						</td>
						<td><div class="datagrid-btn-separator"></div></td>
						<td>
							<a href="#" onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
						</td>
						<td><div class="datagrid-btn-separator"></div></td>
						<td> <a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_154',plain:true" onclick="return ajaxFileUpload();">导入</a> 
						</td>
					</tr>
				</table>
			</div>
		</div>
		<table id="dg"></table>
	</div>
</body>
</html>