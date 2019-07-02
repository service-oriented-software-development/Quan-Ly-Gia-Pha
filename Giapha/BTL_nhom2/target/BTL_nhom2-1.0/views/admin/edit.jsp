<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html >
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Thông tin dòng họ</title>
	<script type="text/javascript" src="<c:url value='/adjs/jquery.min.1.7.1.js'/>" ></script>
	<link href="<c:url value='/adcss/layout.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/adcss/bootstrap.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/adcss/common.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/adcss/ucp.css'/>" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<c:url value='/adjs/ucp.js'/>" > </script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/adcss/editor.css'/>" />

	
  
  </head>
  <body >
<form name="form1" method="" action="" id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
</div>


<div>

	<input type="hidden" name="state" id="state" value="<c:out value="${state}"></c:out>">
	<input type="hidden" name="idpr" id="idpr" value="<c:out value="${prt.parentage_id}"></c:out>">
</div>
        
<div class="main_frame">
<div class="ucp_def_header" >
        

<div class="banner txtC">
    <img src="<c:url value='/adimgs/cen_bn.jpg'/>" style="height:80px" />
</div>
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="ucp_info" >
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
            
<div class="ucpleft_group" id="lgr" >
    <h2 class="title">Dòng họ</h2>
    <div class="gitem">
        <a href="<c:url value='/parentage/ae'/>">Thông tin dòng họ</a>
        <a href="<c:url value='/view/tree'/>">Quản lý phả đồ</a>
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=danh-sach-thanh-vien">Danh sách thành viên</a>
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=nttt">Nghĩa trang dòng họ</a>
        <a href="/adv/image/view">Album ảnh</a>
    </div>    
    <h2 class="title">Tin tức</h2>
    <div class="gitem">
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=news-detail">Viết bài mới</a>
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=created-news">Tin bài đã tạo</a>
    </div>
    <h2 class="title">Tin nhắn</h2>
    <div class="gitem">
        
        <a href="javascript:void(0)">Soạn tin nhắn</a>
        <a href="javascript:void(0)">Hộp thư đến</a>
        <a href="javascript:void(0)">Tin đã gửi</a>
    </div>
    <h2 class="title">Account</h2>
    <div class="gitem">
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=accinfo">Thông tin tài khoản</a>
        <a href="http://www.giaphavietnam.vn/ucp.aspx?cp=change_pwd">Đổi mật khẩu</a>
        <a id="ctl02_left_ctrl0_logout" href="javascript:logout()">Đăng xuất</a>
    </div>
</div>
</div>

<!--Content-->
<div class="ucp_def_right">
            <div class="load_progress"></div>
            <div class="htree" id="htree"></div>
            <div id="float_panel"></div>
<div class="page_title" style="margin-bottom: 15px">
    <h2>Thông tin dòng họ</h2>
    <div class="toolbox"><a href="javascript:saveGiaPhaInfo()" id="btn_save" class="ubtn save">Lưu lại</a></div>
