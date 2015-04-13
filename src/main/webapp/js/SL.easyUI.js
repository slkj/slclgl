var SL = $.extend({}, SL);
SL.showWindow = function(options) {
	var opts = $.extend({
		title : options.title,
		iconCls : options.iconCls,
		width : options.width === undefined ? 600 : options.width,
		height : options.height === undefined ? 400 : options.height,
		minimizable : false,
		maximizable : false,
		collapsible : false,
		cache : false,
		onClose : function() {
			$(this).window('destroy');
		},
		loadingMessage : '正在加载数据，请稍等片刻......'
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.href = options.url;
	}

	return $('<div id="win" />').dialog(opts);
};
SL.closeWindow = function() {
	$('#win').dialog('close');
};

/**
 * 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
 */
SL.msgShow = function(title, msgString, msgType) {
	
	$.messager.alert(title == null ? "提示" : title, msgString, msgType == null ? "warning" : msgType);
}

SL.sysSlideShow = function(options) {
	$.messager.show({
		title : '提示',
		msg : options.msg,
		timeout : 1200,
		showType : 'slide'
	});
};
/**
 * 获取url中参数
 * 
 * @param name
 * @returns
 */
function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}