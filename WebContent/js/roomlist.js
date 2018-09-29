/**
 * roomlist脚本文件
 */

$(function() {
	/**
	 * 翻页
	 */
	$("#go").click(function() {
		$("form").submit();
	})
	/**
	 * 首页
	 */
	$("#first").click(function() {
		var page = $("[name=page]").val();
		if (page > 1) {
			$("[name=page]").val(1);
			$("form").submit();
		}

	})
	/**
	 * 尾页
	 */
	$("#last").click(function() {
		var page = $("[name=page]").val();
		var last = $("totalpage").text();//取总页数
		if (page < last) {
			$("[name=page]").val(last);
			$("form").submit();
		}
	})
	/**
	 * 上一页
	 */
	$("#prev").click(function() {
		var page = $("[name=page]").val();
		if (page > 1) {
			$("[name=page]").val(page - 1);
			$("form").submit();
		}
	})
	/**
	 * 下一页
	 */
	$("#next").click(function() {
		var page = parseInt($("[name=page]").val());
		var last = $("totalpage").text();//取总页数
		if (page < last) {
			$("[name=page]").val(page + 1);
			$("form").submit();
		}
	})
})