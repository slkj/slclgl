<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加车辆行驶证信息</title>
<%-- <%@ include file="/common/taglibs.jsp"%> --%>
</head>
<body>
	
			<form id="dform" method="post">
				<input id="vId" name="vId" type="hidden" /> <input id="carNumbers"
					name="carNumber" type="hidden" />
				<!-- 行驶证信息 开始-->
				<table class="grid" id="drivingtab">
					<tr>
						<th width="100px">档案编号：</th>
						<td width="150px"><input name="fileNumber" class="easyui-validatebox"
							editable="false" type="text" data-options="required:true" /></td>
						<th width="100px">注册日期：</th>
						<td width="150px">
							<input name="driRegDate" class="easyui-datebox" editable="false" type="text" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<th>发证日期：</th>
						<td><input name="driCertDate" class="easyui-datebox"
							editable="false" type="text" data-options="required:true" /></td>
						<th>强制报废期止：</th>
						<td><input id="baoFeiDate" name="baoFeiDate"
							class="easyui-datebox" editable="false" /></td>
					</tr>
					<tr>
						<th>检测机关：</th>
						<td><input name="testOrgan" class="easyui-textbox" /></td>
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