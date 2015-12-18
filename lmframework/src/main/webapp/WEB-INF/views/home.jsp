<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/js-plugins/jquery-ui-1.11.4/jquery-ui.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/js-plugins/JQuery zTree v3.4/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js-plugins/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js-plugins/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js-plugins/jquery-ui-1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js-plugins/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js-plugins/JQuery zTree v3.4/js/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js-plugins/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript">
	var setting = {};

	var zNodes = [ {
		name : "父节点1 - 展开",
		open : true,
		children : [ {
			name : "父节点11 - 折叠",
			children : [ {
				name : "叶子节点111"
			}, {
				name : "叶子节点112"
			}, {
				name : "叶子节点113"
			}, {
				name : "叶子节点114"
			} ]
		}, {
			name : "父节点12 - 折叠",
			children : [ {
				name : "叶子节点121"
			}, {
				name : "叶子节点122"
			}, {
				name : "叶子节点123"
			}, {
				name : "叶子节点124"
			} ]
		}, {
			name : "父节点13 - 没有子节点",
			isParent : true
		} ]
	}, {
		name : "父节点2 - 折叠",
		children : [ {
			name : "父节点21 - 展开",
			open : true,
			children : [ {
				name : "叶子节点211"
			}, {
				name : "叶子节点212"
			}, {
				name : "叶子节点213"
			}, {
				name : "叶子节点214"
			} ]
		}, {
			name : "父节点22 - 折叠",
			children : [ {
				name : "叶子节点221"
			}, {
				name : "叶子节点222"
			}, {
				name : "叶子节点223"
			}, {
				name : "叶子节点224"
			} ]
		}, {
			name : "父节点23 - 折叠",
			children : [ {
				name : "叶子节点231"
			}, {
				name : "叶子节点232"
			}, {
				name : "叶子节点233"
			}, {
				name : "叶子节点234"
			} ]
		} ]
	}, {
		name : "父节点3 - 没有子节点",
		isParent : true
	}

	];
	$(document).ready(function() {

		$.fn.zTree.init($("#treeDemo"), setting, zNodes);

	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">north
		region</div>
	<div data-options="region:'west',split:true,title:'West'"
		style="width: 240px; padding: 10px;">
		<div class="easyui-accordion" style="width: 230px; height: 300px;">
			<div title="OA办公" data-options="iconCls:'icon-help'"
				style="padding: 10px;">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div title="HR系统">
				<p>系统建设中。。。。。。</p>
			</div>
		</div>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center',title:'Center'">
		<iframe src="hr/toLocationList" width="99%" height="99%"></iframe>
	</div>
</body>
</html>
