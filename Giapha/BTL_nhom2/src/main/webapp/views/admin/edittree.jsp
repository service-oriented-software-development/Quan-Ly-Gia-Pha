<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phả đồ</title>
<script type="text/javascript"
	src="<c:url value='/adjs/jquery.min.1.7.1.js'/>"></script>
<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/adjs/ucp.js'/>">
	
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/adcss/editor.css'/>" />
<link rel="stylesheet" href="adcss/bootstrap.css">

<title>Quản Lý Phả Đồ</title>
<style>
#lgr a {
	color: #19191a;
}
</style>
</head>
<body>
	<div>
		<input type="hidden" name="state" id="state"
			value="<c:out value="${state}"></c:out>"> <input
			type="hidden" name="idpr" id="idpr"
			value="<c:out value="${prt.parentage_id}"></c:out>">
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
						<td class="subleft"><a href="<c:url value='/view'/>">TRANG CHỦ</a></td>
						<td class="subcen"><c:out value="${prname}"></c:out></td>
						<td class="subright">Người tạo: <c:out value="${pracname}"></c:out>

						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div style="clear: both"></div>
		</div>
		<div class="ucp_def_body">
			<jsp:include page="/views/common/menu-left.jsp"></jsp:include>


			<div class="dlg_title">
				Thành viên:
				<c:out value="${indname}"></c:out>
				<input type="button" id="btn_back" value="Trở lại" onclick="back()"
					style="float: right">
			</div>
			<!-- edit -->
			<div class="ucp_def_right " id="dlg_tmform"
				style="width: 43.4%; float: left">
				<div class="dlg_title">Hậu duệ</div>
				<div class="dlg_content">
					<div class="frm_loadstatus" style="display: none"></div>
					<div class="tabct">
						<div class="ctab" id="tab1">
							<table border="0" style="width: 100%" class="frm_data">
								<tbody>
									<tr>
										<td><input type="hidden" value="68097" id="hdpr"></td>
										<td colspan="3" id="update_msg"></td>
									</tr>
									<tr>
										<td style="width: 85px">Họ và tên</td>
										<td><input type="text" style="width: 270px"
											name="FullName" id="FullName"></td>
										<td rowspan="4" style="width: 110px; vertical-align: top">
											<form id="frm1" method="POST"
												action="http://localhost:8080/home/individual/ae?id=<c:out value="${indid }"/>"
												enctype="multipart/form-data">
												<img id="avatar" name="avatar"
													style="width: 100%; border: 1px solid #ccc; max-height: 130px"
													src="/home/adimgs/${childavatar}"> <input type="file"
													onchange="changeimg(event)" id="real" name="real"
													accept=".png, .jpg, .jpeghidden " hidden="hidden">
												<input type="text" name="addchild" value="1" hidden="hidden" />
											</form>
										</td>
										<td rowspan="4" style="vertical-align: top"><a
											href="javascript:choseimgs()" id="btn_changeimg"
											class="aubtn browse">Chọn ảnh</a> <a onclick="agree()"
											id="btn_changeimg1" class="aubtn browse">Chấp nhận</a></td>
									</tr>
									<tr>
										<td>Tên Vợ/Chồng</td>
										<td><input type="text" name="PartnerName"
											id="PartnerName" style="width: 270px"></td>
									</tr>
									<tr>
										<td>Ngày sinh</td>
										<td><input type="text" style="width: 100px"
											name="BirdDate" id="BirdDate"> <span class="legend">(Định
												dạng Ngày/Tháng/Năm)</span></td>
									</tr>
									<tr>
										<td>Con thứ</td>
										<td><select id="cboOrderInFamily"
											style="width: 105px; height: 25px"><option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option></select> <span class="legend">(Thứ
												tự trong gia đình)</span></td>
									</tr>
									<tr>
										<td>Giới tính</td>
										<td><select id="cboGender"
											style="width: 105px; height: 25px">
												<option value="0">Nữ</option>
												<option value="1" selected="selected">Nam</option>
										</select></td>
									</tr>
									<tr>
										<td>Trạng thái</td>
										<td style="width: 280px"><select id="cboLiveStatus"
											onchange="change()"
											style="width: 105px; height: 25px; float: left">
												<option selected="selected" value="1">Còn sống</option>
												<option value="2">Đã mất</option>
										</select>
											<div id="rip_box" class="rip_box"
												style="padding-left: 10px; float: left; display: none">
												Ngày mất <input type="text" style="width: 100px"
													name="RipDate" id="RipDate">
											</div></td>
									</tr>
									<tr>
										<td></td>
										<td colspan="3"
											style="padding-top: 15px !important; vertical-align: top">
											<input type="button" id="btn_save" onclick="addind()"
											value="Thêm mới" style="float: left">
										</td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

			<!-- info -->

			<div class="ucp_def_right " id="dlg_tmform"
				style="width: 43%; float: left">
				<div class="dlg_title">Thông tin thành viên</div>
				<div class="dlg_content">
					<div class="frm_loadstatus" style="display: none"></div>
					<div class="tabct">
						<div class="ctab" id="tab1">
							<table border="0" style="width: 100%" class="frm_data">
								<tbody>
									<tr>
										<td><input type="hidden" value="68097" id="hdpr"></td>
										<td colspan="3" id="update_msg"></td>
									</tr>
									<tr>
										<td style="width: 85px">Họ và tên</td>
										<td><input type="text" style="width: 270px"
											name="FullName2" id="FullName2"
											value="<c:out value="${indname }"/>"></td>
										<td rowspan="4" style="width: 110px; vertical-align: top">
											<form id="frm" method="POST"
												action="http://localhost:8080/home/individual/ae?id=<c:out value="${indid }"/>"
												enctype="multipart/form-data">
												<img id="avatar1" name="avatar1"
													style="width: 100%; border: 1px solid #ccc; max-height: 130px"
													src="/home/adimgs/${indavatar }"> <input type="file"
													onchange="changeimg1(event)" id="real1" name="real1"
													accept=".png, .jpg, .jpeg" hidden="hidden" />

											</form>
										</td>
										<td rowspan="4" style="vertical-align: top"><a
											onclick="choseimgs1()" id="btn_changeimg1"
											class="aubtn browse">Chọn ảnh</a> <a onclick="agree1()"
											id="btn_changeimg1" class="aubtn browse">Chấp nhận</a></td>
									</tr>
									<tr>
										<td>Tên Vợ/Chồng</td>
										<td><input type="text" name="PartnerName2"
											id="PartnerName2" value="<c:out value="${indpartnername }"/>"
											style="width: 270px"></td>
									</tr>
									<tr>
										<td>Ngày sinh</td>
										<td><input type="text" style="width: 100px"
											name="BirdDate2" id="BirdDate2"
											value="<c:out value="${indbirth}"/>"> <span
											class="legend">(Định dạng Năm/Tháng/Ngày)</span></td>
									</tr>
									<tr>
										<td>Ngày mất</td>
										<td><input type="text" style="width: 100px"
											name="DeathDate2" id="DeathDate2"
											value="<c:out value="${inddeath}"/>"> <span
											class="legend">(Định dạng Năm/Tháng/Ngày)</span></td>
									</tr>
									<tr>
										<td>Giới tính</td>
										<td><select id="cboGender2"
											style="width: 105px; height: 25px">
												<option value="0">Nữ</option>
												<option value="1" selected="selected">Nam</option>
										</select></td>
									</tr>
									<tr>
										<td>Bố & Mẹ:</td>
										<td><c:out value="${parent}" /></td>
									</tr>
									<tr>
										<td>Anh chị em:</td>
										<td><c:out value="${bro}" /></td>
									</tr>
									<tr>
										<td>Con:</td>
										<td><c:out value="${child}" /></td>
									</tr>
									<tr>
										<td>Đời thứ:</td>
										<td><c:out value="${indorder}" /></td>
									</tr>
									<tr>
										<td></td>
										<td colspan="3"
											style="padding-top: 15px !important; vertical-align: top">
											<input type="button" onclick="updateind()" value="Cập nhật"
											style="float: left">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div style="" id="frm_msg"></div>
		</div>
	</div>

	<!-- Footer -->
	<%@include file="/views/common/footer.jsp"%>
	<span style="float: left; padding-left: 20px; color: red" id="frm_msg"></span>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#cboGender2 option").each(function() {
				if ($(this).val() == "<c:out value="${indsex}"/>")
					$(this).attr("selected", "selected");
			});
		});

		//chọn ảnh

		function choseimgs1() {
			var real1 = document.getElementById("real1");
			real1.click();
		}

		function changeimg1(evt) {

			evt.stopPropagation();
			evt.preventDefault();
			var files = evt.target.files;
			var file = files[0];
			var fileReader = new FileReader();

			fileReader.onload = function(progressEvent) {
				var url = fileReader.result;
				var myImg = document.getElementById("avatar1");
				myImg.src = url;
			}
			fileReader.readAsDataURL(file);
		}

		function choseimgs() {
			var real = document.getElementById("real");
			real.click();
		}

		function changeimg(evt) {
			evt.stopPropagation();
			evt.preventDefault();
			var files = evt.target.files;
			var file = files[0];
			var fileReader = new FileReader();

			fileReader.onload = function(progressEvent) {
				var url = fileReader.result;
				var myImg = document.getElementById("avatar");
				myImg.src = url;
			}
			fileReader.readAsDataURL(file);
		}

		function updateind() {
			$("#frm_msg")
					.html(
							'<img src="<c:url value='/adimgs/loading1.gif'/>">Đang xử lý..');
			var fuln;
			if ($("#PartnerName2").val() != "") {
				fuln = ($("#FullName2").val()) + " & "
						+ ($("#PartnerName2").val());
			} else {
				fuln = $("#FullName2").val();
			}
			if (fuln == "") {
				alert("Tên thành viên không được để trống");
				$("#frm_msg").html('');
				return;
			}
			if ($("#BirdDate2").val() != "") {
				if (!$("#BirdDate2").val().match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)) {
					$("#frm_msg").html('');
					alert("Sai định dạng ngày(Năm/Tháng/Ngày)");
					return;
				}
			}
			if ($("#DeathDate2").val() != "") {
				if (!$("#DeathDate2").val()
						.match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)) {
					$("#frm_msg").html('');
					alert("Sai định dạng ngày(Năm/Tháng/Ngày)");
					return;
				}
			}
			var request;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {

				var data = {
					individual_id : "",
					fullname : fuln,
					gender : $("#cboGender2").val(),
					date_of_birth : $("#BirdDate2").val(),
					date_of_death : $("#DeathDate2").val(),
					father : "<c:out value='${indfather}'/>",
					branch : "<c:out value='${indbranch}'/>",
					parentage_id : "<c:out value='${indprid}'/>",
					avatar : document.getElementById("avatar1").src
				};

				var datastr = JSON.stringify(data);
				var url = "http://localhost:8080/home/individual/ae?id=<c:out value='${indid}'/>&action=edit&data="
						+ encodeURIComponent(datastr);
				request.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						$("#frm_msg").html('');
						alert(request.responseText);
						location.href = location.href;
					}
				};

				request.open("POST", url, true);
				request.setRequestHeader('Content-Type',
						'application/json; charset=utf-8');
				request.send();
			} catch (e) {
				alert("Unable connect to server");
			}

		}
		function agree1() {
			var form = document.getElementById("frm");
			form.submit();
		}
		function agree() {
			var form = document.getElementById("frm1");
			form.submit();
		}
		function addind() {
			$("#frm_msg").html(
					'<img src="<c:url value='/adimgs/loading1.gif'/>">');
			if ($("#FullName").val() == "") {
				$("#frm_msg").html('');
				alert("Tên thành viên không được để trống");
				return;
			}
			if ($("#BirdDate").val() != "") {
				if (!$("#BirdDate").val().match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)) {
					$("#frm_msg").html('');
					alert("Sai định dạng ngày(Năm/Tháng/Ngày)");
					return;
				}
			}
			if ($("#RipDate").val() != "") {
				if (!$("#RipDate").val().match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)) {
					$("#frm_msg").html('');
					alert("Sai định dạng ngày(Năm/Tháng/Ngày)");
					return;
				}
			}

			var request;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			var request;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				var fuln;
				if ($("#PartnerName").val() != "") {
					fuln = ($("#FullName").val()) + " & "
							+ ($("#PartnerName").val());
				} else {
					fuln = $("#FullName").val();
				}

				var data = {
					individual_id : "",
					fullname : fuln,
					gender : $("#cboGender").val(),
					date_of_birth : $("#BirdDate").val(),
					date_of_death : $("#RipDate").val(),
					father : "<c:out value='${indid}'/>",
					branch : "<c:out value='${indbranch}'/>."
							+ $("#cboOrderInFamily option:selected").val(),
					parentage_id : "<c:out value='${indprid}'/>",
					avatar : document.getElementById("avatar").src
				};
				var datastr = JSON.stringify(data);
				var url = "http://localhost:8080/home/individual/ae?id=<c:out value='${indid}'/>&action=add&data="
						+ encodeURIComponent(datastr);
				request.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						alert(request.responseText);
						location.href = "http://localhost:8080/home/individual/ae?id=<c:out value='${indid}'/>";
						$("#frm_msg").html('');

					}
				};

				request.open("POST", url, true);
				request.setRequestHeader('Content-Type',
						'application/json; charset=utf-8');
				request.send();
			} catch (e) {
				alert("Unable connect to server");
			}

		}

		function change() {
			var rip = document.getElementsByClassName("rip_box");
			if (($("#cboLiveStatus option:selected").val()) === "2") {
				rip[0].style = "";
			} else {
				rip[0].style = "display:none";
			}
		}

		function openedit(id) {
			window.location.href = "/home/individual/ae?id=" + id;
		}
		

		function back() {
			window.location.href = "/home/view/tree";
		}
	</script>
</body>
</html>