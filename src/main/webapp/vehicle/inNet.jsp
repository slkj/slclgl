<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆入网</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	var basePath = "../vehicle/";
	var id;
	var Request = new Object();
	$(function() {
		Request = GetRequest();
		id = Request['id'];
		$("#carid").val(id);
	});
	function submitForm() {
		if ($("#form").form('enableValidation').form('validate')) {
			$.ajax({
				cache : false,
				type : 'POST',
				url : basePath + 'activated',
				data :  $("#form").serialize(),
				async : false,
				success : function(data) {
					if (data) {
						backPage();
					} else {
						top.SL.msgShow("提示", "入网失败！", "warning");
					}
				}
			});
		}
	}
	//设备号联想搜索
	var sbloader = function(param, success, error) {
		// 获取输入的值
		var q = param.q || "";
		// 此处q的length代表输入多少个字符后开始查询
		if (q.length < 3)
			return false;
		$.ajax({
			url : "../devices/getList",
			//		type : "post",
			data : {
				// 传值，还是JSON数据
				listnum : q
			},
			// 重要，如果写jsonp会报转换错误，此处不写都可以
			dataType : "json",
			success : function(data) {
				// 关键步骤，遍历一个MAP对象
				var items = $.map(data, function(item) {
					return {
						id : item.listnum,
						name : item.listnum + "(" + item.firm + ")"
					};
				});
				// 执行loader的success方法
				success(items);
			}, // 异常处理
			error : function(xml, text, msg) {
				error.apply(this, arguments);
			}
		});
	};
	//SIM卡号联想搜索
	var btsloader = function(param, success, error) {
		// 获取输入的值
		var q = param.q || "";
		// 此处q的length代表输入多少个字符后开始查询
		if (q.length < 3)
			return false;
		$.ajax({
			url : "../sim/getList",
			//		type : "post",
			data : {
				// 传值，还是JSON数据
				telnum : q
			},
			// 重要，如果写jsonp会报转换错误，此处不写都可以
			dataType : "json",
			success : function(data) {
				// 关键步骤，遍历一个MAP对象
				var items = $.map(data, function(item) {
					return {
						id : item.telnum,
						name : item.telnum
					};
				});
				// 执行loader的success方法
				success(items);
			}, // 异常处理
			error : function(xml, text, msg) {
				error.apply(this, arguments);
			}
		});
	};
	function clearForm() {
		$('#form').form('clear');
// 		$("#regName").combobox("setValue", "3");
// 		$("#selCarType").combobox("setValue", "黄牌");
// 		$("#classify").combobox("setValue", "大型");
// 		$("#carObtWay").combobox("setValue", "购买");
// 		$('input:radio[name=carProType]')[0].checked = true;
	}
	function backPage() {
// 		parent.$("#cnIframe").attr("src", "carList.jsp");
		window.location.href = 'vehicleList.jsp';
	}
</script>
</head>
<body>
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:submitForm()">保存</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="javascript:clearForm()">重置</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:backPage()">返回</a>
	</div>
	<form id="form" metdod="post">
		<input id="carid" type="hidden" name="id">
		<div class="easyui-accordion" data-options="border:false">
			<div title="设备信息"
				data-options="collapsed:false,collapsible:false,border:false">
				<table class="grid">
					<tr>
						<th style="width: 120px">设备号:</th>
						<td style="width: 280px"><input name="equitment"
							class="easyui-combobox" style="width: 200px;"
							data-options="loader: sbloader,mode: 'remote',valueField: 'id',textField: 'name',required:true" /></td>
						<th style="width: 120px">SIM卡号:</th>
						<td style="width: 280px"><input name="simNumber"
							class="easyui-combobox" style="width: 200px;"
							data-options="loader: btsloader,mode: 'remote',valueField: 'id',textField: 'name',required:true" />
						</td>
					</tr>
					<tr>
						<th>入网证明编号:</th>
						<td><input name="networkNo" class="easyui-validatebox"
							style="width: 200px;" data-options="required:true" /></td>
						<th>安装人:</th>
						<td><input name="installers" class="easyui-validatebox"
							style="width: 200px;" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>安装日期:</th>
						<td>
							<input id="installtime" name="installtime" class="easyui-validatebox" style="width: 200px;" data-options="required:true"/>
							<img onclick="WdatePicker({el:'installtime',dateFmt:'yyyy-MM-dd HH:mm:ss'})" src="../js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
						</td>
						<th>安装地点:</th>
						<td><input name="installAddress" class="easyui-validatebox"
							style="width: 200px;" /></td>
					</tr>
				</table>
			</div>
			<div title="服务信息"
				data-options="collapsed:false,collapsible:false,border:false">
				<table class="grid">
<!-- 					<tr> -->
<!-- 						<th style="width: 120px">服务运营商:</th> -->
<!-- 						<td colspan="3"><input name="fees" class="easyui-combobox" -->
<!-- 							style="width: 300px;" /></td> -->
<!-- 					</tr> -->
					<tr>
						<th style="width: 120px">服务费:</th>
						<td style="width: 280px"><input name="fees"
							class="easyui-numberbox" style="width: 170px;"
							data-options="min:0,precision:2,prefix:'￥'" /> (元/月)</td>
						<th>缴费时间:</th>
						<td><input id="payerTime" name="payerTime" class="easyui-validatebox" 
							style="width: 150px;"   data-options="required:true"/> 
							<img onclick="WdatePicker({el:'payerTime'})" src="../js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/></td>
					</tr>
					<tr>
						<th>SIM卡缴费人 :</th>
						<td><input name="simPayer" class="easyui-validatebox"
							style="width: 200px;" /></td>
						<th style="width: 120px">安检到期时间:</th>
						<td style="width: 280px">
							<input id="feeseEnd" name="feeseEnd" class="easyui-validatebox" 	style="width: 150px;" data-options="required:true" />
							<img onclick="WdatePicker({el:'feeseEnd',dateFmt:'yyyy-MM'})" src="../js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
							<label><input id="ckISnotice" type="checkbox"
								name="ckISnotice">到期提醒</label></td>
					</tr>
				</table>
			</div>
			<div title="行业信息"
				data-options="collapsed:false,collapsible:false,border:false">
				<table class="grid">
					<tr>
						<th style="width: 120px">营运线路:</th>
						<td style="width: 280px"><input name="CTradingLine"
							class="easyui-validatebox" style="width: 200px;" /></td>
						<th style="width: 120px">载客数:</th>
						<td style="width: 280px"><input id="CCatchMenbers"
							name="regNum" class="easyui-validatebox" style="width: 150px;" /></td>
					</tr>
				</table>
			</div>
			<div title="备注"
				data-options="collapsed:false,collapsible:false,border:false">
				<textarea rows="3" cols="30" name="remark"
					style="width: 800px; margin: 5px"></textarea>
			</div>
		</div>


	</form>
</body>
</html>