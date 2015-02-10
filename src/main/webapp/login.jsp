<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>围场县客货、出租车车辆管理系统平台</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="js/login.js"></script> -->
<script type="text/javascript">
	if (window != top) {
		top.location.href = location.href;
	}

	//加入收藏

	function AddFavorite(sURL, sTitle) {

		sURL = encodeURI(sURL);
		try {

			window.external.addFavorite(sURL, sTitle);

		} catch (e) {

			try {

				window.sidebar.addPanel(sTitle, sURL, "");

			} catch (e) {

				alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");

			}

		}

	}

	//设为首页

	function SetHome(url) {

		if (document.all) {

			document.body.style.behavior = 'url(#default#homepage)';

			document.body.setHomePage(url);

		} else {

			alert("您好,您的浏览器不支持自动设置页面为首页功能,请您手动在浏览器里设置该页面为首页!");

		}

	}
</script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="images/login_logo.png" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a onclick="SetHome(window.location)"
							href="javascript:void(0)">设为首页</a></li>
						<li><a onclick="AddFavorite(window.location,document.title)"
							href="javascript:void(0)">加入收藏</a></li>|
						<li><a href="#">反馈</a></li>
						<li><a href="#">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title">
					<img src="images/login_title.png" />
				</h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<p>
					<label>用户名：</label> <input type="text" id="username" size="20"
						class="login_input" />
				</p>
				<p>
					<label>密码：</label> <input type="password" id="password" size="20"
						class="login_input" />
				</p>
				<!-- 				<p> -->
				<!-- 					<label>验证码：</label> <input id="vcode" class="vcode" type="text" -->
				<!-- 						size="5" /> <span> <img src="images/AuthImageServlet" -->
				<!-- 						alt="" width="75" height="24" onclick="change(this)" /></span> -->
				<!-- 				</p> -->
				<div class="login_bar">
					<input id="loginBtn" class="sub" type="button" value=""
						onclick="login()" />
				</div>
			</div>
			<div class="login_banner">
				<img src="images/login_banner.jpg" />
			</div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>
				<div class="login_inner">
					<p>使用方便、自动提醒、扩展性强、节省成本、安全性高
				</div>
			</div>
		</div>
		<div id="login_footer">Copyright &copy; 2014 www.wlsh.cn Inc.
			All Rights Reserved.</div>
	</div>
</body>
</html>