<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑车辆行驶证信息</title>
<%-- <%@ include file="/common/taglibs.jsp"%> --%>
</head>
<body>
	
			<form id="dform" method="post">
				<input id="id" name="id" type="hidden" /> 
				<input id="vId" name="vId" type="hidden" /> 
				<input id="carNumbers" name="carNumber" type="hidden" />
				<!-- 行驶证信息 开始-->
				<table class="grid" id="drivingtab">
					<tr>
				<tr>
					<th>冀交运管:</th>
					<td>
						<input id="traWord" name="traWord" class="easyui-validatebox" type="text" style="width: 50px;"  readOnly="true"/>字
						<input id="traCode" name="traCode" class="easyui-validatebox" type="text" style="width: 100px;" readOnly="true"/>号
					</td>
					<th>经济类型：</th>
					<td>
						<input id="traEcoType" name="traEcoType" class="easyui-validatebox" type="text" style="width: 150px;" readOnly="true"/>
					</td>
				</tr>
			</tr>
			<tr>
				<th>经营许可证:</th>
				<td>
					<input id="traBusLicNo" name="traBusLicNo" class="easyui-validatebox" type="text" style="width: 150px;" readOnly="true"/>
				</td>
				<th>经营许可证核发日期：</th>
				<td>
					<input id="traBusLicDate" name="traBusLicDate" class="easyui-datebox" type="text" style="width: 150px;" data-options="required:true" readOnly="true"/>
				</td>
			</tr>
					<tr>
						<th>检测机关：</th>
						<td><input name="testOrgan" class="easyui-validatebox" data-options="required:true"/></td>
						<th>到期日期：</th>
						<td><input name="endDate" class="easyui-datebox"
							data-options="required:true" editable="false" /></td>
					</tr>
					<tr>
						<th>备注：</th>
						<td colspan="3"><textarea id="remark" name="remark" cols="20"
								rows="2" style="width: 100%"> </textarea></td>
					</tr>
				</table>
				<!-- 行驶证信息 结束-->
			</form>
		
</body>
</html>