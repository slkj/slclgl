<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS设备管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/prove.js"></script>
</head>
<body>
<input id="roleId" type="hidden" value="${userSession.roleId }">
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td> 证明编号:<input name="number" class="easyui-numberbox"
							style="width: 150px" /> SIM卡号:<input name="phone"
							class="easyui-numberbox" style="width: 150px" /> 车牌号:<input
							name="carNumber" class="easyui-textbox" style="width: 150px" />
						</td>
					</tr>
					<tr height="3px"></tr>
					<tr>
						<td>设备终端ID：<input name="lyr" class="easyui-textbox"
							style="width: 150px" /> 
						<td>设备厂商 : <select id="firm" class="easyui-combobox"
							name="firm" panelheight="auto" style="width: 100px">
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
					<tr>
						<td><a id="high_search_btn" href="#"
							class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:'true'">更多条件</a> <a
							id="search_btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:'true'">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table id="toolbar" cellspacing="0" cellpadding="0">

			</table>
		</div>
	</div>
	<table id="dg"></table>

</body>
</html>