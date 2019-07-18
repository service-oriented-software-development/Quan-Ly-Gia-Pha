<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Đổi mật khẩu - Gia phả Việt Nam</title>

<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet"type="text/css" />
<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet"type="text/css"/>
<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet"type="text/css" />

<script type="text/javascript" src="<c:url value='/adjs/jquery.min.1.7.1.js'/>"></script>

<style>
	#lgr a{color: #19191a}
	
</style>

</head>
<body>
	

	

	<div class="main_frame">
		<div class="ucp_def_header">


			<div class="banner txtC">
				<img src="<c:url value='/adimgs/cen_bn.jpg'/>" style="height: 80px" />
			</div>
			<table width="100%" cellspacing="0" cellpadding="0" border="0"
				class="ucp_info">
				<tbody>
					<tr>
						<td></td>
						<td class="subleft"><a href="/home/view">TRANG CHỦ</a></td>
						<td class="subcen"><c:out value="${prname}"></c:out></td>
						<td class="subright">Người tạo: <c:out value="${pracname}"></c:out></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div style="clear: both"></div>
		</div>
		<div class="ucp_def_body">
			<div class="ucp_def_left">
				<div class="ucpleft_group" id="lgr">
					<h2 class="title">Dòng họ</h2>
					<div class="gitem">
						<a href="/home/parentage/ae">Thông tin dòng họ</a> 
						<a href="/home/view/tree">Quản lý phả đồ</a> 
						<a href="#">Danh sách thành viên</a> 
						<a href="/home/image/view">Album ảnh</a>
					</div>
					<h2 class="title">Tin tức</h2>
					<div class="gitem">
						<a href="#">Viết bài mới</a> <a href="#">Tin bài đã tạo</a>
					</div>
					<h2 class="title">Tin nhắn</h2>
					<div class="gitem">

						<a href="javascript:void(0)">Soạn tin nhắn</a> <a
							href="javascript:void(0)">Hộp thư đến</a> <a
							href="javascript:void(0)">Tin đã gửi</a>
					</div>
					<h2 class="title">Account</h2>
					<div class="gitem">
						<a href="#">Thông tin tài khoản</a> <a
							href="#">Đổi mật khẩu</a> <a
							id="ctl02_left_ctrl0_logout"
							href="#">Đăng
							xuất</a>
					</div>
				</div>


			</div>
			<div class="ucp_def_right">
            

<div class="page_title" style="margin-bottom: 15px">
    <h2>Đổi mật khẩu đăng nhập</h2>
</div>
<div class="message"></div>

<div class="form_ctrl">
    <table border="0" cellpadding="0" cellspacing="10" class="compose">
        <tbody><tr>
            <td class="ar" style="width: 100px">Mật khẩu cũ</td>
            <td class="al" style="width: 300px"><input name="ctl02$right_ctrl0$txtOldPwd" type="password" id="ctl02_right_ctrl0_txtOldPwd" style="width:200px;"></td>
        </tr>
        <tr>
            <td class="ar">Mật khẩu mới</td>
            <td class="al"><input name="ctl02$right_ctrl0$txtNewPwd" type="password" id="ctl02_right_ctrl0_txtNewPwd" style="width:200px;"></td>
        </tr>
        <tr>
            <td class="ar">Xác nhận Mật khẩu mới</td>
            <td class="al"><input name="ctl02$right_ctrl0$txtConfirm" type="password" id="ctl02_right_ctrl0_txtConfirm" style="width:200px;"></td>
        </tr>
        <tr>
            <td class="ar"></td>
            <td class="al"><input type="submit" name="ctl02$right_ctrl0$btnOK" value="Đồng ý" id="ctl02_right_ctrl0_btnOK" class="button w70 op" style="height:28px;"></td>
        </tr>
    </tbody></table>
</div>
        </div>
		</div>
	</div>

	<!-- Footer -->
	<%@include file="/views/common/footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#ctn").html('hhh');
			loadimg();
		});

		function loadimg() {
			var url = "http://localhost:8080/home/album";
			var request;

			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}

			try {
				request.onreadystatechange = getInfo;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

			function getInfo() {
				if (request.readyState == 4) {
					var val = request.responseText;
					$("#ctn").html(val);
				}
			}
		}

		function changeimg(evt) {
			evt.stopPropagation();
			evt.preventDefault();
			var files = evt.target.files;
			var file = files[0];
			var fileReader = new FileReader();

			fileReader.onload = function(progressEvent) {
				var url = fileReader.result;
				var myImg = document.getElementById("img0");
				myImg.src = url;
			}
			fileReader.readAsDataURL(file);
		}
		
		function del_img(){
			$("#del_img").submit();
		}
	</script>
</body>
</html>
