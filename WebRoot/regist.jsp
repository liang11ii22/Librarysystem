<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Public-Library Website Template | Contact ::
	w3layouts</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/bootstrap3-validation.js"></script>

<link href="./css/style.css" rel="stylesheet" type="text/css"
	media="all" />


</head>
 <script type="text/javascript">
  $(function(){
    //1. 简单写法：
    $("#form1").validation({icon:true});
    // 要从后台数据确定填的邮箱是不是已注册过了，采用回调方法
    // $("form").validation(function(obj,params){
    //   if (obj.id=='mail'){
    //     $.post("/verifymail",{mail :$(obj).val()},function(data){
    //       params.err = !data.success;
    //       params.msg = data.msg;
    //     });
    //   }}
    //   ,{reqmark:true} //这个参数是设必填不要显示有星号，默认是有星号的
    // );
   
    //.注册
    $("#submit1").on('click',function(event){
      // 2.最后要调用 valid()方法。
      //  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
      //  valide(msg)
      
      //第一种提示写法
      if ($("#form1").valid(this,'内容出错')==false){
        return false;
      }
      
      //第二种提示写法，回调方法你自己提示就随意你了。
      //if ($("#form1").valid(this,function(err){alert(err)})==false){
      //  return false;
      //}
      
      
    })
    $("#form2").validation();
    //.注册
    $("#submit2").on('click',function(event){
      // 2.最后要调用 valid()方法。
      if ($("#form2").valid()==false){
        alert('填写信息不完整。');
        return false;
      }
    });
    $("#form3").validation(function(obj,params){  
      //扩展校验方法
    },{reqmark:false,icon:true});
    //.注册
    $("#submit3").on('click',function(event){
      // 2.最后要调用 valid()方法。
      if ($("#form3").valid('填写信息不完整。')==false){
        //alert('填写信息不完整。');
        return false;
      }
    });
  })
</script>
<body>

	<div class="btm_border">
		<div class="h_bg">
			<div class="wrap">
				<div class="header">
					<div class="logo">
						<h1>
							<a href="index.jsp"><img src="./images/logo.png" alt=""></a>
						</h1>
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
							<li class='active' class='last'><a href='contact.jsp'><span>Contact</span></a></li>
							<div class="clear"></div>
						</ul>
					</div>
					<div class="search">
						<form>
							<input type="text" value=""> <input type="submit"
								value="">
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

								<div class="row">
									<div class="box col-md-12">


										<div class="box-content">
											<h2 class="style">User registration</h2>
											 
    <!-- 水平排列的表单 -->
    <div class="container">
  <form class="form-horizontal"  id="form1" action="User_uploadUser.action" role="form" enctype="multipart/form-data" method="post">
    
    
      <div class="form-group">
        <label for="mail" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="mail" placeholder="xxxx@xx.com" check-type="mail required" name="user.email">
        </div>
      </div>

      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="Please enter your username" name="user.name">
        </div>
      </div>
       
       <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Tel:</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="mobile" name="user.tel">
        </div>
      </div>
       
       

      <div class="form-group">
        <label for="pw1" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="pw1" check-type="required" minlength="6" name="user.password">
        </div>
      </div>

     

       
       
		<div class="form-group ">
         <label for="exampleInputFile" class="col-sm-2 control-label">Upload Your Photo</label>
          
          <div class="col-md-6 col-sm-6">
         <input type="file" id="exampleInputFile" class="form-control" check-type="required" name="myfile">
          </div>
        </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" id="submit1" class="btn btn-primary col-sm-2">Submit</button>
          <button type="reset"  class="btn btn-primary col-sm-2">Reset</button>
        </div>
      </div>


    </form>
  </div>
										</div>
									</div>
								</div>
























								<form method="post" action="contact-post.jsp">
									<div>
										<span><label>NAME</label></span> <span><input
											name="userName" type="text" class="textbox"></span>
									</div>
									<div>
										<span><label>DEPARTMENT</label></span> <span><select
											id="user.dep.name" name="user.dep.name">
												<c:forEach var="list" items="${listd}">
													<option value="${dep.name }">${list.name }</option>
												</c:forEach>
										</select></span>
									</div>
									<div>
										<span><label>E-MAIL</label></span> <span><input
											name="userEmail" type="text" class="textbox"></span>
									</div>
									<div>
										<span><label>MOBILE</label></span> <span><input
											name="userPhone" type="text" class="textbox"></span>
									</div>
									<div>
										<span><label>PASSWPRD</label></span> <span><input
											name="password" type="password" class="textbox"></span>
									</div>
									<div>
										<span><label>PHOTO</label></span> <img src="${base }"
											width="200" height="250" /> <span id="files"><input
											type="file" name="myfile" value="ccc" /></span>
									</div>
									<div>
										<span><input type="submit" value="Submit me"></span>
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
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those interested. ions from the 1914 below
						for those by H. Rackham</p>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those The standard chunk of Lorem Ipsum used
						since the 1500s is reproduced reproduced</p>
				</div>
				<div class="box1">
					<h4 class="btm">Categories</h4>
					<nav>
					<ul>
						<li><a href="">The standard chunk of Lorem Ipsum used
								since </a></li>
						<li><a href="">Duis a augue ac libero euismod viverra
								sitth</a></li>
						<li><a href="">Duis a augue ac libero euismod viverra sit
						</a></li>
						<li><a href="">The standard chunk of Lorem Ipsum used
								since </a></li>
						<li><a href="">Duis a augue ac libero euismod viverra sit
						</a></li>
						<li><a href="">The standard chunk of Lorem Ipsum used
								since </a></li>
						<li><a href="">Duis a augue ac libero euismod viverra sit
						</a></li>
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
						<p>
							Email: <span>info(at)mycompany.com</span>
						</p>
						<p>
							Follow on: <span>Facebook</span>, <span>Twitter</span>
						</p>
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
					<p class="w3-link">
						© All Rights Reserved | Design by&nbsp; <a
							href="http://w3layouts.com/"> W3Layouts</a>
					</p>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>