
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Public-Library Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="./css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="./js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="./js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
</head>
<body>
<div class="btm_border">
<div class="h_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<h1><a href="index.jsp"><img src="./images/logo.png" alt=""></a></h1>
		</div>
		<div class="social-icons">
			<ul>
			     <li><a class="facebook" href="#" target="_blank"> </a></li>
			     <li><a class="twitter" href="#" target="_blank"></a></li>
			     <li><a class="googleplus" href="#" target="_blank"></a></li>
			     <li><a class="pinterest" href="#" target="_blank"></a></li>
			     <li><a class="dribbble" href="#" target="_blank"></a></li>
			     <li><a class="vimeo" href="#" target="_blank"></a></li>
		   </ul>
		</div>	
		<div class="clear"></div>
	</div>
	<div class='h_btm'>
		<div class='cssmenu'>
			<ul>
			    <li class='active'><a href='index.jsp'><span>Home</span></a></li>
			    <li><a href='about.jsp'><span>About</span></a></li>
			    <li><a href='BorrowReturn_checkBorrowList.action'><span>Check you own book list</span></a></li>
			   <li><a href='Reservation_checkSeat.action'><span>Book A Seat</span></a></li>
			    <li class='last'><a href='contact.jsp'><span>Contact</span></a></li>
			 	<div class="clear"></div>
			 </ul>
	</div>
	<div class="search">
    	<form>
    		<input type="text" value="">
    		<input type="submit" value="">
    	</form>
	</div>
	<div class="clear"></div>
</div>
</div>
</div>
</div>
<!------ Slider_bg ------------>
<div class="slider_bg">
<div class="wrap">
	<!------ Slider------------>
		  <div class="slider">
	      	<div class="slider-wrapper theme-default">
	            <div id="slider" class="nivoSlider">
	                <img src="./images/banner1.jpg" data-thumb="./images/1.jpg" alt="" />
	                <img src="./images/banner2.jpg" data-thumb="./images/2.jpg" alt="" />
	                <img src="./images/banner3.jpg" data-thumb="./images/3.jpg" alt="" />
	            </div>
	        </div>
	      </div>
		<!------End Slider ------------>
		<div class="grids_1_of_3">
				<div class="grid_1_of_3 images_1_of_3">
					  <a href="Book_showBookList.action"><img src="./images/icon1.jpg">
					  <h3>Check Book List</h3></a>
					  <p></p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <a href="login.jsp"><img src="./images/icon2.jpg"></a>
					  <a href="login.jsp"><h3>Sign up</h3></a>
					  <p></p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <a href="Announce_annList.action"><img src="./images/icon3.jpg">
					  <h3>Announcement</h3></a>
					  <p></p>
				</div>
				<div class="clear"></div>
			</div>
</div>
</div>
<!--main-->
<div class="main_bg">
<div class="wrap">
<div class="main">
	<div class="content">
		<!-- Alert -->
                         <div class="alert alert-danger alert-dismissable hide" id="notify">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong>Your borrow book will be due in several days, please return them on time!</strong>
                        </div>
                        <script type="text/javascript">
                        
                            $("#${alertRegister}").attr("class","alert alert-danger");
                            //window.alert("${alertRegister}");
                        </script>
					 <!-- ---------------------------------- -->
	</div>
</div>
</div>
<div class="main_btm">
	<div class="wrap">
		 <div class="main">
					<div class="gallery">
						<h3>Our latest projects</h3>
						<ul>
							<li><a href="./images/gallery1.jpg"><img src="./images/gallery1.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery2.jpg"><img src="./images/gallery2.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery3.jpg"><img src="./images/gallery3.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery4.jpg"><img src="./images/gallery4.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery4.jpg"><img src="./images/gallery4.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery3.jpg"><img src="./images/gallery3.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery5.jpg"><img src="./images/gallery5.jpg" alt=""></a><a href="#"></a></li>
							<li><a href="./images/gallery6.jpg"><img src="./images/gallery6.jpg" alt=""></a><a href="#"></a></li>
						</ul>
					</div>
					<script type="text/javascript" src="./js/jquery.lightbox.js"></script>
				    <link rel="stylesheet" type="text/css" href="./css/lightbox.css" media="screen">
				  	<script type="text/javascript">
				    $(function() {
				        $('.gallery a').lightBox();
				    });
				    </script>
					<div class="terminals">
						<h3>Testimonials</h3>
						<p>sed tempor ipsum dolor sit amet,Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt aliqua. Ut enim ad minim veniam,consectetur adipisicing elit,sed do eiusmod tempor incididunt magna aliqua. </p>
						<p>sed tempor Ipsum dolor sit amet,Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt aliqua. Ut enim ad minim veniam,consectetur adipisicing elit,sed do eiusmod tempor incididunt magna aliqua. </p>
						<span><a href="#">- Lorem ipsum</a> USA.</span>
					</div>
					<div class="clear"> </div>
		</div>
	</div>
</div>
<!--footer-->
<div class="footer-bg">	
<div class="wrap">
<div class="footer">
  <div class="box1">
	<h4 class="btm">What We Do</h4>
	<p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. ions from the 1914 below for those  by H. Rackham</p>
	<p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those The standard chunk of Lorem Ipsum used since the 1500s is reproduced reproduced</p>
  </div>
   <div class="box1">
	<h4 class="btm">Categories</h4>
	<nav>
		<ul>
			<li><a href="">The standard chunk of Lorem Ipsum used since </a></li>
			<li><a href="">Duis a augue ac libero euismod viverra sitth</a></li>
			<li><a href="">Duis a augue ac libero euismod viverra sit </a></li>
			<li><a href="">The standard chunk of Lorem Ipsum used since </a></li>
			<li><a href="">Duis a augue ac libero euismod viverra sit </a></li>
			<li><a href="">The standard chunk of Lorem Ipsum used since </a></li>
			<li><a href="">Duis a augue ac libero euismod viverra sit </a></li>
	    </ul>
	</nav>
	</div>
	<div class="box1">
		<h4 class="btm">Get in touch</h4>
		<div class="box1_address">
			<p>500 Lorem Ipsum Dolor Sit,</p>
			<p>22-56-2-9 Sit Amet, Lorem,</p>
			<p>USA</p>
			<p>Phone:(00) 222 666 444</p>
			<p>Fax: (000) 000 00 00 0</p>
			<p>Email: <span>info(at)mycompany.com</span></p>
			<p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
		</div>
	</div>
	<div class="clear"></div>			
</div>
</div>
</div>
<!--footer1-->
<div class="ftr-bg">
	<div class="wrap">
		<div class="footer">
		<div class="copy">
			<p class="w3-link">© All Rights Reserved | Design by&nbsp; <a href="http://w3layouts.com/"> W3Layouts</a></p>
		</div>
		<div class="clear"></div>	
	</div>
	</div>
</div>
</body>
</html>