// 一层Combo
var srmCombx = $("#txtShouName").combobox({
	loader : function(param, success, error) {
		$.ajax({
			url : '${CTX_ROOT}/TEquipmentsController?method=getEquipmentByParId&id=' + selectSgId + '',
			dataType : 'json',
			success : function(data) {
				data.unshift({
					equipmentid : '',
					equipmentname : '全部'
				});
				success(data);
			},
			error : function() {
				error.apply(this, arguments);
			}
		});
	},
	onSelect : function(record) { // onSelect 用户点击时触发的事件
									// 在此的意义在于，用户点击一级后自动二级combobox
		piperowCombx.combobox({
			loader : function(param, success, error) {
				$.ajax({
					url : '${CTX_ROOT}/TEquipmentsController?method=getEquipmentByParId&id=' + $("#txtShouName").combobox("getValue") + '',
					dataType : 'json',
					success : function(data) {
						data.unshift({
							equipmentid : '',
							equipmentname : '全部'
						});
						success(data);
					},
					error : function() {
						error.apply(this, arguments);
					}
				});
			},
			onSelect : function(record) { // 这里也使用了onSelect事件，在二级combobox被用户点击时触发三级combobox
				pipeCombx.combobox({
					loader : function(param, success, error) {
						$.ajax({
							url : '${CTX_ROOT}/TEquipmentsController?method=getEquipmentByParId&id=' + $("#txtPipeRowName").combobox("getValue") + '',
							dataType : 'json',
							success : function(data) {
								data.unshift({
									equipmentid : '',
									equipmentname : '全部'
								});
								success(data);
							},
							error : function() {
								error.apply(this, arguments);
							}
						});
					},
					valueField : 'equipmentid',
					textField : 'equipmentname',
					value : '',
					editable : false
				});
			},
			onLoadSuccess : function() { // 清空三级下拉框 就是成功加载完触发的事件
											// 当一级combobox改变时，二级和三级就需要清空
				pipeCombx.combobox("clear");
				pipeCombx.combobox('setValue', '全部'); // 给combobox下拉框设置一个值，否则为空不好看
			},
			valueField : 'equipmentid',
			textField : 'equipmentname',
			value : '',
			editable : false
		}).combobox("clear"); // 清空二级下拉框

	},
	valueField : 'equipmentid',
	textField : 'equipmentname',
	value : '',
	editable : false
});
/** *************************************************************************************************** */
// 下面的俩个是组件，
// 二层Combo
var piperowCombx = $("#txtPipeRowName").combobox({
	loader : function(param, success, error) {
		$.ajax({
			url : '${CTX_ROOT}/TEquipmentsController?method=getEquipmentByParId&id=' + $("#txtShouName").combobox("getValue") + '',
			dataType : 'json',
			success : function(data) {
				data.unshift({
					equipmentid : '',
					equipmentname : '全部'
				});
				success(data);
			},
			error : function() {
				error.apply(this, arguments);
			}
		});
	},
	valueField : 'equipmentid',
	textField : 'equipmentname',
	value : '',
	editable : false
});

// 三层Combo
var pipeCombx = $("#txtPipeName").combobox({
	loader : function(param, success, error) {
		$.ajax({
			url : '${CTX_ROOT}/TEquipmentsController?method=getEquipmentByParId&id=' + $("#txtPipeRowName").combobox("getValue") + '',
			dataType : 'json',
			success : function(data) {
				data.unshift({
					equipmentid : '',
					equipmentname : '全部'
				});
				success(data);
			},
			error : function() {
				error.apply(this, arguments);
			}
		});
	},
	valueField : 'equipmentid',
	textField : 'equipmentname',
	value : '',
	editable : false
});