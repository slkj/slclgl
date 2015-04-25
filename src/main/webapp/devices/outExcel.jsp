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
			<th>包装</th>
			<th>使用状态</th>
			<th>设备编号</th>
			<th>设备厂商</th>
			<th>厂牌型号</th>
			<th>入库时间</th>
		</tr>
		<tbody id="tb">
			<tr height="30">
				<td>0</td>
				<td>未出库</td>
				<td>5121211018</td>
				<td>珠海天琴</td>
				<td>SL-02</td>
				<td>2015-01-01</td>
			</tr>
		</tbody>
	</table>
</body>
</html>