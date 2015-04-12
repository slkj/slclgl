var grid;
var basePath = "../company/";
$(function() {
	// 初始化页面
	loadTree();
	$("#search_btn").click(function() {
		$('#dg').datagrid({
			queryParams : form2Json("searchform")
		}); // 点击搜索
		// 清空表单
		$('#searchform').form('clear');
	});

});
function loadTree() {
	$('#comtree').tree({
		url : basePath + 'getTreeList',
		lines : true,
		onClick : function(node) {
			if (node != null) {
				loadCompany(node.id);
			}
		},
		onLoadSuccess : function(node, data) {
			if (data) {
				loadCompany(data[0].id);
			}

		}
	// onBeforeExpand: function(node){
	// if(node){
	// $('#comtree').tree('options').url = basePath + "/getTreeList?currentId="
	// + node.id ;
	// }
	// }
	});
}
function loadCompany(id) {
	$.ajax({
		url : basePath + 'queryOne?id=' + id,
		async : false,
		cache : false,
		success : function(data) {
			if (data) {
				$("#compName").text(data.compName);
				$("#compSName").text(data.compSName);
				$("#organizationCode").text(data.organizationCode);
				$("#corporate").text(data.corporate);
				$("#contactMenber").text(data.contactMenber);
				$("#contactWay").text(data.contactWay);
				$('#level').combobox('setValue', data.level);
				$("#businessLicense").text(data.businessLicense);
				$("#registeredCapital").text(data.registeredCapital+"万元");
				$("#email").text(data.email);
				$("#compAddress").text(data.compAddress);
				$("#introduction").text(data.introduction);
				$("#remarks").text(data.remarks);
			}
		}
	});
}
function addCompany() {
	SL.showWindow({
		title : '新增公司',
		iconCls : 'icon-add',
		width : 700,
		height : 550,
		url : basePath + 'CompanyAdd.jsp',
		onLoad : function() {
			// autoSIM("phone");
		},
		buttons : [ {
			text : '确定',
			iconCls : 'icon-add',
			handler : function() {
				fCallback("save");
			}
		}, {
			text : '关闭',
			handler : function() {
				SL.closeWindow();
			}
		} ]
	});
}
function fCallback(url) {
	if ($("#comForm").form('enableValidation').form('validate')) {
		var data = $("#comForm").serialize();
		$.ajax({
			cache : false,
			type : "POST",
			url : basePath + url,
			data : data,
			async : false,
			success : function(data) {
				if (data) {
					$('#comtree').tree('reload');
					SL.closeWindow();
				}
			}
		});
	}
}
function delCompany() {
	var node = $('#comtree').tree('getSelected');
	// 判断是否是叶子节点
	if ($('#comtree').tree('isLeaf', node.target)) {
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.ajax({
					url : basePath + "delete?id=" + node.id,
					success : function(data) {
						if (data) {
							$('#comtree').tree('reload');
							top.max.sysSlideShow({
								msg : '成功删除!'
							});
						} else {
							top.$.messager.alert('提示', '删除失败，请联系管理员。');
						}
					}
				});
			}
		});
	} else {
		SL.msgShow("提示", "检测到该公司含有下属公司，无法删除！", "warning");
	}
}
function editCompany() {
}
function collapseAll() {
	$('#comtree').tree('collapseAll');
}
function expandAll() {
	$('#comtree').tree('expandAll');
}
// 将表单数据转为json
function form2Json(id) {
	var arr = $("#" + id).serializeArray()
	var jsonStr = "";
	jsonStr += '{';
	for (var i = 0; i < arr.length; i++) {
		jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
	}
	jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
	jsonStr += '}'

	var json = JSON.parse(jsonStr)
	return json
}