<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<link rel="shortcut icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
	<link rel="icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
	<title>Trang dòng họ - Gia phả Việt Nam</title>
	<script type="text/javascript" src="/adv/adcss/jquery.min.1.7.1.js.tải xuống"></script>
	<link href="/adv/adcss/layout.css" rel="stylesheet" type="text/css">
	<link href="/adv/adcss/common.css" rel="stylesheet" type="text/css">
	<link href="/adv/adcss/default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<a href="/adv/view" title="Bấm vào đây đề về Trang chủ">
			<div class="banner ovh txtC">
	    		<img src="/adv/adimgs/cen_bn.jpg" style="height:150px">
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
				            <li id="dhinfo" onclick="LoadInfo()" class="active">Thông tin chung</li>
				            <li id="dhnews" onclick="LoadNews(1)">Tin tức dòng họ</li>
				            <li id="dhtree"><a href="http://www.giaphavietnam.vn/default.aspx?cp=phado&amp;id=28202">Phả đồ</a></li>
				            <li id="dhalbum">Album ảnh dòng họ</li>
				        </ul>
				    </div>
				</div>
				<div class="box ovh txtC menu">
				    <h3 class="bhead">TÁC GIẢ</h3>
				    <div class="grb ftcreator">
				        <img id="cravatar" alt="Ảnh đại diện" src="/adv/adimgs/default.png">
				        <p>Họ tên: <span id="cre_fn">${prhead}</span></p>
				        <p>Email: <span id="cre_email">${premail}</span></p>
				        <p>Điện thoại: <span id="cre_phone">${prnumber}</span></p>
				        <p>Địa chỉ: <span id="cre_addr">${prheadadr}</span></p>
				    </div>
				</div></div>
				
            <div class="main-right1 flr">

				<div class="box ovh txtC">
				    <h3 class="crbhead" id="dhfrmtit">THÔNG TIN DÒNG HỌ</h3>
				    <div class="grb" id="ft_ct">
				    	<p class="dhtitle"><span>Tên dòng họ</span><b>:</b><span>${prname}</span></p>
				    	<p class="dhtitle"><span>Quê gốc</span><b>:</b><span>${prheadadr}</span></p>
				    	<p class="dhtitle"><span>Ngày giỗ họ</span><b>:</b><span>15/1</span></p>
				    	<p class="dhtitle"><span>Số thành viên</span><b>:</b><span>${prnumber_individual}(<a href="/adv/parentage/info/view" class="treelink">Xem Phả đồ tại đây</a>)</span></p>
				    	<p class="dhtitle"><span>Ngày lập gia phả</span><b>:</b><span>17/05/2019</span></p>
				    	<p class="dhtitle"><span>Người lâp gia phả</span><b>:</b><span>${prhead}</span></p>
				    	<h3>LỜI HAY Ý ĐẸP</h3><div class="lhyd">${pradvise}</div>
				    	<h3>GIỚI THIỆU VỀ DÒNG HỌ</h3>
				    		<div class="gtdh">${prhistory}</div>
					</div>
				</div>
			</div>
        </div>
    </div>

    <div class="footer txtC w100">
		<div class="clb ovh fw100 navBottom fonts ul-none">
		    <ul>
		        <li><a href="/adv/view">TRANG CHỦ</a></li>
		        <li><a href="http://www.giaphavietnam.vn/default.aspx?lang=vi-VN&amp;cp=tin-tuc">TIN TỨC</a></li>
		        <li><a href="http://www.giaphavietnam.vn/default.aspx?cp=gia-pha-viet-nam">GIA PHẢ VIỆT NAM</a></li>
		        <li><a href="http://www.giaphavietnam.vn/default.aspx?cp=nttt">NGHĨA TRANG TRỰC TUYẾN</a></li>
		        <li><a href="http://www.giaphavietnam.vn/default.aspx?cp=gioi-thieu">GIỚI THIỆU</a></li>
		        <li><a href="http://www.giaphavietnam.vn/default.aspx?cp=lien-he-gop-y">LIÊN HỆ - GÓP Ý</a></li>
		    </ul>
		</div>
		<p>© </p>
	</div>

</div>
    <a href="javascript:void(0)" id="toTop">to Top</a>
</body>
</html>