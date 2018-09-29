/**
 * 
 */
$(function() {
	/**
	 * 初始化房间
	 */
	function initRoom() {
		var room =$("#hideRoom").val();
		$.getJSON("roomaction.do?opt=all", function(result) {
			// 清空
			$("#room").empty();

			$("#room").append('<option value="-1">==客房地址==</option>');
			for (var i = 0; i < result.length; i++) {

				var opt = "";
				if (room == result[i].id) {
					opt = '<option selected value="' + result[i].id + '">'
							+ result[i].description + '</option>';
				} else {
					opt = '<option value="' + result[i].id + '">'
							+ result[i].description + '</option>';
				}

				$("#room").append(opt);
			}

		})
	}
	/**
	 * 查询
	 */
	$("#query").click(function() {
		$("form").submit();
	})
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
		var last = $("totalpage").text();
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
		var last = $("totalpage").text();
		
		if (page < last) {
			$("[name=page]").val(page + 1);
			$("form").submit();
		}
	})
	// 执行
	initRoom();
})