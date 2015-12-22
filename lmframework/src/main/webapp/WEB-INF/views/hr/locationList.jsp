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
<title>Insert title here</title>
</head>
<body>

	<h2>Basic CRUD Application</h2>
	<p>Click the buttons on datagrid toolbar to do crud actions.</p>

	<table id="dg" title="locations" class="easyui-datagrid"
		style="width: 700px; height: 250px" url="queryLocations"
		toolbar="#toolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="locationId" width="50">ID</th>
				<th field="city" width="50">城市</th>
				<th field="postalCode" width="50">邮编</th>
				<th field="stateProvince" width="50">省</th>
				<th field="streetAddress" width="50">街道</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newUser()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyUser()">删除
			</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>First Name:</label> <input name="firstname"
					class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Last Name:</label> <input name="lastname"
					class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Phone:</label> <input name="phone" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Email:</label> <input name="email" class="easyui-textbox"
					validType="email">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="saveUser()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>
	<script type="text/javascript">
		var url;
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', 'New User');
			$('#fm').form('clear');
			url = 'save_user.php';
		}
		function editUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
				$('#fm').form('load', row);
				url = 'update_user.php?id=' + row.id;
			}
		}
		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					} else {
						$('#dlg').dialog('close'); // close the dialog
						$('#dg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm',
						'Are you sure you want to destroy this user?',
						function(r) {
							if (r) {
								$.post('destroy_user.php', {
									id : row.id
								}, function(result) {
									if (result.success) {
										$('#dg').datagrid('reload'); // reload the user data
									} else {
										$.messager.show({ // show error message
											title : 'Error',
											msg : result.errorMsg
										});
									}
								}, 'json');
							}
						});
			}
		}
	</script>
	<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
</body>
</html>