<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑车辆二级维护信息</title>
<%-- <%@ include file="/common/taglibs.jsp"%> --%>
</head>
<body>

			<form id="dform" method="post">
				<input id="id" name="id" type="hidden" /> 
				<input id="vid" name="vid" type="hidden" /> 
				<!-- 二级维护信息 开始-->
				<table class="grid" id="drivingtab">
					<tr>
					<th align="right">二保单位:</th>
					<td><input name="keepaddress" style="width: 150px;" class="easyui-validatebox" data-options="required:true" /></td>
					<th align="right">上次维修日期:</th>
					<td><input id="lastriqi" class="easyui-datebox" name="lastriqi"
						editable="false" style="width: 150px" data-options="required:true"></td>
						</tr>				
					<tr>
				 	<th align="right">维护日期:</th>
					<td><input id="riqi" class="easyui-datebox" name="riqi"
						editable="false" style="width: 150px" data-options="required:true"></td>
				
					<th align="right">下次维护日期:</th>
					<td><input id="nextriqi" class="easyui-datebox"
						name="nextriqi" editable="false" style="width: 150px" data-options="required:true"></td>
						</tr>				
					<tr>
					<th align="right">使用年限(年):</th>
					<td><input id="life" name="life" style="width: 150px;"  class="easyui-numberbox" data-options="required:true" /></td>
					<th align="right">年检日期:</th>
					<td><input id="examine" class="easyui-datebox" name="examine"
						editable="false" style="width: 150px" data-options="required:true"></td>
				</tr>
				<tr>
					<th align="right">备注:</th>
					<td colspan="3"><textarea id="remark" name="remark"
							style="width: 100%;" rows="2"></textarea></td>
				</tr>
				</table>
				<!-- 二级维护信息 结束-->
			</form>
		
</body>
</html>