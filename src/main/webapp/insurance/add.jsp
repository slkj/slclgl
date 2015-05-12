<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加车辆保险信息</title>
<%-- <%@ include file="/common/taglibs.jsp"%> --%>
</head>
<body>
	
			<form id="dform" method="post">
				<input id="vid" name="vid" type="hidden" /> 
				<!-- 保险信息 开始-->
				<table class="grid" id="drivingtab">
					<tr>
					<th>保单号：</th>
					<td><input type="text" name="policy" class="easyui-validatebox"
						style="width: 150px" data-options="required:true" /></td>
						<th align="right">投保类型:</th>
					<td> <input id="insuranceType" name="insuranceType" style="width: 150px;" data-options="required:true" /> 
					<!-- <input id="typeName" name="typeName" style="width: 150px;" data-options="required:true" /> --></td>
				 	</tr>
				<tr>
				 	<th align="right">费用(元):</th>
					<td><input name="feiyong" style="width: 150px;" class="easyui-numberbox" data-options="required:true" /></td>
				<th align="right">承保单位:</th>
					<td> <input id="insuranceCompany" name="insuranceCompany"
						style="width: 150px;" data-options="required:true" />
						<!-- <input id="companyName" name="companyName"
						style="width: 150px;" data-options="required:true" /> --></td>
				</tr>
			
				<tr>
					<th align="right">投保日期:</th>
					<td><input id="riqi" class="easyui-datebox" name="riqi"
						editable="false" style="width: 150px" data-options="required:true"></td>
					<th align="right">核保人:</th>
					<td><input name="checkMan" style="width: 150px;"
						class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
				<tr>
					<th align="right">制单人:</th>
					<td><input name="makeMan" style="width: 150px;"
						class="easyui-validatebox" data-options="required:true" /></td>
						<th></th><td></td>
				</tr>
					<tr>
					<th align="right">保&nbsp;险&nbsp;期&nbsp;间:</th>
					<td colspan="3">自<input id="startTime" class="easyui-datebox"
						name="startTime" editable="false" style="width: 150px"
						data-options="required:true"> 零时起 至 <input id="endTime"
						class="easyui-datebox" name="endTime" editable="false"
						style="width: 150px" data-options="required:true">二十四时止
					</td>
					</tr>
					<tr>
					<th align="right">备注:</th>
					<td colspan="3"><textarea id="remark" name="remark"
							style="width: 100%;" rows="2"></textarea></td>
				</tr>

				</table>
				<!-- 保险信息 结束-->
			</form>
	
</body>
</html>