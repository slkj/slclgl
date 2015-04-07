<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
	String fileName = "GPS设备清单.xls";
	fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
	response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="">
<title>gps设备清单</title>
</head>

<body>
	<table border="1" cellspacing="0" cellpadding="0">
<!-- 		<tr> -->
<!-- 			<td colspan="17">①使用状态：1=已出库；2=未出库;3=退回;4=入网使用;②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳</td> -->
<!-- 		</tr> -->
		<tr>
			<th>使用状态</th>
			<th>设备编号</th>
			<th>SIM卡号</th>
			<th>设备厂商</th>
			<th>厂牌型号</th>
			<th>入库时间</th>
			<th>领用人</th>
			<th>领用时间</th>
			<th>返还时间</th>
			<th>安装人</th>
			<th>安装时间</th>
			<th>车牌号</th>
			<th>使用公司</th>
			<th>入网证明编号</th>
			<th>测试</th>
			<th>测试时间</th>
			<th>测试结果</th>
			<th>所在地区</th>
		</tr>
		<tbody id="tb">
			<tr height="30">
				<td>已出库</td>
				<td>5121211018</td>
				<td>18132242201</td>
				<td>珠海天琴</td>
				<td>SL-02</td>
				<td>2011-02-02</td>
				<td>马续辉</td>
				<td>2010-02-02</td>
				<td>2010-03-02</td>
				<td>马续辉</td>
				<td>2010-02-02</td>
				<td>冀DSL104</td>
				<td>神龙</td>
				<td>XS0000001</td>
				<td>已测试</td>
				<td>2010-02-02</td>
				<td>定位</td>
				<td>沧州</td>
			</tr>
		</tbody>
	</table>
</body>
</html>