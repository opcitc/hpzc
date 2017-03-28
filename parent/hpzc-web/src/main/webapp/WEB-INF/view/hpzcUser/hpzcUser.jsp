<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>采购单界面</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<div id="form">
		<table>
			<tr>
				<td>账号:<input id="zh" name="zh" type="text"
					style="width: 120px"></td>
				<td>用户名:<input id="yhm" name="yhm" class="easyui-text"
					style="width: 120px"></td>
			</tr>
			<tr>
				<td>电话:<input id="dh" name="dh" class="easyui-text"
					style="width: 120px"></td>
				<td>QQ:<input id="qq" name="qq" class="easyui-text"
					style="width: 120px"></td>
				<td>供应商:<input id="gys" name="gys" style="width: 120px"></td>
			</tr>

		</table>
	</div>
	<div>
		<div id="cgd" style="padding: 5px; height: auto"></div>

	</div>
</body>
<script>
	$('#gys').combobox({
		valueField : 'name',
		textField : 'username',
		url : '${pageContext.request.contextPath}/hpzcUser/hpzcUserJson',
	});

	//返回查询条件
	function attrDatas() {
		return {
			zh : $('#zh').val(),
			yhm : $('#yhm').val(),
			dh : $('#dh').val(),
			qq : $('#qq').val()
		}
	}
	//重置
	function reset() {
		$('#zh').val("");
		$('#yhm').val("");
		$('#dh').val("");
		$('#qq').val("");
	}

	$(document).ready(function() {
		queryData();
	});

	function queryData() {
		var PageParam = new Object();
		var ParamMap = attrDatas();
		PageParam.page = 1;
		PageParam.pageSize = 10;
		var paramsMap = JSON.stringify(ParamMap);
		var map = eval("(" + paramsMap + ")");
		PageParam.searchContent = map;
		var paramsShow = JSON.stringify(PageParam);
		$('#cgd')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/hpzcUser/hpzcUserData',
							queryParams : {
								pageParam : paramsShow
							},
							rownumbers : true,
							title : "用户列表",
							contentType : "charset=UTF-8",
							pagination : true,
							idField : 'uId',
							pageSize : 10,
							pageList : [ 10, 20, 30 ],
							onDblClickRow : function(rowIndex, rowData) {
								if (obj.editRow != undefined) {
									$('#cgd').datagrid('endEdit', obj.editRow);
								}
								if (obj.editRow == undefined) {
									$('#cgd').datagrid('beginEdit', rowIndex);
									obj.editRow = rowIndex;
								}
							},
							onAfterEdit : function(rowIndex, rowData, changes) {
								var inserted = $('#cgd').datagrid('getChanges',
										'inserted');
								var updated = $('#cgd').datagrid('getChanges',
										'updated');
								var url = "";
								var info = "";
								//新增内容
								if (inserted.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcUser/hpzcUserSave';
									info = '个用户信息增加成功!';
								}
								//更新内容
								if (updated.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcUser/hpzcUserEdit';
									info = '个用户信息修改成功!';
								}
								$.ajax({
									type : 'post',
									url : url,
									data : {
										row : JSON.stringify(rowData),
									},
									beforeSend : function() {
										$('#cgd').datagrid('loading');
									},
									success : function(data) {
										if (data) {
											$('#cgd').datagrid('load');
											$('#cgd').datagrid('loading');
											$('#cgd').datagrid('unselectAll');
											$.messager.show({
												title : '提示',
												msg : data + info,
											});
											obj.editRow = undefined;
										}
									}
								})

							},
							columns : [ [ {
								field : 'uId',
								title : '用户ID',
								checkbox : true,
							}, {
								field : 'username',
								title : '账号',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'password',
								title : '密码',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'name',
								title : '用户名',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'tel',
								title : '联系电话',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'qq',
								title : 'QQ号',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'mail',
								title : '邮箱',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'memo',
								title : '备注',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							} ] ],
							toolbar : [ {
								text : '添加',
								iconCls : 'icon-add',
								handler : function() {
									obj.add();
								}
							}, '-', {
								text : '修改',
								iconCls : 'icon-edit',
								handler : function() {
									obj.edit();
								}
							}, '-', {
								text : '删除',
								iconCls : 'icon-remove',
								handler : function() {
									obj.remove();
								}
							}, '-', {
								text : "保存",
								iconCls : "icon-save",
								handler : function() {
									obj.save();
								}
							}, '-', {
								text : "取消编辑",
								iconCls : "icon-redo",
								handler : function() {
									obj.redo();
								}
							}, '-', {
								text : "打印",
								iconCls : "icon-print",
								handler : function() {
									delAppInfo();
								}
							}, '-', {
								text : '导出',
								iconCls : 'icon-save',
								handler : function() {
									openDialog("add_dialog", "edit");
								}
							}, '-', {
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									obj.search();
								}
							}, '-', {
								text : '重置',
								iconCls : 'icon-remove',
								handler : function() {
									obj.reset();
								}
							} ]
						})
	}

	obj = {
		editRow : undefined,
		add : function() {
			if (this.editRow == undefined) {
				$('#cgd').datagrid('insertRow', {
					index : 0,
					row : {

					},

				});
				$('#cgd').datagrid('beginEdit', 0);
				this.editRow = 0;
			}
		},
		save : function() {
			//将新增的一行设置为结束编辑状态
			$('#cgd').datagrid('endEdit', this.editRow);

		},
		redo : function() {
			this.editRow = undefined;
			$('#cgd').datagrid('rejectChanges');
		},
		edit : function() {
			var rows = $('#cgd').datagrid('getSelections');
			if (rows.length == 1) {
				if (this.editRow != undefined) {
					$('#cgd').datagrid('endEdit', this.editRow);
				}
				if (this.editRow == undefined) {
					var index = $('#cgd').datagrid('getRowIndex', rows[0]);
					$('#cgd').datagrid('beginEdit', index);
					this.editRow = index;
					//取消上一行的选定编辑状态!
					$('#cgd').datagrid('unselectRow', index);
				}
			} else {
				$.messager.alert('警告!', '修改时只能选择一行!', 'waring');
			}
		},
		remove : function() {
			var rows = $('#cgd').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager
						.confirm(
								'确定操作',
								'确定要删除选定的记录吗!',
								function(flag) {
									if (flag) {
										var ids = new Array();
										for (var i = 0; i < rows.length; i++) {
											ids.push(rows[i].hId);
										}
										//var hIds = JSON.stringify(ids.join(','));
										$
												.ajax({
													type : 'post',
													url : '${pageContext.request.contextPath}/hpzcUser/hpzcUserRemove',
													dataType : "json",
													data : {
														hIds : ids.join(','),
													},
													beforeSend : function(
															jqXHR, settings) {
														$('#cgd').datagrid(
																'loading');
													},
													success : function(data) {
														if (data) {
															$('#cgd').datagrid(
																	'load');
															$('#cgd').datagrid(
																	'loaded');
															$('#cgd')
																	.datagrid(
																			'unselectAll');
														}
														$.messager
																.show({
																	title : '提示!',
																	msg : data
																			+ '个用户被删除!',

																});
													},

												})
									}

								})
			} else {
				$.messager.alert('警告!', '请选择要删除的记录!', 'waring');
			}
		},
		search : function() {
			queryData();
		},
		reset : function() {
			reset();
			queryData()
		}
	};

	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	}

	//假设有这个方法,则编辑时原有内容清空!
	/* $.extend($.fn.datagrid.defaults.editors, {
		datetimebox : {
			init : function(container, options) {
				var input = $('<input type="text">').appendTo(container);
				options.editable = false;
				input.datetimebox(options);
				return input;
			},
			getValue : function(target) {
				return $(target).datetimebox('getValue');
			},
			setValue : function(target) {
				$(target).datetimebox('setValue', value);
			},
			resize : function(target, value) {
				$(target).datetimebox('resize', width);
			},
			destroy : function(target) {
				$(target).datetimebox('destroy');
			},

		}
	}) */
</script>
</html>