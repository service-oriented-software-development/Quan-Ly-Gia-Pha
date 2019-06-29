function checkvalid()
{
		$("#login_msg").html('<img src="adimgs/loading1.gif">');
		var username = $("#loginid").val().trim();
		var password = $("#pass").val().trim();
		var error = true;
		if( username.length<0 ){
			$('[name="loginid"]').parent().parent().addClass('has-error');
			$('[name="loginid"]').next().text("[loginid] không để trống, >5 ký tự");
			error = false;
		}
		if( password.length<0 ){
			$('[name="pass"]').parent().parent().addClass('has-error');
			$('[name="pass"]').next().text("[pass] không để trống, >=5 ký tự");
			error = false;
		}
		if(error ===1 ){
			$("#login_msg").html('Có lỗi');
			return error;
		}else{
			return error;
		}
		
}

function login(){
	if(checkvalid()){
		$('#form')[0].action = "/adv/view";
		$('#form')[0].method = "POST";
		$('#form')[0].submit();
	}
}