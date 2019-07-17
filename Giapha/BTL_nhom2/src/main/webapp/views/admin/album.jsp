<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Album ảnh - Gia phả Việt Nam</title>
<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet"type="text/css" />
<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet"type="text/css"/>
<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet"type="text/css" />
<link href="<c:url value='/adcss/bootstrap.css'/>" rel="stylesheet"type="text/css" />
<script type="text/javascript"
	src="<c:url value='/adjs/jquery.min.1.7.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/adjs/ucp.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/adjs/ucp_treeinf.js'/>"></script>
<script type="text/javascript" src="<c:url value='/adjs/action.js'/>"></script>
<style>
	#lgr a{color: #19191a}
</style>
</head>
<body>

	<div>
		<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
		<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT"
			value="" /> <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
			value="wEPDwUKLTg3MzMwNzE5MA8WAh4TVmFsaWRhdGVSZXF1ZXN0TW9kZQIBZBgBBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WAgUdY3RsMDIkbGVmdF9jdHJsMCRsb2dvdXQkY3RsMDEFHWN0bDAyJGxlZnRfY3RybDAkbG9nb3V0JGN0bDAzadN+P9zhWVj2MoOhWVvrb/1oQdzCWA6YBcCm6q2/Gy4=" />
	</div>

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
						<td class="subleft"><a href="/adv/view">TRANG CHỦ</a></td>
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
						<a href="/adv/parentage/ae">Thông tin dòng họ</a> 
						<a href="/adv/view/tree">Quản lý phả đồ</a> 
						<a href="#">Danh sách thành viên</a> 
						<a href="/adv/image/view">Album ảnh</a>
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
					<h2>Ảnh của dòng họ</h2>
					<div class="toolbox">
						<form id="album" method="post"
							action="http://localhost:8080/adv/image/ae"
							enctype="multipart/form-data">
							<input id="img-format" name="img-format" type="file"
								onchange="changeimg(event)" accept=".png, .jpg,.jpeg" 
								style="color:white;cursor:pointer;"/>
							<button class="btn" type="submit" style="color:white;border:1px solid white">Lưu</button>
						</form>
					</div>

				</div>
				<div class="load_progress"></div>


				<div class="container">
					<div class="row" id="ctn"></div>
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
			var url = "http://localhost:8080/adv/album";
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
