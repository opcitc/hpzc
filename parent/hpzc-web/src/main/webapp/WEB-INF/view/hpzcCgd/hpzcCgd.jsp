<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@   page   import= "com.hpzc.controller.test.* "%> --%>
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
	在线人数为：<%=com.hpzc.controller.test.SessionCounter.getSession()%>
	<div>
		<div id="form">
			<table>
				<tr>
					<td>制单人:<input id="zdr" name="zdr" type="text"
						style="width: 80px"></td>
					<td>制单日期: <input id="zdbegin" name="zdbegin"
						class="easyui-datebox" style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"> 到: <input
						id="zdend" name="zdend" class="easyui-datebox"
						style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"></td>

				</tr>
				<tr>

					<td>采购人:<input id="cgr" name="cgr" class="easyui-text"
						style="width: 80px"></td>
					<td>采购日期: <input id="cgbegin" name="cgbegin"
						class="easyui-datebox" style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"> 到: <input
						id="cgend" name="cgend" class="easyui-datebox"
						style="width: 180px"
						data-options="formatter:myformatter,parser:myparser"></td>

				</tr>
				<tr>
					<td>供应商:<input id="gys" name="gys" class="easyui-text"
						style="width: 80px"></td>
					<td>采购金额: <input id="minje" name="minje"
						class="easyui-numberspinner" type="text" style="width: 180px">
						到: <input id="maxje" name="maxje" class="easyui-numberspinner"
						type="text" style="width: 180px"></td>
				</tr>
			</table>
		</div>
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
			zdr : $('#zdr').val(),
			cgr : $('#cgr').val(),
			gys : $('#gys').val(),
			zdbegin : $('#zdbegin').datebox('getValue'),
			zdend : $('#zdend').datebox('getValue'),
			cgbegin : $('#cgbegin').datebox('getValue'),
			cgend : $('#cgend').datebox('getValue'),
			minje : $('#minje').numberspinner('getValue'),
			maxje : $('#maxje').numberspinner('getValue')
		}
	}
	//重置
	function reset() {
		$('#zdr').val("");
		$('#cgr').val("");
		$('#gys').val("");
		$('#zdbegin').datebox('setValue', null);
		$('#zdend').datebox('setValue', null);
		$('#cgbegin').datebox('setValue', null);
		$('#cgend').datebox('setValue', null);
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
		$('#cgd')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdData',
							queryParams : {
								pageParam : paramsShow
							},
							rownumbers : true,
							title : "采购单列表",
							contentType : "charset=UTF-8",
							pagination : true,
							idField : 'hId',
							pageSize : 10,
							pageList : [ 5, 10, 15, 20, 25, 30 ],
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
									url = '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdSave';
									info = '个用户信息增加成功!';
								}
								//更新内容
								if (updated.length > 0) {
									url = '${pageContext.request.contextPath}/hpzcCgd/hpzcCgdEdit';
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
								field : 'hId',
								title : '采购单ID',
								checkbox : true,
							}, {
								field : 'hCode',
								title : '进货编号',
							}, {
								field : 'hDate',
								title : '采购日期',
								editor : {
									type : 'datetimebox',
									options : {
										/* formatter : myformatter, 
										parser : myparser,*/
										required : true
									}
								},
							}, {
								field : 'hzdrq',
								title : '制单日期',
							}, {
								field : 'hPurName',
								title : '采购人姓名',
								editor : {
									type : 'text',
									options : {}
								},
							}, {
								field : 'hXgr',
								title : '修改人',
								editor : {
									type : 'text',
									options : {
										required : true
									}
								},
							}, {
								field : 'hGysbm',
								title : '供应商编号',
								editor : {
									type : 'combobox',
									options : {
										required : true
									}
								},
							}, {
								field : 'hGysmc',
								title : '供应商名称',
								editor : {
									type : 'combobox',
									options : {
										required : true,
									/* valueField : 'name',
									textField : 'username',
									url : '${pageContext.request.contextPath}/hpzcUser/hpzcUserJson', */
									}
								},
							}, {
								field : 'hPurMoney',
								title : '采购人总金额',
							}, {
								field : 'hZffsmc',
								title : '支付方式名称',
							}, {
								field : 'hMemo1',
								title : '支付描述',
							}, ] ],
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
									addDetail();
								}
							}, '-', {
								text : '导出',
								iconCls : 'icon-save',
								handler : function() {
									exportPurchase();
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
								text : '采购详情',
								iconCls : 'icon-remove',
								handler : function() {
									addDetail();
								}
							} ]
						})
	}

	function exportPurchase() {
		var rows = $('#cgd').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('警告!', '查看采购单想详情时最少选择一行!', 'waring');
		} else {
			var ids = new Array();
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].hId);
			}
			window.location.href = "${pageContext.request.contextPath}/export/purchase?ids="
					+ ids;
		}

	}

	function addDetail() {
		var rows = $('#cgd').datagrid('getSelections');
		if (rows.length == 1) {
			window.location.href = "${pageContext.request.contextPath}/hpzcCgd/hpzcCgdDetail?gCode="
					+ rows[0].hCode;
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
				$.messager.confirm('确定操作', '确定要删除选定的记录吗!', function(flag) {
					if (flag) {
						var ids = new Array();
						for (var i = 0; i < rows.length; i++) {
							ids.push(rows[i].hId);
						}
						//var hIds = JSON.stringify(ids.join(','));
						$.ajax({
							type : 'post',
							url : './hpzcCgdRemove',
							dataType : "json",
							data : {
								hIds : ids.join(','),
							},
							beforeSend : function(jqXHR, settings) {
								$('#cgd').datagrid('loading');
							},
							success : function(data) {
								if (data) {
									$('#cgd').datagrid('load');
									$('#cgd').datagrid('loaded');
									$('#cgd').datagrid('unselectAll');
								}
								$.messager.show({
									title : '提示!',
									msg : data + '个用户被删除!',

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