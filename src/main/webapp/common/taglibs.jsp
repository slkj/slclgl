<%
	String themeName = "default";

	Cookie cookies[] = request.getCookies();

	if (cookies != null && cookies.length > 0) {

		for (int i = 0; i < cookies.length; i++) {

			if ("themeName".equals(cookies[i].getName())) {

				themeName = cookies[i].getValue();

				break;

			}

		}

	}
%>
<link id="uiTheme" href="${pageContext.request.contextPath}/js/easyui-1.4.2/themes/<%=themeName %>/easyui.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/easyui-1.4.2/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/syscss.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.4.2/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.4.2/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src='${pageContext.request.contextPath}/js/SL.easyUI.js' type="text/javascript"></script>
<script src='${pageContext.request.contextPath}/js/DateUtil.js' type="text/javascript"></script>

