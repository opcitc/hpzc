function fd() {

}
$(document).ready(
		function() {
			var products = null;
			var pageSize = 10;
			var attdata = attrDatas();
			products = getMap(
					'${pageContext.request.contextPath}/hpzcCgd/hpzcCgdData',
					attdata, pageSize);
			init();
			// 查询方法--获取数据
		})
function getMap(url, person, pageSize) {
	var products1 = fcData(url, person, pageSize);
	alert("ewr" + products1);
	return products1;
}

function fcData(url, person, pageSize) {
	var PageParam = new Object();
	PageParam.page = 1;
	PageParam.pageSize = pageSize;
	var paramsMap = JSON.stringify(person);
	var map = eval("(" + paramsMap + ")");
	PageParam.searchContent = map;
	var paramsShow = JSON.stringify(PageParam);
	var products = null;
	$.ajax({
		url : url,
		contentType : "text/html;charset=UTF-8",
		data : {
			"pageParam" : paramsShow,
		},
		success : function(data) {
			products = data;
			alert("success" + products);
			return products;
		}
	}, function() {

	})

}
