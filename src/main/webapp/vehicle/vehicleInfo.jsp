<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆详细信息</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	var basePath = "../vehicle/";
	var id;
	var Request = new Object();
	$(function() {
		loadCompany();
		Request = GetRequest();
		id = Request['id'];
		$.ajax({
			url : basePath + 'queryOne?id=' + id,
			success : function(data) {
				if (data) {
					$("#carForm").form('load', data);
					$("input").attr("readOnly", true);
					// 					$("input").attr("disabled","disabled");
					$('#companyId').combobox('disable');
					$('#carOwnersType').combobox('disable');
					$('#plateColor').combobox('disable');
					$('#classify').combobox('disable');
					$('#carFuelType').combobox('disable');
					$('#carUseNatu').combobox('disable');
					$('#carObtWay').combobox('disable');
					$('#carType').combotree('disable');

				}
			}
		});
	});
	function loadCompany() {
		$('#companyId').combobox({
			url : '../company/queryComList',
			required : true,
			valueField : 'id',
			textField : 'compName',
			editable : false
		});
	}
	function backPage() {
		// 		window.location.href = 'vehicleList.jsp';
		history.go(-1);
	}
</script>
</head>
<body>
	<div class="easyui-panel" style="padding: 5px">
	<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:backPage()" data-options="iconCls:'icon-undo'">返回</a>
	</div>
	<form id="carForm" metdod="post">
		<div id="aa" class="easyui-accordion" data-options="border:false">
			<div title="车辆基本信息"
				data-options="collapsed:false,collapsible:false,border:false"
				style="overflow: auto;">
				<table class="grid">
					<tr>
						<th style="width: 120px">业户/车主:</th>
						<td style="width: 290px"><input name="carOwner"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" /></td>
						<th style="width: 120px">身份证明名称/号码:</th>
						<td style="width: 290px"><select class="easyui-combobox"
							id="carOwnersType" name="carOwnersType" editable="false">
								<option value="1">组织机构代码</option>
								<option value="2">营业执照</option>
								<option value="3" selected="selected">身份证</option>
						</select> / <input id="carOwnersCard" name="carOwnersCard"
							class="easyui-validatebox" style="width: 150px;" /></td>
					</tr>
					<tr>
						<th>联系人:</th>
						<td><input name="contacts" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;" /></td>
						<th>联系方式:</th>
						<td><input name="contactsTel" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>车牌号(主):</th>
						<td><input id="carNumber" name="carNumber"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" /></td>
						<th>所属公司:</th>
						<td><input id="companyId" name="companyId"
							style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>车牌号(挂):</th>
						<td><input id="carNumberG" name="carNumberG"
							style="width: 200px;" data-options="required:true" /></td>
						<th>车牌颜色:</th>
						<td><select id="plateColor" name="plateColor"
							class="easyui-combobox" data-options="required:true"
							style="width: 100px;">
								<option selected="selected" value="黄牌">黄牌</option>
								<option value="蓝牌">蓝牌</option>
								<option value="黑牌">黑牌</option>
								<option value="白牌">白牌</option>
								<option value="其他">其他</option>
						</select></td>
					</tr>
					<tr>
						<th>车辆类型:</th>
						<td><select class="easyui-combobox" id="classify"
							name="classify" style="width: 50px;">
								<option value="大型">大型</option>
								<option value="重型">重型</option>
								<option value="中型">中型</option>
								<option value="小型">小型</option>
								<option value="微型">微型</option>
								<option value="轻型">轻型</option>
						</select> <select id="carType" name="carType" class="easyui-combotree"
							style="width: 150px;"
							data-options="url:'../data/carcalss_data.json',required:true,lines:true,panelHeight:300,panelWidth:200"></select>
						</td>
						<th>车辆品牌:</th>
						<td><input id="carBrand" name="carBrand"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>车辆型号:</th>
						<td><input id="carModel" name="carModel"
							class="easyui-validatebox" style="width: 200px;" /></td>
						<th>车身颜色:</th>
						<td><input id="carColor" name="carColor"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" /></td>
					</tr>

					<tr>
						<th nowrap="nowrap">识别代号/车架号:</th>
						<td><input id="carVin" name="carVin"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" /></td>

						<th>使用性质:</th>
						<td><select id="carUseNatu" class="easyui-combobox"
							name="carUseNatu" style="width: 200px;"
							data-options="required:true">
								<option></option>
								<option value="001">货运</option>
								<option value="002">危化品运输</option>
								<option value="003">公路客运</option>
								<option value="006">公交客运</option>
								<option value="005">出租客运</option>
								<option value="004">旅游客运</option>
								<option value="007">非营运</option>
						</select></td>
					</tr>
					<tr>
						<th>外廓尺寸:</th>
						<td>长<input id="carOutLength" name="carOutLength"
							class="easyui-numberbox" style="width: 70px;" /> 宽<input
							id="carOutWidth" name="carOutWidth" class="easyui-numberbox"
							style="width: 70px;" /> 高<input id="carOutHeight"
							name="carOutHeight" class="easyui-numberbox" style="width: 70px;" />mm
						</td>
						<th>总质量:</th>
						<td><input id="carTotalmass" name="carTotalmass"
							class="easyui-numberbox" style="width: 200px;" />kg</td>
					</tr>
					<tr>
						<th style="width: 120px">发动机型号:</th>
						<td style="width: 290px"><input id="carEngModel"
							name="carEngModel" class="easyui-validatebox"
							style="width: 200px;" /></td>
						<th style="width: 120px">发动机号:</th>
						<td style="width: 290px"><input id="carEngNum"
							name="carEngNum" class="easyui-validatebox" style="width: 200px;" /></td>
					</tr>

					<tr>
						<th>燃料种类:</th>
						<td><select class="easyui-combobox" id="carFuelType"
							editable="false" name="carFuelType" style="width: 200px;">
								<option value="汽油">汽油</option>
								<option value="柴油">柴油</option>
								<option value="天然气">天然气</option>
								<option value="液化气">液化气</option>
								<option value="氧气">氧气</option>
								<option value="柴油">柴油</option>
								<option value="汽油">汽油</option>
						</select></td>
						<th>排量/功率:</th>
						<td><input id="carDisplacement" name="carDisplacement"
							class="easyui-validatebox" style="width: 100px;" />ml/ <input
							id="carPower" name="carPower" class="easyui-validatebox"
							style="width: 100px;" />kw</td>
					</tr>
					<tr>
						<th>制造厂名称:</th>
						<td><input id="carManuName" name="carManuName"
							class="easyui-textbox" style="width: 200px;" /></td>
						<th>转向形式:</th>
						<td><input id="carModality" name="carModality"
							class="easyui-textbox" style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>轮距:</th>
						<td>前<input id="carTreadBe" name="carTreadBe"
							class="easyui-numberbox" style="width: 100px;" /> 后<input
							id="carTreadAfter" name="carTreadAfter" class="easyui-numberbox"
							style="width: 100px;" />mm
						</td>
						<th>轮胎数:</th>
						<td><input id="carTireNum" name="carTireNum"
							class="easyui-numberbox" style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>轮胎规格:</th>
						<td><input id="carTireSpe" name="carTireSpe"
							class="easyui-textbox" style="width: 200px;" /></td>
						<th>钢板弹簧片数:</th>
						<td>后轴<input id="carNumOfSpring" name="carNumOfSpring"
							class="easyui-numberbox" style="width: 200px;" />片
						</td>
					</tr>
					<tr>
						<th>轴距:</th>
						<td><input id="carAxleDist" name="carAxleDist"
							class="easyui-numberbox" style="width: 200px;" />mm</td>
						<th>轴数:</th>
						<td><input id="carAxleNum" name="carAxleNum"
							class="easyui-numberbox" style="width: 200px;" /></td>
					</tr>
					<tr>
						<th>货箱内部尺寸:</th>
						<td>长<input id="carContLength" name="carContLength"
							class="easyui-numberbox" style="width: 70px;"
							data-options="min:0,precision:0" /> 宽<input id="carContWidth"
							name="carContWidth" class="easyui-numberbox" style="width: 70px;"
							data-options="min:0,precision:0" /> 高<input id="carContHeight"
							name="carContHeight" class="easyui-numberbox"
							style="width: 70px;" data-options="min:0,precision:0" />mm
						</td>
						<th>核定载质量:</th>
						<td><input id="carApproved" name="carApproved"
							class="easyui-numberbox" style="width: 200px;" />kg</td>
					</tr>
					<tr>
						<th>核定载客:</th>
						<td><input id="carApprGuest" name="carApprGuest"
							class="easyui-numberbox" style="width: 200px;" />人</td>
						<th>准牵引总质量:</th>
						<td><input id="carTrac" name="carTrac"
							class="easyui-numberbox" style="width: 200px;" />kg</td>
					</tr>
					<tr>
						<th>驾驶室载客:</th>
						<td><input id="carCabGuest" name="carCabGuest"
							class="easyui-numberbox" style="width: 200px;" />人</td>
						<th>国产/进口:</th>
						<td><input id="carProType" name="carProType" type="radio"
							disabled="disabled" value="国产" checked="checked" />国产 <input
							name="carProType" type="radio" value="进口" disabled="disabled" />进口</td>
					</tr>
					<tr>
						<th>车辆获取方式:</th>
						<td><select class="easyui-combobox" id="carObtWay"
							name="carObtWay" style="width: 200px;">
								<option value="购买" selected="selected">购买</option>
								<option value="仲裁裁决">仲裁裁决</option>
								<option value="继承">继承</option>
								<option value="赠予">赠予</option>
								<option value="协议抵偿债务">协议抵偿债务</option>
								<option value="资产重组">资产重组</option>
								<option value="资产整体买卖">资产整体买卖</option>
						</select></td>
						<th>车辆出厂日期:</th>
						<td><input id="carFacDate" name="carFacDate"
							class="easyui-datebox" disabled="true" style="width: 200px;" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<div>
		<label style="color: red;">上传车辆左前方45角度图片，图片上传，小于3M，jpg、jpeg格式</label>
		<form name="cForm" action="/springMVC7/file/upload2"
			enctype="multipart/form-data" method="post"">
			<ul style="padding-top: 0px; padding-bottom: 5px;">
				<li>车辆登记证上传： <input type="file" id="djFile" name="myfiles"
					size="28" accept="image/jpeg,image/png,image/gif,image/jpeg" />
				</li>
				<li>车辆合格证/行驶证： <input type="file" id="xsFile" name="myfiles"
					size="28" accept="image/jpeg,image/png,image/gif,image/jpeg" />
				</li>
				<li>车身照片： <input type="file" id="carimg" name="myfiles"
					size="28" accept="image/jpeg,image/png,image/gif,image/jpeg" />
				</li>
			</ul>
		</form>
	</div>
	<div style="height: 30px"></div>
</body>
</html>