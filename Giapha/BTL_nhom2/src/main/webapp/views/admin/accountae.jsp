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
			<jsp:include page="/views/common/menu-left.jsp"></jsp:include>
			<div class="ucp_def_right">
            


<div class="page_title" style="margin-bottom: 15px">
    <h2>Thông tin tài khoản</h2>
    
    <div class="toolbox"><a href="javascript:void(0)" id="btn_save" class="ubtn save">Lưu lại</a></div>
</div>
<div class="frm_loadstatus" style="display: none;"></div>
<table border="0" style="width: 100%; border-collapse: collapse" class="ucp_tbl_acc">
    <tbody><tr>
        <td colspan="2" id="frm_msg"></td>
    </tr>
    <tr>
        <td style="width: 100px">Họ và tên</td>
        <td><input type="text" name="FullName" value="${prheadname}" readonly style="width: 200px"></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><input type="text" name="Email" value="${prheademail}" readonly style="width: 200px"></td>
    </tr>
    <tr>
        <td>Điện thoại</td>
        <td><input type="text" name="Phone" value="${prheadnumber}" readonly style="width: 200px"></td>
    </tr>
    <tr>
        <td>Địa chỉ</td>
        <td><input type="text" name="Address" value="${prheadaddress}" readonly style="width: 500px"></td>
    </tr>
     
</tbody></table>



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
