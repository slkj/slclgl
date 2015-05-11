<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神龙OA管理系统</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/syscss.css" />

<link rel="stylesheet" type="text/css" href="css/syscss.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='js/SL.easyUI.js' ></script>

<style type="text/css">
a {
	color: Black; text-decoration: none;
}

a:hover {
	color: black; text-decoration: none;
}

* {
	font-size: 12px; font-family: Tahoma, Verdana, 微软雅黑, 新宋体
}

a {
	color: Black; text-decoration: none;
}

a:hover {
	color: blue; text-decoration: none;
}

.footer {
	text-align: center; color: #15428B; margin: 0px; padding: 0px; line-height: 23px; font-weight: bold;
}

.head a {
	color: White; text-decoration: none;
}

.shortcut {
	margin-left: 5px; margin-top: 8px; height: 62px;
}

.shortcut li {
	float: left; list-style: none; margin-right: 10px; cursor: pointer;
}

.bigicon .img {
	display: block
}

.bigicon ul {
	
}

.bigicon li {
	text-align: center
}

.menuItem li div:hover {
	border: 1px dashed #D69C00; background: #FFE88C; cursor: pointer
}

.bigicon ul {
	list-style-type: none; margin: 0; padding: 10px
}

.bigicon ul li {
	padding: 0
}

.bigicon ul li a {
	line-height: 24px; cursor: pointer; text-decoration: none;
}

.bigicon ul li a span.nav {
	font-family: "Arial Negreta", "Arial"; font-weight: 700; font-style: normal; font-size: 12px; color: #333; text-align: left; line-height: normal;
}

.bigicon ul li div {
	margin: 2px 0; padding-left: 10px; padding-top: 2px; border: 1px solid transparent
}

.menuItem li div:hover {
	border: 1px dashed #D69C00; background: #FFE88C; cursor: pointer
}

.bigicon ul li div.hover a {
	color: #D16C00; text-decoration: none
}

.bigicon ul li div.selected {
	border: 1px solid #D69C00; background: #FFE88C; cursor: default
}

.bigicon ul li div.selected a {
	color: #D16C00; font-weight: bold
}
</style>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body id="index_layout" class="easyui-layout" style="overflow-y: hidden" scroll="no">
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
	<!-- 顶部-->
	<div region="north" border="false"
		style="height: 98px; padding: 1px; overflow: hidden; width: 1438px; display: block; background: rgb(168, 215, 233);">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" style="vertical-align: text-bottom">
					<img src="images/login/logo1.jpg">
<!-- 					<div style="position: absolute; top: 75px; left: 33px;"> -->
<!-- 						JEECG Framework <span style="letter-spacing: -1px;">3.4.3 -->
<!-- 							GA</span> -->
<!-- 					</div> -->
				</td>
				<td align="right" nowrap="">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr style="height: 25px;" align="right">
							<td style="" colspan="2">
								<div
									style="background: url(images/login/images/top_bg.jpg) no-repeat right center; float: right;">
									<div style="float: left; line-height: 25px; margin-left: 70px;">
										<span style="color: #386780">用户:</span> <span
											style="color: #FFFFFF">${userSession.realname }</span>&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
									<div style="float: left; margin-left: 18px;">
										<div style="right: 0px; bottom: 0px;">
											<a id="editpass" href="#" class="easyui-linkbutton"
												data-options="iconCls:'icon-comturn',plain:true">控制面板</a> <a
												id="btn" href="#" class="easyui-linkbutton"
												data-options="iconCls:'icon-tip',plain:true">帮助</a> <a
												id="loginOut" href="#" class="easyui-linkbutton"
												data-options="iconCls:'icon-exit',plain:true">注销</a>
										</div>


									</div>
								</div>
							</td>
						</tr>
						<tr style="height: 80px;">
							<td colspan="2">
								<ul id="topMenus" class="shortcut">
									<!-- 									<li style="position: relative;"><img class="imag1" src="plug-in/login/images/default.png" style="display: inline;">  <img class="imag2" src="plug-in/login/images/default_up.png" style="display: none;"><div style="width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;"><span style="letter-spacing:-1px;">自定义表单</span></div></li> -->
									<!-- 									<li><img class="imag1" src="plug-in/login/images/xtgl.png" style="display: none;">  <img class="imag2" src="plug-in/login/images/xtgl_up.png" style="display: inline;"> </li> -->
								</ul>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<!-- 左侧-->
	<div region="west" split="true" href="" title="导航菜单"
		style="width: 150px; padding: 1px;" class="bigicon">
		<ul id="menu1" class="bigicon menuItem"></ul>
	</div>
	<!-- 中间-->
	<div id="mainPanle" region="center" style="overflow: hidden;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div class="easyui-tab" title="首页" href=""
				style="padding: 2px; overflow: hidden;"></div>
		</div>
	</div>
	<!-- 底部 -->
	<div region="south" border="false"
		style="height: 25px; overflow: hidden;">
		<div align="center" style="color: #1fa3e5; padding-top: 2px">
			&copy; 版权所有 <span class="tip"> <a href="http://www.wlsh.cn"
				title="河北神龙物流信息科技有限公司">河北神龙物流信息科技有限公司</a> 版本 V2.0
			</span>
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
	</div>
	<div id="dd"></div>
</body>
</html>