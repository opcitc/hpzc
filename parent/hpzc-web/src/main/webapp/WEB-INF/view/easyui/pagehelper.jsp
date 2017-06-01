<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EASYUI</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>
	列表数据:
	<div>
		<div id="form">
			<table>
				<tr>
					<td>制单人:<input id="zdr" name="zdr" type="text"
						style="width: 80px"></td>
					<td>采购人:<input id="cgr" name="cgr" class="easyui-text"
						style="width: 80px"></td>
					<td>供应商:<input id="gys" name="gys" class="easyui-text"
						style="width: 80px"></td>
				</tr>
			</table>
		</div>

		<div id="gridlist"></div>
	</div>
</body>
<script>
	function attrDatas() {
		return {
			zdr : $('#zdr').val(),
			cgr : $('#cgr').val(),
			gys : $('#gys').val()
		}
	}

	$(document).ready(function() {
		queryData();
	});

	function queryData() {
		var PageParam = new Object();
		var ParamMap = attrDatas();
		var paramsMap = JSON.stringify(ParamMap);
		var map = eval("(" + paramsMap + ")");
		PageParam.searchContent = map;
		var paramsShow = JSON.stringify(PageParam);
		$('#gridlist').datagrid({
			loadMsg : '数据加载中....',
			title : "采购单信息一览表",
			url : '${pageContext.request.contextPath}/easyui/pagehelperjson',
			queryParams : {
				pageParam : paramsShow
			},
			method : 'POST',
			striped : true, //设置为true将交替显示行背景。相邻行不同颜色
			//fit:false,//自适应大小
			//fitColumns:true,//列宽适应浏览器,无左右滚动条
			rownumbers : true,//行number
			pagination : true,//显示页码
			pageSize : 10,//初始化每页显示的条数
			pageList : [ 10, 20, 50, 100 ],//可以调节的每页显示条数
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
			}, {
				field : 'hzdrq',
				title : '制单日期',
			}, {
				field : 'hPurName',
				title : '采购人姓名',
			}, {
				field : 'hXgr',
				title : '修改人',
			}, {
				field : 'hGysbm',
				title : '供应商编号',
			}, {
				field : 'hGysmc',
				title : '供应商名称',
			} ] ],
			sortOrder : "desc",
			sortName : "hGysbm", //初始化时按Id升序排序
			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加',
				handler : function() {
					alert('Add')
				}
			}, '-', { //分隔符
				iconCls : 'icon-edit',
				text : '编辑',
				handler : function() {
					alert('edit')
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
					alert('delete')
				}
			}, '-', {
				iconCls : 'icon-search',
				text : '查询',
				handler : function() {
					queryData();
				}
			} ]
		});
	};
</script>
</html>