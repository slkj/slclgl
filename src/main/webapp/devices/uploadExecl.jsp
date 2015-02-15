<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入EXECL</title>
<script type="text/javascript">
	//导入客户,在页面中引入 js/swfupload/ajaxfileupload.js
	function ajaxFileUpload() {
		var myfile = document.getElementById("myfile").value;
		jQuery.ajaxFileUpload({
			url : '${basePath}customer/upload.html', //你处理上传文件的服务端
			secureuri : false, //与页面处理代码中file相对应的ID值
			fileElementId : 'myfile',
			name : myfile,
			dataType : 'json', //返回数据类型:text，xml，json，html,scritp,jsonp五种
			autoSubmit : true,
			success : function(data, status) {
				alert("导入数据成功");
			}
		});
	}
</script>
</head>
<body>

	<form id="uform">
		<table class="grid">
			<tr>
				<td>添附文件 :<input class="easyui-filebox" name="file"
					data-options="prompt:'需要上传的文件',buttonText:'选择'" style="width: 70%" onclick="return ajaxFileUpload();">
					<button class="button" id="buttonUpload" onclick="return ajaxFileUpload();">导入</button>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;">导入结果</th>
			</tr>
			<tr>
				<td>haode</td>
			</tr>
		</table>
	</form>
</body>
</html>