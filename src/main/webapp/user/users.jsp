<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="js/user.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" >
		<form name="searchform" method="post" action="" id="searchform">
			<table cellspacing="0" cellpadding="0" style="padpadding: 5px">
				<tr>
					<td>使用状态: <select name="status" class="easyui-combobox"
						style="width: 100px;">
							<option value="" selected="selected">请选择</option>
							<option value="enabled">启用</option>
							<option value="disabled">禁用</option>
					</select> 用户名:<input name="username" type="text" style="width: 150px" /> <a
						id="search_btn" href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'">查询</a> <a href="#"
						onclick="outExcel()" class="easyui-linkbutton"
						data-options="iconCls:'pic_157'">导出</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="gird"></table>
	</div>


</body>
</html>