</div>
<div class="load_progress"></div>
<table border="0" style="width: 100%; border-collapse: collapse" class="ucp_tbl form">
    <tbody><tr><td></td><td id="msg" colspan="5" style="color:blue"></td></tr>
    <tr>
        <td style="width: 110px">Tên dòng họ</td>
        <td style="width: 400px"><input type="text" name="FamilyName" id="FamilyName" style="width: 380px" value='<c:out value="${prname}"></c:out>'></td>
        <td style="width: 120px">Tên thủy tổ</td>
        <td style="width: 180px"><input type="text" name="Ancestor" id="Ancestor" value='<c:out value="${prancestor}"></c:out>'></td>
        <td>Truy cập gần đây:</td>
        <td id="recently"></td>
    </tr>
    <tr>
        <td style="width: 110px">Ngày tế thu (âm lịch)</td>
        <td style="width: 200px"><input type="text" name="AutumnAnniversary" placeholder="yyyy/mm/dd" id="AutumnAnniversary" value='<c:out value="${prt.cultural_autumn_day}"></c:out>'></td>
        <td style="width: 120px">Ngày tế xuân (âm lịch)</td>
        <td style="width: 160px"><input type="text" name="SpringAnniversary" placeholder="yyyy/mm/dd" id="SpringAnniversary" value='<c:out value="${prt.cultural_spring_day}"></c:out>'></td>
        <td style="width: 120px">Số thành viên:</td>
        <td id="member_count">${prnumber_individual}</td>
    </tr>
   <!-- <c:out value="${prt.address}"></c:out> -->
    <tr>
        <td>Địa chỉ</td>
        <td>
        	
            <select id="cboAddress" style="width: 150px; height: 25px; float: left" >
                <option value='1'>Quảng Nam </option><option value='2	'>Đà Nẵng</option><option value='3'>Sài Gòn </option><option value='4'>Hà Nội </option><option value='5'>An Giang </option><option value='6'>Bà Rịa Vũng Tàu </option><option value='7'>Bạc Liêu </option><option value='8'>Bắc Cạn </option><option value='9'>Bắc Giang </option><option value='10'>Bắc Ninh </option><option value='11'>Bến Tre </option><option value='12'>Bình Dương </option><option value='13'>Bình Định </option><option value='14'>Bình Dương </option><option value='15'>Bình Định </option><option value='16'>Bình Phước </option><option value='17'>Bình Thuận </option><option value='18'>Cà Mau </option><option value='19'>Cao Bằng </option><option value='20'>Cần Thơ </option><option value='21'>Đắc Lắc </option><option value='22'>Đồng Nai </option><option value='23'>Đồng Tháp </option><option value='24'>Gia Lai </option><option value='25'>Hà Giang </option><option value='26'>Hà Nam </option><option value='27'>Hà Tây </option><option value='28'>Hà Tĩnh </option><option value='29'>Hải Dương </option><option value='30'>Hải Phòng </option><option value='31'>Hòa Bình </option><option value='32'>Hưng Yên </option><option value='33'>Khánh Hòa </option><option value='34'>Kiên Giang </option><option value='35'>Kon Tum </option><option value='36'>Lai Châu </option><option value='37'>Lâm Đồng </option><option value='38'>Lạng Sơn </option><option value='39'>Lào Cai </option><option value='40'>Long An </option><option value='41'>Nam Định </option><option value='42'>Nghệ An </option><option value='43'>Ninh Bình </option><option value='44'>Ninh Thuận </option><option value='45'>Phú Yên </option><option value='46'>Phú Thọ </option><option value='47'>Quảng Bình </option><option value='48'>Quảng Ngãi </option><option value='49'>Quảng Ninh </option><option value='50'>Quảng Trị </option><option value='51'>Sóc Trăng </option><option value='52'>Sơn La </option><option value='53'>Tây Ninh </option><option value='54'>Thái Bình </option><option value='55'>Thái Nguyên </option><option value='56'>Thanh Hóa </option><option value='57'>Thừa Thiên Huế </option><option value='58'>Tiền Giang </option><option value='59'>Trà Vinh </option><option value='60'>Tuyên Quang </option><option value='61'>Vĩnh Long </option><option value='62'>Vĩnh Phúc </option><option value='63'>Yên Bái </option>					
            </select>
        </td>
        <td style="width: 110px">Tên trưởng họ</td>
        <td style="width: 200px"><input type="text" name="Head" id="Head" value="<c:out value="${prhead}"></c:out>"></td>
        
       
    </tr>
    <tr><td>-----------------</td></tr>
    <tr>
        <td>SDT Ngưởi tạo</td>
        
        <td style="width: 110px"><input type="text" name="Number" id="Number" value='<c:out value="${prt.head_of_parentage_number}"></c:out>'></td>
        <td style="width: 200px">Email Ngưởi tạo</td>
      	<td style="width: 120px"><input type="text" name="Email" id="Email" value='<c:out value="${prt.head_of_parentage_email}"></c:out>'></td>
        <td>Địa chỉ người tạo</td>
        <td><input type="text" name="Address" id="Address" value='<c:out value="${prheadadr}"></c:out>'></td>
        
    </tr>
    
    <tr><td>-----------------</td></tr>
    <tr>
    <tr>
        <td style="vertical-align: top">Lời giới thiệu</td>
        <td colspan="7"><textarea name="Description" id="Description" style="height:230px; width:580px " ><c:out value="${prhistory}"></c:out></textarea>
        
   </tr>
</tbody></table>
        </div>
    </div>
    <div class="ucp_def_footer">
        
    </div>
</div>
    </form>
	

