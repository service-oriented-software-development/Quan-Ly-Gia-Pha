<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html >
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Phả đồ</title>
	<script type="text/javascript" src="<c:url value='/adjs/jquery.min.1.7.1.js'/>" ></script>
	<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<c:url value='/adjs/ucp.js'/>" > </script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/adcss/editor.css'/>" />


	<title>Quản lý phả đồ - Gia phả Việt Nam</title>

  
  </head>
  <body >



<div>

	<input type="hidden" name="state" id="state" value="<c:out value="${state}"></c:out>">
	<input type="hidden" name="idpr" id="idpr" value="<c:out value="${prt.parentage_id}"></c:out>">
</div>
        
<div class="main_frame">
    <div class="ucp_def_header">
        

<div class="banner txtC">
    <img src="<c:url value='/adimgs/cen_bn.jpg'/>" style="height:80px" />
</div>
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="ucp_info">
    <tbody><tr><td></td>
        <td class="subleft">
            <a href="<c:url value='/view'/>">TRANG CHỦ</a> | 
        </td>
        <td class="subcen">
            <c:out value="${prname}"></c:out>
        </td>
        <td class="subright">
            Người tạo: <c:out value="${pracname}"></c:out>
            
        </td><td></td>
    </tr>
</tbody></table><div style="clear: both"></div>
    </div>
    <div class="ucp_def_body">
        <div class="ucp_def_left">
            
<div class="ucpleft_group" id="lgr">
    <h2 class="title">Dòng họ</h2>
    <div class="gitem">
        <a href="<c:url value='/parentage/ae'/>">Thông tin dòng họ</a>
        <a href="<c:url value='/view/tree'/>">Quản lý phả đồ</a>
        <a href="#">Danh sách thành viên</a>
        <a href="/adv/album">Album ảnh</a>
    </div>    
    <h2 class="title">Tin tức</h2>
    <div class="gitem">
        <a href="#">Viết bài mới</a>
        <a href="#">Tin bài đã tạo</a>
    </div>
    <h2 class="title">Tin nhắn</h2>
    <div class="gitem">
        
        <a href="javascript:void(0)">Soạn tin nhắn</a>
        <a href="javascript:void(0)">Hộp thư đến</a>
        <a href="javascript:void(0)">Tin đã gửi</a>
    </div>
    <h2 class="title">Account</h2>
    <div class="gitem">
        <a href="#">Thông tin tài khoản</a>
        <a href="#">Đổi mật khẩu</a>
        <a id="ctl02_left_ctrl0_logout" href="#">Đăng xuất</a>
    </div>
</div>
</div>

<!-- content -->
<div class="ucp_def_right" id="gp_phahe">

</div>
</div>
</div>


<script type="text/javascript">
$(document).ready(function() {
	loadPhaHe();
});


function loadPhaHe(){

	var request;
	var url = "http://localhost:8080/adv/individual/view";
	
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
    	    var data = request.responseText;    	    
    	    $("#gp_phahe").html(data);
   	 	}
	}
}
function del(id){
	var mess = "Bạn có thực sự muốn xóa thành viên";
	if(window.confirm(mess)){
		var request;
		var url = "/adv/individual/ae?action=del&id="+id;
		
		if (window.XMLHttpRequest) {
	        request = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	        request = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    try {
	        request.onreadystatechange = getInfo;
	        request.open("POST", url, true);
	        request.send();
	    } catch (e) {
	        alert("Unable to connect to server");
	    }


		function getInfo() {
	    	if (request.readyState == 4) {
	    	    var data = request.responseText;    	    
	    	    alert(data);
	    	    location.href = location.href
	   	 	}
		}
	}
}
function openedit(id){
	window.location.href = "/adv/individual/ae?id="+id;
}
function logout()
{	
	var mess = "Bạn có thực sự muốn đăng xuất khỏi hệ thống";
	if(window.confirm(mess)){
		window.location.href = "/adv/view?action=logout";
	}
}

</script>
</body>
</html>