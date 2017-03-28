<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>销售单界面</title>
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
					<td>销售人:<input id="xsr" name="zdr" type="text"
						style="width: 80px"></td>
					<td>销售日期: <input id="xsbegin" name="xsbegin"
						class="easyui-datebox" style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"> 到: <input
						id="xsend" name="xsend" class="easyui-datebox"
						style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"></td>
				</tr>
				<tr>
					<td>制单人:<input id="zdr" name="zdr" class="easyui-text"
						style="width: 80px"></td>
					<td>制单日期: <input id="zdbegin" name="zdbegin"
						class="easyui-datebox" style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"> 到: <input
						id="zdend" name="zdend" class="easyui-datebox"
						style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"></td>
				</tr>
				<tr>
					<td>销售部门:<input id="xsbm" name="gys" class="easyui-text"
						style="width: 80px"></td>
					<td>销售金额: <input id="minje" name="minje"
						class="easyui-numberspinner" type="text" style="width: 180px">
						到: <input id="maxje" name="maxje" class="easyui-numberspinner"
						type="text" style="width: 180px"></td>
				</tr>
			</table>
		</div>


		<div id="xsd" style="padding: 5px; height: auto"></div>

	</div>
</body>
<script>
	//返回查询条件
	function attrDatas() {
		return {
			xsr : $('#xsr').val(),
			zdr : $('#zdr').val(),
			xsbm : $('#xsbm').val(),
			xsbegin : $('#xsbegin').datebox('getValue'),
			xsend : $('#xsend').datebox('getValue'),
			zdbegin : $('#zdbegin').datebox('getValue'),
			zdend : $('#zdend').datebox('getValue'),
			minje : $('#minje').numberspinner('getValue'),
			maxje : $('#maxje').numberspinner('getValue')
		}
	}

	//重置
	function reset() {
		$('#xsr').val("");
		$('#zdr').val("");
		$('#xsbm').val("");
		$('#xsbegin').datebox('setValue', null);
		$('#xsend').datebox('setValue', null);
		$('#zdbegin').datebox('setValue', null);
		$('#zdend').datebox('setValue', null);
		$('#minje').numberspinner('setValue', null);
		$('#maxje').numberspinner('setValue', null);
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
		$('#xsd')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/hpzcXsd/hpzcXsdData',
							queryParams : {
								pageParam : paramsShow
							},
							rownumbers : true,
							title : "销售单列表",
							contentType : "charset=UTF-8",
							pagination : true,
							idField : 'xId',
							pageSize : 10,
							pageList : [ 10, 20, 30 ],
							onDblClickRow : function(rowIndex, rowData) {
								if (obj.editRow != undefined) {
									$('#xsd').datagrid('endEdit', obj.editRow);
								}
								if (obj.editRow == undefined) {
									$('#xsd').datagrid('beginEdit', rowIndex);
									obj.editRow = rowIndex;
								}
							},
							onAfterEdit : function(rowIndex, rowData, changes) {
								var inserted = $('#xsd').datagrid('getChanges',
										'inserted');
								var updated = $('#xsd').datagrid('getChanges',
										'updated');
								var url = "";
								var info = "";
								//新增内容
								if (inserted.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcXsd/hpzcXsdSave';
									info = '个用户信息增加成功!';
								}
								//更新内容
								if (updated.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcXsd/hpzcXsdEdit';
									info = '个用户信息修改成功!';
								}
								$.ajax({
									type : 'post',
									url : url,
									data : {
										row : JSON.stringify(rowData),
									},
									beforeSend : function() {
										$('#xsd').datagrid('loading');
									},
									success : function(data) {
										if (data) {
											$('#xsd').datagrid('load');
											$('#xsd').datagrid('loading');
											$('#xsd').datagrid('unselectAll');
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
								field : 'xId',
								title : '销售单ID',
								checkbox : true,
							}, {
								field : 'xXsdh',
								title : '销售单号',
							}, {
								field : 'xXsrq',
								title : '销售日期',
								editor : {
									type : 'datetimebox',
									options : {
										formatter : myformatter,
										parser : myparser,
										required : true
									}
								},
							}, {
								field : 'xYwyxm',
								title : '销售人',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'xZdrxm',
								title : '制单人',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'xXsje',
								title : '销售金额',
							}, {
								field : 'hZdrq',
								title : '制单日期',
							}, {
								field : 'remark1',
								title : '备注',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}

							] ],
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
							}, '-', {
								text : '销售详情',
								iconCls : 'icon-remove',
								handler : function() {
									addDetail();
								}
							} ]
						})
	}
	
	function addDetail() {
		var rows = $('#xsd').datagrid('getSelections');
		if (rows.length == 1) {
			window.location.href = "${pageContext.request.contextPath}/hpzcXsd/hpzcXsdDetail?xXsdh="
				+ rows[0].xXsdh; 
		} else {
			$.messager.alert('警告!', '查看采购单想详情时只能选择一行!', 'waring');
		}
	}


	obj = {
		editRow : undefined,
		search : function() {

		},
		add : function() {
			if (this.editRow == undefined) {
				$('#xsd').datagrid('insertRow', {
					index : 0,
					row : {

					},

				});
				$('#xsd').datagrid('beginEdit', 0);
				this.editRow = 0;
			}
		},
		save : function() {
			//将新增的一行设置为结束编辑状态
			$('#xsd').datagrid('endEdit', this.editRow);

		},
		redo : function() {
			this.editRow = undefined;
			$('#xsd').datagrid('rejectChanges');
		},
		edit : function() {
			var rows = $('#xsd').datagrid('getSelections');
			if (rows.length == 1) {
				if (this.editRow != undefined) {
					$('#xsd').datagrid('endEdit', this.editRow);
				}
				if (this.editRow == undefined) {
					var index = $('#xsd').datagrid('getRowIndex', rows[0]);
					$('#xsd').datagrid('beginEdit', index);
					this.editRow = index;
					//取消上一行的选定编辑状态!
					$('#xsd').datagrid('unselectRow', index);
				}
			} else {
				$.messager.alert('警告!', '修改时只能选择一行!', 'waring');
			}
		},
		remove : function() {
			var rows = $('#xsd').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager
						.confirm(
								'确定操作',
								'确定要删除选定的记录吗!',
								function(flag) {
									if (flag) {
										var ids = new Array();
										for (var i = 0; i < rows.length; i++) {
											ids.push(rows[i].xId);
										}
										$
												.ajax({
													type : 'post',
													url : '${pageContext.request.contextPath}/hpzcXsd/hpzcXsdRemove',
													dataType : "json",
													data : {
														hIds : ids.join(','),
													},
													beforeSend : function(
															jqXHR, settings) {
														$('#xsd').datagrid(
																'loading');
													},
													success : function(data) {
														if (data) {
															$('#xsd').datagrid(
																	'load');
															$('#xsd').datagrid(
																	'loaded');
															$('#xsd')
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
</script>
</html>