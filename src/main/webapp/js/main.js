var _menus = null;
window.onload = function() {
	$('#loading-mask').fadeOut();
}
$(function() {
	getMeuns()
	tabClose();
	tabCloseEven();
	// 释放内存
	$.fn.panel.defaults = $.extend({}, $.fn.panel.defaults, {
		onBeforeDestroy : function() {
			var frame = $('iframe', this);
			if (frame.length > 0) {
				frame[0].contentWindow.document.write('');
				frame[0].contentWindow.close();
				frame.remove();
			}
			if ($.support.msie) {
				CollectGarbage();
			}
		}
	});

	$('#tabs').tabs({
		onSelect : function(title) {
			rowid = "";
		}
	});
});
function getMeuns() {
	$.ajax({
		url : "module/list/user",
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.length > 0) {
				_menus = data[0].children;
				var topMenus = '';
				$.each(_menus, function(i, sm) {
					if (sm.parent_id == "1") {
						topMenus += '<li id="' + i + '" style="position: relative;">' + '<img class="imag1" src="images/login/images/default.png" style="display: none;">' + '<img class="imag2" src="images/login/images/default_up.png" style="display: inline;">'
								+ '<div style="width: 67px; position: absolute; top: 40px; text-align: center; color: #909090; font-size: 12px;">' + sm.name + '</div></li>';
					}
				});
				$("#topMenus").append(topMenus);
			}
		}
	});
	// start for:新增首页风格,一级菜单点击事件的切换操作
	$(".shortcut li").on("click", function() {
		$(this).find(".imag1").hide();
		$(this).find(".imag2").show();
		$(this).siblings().find(".imag2").hide();
		$(this).siblings().find(".imag1").show();
		var m = _menus[this.id];
		if(m.children.length > 1){
			$('#index_layout').layout('expand','west');  
			InitLeftMenu(this.id);
		}else{
			$('#index_layout').layout('collapse','west');  
			addTab(m.id,m.name, m.url, "");
		}
		
	});
	// end for:新增首页风格,一级菜单点击事件的切换操作
	// 新增首页风格,初始化第一个菜单的内容显示
	$(".shortcut li").eq(0).trigger("click");
	// 新增首页风格,初始化第一个菜单的内容显示
}
var rowid = "";
// 初始化左侧
function InitLeftMenu(index) {
	//加载左侧菜单，加载前清空div 下内容
	$("#menu1").empty();
	var obj = _menus[index].children;
	var menulist = "";
	$.each(obj, function(i, key) {
		var o = obj[i];
		menulist += '<li><div style="overflow: auto;padding:5px;"><a ref="' + o.id + '" href="#" rel="' + o.url + '"><span class="img" ><img src="images/index/' + o.description + '"></span><span class="nav">' + o.name + '</span></a></div></li> ';
	});
	$("#menu1").append(menulist);
	//初始化左侧菜单点击事件
	$('#menu1 li a').on('click', function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var ref = $(this).attr("ref");
		
		addTab(ref,tabTitle, url, "");
		$('#menu1 li div').removeClass("selected");
		$(this).parent().addClass("selected");
	});
}
//获取左侧导航的图标
function getIcon(menuid) {
	var icon = 'pic ';
	$.each(_menus, function(i, n) {
		$.each(n.children, function(j, o) {
			if (o.id == menuid) {
				icon += o.icon;
			}
		})
	})

	return icon;
}

function find(menuid) {
	var obj = null;
	$.each(_menus, function(i, n) {
		$.each(n.children, function(j, o) {
			if (o.id == menuid) {
				obj = o;
			}
		});
	});

	return obj;
}

function addTab(menuid,subtitle, url, icon) {
	//动态传选择菜单id
	if(url.indexOf("?") >= 0){
		url += "&tabid="+menuid;
	}else{
		url += "?tabid="+menuid;
	}
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			id : menuid,
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		//刷新tabs
		var currentTab = $('#tabs').tabs('getSelected');
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		$('#tabs').tabs('update', {
			tab : currentTab,
			options : {
				content : createFrame(src)
			}
		})
		$('#mm-tabupdate').click();
		
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe id="tabiFrame" scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
		var subtitle = $(this).children(".tabs-closable").text();
		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {

	$('#mm').menu({
		onClick : function(item) {
			closeTab(item.id);
		}
	});

	return false;
}

function closeTab(action) {
	var alltabs = $('#tabs').tabs('tabs');
	var currentTab = $('#tabs').tabs('getSelected');
	var allTabtitle = [];
	$.each(alltabs, function(i, n) {
		allTabtitle.push($(n).panel('options').title);
	})

	switch (action) {
	case "refresh":
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		$('#tabs').tabs('update', {
			tab : currentTab,
			options : {
				content : createFrame(src)
			}
		})
		break;
	case "close":
		var currtab_title = currentTab.panel('options').title;
		if (currtab_title != onlyOpenTitle) {
			$('#tabs').tabs('close', currtab_title);
		}

		break;
	case "closeall":
		$.each(allTabtitle, function(i, n) {
			if (n != onlyOpenTitle) {
				$('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeother":
		var currtab_title = currentTab.panel('options').title;
		$.each(allTabtitle, function(i, n) {
			if (n != currtab_title && n != onlyOpenTitle) {
				$('#tabs').tabs('close', n);
			}
		});
		break;
	case "closeright":
		var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);

		if (tabIndex == alltabs.length - 1) {
			alert('亲，后边没有啦 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i > tabIndex) {
				if (n != onlyOpenTitle) {
					$('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "closeleft":
		var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
		if (tabIndex == 1) {
			alert('亲，首页无法关闭。 ^@^!!');
			return false;
		}
		$.each(allTabtitle, function(i, n) {
			if (i < tabIndex) {
				if (n != onlyOpenTitle) {
					$('#tabs').tabs('close', n);
				}
			}
		});

		break;
	case "exit":
		$('#closeMenu').menu('hide');
		break;
	}
}