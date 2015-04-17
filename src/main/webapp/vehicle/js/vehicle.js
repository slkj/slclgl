	var basePath = "../vehicle/";
	var grid;
	$(function() {
		// 初始化页面
		loadDataGrid();
		$("#search_btn").click(function() {
			$('#dg').datagrid({
				queryParams : form2Json("searchform")
			}); // 点击搜索
			// 清空表单
			$('#searchform').form('clear');
		});
	});
	function loadDataGrid() {
		grid = $('#dg')
				.datagrid(
						{
							method : 'post',
							url : basePath + 'list',
							fitColumns : false,
// 							title : '车辆列表',
							fit : true,
							nowrap : true, // false:折行
							rownumbers : true, // 行号
							striped : true, // 隔行变色
							pagination : true,
							singleSelect : true,
							autoRowHeight : false,//设置行的高度，根据该行的内容。设置为false可以提高负载性能。
							pageSize : 15,
							pageList : [ 1, 10, 15, 20, 30, 50 ],
							loadMsg : '数据加载中,请稍后……',
							columns : [ [
									{
										field : 'id',
										title : '车号'
									},{
										field : 'dw',
										title : '定位',
										formatter : function(value, row, index) {
											return "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:pos('"+ index + "');\">定位</span></a>";
										}
									},{
										field : '_state',
										title : '使用状态',
										formatter : function(value, row, index) {
											var s = "";
											if (typeof(row.networkNo)!="undefined" && row.networkNo !="" && row.networkNo != null ) {
												s = "<div style='background-color:#008B00;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>入网使用</div>";
											}
											return s;
										}
									},
									{
										field : 'carNumber',
										title : '车牌号',
										width : 100
									},
									{
										field : 'carOwner',
										title : '车主',
										width : 100
									},
									{
										field : 'fhtime',
										title : '车辆类型',
										width : 110,
										formatter : function(value, row, index) {
											return row.classify + row.carType;
										}
									},
									{
										field : 'equitment',
										title : '设备号',
										width : 100
									},
									{
										field : 'simNumber',
										title : 'SIM卡',
										width : 100
									},
									{
										field : 'networkNo',
										title : '入网证明编号',
										width : 100
									},
									{
										field : 'installtime',
										title : '安装日期',
										width : 80,
									},
									{
										field : 'companyName',
										title : '所属公司'
									},
									{
										title : '操作',
										field : '_operate',
										align : 'center',
										width : 240,
										formatter : function(value, row, index) {
											var s = "";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">详细</span></a>";
											s += "&nbsp;|&nbsp;";

											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:inNet('"
													+ row.id + "');\">入网</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:goBack('"
													+ index + "');\">编辑</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:deleteRow('"
													+ index + "');\">删除</span></a>";
											s += "&nbsp;|&nbsp;";
											s += "<a href=\"javascript:void(0)\"><span onclick=\"javaScript:detailCarInfo('"
													+ index + "');\">安装记录</span></a>";
											return s;
										}
									} ] ],
							toolbar : '#tb',
							onLoadSuccess : function() {
								grid.datagrid('clearSelections');
							}
						});
		// 设置分页控件
		grid.datagrid('getPager').pagination({
			beforePageText : '第',// 页数文本框前显示的汉字
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	}
	function pos(index) {
		var data = grid.datagrid('getData').rows[index];
		window.open('../location.jsp') 
	}
	function addCar() {
		window.location.href = 'vehicleAdd.jsp';
	}
	function inNet(id) {
		window.location.href = 'inNet.jsp?id='+id;
	}
	function detailCarInfo(index) {
		var data = grid.datagrid('getData').rows[index];
		SL.showWindow({
			title : '车辆详细信息',
			iconCls : 'icon-add',
			width : 800,
			height : 500,
			url : 'detailCarInfo.jsp',
			onLoad : function() {
				// autoSIM("phone");
			},
			buttons : [ {
				text : '关闭',
				handler : function() {
					SL.closeWindow();
				}
			} ]
		});
	}
	function deleteRow(index) {
		$.messager.confirm('提示', '将删除该车辆所有信息，确认删除?', function(row) {
			if (row) {
				var data = grid.datagrid('getData').rows[index];
				$.ajax({
					url : basePath + 'delete?id=' + data.id,
					success : function(data) {
						if (data) {
							grid.datagrid('reload');
							top.SL.sysSlideShow({
								msg : '成功删除!'
							});
						} else {
							SL.msgShow("提示", "操作错误，请联系管理员", "error");
						}
					}
				});
			}
		})
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