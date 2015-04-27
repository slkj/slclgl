var _menus;
window.onload = function() {
	$('#loading-mask').fadeOut();
}
var onlyOpenTitle = "欢迎使用";// 不允许关闭的标签的标题

$(function() {
	getMeuns();
	tabClose();
	tabCloseEven();
});
function getMeuns() {
	_menus = null;
	$.ajax({
		url : "module/list/user",
		async : false,
		dataType : "json",
		cache : false,
		success : function(data) {
			if(data.length > 0){
				_menus = data[0].children;
				InitLeftMenu();
			}
		}
	});
}
// 初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({
		animate : false,
		fit : true,
		border : false
	});
	var selectedPanelname = '';
	$.each(_menus, function(i, n) {
		var menulist = '';
		menulist += '<ul class="navlist">';
		$.each(n.children, function(j, o) {
			menulist += '<li><div><a ref="' + o.id + '" href="#" rel="' + o.url
					+ '" ><span class="pic ' + o.icon + '" >&nbsp;</span><span class="nav">'
					+ o.name + '</span></a></div> ';

			if (o.children && o.children.length > 0) {
				// li.find('div').addClass('icon-arrow');
				menulist += '<ul class="third_ul">';
				$.each(o.children, function(k, p) {
					menulist += '<li><div><a ref="' + p.id + '" href="#" rel="' + p.url
							+ '" ><span class="pic ' + p.icon
							+ '" >&nbsp;</span><span class="nav">' + p.name
							+ '</span></a></div> </li>'
				});
				menulist += '</ul>';
			}

			menulist += '</li>';
		})
		menulist += '</ul>';
		$('#nav').accordion('add', {
			title : n.name,
			content : menulist,
			border : false,
			iconCls : 'pic ' + n.icon
		});

		if (i == 0) {
			selectedPanelname = n.name;
		}

	});
	$('#nav').accordion('select', selectedPanelname);
	$('.navlist li a').click(function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = $(this).find('.pic').attr('class');
		var third = find(menuid);
		if (third && third.children && third.children.length > 0) {
			$('.third_ul').slideUp();
			var ul = $(this).parent().next();
			if (ul.is(":hidden"))
				ul.slideDown();
			else
				ul.slideUp();

		} else {
			addTab(menuid,tabTitle, url, icon);
			$('.navlist li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}
	}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
	// 选中第一个
	// var panels = $('#nav').accordion('panels');
	// var t = panels[0].panel('options').title;
	// $('#nav').accordion('select', t);
}
// 获取左侧导航的图标
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
closeAllTabs = function() {
	return closeTab("closeall");
};

