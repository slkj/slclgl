<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神龙车辆管理服务平台</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/syscss.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='js/SL.easyUI.js'></script>
<script type="text/javascript" src='js/SL.index.js'></script>
<script type="text/javascript">
	//设置登录窗口
	function openPwd() {
		$('#w').window({
			title : '修改密码',
			width : 350,
			height : 200,
			modal : true,
			shadow : true,
			closed : true,
			resizable : false
		});
	}
	//关闭登录窗口
	function closePwd() {
		$('#w').window('close');
	}

	//修改密码
	function serverLogin() {
		var $newpass = $('#txtNewPass');
		var $rePass = $('#txtRePass');

		if ($newpass.val() == '') {
			msgShow('系统提示', '请输入密码！', 'warning');
			return false;
		}
		if ($rePass.val() == '') {
			msgShow('系统提示', '请在一次输入密码！', 'warning');
			return false;
		}

		if ($newpass.val() != $rePass.val()) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}

		$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
			msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
			$newpass.val('');
			$rePass.val('');
			close();
		})

	}

	$(function() {
		openPwd();
		$('#editpass').click(function() {
			$('#w').window('open');
		});
		$('#btnCancel').click(function() {
			closePwd();
		})

		$('#btnEp').click(function() {
			serverLogin();
		})
		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

				if (r) {
					location.href = 'login.jsp';
				}
			});
		})
	});
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" fit="true"
	scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>

	<div id="loading-mask"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #D2E0F2; z-index: 20000">
		<div id="pageloading"
			style="position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #8DB2E3; width: 200px; height: 40px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #15428B;">
			<img src="images/loading.gif" align="absmiddle" /> 正在加载中,请稍候...
		</div>
	</div>
<!-- 	<div data-options="region:'north'" style="border: 0px"> -->
<!-- 		<div class="header"> -->
<!-- 			<div class="header_cont"> -->
<!-- 				<div id="topMenus" class="hea_nav"></div> -->
<!-- 				<div class="system"> -->
<!-- 					<a id="editpass" href="javascript:void(0)" title="修改密码">  -->
<!-- 						<img border="0" src="images/btn_hd_support.gif" title="修改密码" alt="修改密码"> -->
<!-- 					</a> <a href="javascript:void(0)"  title="帮助">  -->
<!-- 						<img border="0" src="images/btn_hd_help.gif" title="帮助" alt="帮助"> -->
<!-- 					</a> <a id="loginOut" href="javascript:void(0)"  title="安全退出">  -->
<!-- 						<img border="0" src="images/btn_hd_exit.gif" title="安全退出" alt="安全退出"> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<div data-options="region:'north'"
		style="height: 60px; padding: 1px; overflow: hidden; width: 1438px; background: rgb(168, 215, 233);">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" style="vertical-align: text-bottom">
<!-- 					<img src="images/index/logo.jpg"> -->
<!-- 					<div style="position: absolute; top: 75px; left: 33px;"> -->
<!-- 						JEECG sdfsd <span style="letter-spacing: -1px;">3.4.3 GA</span> -->
<!-- 					</div> -->
				</td>
				<td align="right" nowrap>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr style="height: 25px;" align="right">
							<td style="" colspan="2">
								<div
									style="background: url(images/index/top_bg.jpg) no-repeat right center; float: right;">
									<div style="float: left; line-height: 25px; margin-left: 70px;">
										<span style="color: #386780">用户:</span>&nbsp;&nbsp;<span
											style="color: #FFFFFF">${userSession.username }</span>&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
									<div style="float: left; margin-left: 18px;">
										<div style="right: 0px; bottom: 0px;">
											<a id="editpass" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-comturn',plain:true">修改密码</a>  
											<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true">帮助</a>  
											<a id="loginOut" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-exit',plain:true">注销</a>  
										</div>
									</div>
								</div>
							</td>
						</tr>
<!-- 						<tr style="height: 80px;"> -->
<!-- 							<td colspan="2"> -->
<!-- 								<ul class="shortcut"> -->
<!-- 									<li style="position: relative;"><img class="imag1" -->
<!-- 										src="images/index/default.png" style="display: none;" /> <img -->
<!-- 										class="imag2" src="images/index/default_up.png" style="" /> -->
<!-- 										<div -->
<!-- 											style="width: 67px; position: absolute; top: 40px; text-align: center; color: #909090; font-size: 12px;">业务申请</div> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</td> -->
<!-- 						</tr> -->
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div region="south" split="true" border="false" style="height: 30px; overflow: hidden; width: 1440px;">
		<div class="footer">By 北京神龙天地网络科技有限公司 河北神龙物流信息科技有限公司</div>
	</div>
	<div region="west" split="true" title="导航菜单"
		style="left: 0px; top: 100px; width: 195px;" id="west">
		<div id="nav">
			<!--  导航内容 -->

		</div>

	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"
			tools="#mainTabs_tools">
			<div title="欢迎使用" data-options="iconCls:'pic pic_17'"
				style="padding: 20px; overflow: hidden; color: red;"></div>
		</div>
	</div>
	<div id="mainTabs_tools" class="tabs-tool"
		style="height: 27px; right: 0px;">
		<table>
			<tbody>
				<tr>
					<td><a id="mainTabs_jumpHome" class="easyui-linkbutton"
						title="跳至首页" data-options="plain: true, iconCls: 'pic pic_17'"></a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a id="mainTabs_toggleAll" class="easyui-linkbutton"
						title="关闭所有页面" data-options="plain: true, iconCls: 'pic pic_58'"
						onclick="closeAllTabs()"></a></td>
			</tbody>
		</table>
	</div>

	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="refresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="closeright">当前页右侧全部关闭</div>
		<div id="closeleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit">退出</div>
	</div>
	<div id="dd" />
</body>
</html>