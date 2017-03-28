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
	<div>
		<div id="button" style="margin-bottom: 5px">
			<div id="add"></div>
			<div id="edit"></div>
			<div id="save"></div>
			<div id="remove"></div>
			<div id="print"></div>
			<div id="excel"></div>
			<div id="search"></div>
			<div id="reset"></div>
		</div>

		<div id="form">
			<table>
				<tr>
					<td>制单人:<input id="zdr" name="zdr" type="text"
						style="width: 80px"></td>
					<td>制单日期: <input id="zdbegin" name="zdbegin"
						class="easyui-datebox" style="width: 80px"> 到: <input
						id="zdend" name="zdend" class="easyui-datebox" style="width: 80px"></td>

				</tr>
				<tr>

					<td>采购人:<input id="cgr" name="cgr" class="easyui-text"
						style="width: 80px"></td>
					<td>采购日期: <input id="cgbegin" name="cgbegin"
						class="easyui-datebox" style="width: 80px"> 到: <input
						id="cgend" name="cgend" class="easyui-datebox" style="width: 80px"></td>

				</tr>
				<tr>
					<td>供应商:<input id="gys" name="gys" class="easyui-text"
						style="width: 80px"></td>
					<td>采购金额: <input id="minje" name="minje"
						class="easyui-numberspinner" type="text" style="width: 80px">
						到: <input id="maxje" name="maxje" class="easyui-numberspinner"
						type="text" style="width: 80px"></td>
				</tr>
			</table>
		</div>

		<div id="cgd" style="padding: 5px; height: auto"></div>

	</div>
</body>
<script>
	//返回查询条件
	function attrDatas() {
		return {
			zdr : $('#zdr').val(),
			cgr : $('#cgr').val(),
			gys : $('#gys').val(),
			zdr : $('#zdbegin').val(),
			cgr : $('#zdend').val(),
			gys : $('#cgbegin').val(),
			zdr : $('#cgend').val(),
			cgr : $('#minje').val(),
			gys : $('#maxje').val()
		}
	}
	//重置
	$('#reset').click(function() {
		$('#zdr').val("");
		$('#cgr').val("");
		$('#gys').val("");
	})

	$('#search').click(function() {
		var PageParam = new Object();
		var ParamMap = attrDatas();
		PageParam.page = 1;
		PageParam.pageSize = 10;
		var paramsMap = JSON.stringify(ParamMap);
		var map = eval("(" + paramsMap + ")");
		PageParam.searchContent = map;
		var paramsShow = JSON.stringify(PageParam);
		$('#cgd').datagrid({
			//url : './hpzcCgdData?pageParam=' + paramsShow,
			url : './hpzcCgdData',
			queryParams : {
				pageParam : paramsShow
			},
			title : "采购单列表",
			contentType : "charset=UTF-8",
			pagination : true,
			idField : 'hId',
			pageSize : 10,
			pageList : [ 10, 20, 30 ],
			columns : [ [ {
				field : 'hId',
				title : '采购单ID',
				hidden : true,
			}, {
				field : 'hCode',
				title : '进货编号',
			}, {
				field : 'hName',
				title : '订单号',
			}, {
				field : 'hDate',
				title : '采购日期',
			}, {
				field : 'hPurName',
				title : '采购人姓名',
				editor:{
					type:'validatebox',
				}
			}, {
				field : 'hPlayName',
				title : '制单人',
			}, {
				field : 'hXgr',
				title : '修改人',
			}, {
				field : 'hGysbm',
				title : '供应商编号',
			}, {
				field : 'hGysmc',
				title : '供应商名称',
			}, {
				field : 'hPurMoney',
				title : '采购人总金额',
			}, {
				field : 'hZffsmc',
				title : '支付方式名称',
			}, {
				field : 'hMemo1',
				title : '支付描述',
			},

			] ]

		})
	})

	$('#add')
			.click(
					function() {
						window.location.href = "${pageContext.request.contextPath}/hpzcCgd/hpzcCgdSave";

					});
	$('#edit')
			.click(
					function() {
						var id = "1";
						alert(id);
						window.location.href = "${pageContext.request.contextPath}/hpzcCgd/hpzcCgdEdit?id="
								+ id;

					});

	/*操作按钮*/
	$('#add').linkbutton({
		iconCls : "icon-add",
		text : "新增"
	})
	$('#edit').linkbutton({
		iconCls : "icon-edit",
		text : "编辑"
	})
	$('#save').linkbutton({
		iconCls : "icon-save",
		text : "保存"
	})
	$('#remove').linkbutton({
		iconCls : "icon-remove",
		text : "删除"
	})
	$('#print').linkbutton({
		iconCls : "icon-print",
		text : "打印"
	})
	$('#excel').linkbutton({
		iconCls : "icon-print",
		text : "导出EXCEL"
	})
	$('#search').linkbutton({
		iconCls : "icon-save",
		text : "查询"
	})
	$('#reset').linkbutton({
		iconCls : "icon-remove",
		text : "重置"
	})
</script>
</html>