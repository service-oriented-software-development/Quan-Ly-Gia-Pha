<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<link rel="shortcut icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
<link rel="icon" href="http://www.giaphavietnam.vn/img/utils/favicon.ico" type="image/x-icon">
<title>Gia Phả Việt Nam</title>
<script type = "text/javascript" src = "/adv/adjs/jquery.min.1.7.1.js"></script>
<link href="/adv/adcss/layout.css" rel="stylesheet" type="text/css" />
<link href="/adv/adcss/common.css" rel="stylesheet" type="text/css" />
<link href="/adv/adcss/default.css" rel="stylesheet" type="text/css" />
<link href="<c:url value='/adcss/bootstrap.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	 
              
<div class = "wrapper">
    
<a href="/adv/view" title="Bấm vào đây đề về Trang chủ">
<div class="banner ovh txtC">
    <img src="/adv/adimgs/cen_bn.jpg" style="height:150px" />
</div></a>
    
    <div class="wrappage">

        <div class="ovh mainpage clb">

            
            
            <div class="main-left1 fll">

<div class="box ovh txtC menu">
    <h3 class="bhead">DANH MỤC</h3>
    <div class="grb"><ul id="menu"><li><a  href="/adv/view">Trang chủ</a></li>
    <li><a  href="#">Tin tức</a></li>
    <li><a class="active" href="/adv/parentage/view">Gia phả Việt Nam</a></li>
    <li><a  href="#">Giới thiệu</a></li>
    <li><a  href="#">Liên hệ - Góp ý</a></li>
    </ul>
    </div>
</div>

</div>

            <div class="main-right1 flr">

<div class="box ovh txtC">
    <h3 class="crbhead" id="dhfrmtit">GIA PHẢ VIỆT NAM</h3>
    <div class="grb gpvn">
        <div class="gpvn_search_box">
        <form id="frm">
        	<input type="text" id="info" name="info" placeholder="Tên dòng họ, Địa chỉ" />
        	<a type="button" href="javascript:loadgp()" >Tìm kiếm</a>
        </form>
        	
        </div>
        <table cellpadding="5" cellspacing="0" border="0" style="width: 100%; border-collapse: collapse" id="gpvn">
            <thead>
                <tr>
                    <td style="width: 30px">STT</td>
                    <td>Tên dòng họ</td>
                    <td>Nguyên quán</td>
                    <td>Thủy tổ</td>
                    <td style="width: 50px">Số thành viên</td>
                </tr>
            </thead>
            <tbody id="list-parentage">
            	<% int i = 0; %>
            	<c:forEach items="${a}" var="item">
            		<% %>
            		<tr>
					<td><%=(i++)%></td>
					<td><a href="/adv/parentage/info/view?prtid=${item.parentage_id}">${item.parentage_name}</a></td>
					<td>${item.head_of_parentage_address}</td>
					<td>${item.ancestor}</td>
					<td>${item.cult_portion_land}</td>
					</tr>
            	</c:forEach>
            </tbody>
        </table>
        <div id = "pager"><input type="hidden" name="ctl06$right_ctrl0$hft" id="ctl06_right_ctrl0_hft" /></div>
    </div>
</div></div>

        </div>
    </div>

    <!-- Footer -->
	<%@include file="/views/common/footer.jsp" %>

</div>
   
    <a href="javascript:void(0)" id="toTop">to Top</a>
    
    <script type="text/javascript">
    
	    function loadgp(){
	    	$("#frm").method="post";
			$("#frm").action = "http://localhost:8080/adv/parentage/view";
	    	$("#frm").submit();
		}	    
    </script>
    
</body>
</html>