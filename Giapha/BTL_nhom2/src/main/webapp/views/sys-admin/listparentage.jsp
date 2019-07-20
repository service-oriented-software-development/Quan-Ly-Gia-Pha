<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin dòng họ</title>
<script type="text/javascript"
	src="<c:url value='/adjs/jquery.min.1.7.1.js'/>"></script>
<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/bootstrap.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/default.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/adjs/ucp.js'/>">
	
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/adcss/editor.css'/>" />
<style>
#lgr a {
	color: #19191a
}
</style>
</head>
<body>
	<form name="form1" method="" action="" id="form1">
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
							<td class="subleft"><a href="<c:url value='/view'/>">TRANG CHỦ</a></td>
							<td class="subcen">QUẢN TRỊ HỆ THỐNG</td>
							<td class="subright">CHÀO MỪNG QUAY TRỞ LẠI!</td>
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
							<a href="<c:url value='/system/admin'/>">Thông tin dòng họ</a>
							<a href="<c:url value='/manager/parentage'/>">Danh sách dòng họ đang quản lý</a>
						</div>
						
						<h2 class="title">Tin nhắn</h2>
						<div class="gitem">

							<a href="javascript:void(0)">Soạn tin nhắn</a> <a
								href="javascript:void(0)">Hộp thư đến</a> <a
								href="javascript:void(0)">Tin đã gửi</a>
						</div>
						<h2 class="title">Account</h2>
						<div class="gitem">
							<a href="#">Thông
								tin tài khoản</a> <a
								href="#">Đổi
								mật khẩu</a> <a id="ctl02_left_ctrl0_logout"
								href="javascript:logout()">Đăng xuất</a>
						</div>
					</div>
				</div>

				<!--Content-->
				<div class="ucp_def_right">

					<div class="page_title" style="margin-bottom: 15px">
						<h2>Dòng họ đang quản lý</h2>
					</div>

					<div class="ofnews" style="width: 100%;">
			<table cellpadding="5" cellspacing="0" border="1" style="width: 100%; border-collapse: collapse" id="gpvn">
            <thead style="color:#fff; background:red;">
                <tr>
                    <td style="width: 30px">STT</td>
                    <td>Tên dòng họ</td>                                      
                    <td>Số thành viên</td>
                    <td>Thực hiện</td>
                </tr>
            </thead>
            <tbody id="list-parentage">
            	<% int i = 0; %>
            	<c:forEach items="${a}" var="item">
            		<% %>
            		<tr>
					<td><%=(i++)%></td>
					<td><a href="/home/parentage/info/view?prtid=${item.parentage_id}">${item.parentage_name}</a></td>					
					<td>${item.cult_portion_land}</td>
					<td style="width: 70px;"><a href="javascript:del(${item.parentage_id})">Xóa</a></td>
					</tr>
            	</c:forEach>
            </tbody>
        </table>
					</div>

				</div>
			</div>
			<div class="ucp_def_footer"></div>
		</div>
	</form>

	<!-- Footer -->
	<%@include file="/views/common/footer.jsp"%>

	<script type="text/javascript">
		function del(id) {
			var mess = "Bạn có thực sự muốn xóa dòng họ";
			if (window.confirm(mess)) {
				window.location.href = "/home/manager/ae?prtid="+id;
			}
		}

		function logout() {
			var mess = "Bạn có thực sự muốn đăng xuất khỏi hệ thống";
			if (window.confirm(mess)) {
				window.location.href = "/home/view?action=logout";
			}
		}
	</script>




</body>
</html>