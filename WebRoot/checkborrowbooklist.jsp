<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Public-Library Website Template | 404 :: w3layouts</title>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/npm.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="./css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">


</head>
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
			    <li class='active'><a href='index.jsp'><span>Home</span></a></li>
			    <li><a href='about.jsp'><span>About</span></a></li>
			    <li><a href='staff.jsp'><span>Staff</span></a></li>
			    <li class='has-sub'><a href='service.jsp'><span>Services</span></a></li>
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
<!--main-->

<div class="wrap">
<div class="main">
	<h2>Borrow Recording</h2>
		 
                 <br>
              <table class="table">
              
                        <thead>
                        
						<tr >
                         <th>Book Title</th>
                         <th>Author</th>
                         <th>Publisher</th>
                         <th>Libray</th>
                         <th>Borrow Date</th>
                         <th>Due Time</th>
                         <th class="center">Action</th>
                        </tr>
                       </thead>
                        <tbody>
                        <!-- Alert -->
                         <div class="alert alert-success alert-dismissable hide" id="returnnotify">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong>Return book success!</strong>
                        </div>
                        <script type="text/javascript">
                        
                            $("#${alertRegister2}").attr("class","alert alert-danger");
                            //window.alert("${alertRegister1}");
                        </script>
                        <!-- Alert -->
                         <div class="alert alert-danger alert-dismissable hide" id="borrowlist">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong>You borrow recording is empty!</strong>
                        </div>
                        <script type="text/javascript">
                        
                            $("#${alertRegister}").attr("class","alert alert-danger");
                            //window.alert("${alertRegister}");
                        </script>
					 <!-- ---------------------------------- -->
                        <c:forEach var="list" items="${listborrow}">
                        <tr>
                            <td class="center" width="100">${list.book.name }</td>
                            <td class="center" width="100">${list.book.author }</td>
                            <td class="center" width="175">${list.book.publishment }</td>
                            <td class="center" width="150">${list.book.schoolLib.name }</td>
                             <td class="center" width="100">${list.BDate }</td>
                              <td class="center" width="180">${list.BShouldDate }</td>
							<td class="center">
							<a class="btn btn-success" href="Book_viewBookDetail.action?bid=${list.book.id }"><i class="glyphicon glyphicon-zoom-in icon-white"></i> View
							</a> 
							<a class="btn btn-success" href="BorrowReturn_returnBooks.action?bid=${list.id }"><i class="glyphicon glyphicon-share-alt"></i> Return
							</a> </td>
						</tr>
                       </c:forEach>
                       
                        </tbody>
                    </table>
                    
              <br>
              <h2>You Have Read...</h2>      
                 <br>
              <table class="table">
               <thead>
                        
						<tr >
                         <th>Book Title</th>
                         <th>Author</th>
                         <th>Publisher</th>
                         <th>Libray</th>
                         <th>Action</th>
                        </tr>
                       </thead>
                       <!-- Alert -->
                         <div class="alert alert-danger alert-dismissable hide" id="allborrowlist">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong>You don't have a borrow recording in this library!</strong>
                        </div>
                        <script type="text/javascript">
                        
                            $("#${alertRegister1}").attr("class","alert alert-danger");
                            //window.alert("${alertRegister1}");
                        </script>
					 <!-- ---------------------------------- -->
                        <tbody>
                       
                        <c:forEach var="list" items="${alllistborrow}">
                        <tr>
                            <td class="center" width="200">${list.name }</td>
                            <td class="center" width="150">${list.author }</td>
                            <td class="center" width="350">${list.publishment }</td>
                            <td class="center" width="250">${list.schoolLib.name }</td>
							<td class="center">
							<a class="btn btn-success" href="Book_viewBookDetail.action?bid=${list.id }"><i class="glyphicon glyphicon-zoom-in icon-white"></i> View
							</a> </td>
						</tr>
                       </c:forEach>
                       
                        </tbody>
                    </table>
                   
	
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