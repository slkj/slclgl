<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/vehicle.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<form name="searchform" method="post" action="" id="searchform">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>车牌号:<input name="carNumber" class="easyui-textbox"
						style="width: 150px" />
					 设备编号:<input name="listnum" class="easyui-textbox"
						style="width: 150px" /> SIM卡号:<input name="phone"
						class="easyui-numberbox" style="width: 150px" />
					</td>
				</tr>
				<tr>
					<td> 所属公司：<input name="companyName" class="easyui-textbox" style="width: 150px" />
						使用状态：<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
								    <option value="1">入网</option>   
								    <option value="2">报停</option>   
								</select> 
						 <a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
					</td>
				</tr>
				
			</table>
		</form>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:addCar();">新加车辆</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'pic_stop',plain:true" onClick="">批量报停</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_154',plain:true" onclick="return ajaxFileUpload();">导入</a></td>
			</tr>
		</table>
	</div>
	<table id="dg"></table>
</body>
</html>