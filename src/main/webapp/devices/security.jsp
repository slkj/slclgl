<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/security.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>
							测试状态:
							<select name="test" class="easyui-combobox" style="width:100px;">   
							    <option value="" selected="selected">请选择</option>
							    <option value="0">未测试</option>
								<option value="1">已测试</option>
							</select> 
							设备编号:<input name="listnum" class="easyui-numberbox" style="width: 150px" />
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
						</td>
					</tr>
					<tr height="3px"></tr>
					<tr>
						<td>
							所在地区：
							 <select class="easyui-combotree" url="../data/city_data.json" name="area" style="width:260px;" data-options="lines:'true'"></select>
							<a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查询</a>
							<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>