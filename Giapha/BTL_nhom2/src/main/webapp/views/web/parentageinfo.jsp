<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
<link rel="icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
<title>Trang dòng họ - Gia phả Việt Nam</title>
<script type="text/javascript"
	src="<c:url value='/adjs/jquery.min.1.7.1.js'/>"></script>
<link href="/adv/adcss/layout.css" rel="stylesheet" type="text/css">
<link href="/adv/adcss/common.css" rel="stylesheet" type="text/css">
<link href="/adv/adcss/default.css" rel="stylesheet" type="text/css">
<link href="<c:url value='/adcss/bootstrap.css'/>" rel="stylesheet"
	type="text/css" />
<style>
#lgr a {
	color: #19191a
}
</style>
</head>
<body>
	<div class="wrapper">
		<a href="/adv/view" title="Bấm vào đây đề về Trang chủ">
			<div class="banner ovh txtC">
				<img src="/adv/adimgs/cen_bn.jpg" style="height: 150px">
			</div>
		</a>

		<div class="wrappage">
			<div class="ovh mainpage clb">
				<div class="dhbn ovh">
					<div class="dhbnhead"></div>
					<div class="dhbnbody" id="dhname">Gia phả dòng họ: ${prname}</div>
					<div class="dhbnend"></div>
				</div>

				<div class="main-left1 fll">
					<div class="box ovh txtC menu">
						<h3 class="bhead">PHẢ KÝ</h3>
						<div class="grb">
							<ul id="dh_menu">
								<li id="dhinfo" onclick="openinf()" class="active">Thông
									tin chung</li>
								<li id="dhnews" onclick="openad()">Tin tức dòng họ</li>
								<li id="dhtree" onclick="openfmtree()">Phả đồ</li>
								<li id="dhalbum" onclick="openalbum()">Album ảnh dòng họ</li>
							</ul>
						</div>
					</div>
					<div class="box ovh txtC menu">
						<h3 class="bhead">TÁC GIẢ</h3>
						<div class="grb ftcreator">
							<img id="cravatar" alt="Ảnh đại diện"
								src="/adv/adimgs/default.png">
							<p>
								Họ tên: <span id="cre_fn">${prhead}</span>
							</p>
							<p>
								Email: <span id="cre_email">${premail}</span>
							</p>
							<p>
								Điện thoại: <span id="cre_phone">${prnumber}</span>
							</p>
							<p>
								Địa chỉ: <span id="cre_addr">${prheadadr}</span>
							</p>
						</div>
					</div>
				</div>

				<div class="main-right1 flr">

					<div class="box ovh txtC">
						<div id="prtif">
							<h3 class="crbhead" id="dhfrmtit">THÔNG TIN DÒNG HỌ</h3>
							<div class="grb" id="ft_ct">
								<p class="dhtitle">
									<span>Tên dòng họ</span><b>:</b><span>${prname}</span>
								</p>
								<p class="dhtitle">
									<span>Quê gốc</span><b>:</b><span>${prheadadr}</span>
								</p>
								<p class="dhtitle">
									<span>Ngày giỗ họ</span><b>:</b><span>15/1</span>
								</p>
								<p class="dhtitle">
									<span>Số thành viên</span><b>:</b><span>${prnumber_individual}(<a
										href="/adv/parentage/info/view" class="treelink">Xem Phả
											đồ tại đây</a>)
									</span>
								</p>
								<p class="dhtitle">
									<span>Ngày lập gia phả</span><b>:</b><span>17/05/2019</span>
								</p>
								<p class="dhtitle">
									<span>Người lâp gia phả</span><b>:</b><span>${prhead}</span>
								</p>
								<h3>LỜI HAY Ý ĐẸP</h3>
								<div class="lhyd">${pradvise}</div>
								<h3>GIỚI THIỆU VỀ DÒNG HỌ</h3>
								<div class="gtdh">${prhistory}</div>
							</div>
						</div>
						<div id="prtimg">
							<h3 class="crbhead" id="dhfrmtit">Album Ảnh</h3>
							<div class="grb" id="ft_ct">
								<div class="row" style="height: 400px; overflow: scroll">
									<c:forEach items="${list_imgs}" var="item">
										<img alt="" src="/adv/adimgs/${item.url}"
											style="max-height: 200px;">
									</c:forEach>
								</div>
							</div>
						</div>
						<div id="prtfmtree">
							<h3 class="crbhead" id="dhfrmtit">Album Ảnh</h3>
							<div class="grb" id="ft_ct"
								style="height: 100px; overflow: scroll">
								<%
									out.print(request.getAttribute("fmtree"));
								%>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="/views/common/footer.jsp"%>

	</div>
	<a href="javascript:void(0)" id="toTop">to Top</a>

	<script type="text/javascript">
		$(document).ready(

		$("#prtimg").css("display", "none"));
		$(document).ready($("#prtfmtree").css("display", "none")

		);
		function openad() {
			$("#prtfmtree").css("display", "none");
			$("#prtimg").css("display", " none");
			$("#prtif")
					.html(
							"<h3 class=\"crbhead\" id=\"dhfrmtit\">TIN TỨC DÒNG HỌ</h3><div class=\"grb\" id=\"ft_ct\">${pradvertisment}</div>");
		}

		function openinf() {
			$("#prtfmtree").css("display", "none");
			$("#prtimg").css("display", " none");
			var tmp = "";
			tmp += "<h3 class=\"crbhead\" id=\"dhfrmtit\">THÔNG TIN DÒNG HỌ</h3> ";
			tmp += " <div class=\"grb\" id=\"ft_ct\"> ";
			tmp += " <p class=\"dhtitle\"><span>Tên dòng họ</span><b>:</b><span>${prname}</span></p> ";
			tmp += " <p class=\"dhtitle\"><span>Quê gốc</span><b>:</b><span>${prheadadr}</span></p> ";
			tmp += " <p class=\"dhtitle\"><span>Ngày giỗ họ</span><b>:</b><span>15/1</span></p> ";
			tmp += " <p class=\"dhtitle\"><span>Số thành viên</span><b>:</b><span>${prnumber_individual}(<a href=\"/adv/parentage/info/view\" class=\"treelink\">Xem Phả đồ tại đây</a>)</span></p> ";
			tmp += " <p class=\"dhtitle\"><span>Ngày lập gia phả</span><b>:</b><span>17/05/2019</span></p> ";
			tmp += " <p class=\"dhtitle\"><span>Người lâp gia phả</span><b>:</b><span>${prhead}</span></p> ";
			tmp += " <h3>LỜI HAY Ý ĐẸP</h3><div class=\"lhyd\">${pradvise}</div> ";
			tmp += " <h3>GIỚI THIỆU VỀ DÒNG HỌ</h3> ";
			tmp += " <div class=\"gtdh\">${prhistory}</div> ";
			tmp += " </div> ";

			$("#prtif").html(tmp);
		}
		function openalbum() {
			$("#prtfmtree").css("display", "none");
			$("#prtif").html('');
			$("#prtimg").css("display", "block");
		}
		//

		function openfmtree() {
			$("#prtif").html('');
			$("#prtfmtree").css("display", "block");
			$("#prtimg").css("display", "none");
		}
	</script>

</body>
</html>