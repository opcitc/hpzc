<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>采购单详情界面</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<div>

		<div id="form">
			<table>
				<tr>
					<td>采购金额: <input id="cgje" name="cgje" type="text"
						style="width: 180px">
					</td>
					<td>采购单编号:<input id="gCode" name="gCode" type="text"
						style="width: 180px"></td>
				</tr>
				<tr>
					<td>制单人:<input id="zdr" name="zdr" type="text"
						style="width: 180px"></td>
					<td>制单日期: <input id="zdrq" name="zdrq" style="width: 180px"></td>
				</tr>
				<tr>

					<td>采购人:<input id="cgr" name="cgr" class="easyui-text"
						style="width: 180px"></td>
					<td>采购日期: <input id="cgrq" name="cgrq" style="width: 180px"></td>
				</tr>
			</table>
		</div>
		<div id="cgd" style="padding: 5px; height: auto"></div>
	</div>
</body>
<script>
	$(document).ready(function() {
		init();
		queryData();
	});

	function init() {
		var hpzcCgd = ${hpzcCgd};
		$("#cgje").val(hpzcCgd.hPurMoney);
		$("#gCode").val(hpzcCgd.hCode);
		$("#zdr").val(hpzcCgd.hPlayName);
		$("#zdrq").val(hpzcCgd.hzdrq);
		$("#cgr").val(hpzcCgd.hPurName);
		$("#cgrq").val(hpzcCgd.hDate);
	};

	function queryData() {
		var gCode = $("#gCode").val();
		$('#cgd')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdDetailData',
							queryParams : {
								gCode : gCode
							},
							rownumbers : true,
							title : "单据详情列表",
							contentType : "charset=UTF-8",
							pagination : true,
							idField : 'gId',
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
								//rowData.gCode = gCode;
								var inserted = $('#cgd').datagrid('getChanges',
										'inserted');
								var updated = $('#cgd').datagrid('getChanges',
										'updated');
								var url = "";
								var info = "";
								//新增内容
								if (inserted.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdDetailSave';
									info = '个用户信息增加成功!';
								}
								//更新内容
								if (updated.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdDetailEdit';
									info = '个用户信息修改成功!';
								}
								$.ajax({
									type : 'post',
									url : url,
									data : {
										row : JSON.stringify(rowData),
										gCode:gCode,
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
								field : 'gId',
								title : '唯一ID',
								checkbox : true,
							}, {
								field : 'gCode',
								title : '采购单编号',
							}, {
								field : 'gSpbh',
								title : '商品编号',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gSpmc',
								title : '商品名称',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gGysbh',
								title : '供应商编号',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gGysmc',
								title : '供应商名称',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gSpdj',
								title : '采购单价',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gCgsm',
								title : '采购说明',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gCkbh',
								title : '仓库编号',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gCkmc',
								title : '仓库名称',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'gCreate',
								title : '创建日期',
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
		search : function() {

		},
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
											ids.push(rows[i].gId);
										}
										$
												.ajax({
													type : 'post',
													url : '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdDetailRemove',
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