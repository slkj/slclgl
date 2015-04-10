<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备统计报表</title>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">
	//路径配置
	require.config({
		paths : {
			echarts : 'http://echarts.baidu.com/build/dist'
		}
	});

	var option = {
		title : {
			text : '入库数量和降安装量'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '入库数量', '安装量' ]
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : [ '神龙', '珠海天琴', '华宝', '博实结', '中斗', '赛格', '航天无线', '鸿泉' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '入库数量',
			type : 'bar',
			data : [ 1111, 2222, 333, 1773, 133, 112, 33, 44 ]
		}, {
			name : '安装量',
			type : 'bar',
			data : [ 999, 1000, 231, 1760, 99, 100, 20, 40 ]
		} ]
	};
	var option1 = {
		    title : {
		        text: 'iphone销量',
		        subtext: '纯属虚构',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item'
		    },
		    legend: {
		        orient: 'vertical',
		        x:'left',
		        data:['iphone3','iphone4','iphone5']
		    },
		    dataRange: {
		        min: 0,
		        max: 2500,
		        x: 'left',
		        y: 'bottom',
		        text:['高','低'],           // 文本，默认为数值文本
		        calculable : true
		    },
		    toolbox: {
		        show: true,
		        orient : 'vertical',
		        x: 'right',
		        y: 'center',
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    series : [
		        {
		            name: 'iphone3',
		            type: 'map',
		            mapType: 'china',
		            roam: false,
		            itemStyle:{
		                normal:{label:{show:true}},
		                emphasis:{label:{show:true}}
		            },
		            data:[
		                {name: '北京',value: Math.round(Math.random()*1000)},
		                {name: '天津',value: Math.round(Math.random()*1000)},
		                {name: '上海',value: Math.round(Math.random()*1000)},
		                {name: '重庆',value: Math.round(Math.random()*1000)},
		                {name: '河北',value: Math.round(Math.random()*1000)},
		                {name: '河南',value: Math.round(Math.random()*1000)},
		                {name: '云南',value: Math.round(Math.random()*1000)},
		                {name: '辽宁',value: Math.round(Math.random()*1000)},
		                {name: '黑龙江',value: Math.round(Math.random()*1000)},
		                {name: '湖南',value: Math.round(Math.random()*1000)},
		                {name: '安徽',value: Math.round(Math.random()*1000)},
		                {name: '山东',value: Math.round(Math.random()*1000)},
		                {name: '新疆',value: Math.round(Math.random()*1000)},
		                {name: '江苏',value: Math.round(Math.random()*1000)},
		                {name: '浙江',value: Math.round(Math.random()*1000)},
		                {name: '江西',value: Math.round(Math.random()*1000)},
		                {name: '湖北',value: Math.round(Math.random()*1000)},
		                {name: '广西',value: Math.round(Math.random()*1000)},
		                {name: '甘肃',value: Math.round(Math.random()*1000)},
		                {name: '山西',value: Math.round(Math.random()*1000)},
		                {name: '内蒙古',value: Math.round(Math.random()*1000)},
		                {name: '陕西',value: Math.round(Math.random()*1000)},
		                {name: '吉林',value: Math.round(Math.random()*1000)},
		                {name: '福建',value: Math.round(Math.random()*1000)},
		                {name: '贵州',value: Math.round(Math.random()*1000)},
		                {name: '广东',value: Math.round(Math.random()*1000)},
		                {name: '青海',value: Math.round(Math.random()*1000)},
		                {name: '西藏',value: Math.round(Math.random()*1000)},
		                {name: '四川',value: Math.round(Math.random()*1000)},
		                {name: '宁夏',value: Math.round(Math.random()*1000)},
		                {name: '海南',value: Math.round(Math.random()*1000)},
		                {name: '台湾',value: Math.round(Math.random()*1000)},
		                {name: '香港',value: Math.round(Math.random()*1000)},
		                {name: '澳门',value: Math.round(Math.random()*1000)}
		            ]
		        },
		        {
		            name: 'iphone4',
		            type: 'map',
		            mapType: 'china',
		            itemStyle:{
		                normal:{label:{show:true}},
		                emphasis:{label:{show:true}}
		            },
		            data:[
		                {name: '北京',value: Math.round(Math.random()*1000)},
		                {name: '天津',value: Math.round(Math.random()*1000)},
		                {name: '上海',value: Math.round(Math.random()*1000)},
		                {name: '重庆',value: Math.round(Math.random()*1000)},
		                {name: '河北',value: Math.round(Math.random()*1000)},
		                {name: '安徽',value: Math.round(Math.random()*1000)},
		                {name: '新疆',value: Math.round(Math.random()*1000)},
		                {name: '浙江',value: Math.round(Math.random()*1000)},
		                {name: '江西',value: Math.round(Math.random()*1000)},
		                {name: '山西',value: Math.round(Math.random()*1000)},
		                {name: '内蒙古',value: Math.round(Math.random()*1000)},
		                {name: '吉林',value: Math.round(Math.random()*1000)},
		                {name: '福建',value: Math.round(Math.random()*1000)},
		                {name: '广东',value: Math.round(Math.random()*1000)},
		                {name: '西藏',value: Math.round(Math.random()*1000)},
		                {name: '四川',value: Math.round(Math.random()*1000)},
		                {name: '宁夏',value: Math.round(Math.random()*1000)},
		                {name: '香港',value: Math.round(Math.random()*1000)},
		                {name: '澳门',value: Math.round(Math.random()*1000)}
		            ]
		        },
		        {
		            name: 'iphone5',
		            type: 'map',
		            mapType: 'china',
		            itemStyle:{
		                normal:{label:{show:true}},
		                emphasis:{label:{show:true}}
		            },
		            data:[
		                {name: '北京',value: Math.round(Math.random()*1000)},
		                {name: '天津',value: Math.round(Math.random()*1000)},
		                {name: '上海',value: Math.round(Math.random()*1000)},
		                {name: '广东',value: Math.round(Math.random()*1000)},
		                {name: '台湾',value: Math.round(Math.random()*1000)},
		                {name: '香港',value: Math.round(Math.random()*1000)},
		                {name: '澳门',value: Math.round(Math.random()*1000)}
		            ]
		        }
		    ]
		};
		                    
	// 使用
	require(
		[ 
          'echarts', 
          'echarts/chart/bar',
          'echarts/chart/map'
        ], 
        function(ec) {
		var myChart = ec.init(document.getElementById('main'));
		myChart.setOption(option);
		var myChart1 = ec.init(document.getElementById('main1'));
		myChart1.setOption(option1);
	});
</script>
</head>
<body>
	<div id="tt" class="easyui-tabs" data-options="fit : true">
		<div title="设备总数">
			<div id="tb" style="padding: 5px; height: auto">
				<form name="searchform" method="post" action="" id="searchform">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td>统计年份: <input type="text" class="Wdate" id="d413"
								onfocus="WdatePicker({dateFmt:'yyyy年',minDate:'2008'})" /> 至 <input
								type="text" class="Wdate" id="d413"
								onfocus="WdatePicker({dateFmt:'yyyy年',minDate:'2008'})" /><a
								id="search_btn" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-search',plain:'true'">查询</a>
							</td>
						</tr>
						<tr height="3px"></tr>
					</table>
				</form>
			</div>
			<table class="grid" style="width: 500px">
				<tr>
					<th>类别</th>
					<th style="text-align: left;">神龙</th>
					<th style="text-align: left;">珠海天琴</th>
					<th style="text-align: left;">华宝</th>
					<th style="text-align: left;">博实结</th>
					<th style="text-align: left;">中斗</th>
					<th style="text-align: left;">赛格</th>
					<th style="text-align: left;">航天无线</th>
					<th style="text-align: left;">鸿泉</th>
				</tr>
				<tr>
					<th>数量</th>
					<td><a href="#">1111</a></td>
					<td><a href="#">2222</a></td>
					<td><a href="#">333</a></td>
					<td><a href="#">1773</a></td>
					<td><a href="#">133</a></td>
					<td><a href="#">112</a></td>
					<td><a href="#">33</a></td>
					<td><a href="#">44</a></td>
				</tr>
			</table>
			<div id="main" style="width: 900px; height: 400px"></div>
		</div>
		<div title="设备分布统计">
			<div id="tb" style="padding: 5px; height: auto">
				<form name="searchform" method="post" action="" id="searchform">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td>统计年份: <input type="text" class="Wdate" id="d413"
								onfocus="WdatePicker({dateFmt:'yyyy年',minDate:'2008'})" /> 至 <input
								type="text" class="Wdate" id="d413"
								onfocus="WdatePicker({dateFmt:'yyyy年',minDate:'2008'})" /><a
								id="search_btn" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-search',plain:'true'">查询</a>
							</td>
						</tr>
						<tr height="3px"></tr>
					</table>
				</form>
			</div>
			<table class="grid" style="width: 500px">
				<tr>
					<th>地区</th>
					<th style="text-align: left;">石家庄市</th>
					<th style="text-align: left;">邯郸市</th>
					<th style="text-align: left;">邢台市</th>
					<th style="text-align: left;">沧州市</th>
					<th style="text-align: left;">秦皇岛市</th>
					<th style="text-align: left;">唐山市</th>
					<th style="text-align: left;">保定市</th>
					<th style="text-align: left;">衡水市</th>
				</tr>
				<tr>
					<th>数量</th>
					<td><a href="#">1111</a></td>
					<td><a href="#">2222</a></td>
					<td><a href="#">333</a></td>
					<td><a href="#">1773</a></td>
					<td><a href="#">133</a></td>
					<td><a href="#">112</a></td>
					<td><a href="#">33</a></td>
					<td><a href="#">44</a></td>
				</tr>
			</table>
			<div id="main1" style="width: 900px; height: 400px"></div>
		</div>
		<div title="设备分布统计">tab3</div>
	</div>
</body>
</html>