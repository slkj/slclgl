<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加驾驶员</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	var basePath = "../phone/";
	$(function() {
		var Request = new Object();
		Request = GetRequest();
		id = Request['id'];
		$.ajax({
			url : basePath + 'one',
			type : "POST",
			data : "id=" + id,
			async : false,
			dataType : "json",
			cache : false,
	        success: function(data) { 
	         
	        	$("#carForm").form('load', data);
	        }  
			
		});
	});
	function submitForm() {
		if ($("#carForm").form('enableValidation').form('validate')) {
			var data = $("#carForm").serialize();
			$.ajax({
				cache : false,
				type : 'POST',
				url : basePath + 'saveMaintain',
				data : data,
				async : false,
				success : function(data) {
					if (data) {
						backPage();
					}
				}
			});
		}
	}
	function clearForm() {
		$('#carForm').form('clear');
	}
	function backPage() {
		window.location.href = 'maintain.jsp';
	}
	
</script>
</head>
<body class="easyui-layout">
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:submitForm()">保存</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="javascript:clearForm()">重置</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:backPage()">返回</a>
	</div>
	<form id="carForm" metdod="post">
	<%-- <input name="uid" type="hidden" value="${userSession.u_id }" /> --%>
		<%-- <input name="companyid" type="hidden" value="${userSession.companyid }" /> --%>
		<input name="uid" type="hidden" value="1" />
		<input hidden="hidden" name="id"/>
		<div id="aa" class="easyui-accordion" data-options="border:false">
			<div title="售后基本信息"
				data-options="collapsed:false,collapsible:false,border:false"
				style="overflow: auto;">
				<table class="grid">
					<tr>
						<th>接听时间：</th>
						<td>
							<!-- 						<input name="riqi" class="easyui-datebox" type="text" style="width: 200px;"> -->
							<input id="riqi" type="text" name="riqi"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							class="Wdate" style="width: 200px" />
						</td>
						<th>客服人员：</th>
						<td><input class="easyui-validatebox" name="customer" style="width: 200px;"   ></td>
					</tr>
					<tr>
						<th>客户公司：</th>
						<td><input id="company" class="easyui-validatebox" name="company" style="width: 200px;"></input></td>
						<th>车牌号：</th>
						<td><input class="easyui-validatebox" name="carNo" style="width: 200px;"   ></td>


					</tr>
					<tr>
						<th>联系人：</th>
						<td><input class="easyui-validatebox" name="linkman"
							style="width: 200px;" data-options="required:true" type="text"></td>
						<th>联系方式：</th>
						<td><input name="telephone" class="easyui-validatebox"  style="width: 200px;"  data-options="required:true" /></td>
					</tr>
					<tr>
						<th>地址：</th>
						<td colspan="3"><input name="address" type="text"
							style="width: 300px;"></td>
					</tr>
					<tr>
						<th>服务类型：</th>
						<td><input name="serviceType" type="radio" value="装机"
							checked="checked" />装机 <input name="serviceType" type="radio"
							value="维修" />维修 <input name="serviceType" type="radio"
							value="回访" />回访 <input name="serviceType" type="radio"
							value="其他" />其他</td>
						<th>服务状态：</th>
						<td><input name="serviceStatus" type="radio" value="保内"
							checked="checked" />保内 <input name="serviceStatus" type="radio"
							value="保外" />保外 <input name="serviceStatus" type="radio"
							value="其他" />其他</td>
					</tr>
					<tr>
						<th>设备故障及原因：</th>
						<td colspan="3"><input type="text" style="width: 400px;"
							name="error" /></td>

					</tr>
					<tr>
						
						<th>派单时间：</th>
						<td>
						<input id="serviceRiqi" type="text" name="serviceRiqi"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							class="Wdate" style="width: 200px" /></td>
							<th>服务人员：</th>
						<td><input type="text" style="width: 200px;" name="serviceMan" /></td>
					</tr>
					
					<tr>
						<th>更换零件：</th>
						<td><input type="text" style="width: 200px;" name="instead" /></td>
						<th>服务结果：</th>
						<td><input name="result" type="radio" value="未解决"	checked="checked" />未解决 
							<input name="result" type="radio" value="已解决" />已解决</td>
							
					</tr>
					
				</table>
			</div>
			
		</div>
	</form>
</body>
</html>