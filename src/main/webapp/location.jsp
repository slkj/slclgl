<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆位置服务</title>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%; margin: 0px; padding: 0px
}

#container {
	height: 100%
}
/* 定义自定义信息窗体样式 */
div.info {
	position: relative; z-index: 100; border: 1px solid #BCBCBC; box-shadow: 0 0 10px; # B7B6B6; border-radius: 8px; background-color: rgba(255, 255, 255, 0.9); transition-duration: 0.25s;
}

div.info:hover {
	box-shadow: 0px 0px 15px #0CF;
}

div.info-top {
	position: relative; background: none repeat scroll 0 0 #F9F9F9; border-bottom: 1px solid #CCC; border-radius: 5px 5px 0 0;
}

div.info-top div {
	display: inline-block; color: #333333; font-size: 14px; font-weight: bold; line-height: 31px; padding: 0 10px;
}

div.info-top img {
	position: absolute; top: 10px; right: 10px; transition-duration: 0.25s;
}

div.info-top img:hover {
	box-shadow: 0px 0px 5px #000;
}

div.info-middle {
	font-size: 12px; padding: 10px; line-height: 21px;
}

div.info-bottom {
	height: 0px; width: 100%; clear: both; text-align: center;
}

div.info-bottom img {
	position: relative; z-index: 104;
}
</style>
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.3&key=f57c09a1ce42183281eeb3361aa23d6a">
	
</script>
<script type="text/javascript">
	function initialize() {
		var position = new AMap.LngLat(114.503246, 36.645486);
		var mapObj = new AMap.Map("container", {
			view : new AMap.View2D({//创建地图二维视口
				center : position,//创建中心点坐标
				zoom : 16, //设置地图缩放级别
				rotation : 0
			//设置地图旋转角度
			}),
			lang : "zh_cn"//设置地图语言类型，默认：中文简体
		});//创建地图实例
		mapObj.plugin([ "AMap.ToolBar", "AMap.OverView", "AMap.Scale" ], function() {
			//加载工具条
			tool = new AMap.ToolBar({
				direction : false,//隐藏方向导航
				ruler : true,//隐藏视野级别控制尺
				autoPosition : false
			//禁止自动定位
			});
			mapObj.addControl(tool);
			//加载鹰眼
			view = new AMap.OverView();
			mapObj.addControl(view);
			//加载比例尺
			scale = new AMap.Scale();
			mapObj.addControl(scale);
		});
		var marker = new AMap.Marker({ //创建自定义点标注                 
			map : mapObj,
			position : new AMap.LngLat(114.503246, 36.645486),
			offset: new AMap.Pixel(-10,-34),
			icon : "images/map/green_s_1.png"
		});
		//实例化信息窗体  
		var infoWindow2 = new AMap.InfoWindow(
				{
					isCustom : true, //使用自定义窗体  
					content : createInfoWindow(
							'冀DSL034',
							"<img src='http://tpc.googlesyndication.com/simgad/5843493769827749134' style='float:left;margin:0 5px 5px 0;'>"
									+ "地址：中华北金色尚都A座5层东北 0.3 公里<br/>电话：0310-5101518<br/>"),
					size : new AMap.Size(300, 0),
					offset : new AMap.Pixel(15, -40)
				});

		//关闭信息窗体  
		function closeInfoWindow() {
			mapObj.clearInfoWindow();
		}
		//构建自定义信息窗体   
		function createInfoWindow(title, content) {
			var info = document.createElement("div");
			info.className = "info";
			// 定义顶部标题  
			var top = document.createElement("div");
			top.className = "info-top";
			var titleD = document.createElement("div");
			titleD.innerHTML = title;
			var closeX = document.createElement("img");
			closeX.src = "images/map/close2.gif";
			closeX.onclick = closeInfoWindow;

			top.appendChild(titleD);
			top.appendChild(closeX);
			info.appendChild(top);
			// 定义中部内容  
			var middle = document.createElement("div");
			middle.className = "info-middle";
			middle.innerHTML = content;
			info.appendChild(middle);

			// 定义底部内容  
			var bottom = document.createElement("div");
			bottom.className = "info-bottom";
			var sharp = document.createElement("img");
			sharp.src = "images/map/sharp.png";
			bottom.appendChild(sharp);
			info.appendChild(bottom);
			return info;
		}
		// 		function myWindow(){
		infoWindow2.open(mapObj, marker.getPosition());
		// 		}
	}
</script>
</head>

<body onload="initialize()">
	<div id="container" style="width: 700px;height: 600px"></div>
</body>
</html>