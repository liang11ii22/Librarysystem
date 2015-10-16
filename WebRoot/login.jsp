<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Public-Library Website Template | Contact :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="css/bootstrap.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
 
</head>
<%
  		String msg = (String)request.getAttribute("msg");
  		if(msg != null){
  			out.print("<script>window.alert('"+msg+"');</script>");
  			request.removeAttribute(msg);
  		}
   %>
<body>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
 <script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
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
			    <li><a href='index.jsp'><span>Home</span></a></li>
			    <li><a href='about.jsp'><span>About</span></a></li>
			    <li><a href='staff.jsp'><span>Staff</span></a></li>
			    <li class='has-sub'><a href='service.jsp'><span>Services</span></a></li>
			    <li class='active' class='last'><a href='Email_sendEmail.action'><span>Contact</span></a></li>
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
<!--main-->
<div class="main_btm">
<div class="wrap">
<div class="main">
	<div class="contact">
		<div class="section group">				
							
				<div class="col span_2_of_4">
				  <div class="contact-form">
								<h2 class="style">User Login</h2>
								<form method="post" action="login_userLogin.action">
									<div class="form-group">
										<input
											type="text" class="form-control" id="exampleInputEmail1"
											placeholder="Username" name="user.name">
									</div>
									<div class="form-group">
										<input
											type="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password" name="user.password">
									</div>
									<div>
										<span><input type="submit" value="Submit"></span>
									</div>
								</form>
							</div>
  				</div>		
  			<div class="clear"></div>
		  </div>
	</div>
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