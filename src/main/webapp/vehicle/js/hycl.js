var grid;
var basePath = "../vehicle/";
$(function() {
	// 初始化页面
	loadTree();
});
function loadTree() {
	$('#comtree').tree({
		url : '../company/getTreeList',
		lines : true,
		onClick : function(node) {
			if (node != null) {
				$('#dg').datagrid({
					queryParams : {
						company : "1"
					}
				});
			}
		},
		onLoadSuccess :function(node, data){
			$("#cnIframe").attr("src", "carList.jsp");
		}
	});
}