<script type="text/javascript">
function lastVisit() {
	  var lastvisit=new Object()
	  lastvisit.firstvisitmsg="This is your first visit to this page. Welcome!" //Change first visit message here
	  lastvisit.subsequentvisitmsg="<b>[displaydate]</b>" // Change subsequent visit message here

	  lastvisit.getCookie=function(Name) { // get cookie value
	    var re=new RegExp(Name+"=[^;]+", "i"); // construct RE to search for target name/value pair
	    if (document.cookie.match(re)) // if cookie found
	      return document.cookie.match(re)[0].split("=")[1] // return its value
	      return ""
	  }
	  lastvisit.setCookie=function(name, value, days) { // set cookie value
	    var expireDate = new Date()
	    //set "expstring" to either future or past date, to set or delete cookie, respectively
	    var expstring=expireDate.setDate(expireDate.getDate()+parseInt(days))
	    document.cookie = name+"="+value+"; expires="+expireDate.toGMTString()+"; path=/";
	  }

	  lastvisit.showmessage=function() {
	  if (lastvisit.getCookie("visitcounter")=="") { // if first visit
	    //lastvisit.setCookie("visitcounter", 2, 730) // set "visitcounter" to 2 and for 730 days (2 years)
	    $("#recently").html(lastvisit.firstvisitmsg)
	  } else
		$("#recently").html(lastvisit.subsequentvisitmsg.replace("\[displaydate\]", new Date().toLocaleString()))
	  }
	  lastvisit.showmessage()
	}





	function ucFirstAllWords( str )
	{
		var pieces = str.split(" ");
		for ( var i = 0; i < pieces.length; i++ )
		{
			var j = pieces[i].charAt(0).toUpperCase();
			pieces[i] = j + pieces[i].substr(1);
		}
		return pieces.join(" ");
	}
	$(document).ready(function() {
		loadCBO();
		$("#recently").html(document.cookie);
		lastVisit();
	});
	
	function loadCBO(){
		$("select option").each(function(){
			  if ($(this).text() == "<c:out value='${pradr}'></c:out>")
			    $(this).attr("selected","selected");
		});
	}
	function open_edit()
	{

	$('.form-group').removeClass('has-error');
		$('#edit').modal('show'); // show bootstrap modal

	}
	
	
	function saveGiaPhaInfo(){
		$("#msg").html('<img src="<c:url value='/adimgs/loading1.gif'/>">Đang xử lý');
		var parentage_name = $("#FamilyName").val().trim();
		var head_of_parentage_name = $("#Head").val().trim();
		var ancestor = $("#Ancestor").val().trim();
		var cultural_spring_day = $("#SpringAnniversary").val().trim();
		var cultural_autumn_day = $("#AutumnAnniversary").val().trim();
		var mess="";

		if( parentage_name=="" ){	
			mess += "Tên họ tộc không được để trống. \n";
		}
		if( head_of_parentage_name=="" ){	
			mess += "Tên trưởng tộc không được để trống. \n";
		}
		if( ancestor=="" ){	
			mess += "Tên thủy tổ không được để trống. \n";
		}
		if(cultural_spring_day!=""){			
			if(!cultural_spring_day.match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)){	
				mess += "Sai định dạng ngày tế xuân(Năm/Tháng/Ngày). \n";
				alert("hhaha");
			}
		}
		if(cultural_autumn_day!=""){
			if(!cultural_autumn_day.match(/\d{4}[/-]\d{1,2}[/-]\d{1,2}/)){	
				mess += "Sai định dạng ngày tế thu(Năm/Tháng/Ngày). \n";
			}
		}
		if(mess != "" ){
			$("#msg").html(mess);
			return;
		}
		
		
		var idpr = $("#idpr").val();
		var request;
		if (window.XMLHttpRequest) {
            request = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
 
        try {
        	var data = {
        			parentage_id : "",
        			address : $("#cboAddress option:selected").text(),
        			parentage_name : $("#FamilyName").val(),
        			head_of_parentage_name : $("#Head").val(),
        			cultural_spring_day : $("#SpringAnniversary").val(),
        			cultural_autumn_day : $("#AutumnAnniversary").val(),
        			head_of_parentage_number : $("#Number").val(),
        			head_of_parentage_email : $("#Email").val(),
        			head_of_parentage_address : $("#Address").val(),
        			ancestor : $("#Ancestor").val(),
        			history_of_parentage : $("#Description").val(),
        			account_name : "<c:out value='${prt.account_name}'></c:out>",
        			cult_portion_land : "update soon",
        			convention_of_parentage : "update soon"			
        	};        	
        	var datastr = JSON.stringify(data);        	
        	var url = "http://localhost:8080/adv/parentage/ae?data="+ encodeURIComponent(datastr);
            request.onreadystatechange = function(){
            	var val = request.responseText;
            	if(this.readyState == 4&& this.status == 200){
            		window.alert(val);
            		$("#msg").html("");
            	}
            };
            request.open("POST", url, true);
            request.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
            request.send();            
        } catch(e) {
            alert("Unable to connect to server");
        }
       
	}
	
	
	function logout()
	{	
		var mess = "Bạn có thực sự muốn đăng xuất khỏi hệ thống";
		if(window.confirm(mess)){
			window.location.href = "/adv/view?action=logout";
		}
	}
	function openedit(id){
		window.location.href = "/adv/individual/ae?id="+id;
	}
</script>

    
   
	
  </body>
</html>