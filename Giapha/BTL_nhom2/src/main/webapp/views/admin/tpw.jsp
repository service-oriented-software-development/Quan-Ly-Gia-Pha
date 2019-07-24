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
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="ucp_info">
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
    <h2>Đổi mật khẩu đăng nhập</h2>
</div>
<div class="message"></div>
<form action="/home/account/tpw" method="post">
	<div class="form_ctrl">
	    <table border="0" cellpadding="0" cellspacing="10" class="compose">
	        <tbody><tr>
	            <td class="ar" style="width: 100px">Mật khẩu cũ</td>
	            <td class="al" style="width: 300px"><input name="password" type="password" id="ctl02_right_ctrl0_txtOldPwd" style="width:200px;"></td>
	        </tr>
	        <tr>
	            <td class="ar">Mật khẩu mới</td>
	            <td class="al"><input name="new_password" type="password" id="ctl02_right_ctrl0_txtNewPwd" style="width:200px;"></td>
	        </tr>
	        <tr>
	            <td class="ar">Xác nhận Mật khẩu mới</td>
	            <td class="al"><input name="confirm_password" type="password" id="ctl02_right_ctrl0_txtConfirm" style="width:200px;"></td>
	        </tr>
	        <tr>
	            <td class="ar"></td>
	            <td class="al"><input type="submit" name="ctl02$right_ctrl0$btnOK" value="Đồng ý" id="ctl02_right_ctrl0_btnOK" class="button w70 op" style="height:28px;"></td>
	        </tr>
	    </tbody></table>
	</div>
</form>
        </div>
		</div>
	</div>

	<!-- Footer -->
	<%@include file="/views/common/footer.jsp" %>
	
	
</body>
</html>
