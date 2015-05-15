<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIM卡管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/sim.js"></script>
<style type="text/css">
.searchtable td {
	padding-left: 10px;
}
</style>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0" class="searchtable">
					<tr>
						<td>SIM号码：<input class="easyui-textbox" id="telnum"
							name="telnum" style="width: 150px">
						</td>
						<td>使用状态: <select class="easyui-combobox" id="state"
							name="state" panelheight="auto" style="width: 100px">
								<option value="">请选择</option>
								<option value="1">已用</option>
								<option value="0">未用</option>
						</select>
						</td>
<!-- 						<td>卡类型 : <select class="easyui-combobox" id="cardType" -->
<!-- 							name="cardType" panelheight="auto" style="width: 100px"> -->
<!-- 								<option value="">请选择</option> -->
<!-- 								<option value="GPRS卡">GPRS卡</option> -->
<!-- 								<option value="短信卡">短信卡</option> -->
<!-- 						</select> -->
<!-- 						</td> -->
<!-- 						<td>领用人：<input class="easyui-textbox" id="lyr" name="lyr" -->
<!-- 							style="width: 150px"> -->
<!-- 						</td> -->
						<td><a id="search_btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<table cellspacing="0" cellpadding="0">
			<tr>

				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onClick="javascript:addNew();">新增</a></td>
				<td><div class="datagrid-btn-separator"></div></td>

				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onClick="javascript:addNew();">删除</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic_130',plain:true"
					onClick="javascript:simPay();">缴费</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<!-- 				<td><a href="#" class="easyui-linkbutton" -->
				<!-- 					data-options="iconCls:'pic pic_48',plain:true" -->
				<!-- 					onClick="javascript:addNew();">返回</a></td> -->
				<!-- 				<td><div class="datagrid-btn-separator"></div></td> -->
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_154',plain:true"
					onClick="javascript:openExcel();">导入</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td align="right"><a href="#" class="easyui-linkbutton"
					data-options="iconCls:'pic pic_157',plain:true"
					onClick="javascript:outExcel();">导出</a></td>
			</tr>
		</table>
	</div>
	<table id="dg"></table>
	<div id="openExcel" class="easyui-dialog" closed="true"
		title="设备Excel导入" buttons="#dlg-buttons"
		style="width: 400px; height: 200px; top: 150px; left: 200px">
		<span style="color: red;">*如导入失败，请将Excel另存为格式选择为Excel
			97/2003的*.xls文件</span> <input id="myfile" name="myfile" style="width: 200px"
			type="file" /> <span id="msg" style="color: red;"></span>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'pic pic_154',plain:true"
			onclick="return excelMB();">导入模板下载</a> <a href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'pic pic_154',plain:true"
			onclick="return ajaxFileUpload();">导入</a>
	</div>
</body>
</html>