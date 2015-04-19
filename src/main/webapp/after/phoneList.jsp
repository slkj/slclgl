<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>售后电话记录管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/phoneList.js"></script>
</head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form name="searchform" method="post" action="" id="searchform">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td>
						服务车辆: <input name="carNo" style="width: 100px" />
						服务类型<select class="easyui-combobox" id="serviceType" style="width: 100px;"
							name="serviceType" editable="false">
								<option value=""></option>
								<option value="装机">装机</option>
								<option value="维修">维修</option>
								<option value="回访">回访</option>
								<option value="其他">其他</option>
						</select>
						客服人员: <input name="customer" style="width: 100px" />
						服务人员: <input name="serviceMan" style="width: 100px" />
						服务结果: <select class="easyui-combobox" id="result" style="width: 100px;"
							name="result" editable="false">
								<option value=""></option>
								<option value="已解决">已解决</option>
								<option value="未解决">未解决</option>
						</select>
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
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onClick="javascript:add();">添加</a>
					</td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td align="right">
						<a href="#"  onclick="outExcel()" class="easyui-linkbutton" data-options="iconCls:'pic pic_157',plain:true">导出</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table id="dg"></table>
</body>
</html>