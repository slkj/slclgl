$.ajaxSetup({
	cache : false
});// ajax不缓存
// 定义全局对象
var max = $.extend({}, max);
/**
 * 增加formatString功能
 * 
 * @example sy.formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * @returns 格式化后的字符串
 */
max.formatString = function(str) {
	for (var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};
/**
 * 跳转页面
 * 
 * @param url
 */
function BackList(url) {

	window.location.href = url;
}
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
/**
 * 创建一个模式化的dialog
 */
max.modalDialog = function(options) {
	var opts = $.extend({
		title : options.title,
		width : options.width === undefined ? 600 : options.width,
		height : options.height === undefined ? 400 : options.height,
		minimizable : false,
		maximizable : false,
		collapsible : false,
		modal : true,
		onClose : function() {
			$(this).window('destroy');
		},
		loadingMessage : '正在加载数据，请稍等片刻......'
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.content = '<iframe scrolling="yes" frameborder="0"  src="'+ options.url + '" style="width:100%;height:98%;"></iframe>';
	}
	
	return $('<div id="win" />').dialog(opts);
};
max.closedlg = function() {
	$('#win').dialog('close');
};


max.showWindow = function(options) {
	var opts = $.extend({
		title : options.title,
		width : options.width === undefined ? 600 : options.width,
		height : options.height === undefined ? 400 : options.height,
		minimizable : false,
		maximizable : false,
		collapsible : false,
		modal : true,
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
max.closeWindow = function() {
	$('#win').dialog('close');
};

max.showMsg = function(title, msg, isAlert) {
    if (isAlert !== undefined && isAlert) {
          $.messager.alert(title, msg);
    } else {
          $.messager.show({
              title: title,
               msg: msg,
              showType: 'show'
         });
       }
  }
max.showConfirm = function(title, msg, callback) {
	$.messager.confirm(title, msg, function(r) {
		if (r) {
			if (jQuery.isFunction(callback))
				callback.call();
		}
	});
}
max.showProcess = function(isShow, title, msg) {
    if (!isShow) {
        $.messager.progress('close');
        return;
    }
    var win = $.messager.progress({
        title: title,
        msg: msg
    });
}
/**
 * 滑动显示信息,信息900m后消失
 */
max.sysSlideShow = function(options) {
	$.messager.show({
		title : '提示',
		msg : options.msg,
		timeout : 1200,
		showType : 'slide'
	});
};
/**
 * 渐进显示信息
 */
max.sysFadeShow = function(options) {
	$.messager.show({
		title : '提示',
		msg : options.msg,
		timeout : 1200,
		showType : 'fade'
	});
};

//将form中的值转换为键值对。
function getFormJson(frm) {
	var o = {};
	var a = $(frm).serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});

	return o;
}
function noheadimg() {
    var img = event.srcElement;
    img.src = "../images/icons/function_icon_set/user_48.png";
    img.onerror = null;
}
function PreviewImage(imgFile) {
	document.getElementById('textfield').value=imgFile.value;
	var path;
	if (document.all)//IE 
	{
		imgFile.select();
		path = document.selection.createRange().text;
		document.getElementById("imgPreview").innerHTML = "";
		document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale', src=\""
				+ path + "\")";//使用滤镜效果 
	} else//FF 
	{
		path = URL.createObjectURL(imgFile.files[0]);
		document.getElementById("imgPreview").innerHTML = "<img style=\"width:260px; height:150px;\" src='"+path+"'/>";
	}
}
