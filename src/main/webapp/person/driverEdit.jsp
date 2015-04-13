<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加货运车辆</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	var basePath = "../person/";
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
	         	/* var photo = '<img  src="../showPicture/load?imgPath='+data.photo+'" width="222" height="122"/>';
	         	$('#photo').html(photo); */
	        	$("#carForm").form('load', data);
	        	$("#car_type").combobox('setValue',data.driver_car_type);
	        }  
			
		});
	});
	function submitForm() {
		if ($("#carForm").form('enableValidation').form('validate')) {
			var data = $("#carForm").serialize();
			$.ajax({
				cache : false,
				type : 'POST',
				url : basePath + 'save',
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
		window.location.href = 'driver.jsp';
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
	
		<input hidden="true" id="qualification_type" name="qualification_type"
			value="" />
			<input hidden="hidden" name="id"/>
		<div id="aa" class="easyui-accordion" data-options="border:false">
			<div title="驾驶员基本信息"
				data-options="collapsed:false,collapsible:false,border:false"
				style="overflow: auto;">
				<table>
					<tr>
						<th>姓名：</th>
						<td><input class="easyui-validatebox" name="name" style="width: 200px;"
							data-options="required:true" type="text"></td>
						<th>身份证号：</th>
						<td><input class="easyui-validatebox" id="idcard_no" style="width: 200px;"
							name="idcard_no" data-options="required:true,validType:'idcard'"
							type="text"></td>
					</tr>
					<tr>
						<th>民族：</th>
						<td><input name="nation"  style="width: 200px;"/></td>
						<th>性别：</th>
						<td><input name="sex" type="radio" value="男"
							checked="checked" />男 <input name="sex" type="radio" value="女" />女</td>
					</tr>
					<tr>
						<th>出生年月日：</th>
						<td><input name="birth" type="text" class="easyui-datebox" style="width: 200px;"></td>
						<th>籍贯：</th>
						<td><input name="home" type="text" style="width: 200px;"></td>
					</tr>
					<tr>
						<th>电子邮件：</th>
						<td><input name="email" type="text" style="width: 200px;"></td>
						<th>联系电话：</th>
						<td><input name="telephone" class="easyui-validatebox" style="width: 200px;"
							data-options="required:true" type="text"></td>
					</tr>
					<tr>
						<th>政治面貌：</th>
						<td><select class="easyui-combobox" id="political" style="width: 200px;"
							name="political" editable="false">
								<option value="群众">群众</option>
								<option value="共青团员">共青团员</option>
								<option value="中共党员">中共党员</option>
						</select></td>
						<th>文化程度：</th>
						<td><select class="easyui-combobox" id="education" style="width: 200px;"
							name="education" editable="false">
								<option value="初中及以下">初中及以下</option>
								<option value="高中">高中</option>
								<option value="中专/技校">中专/技校</option>
								<option value="大专">大专</option>
								<option value="本科">本科</option>
								<option value="硕士以上">硕士以上</option>
						</select></td>
					</tr>
					<tr>
						<th>从业状态：</th>
						<td><select class="easyui-combobox" id="work_status" style="width: 200px;"
							name="work_status" editable="false">
								<option value="待业">待业</option>
								<option value="就业">就业</option>
						</select></td>
						<th>现服务车辆：</th>
						<td><input type="text" style="width: 200px;"
							 text-transform: uppercase;" name="fwcl" /></td>
							
					</tr>
					<tr><th>所属公司：</th>
						<td colspan="3"><select id="companyid" name="companyid" class="easyui-combotree" style="width:200px;"
									data-options="url:'../company/getTreeList',required:true,lines:true"></select></td></tr>
				</table>
			</div>
			<div title="驾驶证信息"
				data-options="collapsed:false,collapsible:false,border:false">
				<table>
					<tr>
						<th>档案编号：</th>
						<td><input name="driver_record_no" type="text" style="width: 200px;"></td>

						<th>驾驶证号：</th>
						<td><input class="easyui-validatebox" name="driver_no" style="width: 200px;"
							type="text" data-options="required:true"></td>
					</tr>
					<tr>
						<th>准驾车型：</th>
						<td><input id="car_type" style="width: 200px;"
							data-options="valueField:'code',textField:'code',url:'../data/qtype_data.json',multiple:true,required:true"
							class="easyui-combobox" name="driver_car_type" /></td>
						<th>初领时间：</th>
						<td><input name="driver_certify_time" class="easyui-datebox" type="text" style="width: 200px;"></td>
					</tr>
					<tr>
						<th>有效日期起：</th>
						<td><input name="driver_begin_time"
							data-options="required:true" class="easyui-datebox" type="text" style="width: 200px;"></td>
						<th>有效期限(年)：</th>
						<td><input name="driver_years" type="text" style="width: 200px;"
							class="easyui-numberbox" data-options="required:true"></td>
					</tr>
					<tr>
						<th>发证机关：</th>
						<td><input name="driver_authority" type="text" style="width: 200px;"></td>
						<th>经营许可证号：</th>
						<td><input name="bussiness_no" type="text" style="width: 200px;"></td>
					</tr>
					<tr>
						<th>联系地址：</th>
						<td colspan="3"><input name="address" type="text"
							style="width: 400px;"></td>
					</tr>
				</table>
			</div>
			<div title="从业资格信息"
				data-options="collapsed:false,collapsible:false,border:false">
				<table>
					<tr>
						<th>从业资格证号：</th>
						<td><input class="easyui-validatebox" style="width: 200px;"
							 name="qualification_no" type="text"></td>
						<th>从业资格证类别：</th>
						<td><select class="easyui-combobox" id="quali_kind" style="width: 200px;"
							name="quali_kind" editable="false">
								<option value="01001">客运驾驶员</option>
								<option value="02001">货运驾驶员</option>
								<option value="03001">危货驾驶员</option>
								<option value="03003">危货押运员</option>
								<option value="12002">客运乘务员</option>
						</select></td>
					</tr>
					<tr>
						<th>初次领证时间：</th>
						<td><input name="quali_certify_time" style="width: 200px;"
							class="easyui-datebox" type="text"></td>


						<th>有效期限：</th>
						<td><input name="quali_begin_time" style="width: 200px;"
							 class="easyui-datebox" type="text"
							style="width: 100px;">至 <input name="quali_end_time" style="width: 200px;"
							 class="easyui-datebox" type="text"
							style="width: 100px;"></td>
					</tr>
					<tr>
						<th>档案号：</th>
						<td><input name="quali_record_no" class="easyui-validatebox" style="width: 200px;"
							type="text"></td>
						<th>发证机关：</th>
						<td><input name="quali_authority" style="width: 200px;"
							 class="easyui-validatebox"
							type="text"></td>

					</tr>

				</table>
			</div>
		</div>
	</form>

	<div style="height: 30px"></div>
</body>
</html>