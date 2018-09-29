/**
 * 添加房间
 */
$(function(){
	/**
	 * 新建房间类型
	 */
	//1、弹出模态框
	$("#new").click(function(){
		$('#myModal').modal('show');
	})
	//2、添加数据
	$("#ok").click(function(){
		var id=$("#myModal #id").val();
		var name=$("#myModal #name").val();
		var beds=$("#myModal #beds").val();
		var price=$("#myModal #price").val();
		var roomType={
				id:id,
				name:name,
				beds:beds,
				price:price
		};
		$.getJSON("roomtypeaction.do?opt=add",roomType,function(result){
			$("#roomType").append("<option value='"+result.id+"'>"+
					result.name+"</option>");
		});
	   //关闭模态框
	   $('#myModal').modal('hide');
	   $("#myModal:text").val("");
	})
	$("#add").click(function(){
		$("form").submit();
	})
})