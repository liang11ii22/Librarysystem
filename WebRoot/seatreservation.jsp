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
<%
  		String msg = (String)request.getAttribute("msg");
  		if(msg != null){
  			out.print("<script>window.alert('"+msg+"');</script>");
  			request.removeAttribute(msg);
  		}
   %>
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
	<div class="row">
	 <div class="about-header">
			<h3>Book A Seat</h3>
			<div class="clear"></div>
		</div>
		<br>
		      
                    <div class="section">
		<div class="container">
                    
                  
                    <div class="post-coments">
                  
                   <br>
                               
                    
              
                       <table class="table table-striped" align="right">
                        
                        <thead>
                        <tr></tr><tr></tr>
						<tr>
                         <th>Seat ID</th>
                         <th>Library Location</th>
                         <th>State</th>
                         <th>Actions</th>
                        </tr>
                       </thead>
                       <tbody>
						 <c:forEach var="list" items="${seatlist}">
							<tr>
								<td>${list.id }</td>
								<td class="center">${list.schoolLib.name }</td>
								<td class="center">${list.state }</td>

								<td class="center"><a class="btn btn-success"
									href="Reservation_bookSeat.action?seatid=${list.id }"> <i class="glyphicon glyphicon-log-in"></i> Book
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
                        </table>
                    
        
											<h4>Comments (${count})</h4>
											<div class="panel panel-info" style="height:700px; weight:1500px;overflow:auto">
									
											<ul class="post-comments">
<br>
												<c:forEach var="comm" items="${comm }">
													<li>
														<div class="comment-wrapper">
															<div class="comment-author">
																<img src="${ comm.users.attachment}" alt="User Pic" class="img-circle" width="50" height="50">
																${comm.users.name}
															</div>
															<br>
															<div class="panel panel-default">
																<div class="panel-body">${comm.commcontents }</div>
															</div>

															<!-- Comment Controls -->
															<div class="comment-actions">
															<div align="right">
																<span class="comment-date">${comm.commdate}</span>

																<!-- collapse reply button -->
																<a class="btn btn-info btn-xs comment-reply-btn"
																	role="button" data-toggle="collapse"
																	href="#collapse${comm.id}" aria-expanded="false"
																	aria-controls="collapse"> <i
																	class="glyphicon glyphicon-share-alt"></i> Reply
																</a>
																
																</div>
																<br>
																<div class="collapse" id="collapse${comm.id}">
																	<div class="well">

																		<form role="form"
																			action="<%=request.getContextPath() %>/BookComm_addBookCommReply.action?commid=${comm.id}"
																			method="post">

																			<div class="form-group">
																				<label for="comment-message"><i
																					class="glyphicon glyphicon-comment"></i> </label>
																				<textarea class="form-control" rows="3"
																					id="concommsrep" name="bookComms.commcontents"></textarea>
																			</div>
																			<div class="form-group">
																				<button type="submit"
																					class="btn btn-primary pull-right">Send</button>
																			</div>
																			<div class="clearfix"></div>
																		</form>

																	</div>
																</div>
																<br>
																<!-- collapse reply button end -->

															</div>
															<!-- Comment Controls end -->

														</div>
													</li>
												</c:forEach>

											</ul>
											
</div>

											<!-- Comments Form -->
											<h4>Leave a Comment</h4>
											<div class="comment-form-wrapper">
												<form role="form" action="BookComm_addBookComms.action?bid=${bookdetail.id }" method="post">
													

													<div class="form-group">
														<label for="comment-message"><i
															class="glyphicon glyphicon-comment"></i> <b>Your
																Message</b></label>
														<textarea class="form-control" rows="5"
															id="concomms" name="bookComms.commcontents"></textarea>
													</div>
													<div class="form-group">
														<button type="submit" class="btn btn-primary pull-right">Send</button>
													</div>
													<div class="clearfix"></div>
												</form>
											</div>
											<!-- End Comment Form -->
										</div>
										<!-- End Comments -->
										<div class="single-post-info"></div>
								</div>
								
								
								
								
								
								
							
                    
                    
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