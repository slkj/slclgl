<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/devices.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>
							使用状态:
							<select id="state" name="state" class="easyui-combobox" style="width:100px;">   
							   <option value="" selected="selected">请选择</option>
								<option value="4">入网使用</option>
								<option value="1">已出库</option>
								<option value="2">未出库</option>
								<option value="3">退回</option>
							</select> 
							设备编号:<input name="listnum" class="easyui-numberbox" style="width: 150px" />
							SIM卡号:<input name="phone" class="easyui-numberbox" style="width: 150px" />
							车牌号:<input name="carNumber" class="easyui-textbox" style="width: 150px" />
						</td>
					</tr>
					<tr height="3px"></tr>
					<tr>
						<td>
							领用人：<input name="lyr" class="easyui-textbox" style="width: 150px" /> 
							所在地区：
							 <select class="easyui-combotree" url="../data/city_data.json" name="area" style="width:260px;" data-options="lines:'true'"></select>
						</td>
					</tr>
					<tr height="3px"></tr>
					<tr id="highsearch" style="display: none;">
						<td>
							设备厂商 : 	
							<select  id="firm"  class="easyui-combobox"  name="firm" panelheight="auto" style="width: 100px">
								<option value="" selected="selected">请选择</option>
								<option value="神龙">神龙</option>
								<option value="珠海天琴">珠海天琴</option>
								<option value="华宝">华宝</option>
								<option value="博实结">博实结</option>
								<option value="中斗">中斗</option>
								<option value="赛格">赛格</option>
								<option value="赛格">航天无线</option>
								<option value="鸿泉">鸿泉</option>
							</select>
							入库时间:<input name="rktime" class="easyui-datebox" style="width: 100px" editable="false">到: <input name="rktime1" class="easyui-datebox" style="width: 100px"> 
							出库时间从: <input name="lytime" class="easyui-datebox" style="width: 100px" editable="false"> 到: <input name="lytime1" class="easyui-datebox" style="width: 100px">
							返还时间从: <input name="fhtime" class="easyui-datebox" style="width: 100px" editable="false"> 到: <input name="fhtime1" class="easyui-datebox" style="width: 100px">
						</td>
					</tr>
					<tr>
						<td>
							<a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查询</a>
							<a id="high_search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">高级查询</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:intoRepertory();">入库</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onClick="javascript:edit();">编辑</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right">
						<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td style="text-align: right;">
						<input id="myfile" name="myfile" style="width: 200px" type="file"/> 
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'pic pic_154',plain:true" onclick="return ajaxFileUpload();">导入</a>
						<span id="msg" style="color: red;"></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>