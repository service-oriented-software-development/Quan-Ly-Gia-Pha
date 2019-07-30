<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="ucp_def_left">

				<div class="ucpleft_group" id="lgr">
					<h2 class="title">Dòng họ</h2>
					<div class="gitem">
						<a href="<c:url value='/parentage/ae'/>">Thông tin dòng họ</a> <a
							href="<c:url value='/view/tree'/>">Quản lý phả đồ</a><a href="/home/image/view">Album ảnh</a>
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

						<a href="<c:url value = '/account/ae'/>">Thông tin tài khoản</a> 
						<a href="<c:url value = '/account/tpw'/>">Đổi mật khẩu</a> <a
							id="ctl02_left_ctrl0_logout" href="javascript:logout()">Đăng xuất</a>

					</div>
				</div>
			</div>
<script>
function logout() {
	var mess = "Bạn có thực sự muốn đăng xuất khỏi hệ thống";
	if (window.confirm(mess)) {
		window.location.href = "/home/view?action=logout";
	}
}
</script>		
