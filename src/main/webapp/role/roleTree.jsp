<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 1px;">
		<div class="easyui-panel" style="padding: 1px;" fit="true"
			border="false" id="functionListPanel">
			<input type="hidden" name="orgId" value="${orgId}" id="orgId">
			<a id="selecrAllBtn" onclick="selecrAll();"> </a> <a id="resetBtn"
				onclick="reset();"> </a>
			<ul id="orgRoleTree"></ul>
		</div>
	</div>
</div>
