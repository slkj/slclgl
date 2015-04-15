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
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=9gzx74lMZMpAqPqtypvbmWUI">
	//v1.5版本的引用方式：src="http://api.map.baidu.com/api?v=1.5&ak=您的密钥"
	//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
</script>
</head>

<body>
	<div id="container"></div>
	<script type="text/javascript">
		var map = new BMap.Map('container');
		map.centerAndZoom(new BMap.Point(114.503246, 36.645486), 13);
// 	根据ip定位
// 		function myFun(result){
// 			var cityName = result.name;
// 			map.setCenter(cityName);
// 		}
// 		var myCity = new BMap.LocalCity();
// 		myCity.get(myFun);
		

		map.addControl(new BMap.NavigationControl());
		var icon = new BMap.Icon('images/map/green_east_22.gif', new BMap.Size(28, 32), {//是引用图标的名字以及大小，注意大小要一样
			anchor : new BMap.Size(20, 20)
		//这句表示图片相对于所加的点的位置
		});
		var marker = new BMap.Marker(new BMap.Point(114.503246, 36.645486), {
			icon : icon
		});
		map.addOverlay(marker);
		var opts = {
			width : 250,//信息窗口宽度height:100,//信息窗口高度  
			title : "冀DSL034："//信息窗口标题  
		}
		var infoWindow = new BMap.InfoWindow("状态：静止(6小时54分)<br/>信号：2015/04/13 16:55:33<br/>ACC:熄火",
				opts); // 创建信息窗口对象    
		map.openInfoWindow(infoWindow, map.getCenter()); // 打开信息窗口

	</script>
</body>
</html>