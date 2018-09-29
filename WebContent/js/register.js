/**
 * 客人登记
 */
$(function() {

	$("#roomType").change(
			function() {
				var idx = $(this).find("option:selected").val();
				$.getJSON("roomaction.do", {
					opt : "type",
					roomType : idx
				}, function(result) {

					// 清空
					$("#room").empty();
					$("#room").append('<option value="-1">==客房地址==</option>');
					for (var i = 0; i < result.length; i++) {
						var opt = '<option value="' + result[i].id + '">'
								+ result[i].description + '</option>';
						$("#room").append(opt);
					}

				});
			})
	/**
	 * 注册验证
	 */
	function addListenner() {
		var roomType = document.getElementById("roomType");
		roomType.oninvalid = function() {

			roomType.setCustomValidity("请选择客房类型");
		}
		roomType.oninput = function() {

			roomType.setCustomValidity("");
		}
	}
	addListenner();
	/**
	 * 验证身份证
	 */
	function validityIdcard() {
		var idcard = document.getElementById("idcard");
		if (idcard.validity.valueMissing) {
			idcard.setCustomValidity("身份证号码不能为空");
		} else if (idcard.validity.patternMismatch) {
			idcard.setCustomValidity("身份证号码格式错误");
		} else {
			idcard.setCustomValidity("");
		}

	}
	/**
	 * 客房类型验证
	 */
	function validityRoomType() {
		var roomType = document.getElementById("roomType");
		if (roomType.value < 0) {
			roomType.oninvalid();
			return false;
		} else {
			roomType.oninput();
			return true;
		}
	}
	/**
	 * 提交表单
	 */
	$("form").click(function() {
		validityIdcard();
		validityRoomType();
	})
})