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
		<tr>
			<th nowrap="nowrap" style="text-align: center">设备编号</th>
			<th nowrap="nowrap" style="text-align: center">设备厂商</th>
			<th nowrap="nowrap" style="text-align: center">设备类别</th>
			<th nowrap="nowrap" style="text-align: center">厂牌型号</th>
			<th nowrap="nowrap" style="text-align: center">入库时间</th>
			<th nowrap="nowrap" style="text-align: center">使用状态</th>
			<th nowrap="nowrap" style="text-align: center">返还时间</th>
			<th nowrap="nowrap" style="text-align: center">领用人</th>
			<th nowrap="nowrap" style="text-align: center">领用时间</th>
			<th nowrap="nowrap" style="text-align: center">测试</th>
			<th nowrap="nowrap" style="text-align: center">卡号</th>
			<th nowrap="nowrap" style="text-align: center">测试时间</th>
			<th nowrap="nowrap" style="text-align: center">测试结果</th>
		</tr>
		<tbody id="tb">
			<tr height="30">
				<td align="center" nowrap="nowrap">5121211018</td>
				<td align="center" nowrap="nowrap">珠海天琴</td>
				<td align="center" nowrap="nowrap"></td>
				<td align="center" nowrap="nowrap"></td>
				<td align="center" nowrap="nowrap">2011-02-02</td>
				<td align="center" nowrap="nowrap">已出库</td>
				<td align="center" nowrap="nowrap">2010-02-02</td>
				<td align="center" nowrap="nowrap">maxh</td>
				<td align="center" nowrap="nowrap">2010-02-02</td>
				<td align="center" nowrap="nowrap">已测试</td>
				<td align="center" nowrap="nowrap">15533071304</td>
				<td align="center" nowrap="nowrap">2010-02-02</td>
				<td align="center" nowrap="nowrap">定位</td>
			</tr>
		</tbody>
	</table>
</body>
</html>