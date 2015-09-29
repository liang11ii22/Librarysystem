<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
   <!--   <meta charset="utf-8">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">-->

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>

	<!-- jQuery -->
	<script src="bower_components/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap3-validation.js"></script>


	<!-- Function validate -->
	<script type="text/javascript">
	$(function(){
	    //1. 简单写法：
	    $("#form1").validation({icon:true});
	   
	    $("#submit1").on('click',function(event){
	      //第一种提示写法
	      if ($("#form1").valid(this,'内容出错')==false){
	        return false;
	      }
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
	   
	  })
	  
	 
	function addComponent(){
		var uploadHtml = document.createElement("<input type='file' name='myfile'/>");
		document.getElementById("files").appendChild(uploadHtml);
		uploadHtml = document.createElement("<p/>");
		document.getElementById("files").appendChild(uploadHtml);
		
	}
</script>

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>Charisma</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.jsp">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
       <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="index.jsp"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                         <li><a class="ajax-link" href="ui.jsp"><i class="glyphicon glyphicon-eye-open"></i><span> Maps</span></a>
                        </li>
                        <!-- <li><a class="ajax-link" href="form.jsp"><i
                                    class="glyphicon glyphicon-edit"></i><span> Forms</span></a></li> -->
                        <li><a class="ajax-link" href="chart.jsp"><i class="glyphicon glyphicon-list-alt"></i><span> Charts</span></a>
                        </li>
                        <li><a class="ajax-link" href="typography.jsp"><i class="glyphicon glyphicon-font"></i><span> Library News</span></a>
                        </li>
                        <!-- <li><a class="ajax-link" href="gallery.jsp"><i class="glyphicon glyphicon-picture"></i><span> Gallery</span></a>
                        </li> -->
                        <li class="nav-header hidden-md">Student Management</li>
                        <li><a class="ajax-link" href="table.jsp"><i
                                    class="glyphicon glyphicon-align-justify"></i><span> Student List</span></a></li>
                        <li><a class="ajax-link" href="booktable.jsp"><i
                                    class="glyphicon glyphicon-book"></i><span> Book List</span></a></li>
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> Student Personal Information Maintain</span></a>
                            <ul class="nav nav-pills nav-stacked">
                               
                                <li><a href="#">Search Student</a></li>
                            </ul>
                        </li>
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> Book Information Maintain</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="form.jsp">Add Book</a></li>
                                <li><a href="#">Search Book</a></li>
                            </ul>
                        </li>
                        
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> Library System</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="Library_showAllLibrary.action">Library List</a></li>
                                <li><a href="#">Library News</a></li>
                            </ul>
                        </li>
                          <li><a class="ajax-link" href="calendar.jsp"><i class="glyphicon glyphicon-calendar"></i><span> Calendar</span></a>
                        </li>
                       <!-- <li><a class="ajax-link" href="grid.jsp"><i
                                    class="glyphicon glyphicon-th"></i><span> Grid</span></a></li>-->
                        <li><a href="tour.jsp"><i class="glyphicon glyphicon-globe"></i><span> Tour</span></a></li>
                       
                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            

<div>
    <ul class="breadcrumb">
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">Blank</a>
        </li>
    </ul>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-star-empty"></i> Blank</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <!-- Add book start -->
                 
     <form class="form-horizontal"  id="form1" action="Book_addBook.action" role="form" enctype="multipart/form-data" method="post">
     

      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Title Of Book</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="Please Full In The Book's Title" name="book.name">
        </div>
      </div>
       
       <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Author Of The Book</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="Please Full In The Book's Author" name="book.author">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Publishment Of The Book</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="Please Full In The Book's Publishment" name="book.publishment">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Category Of The Book</label>
        	
										<div class="form-group">
											<select class="form-control" name="book.category.name" id="book.category.name">
											<c:forEach var="catelist" items="${catelist}">
												<option>${catelist.name }</option>
											</c:forEach>
											</select>
										</div>
     </div>
     
     <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Library Contains The Book</label>
        	
										<div class="form-group">
											<select class="form-control" name="book.schoollib.name" id="book.schoollib.name">
											<c:forEach var="liblist" items="${liblist}">
												<option>${liblist.name }</option>
												</c:forEach>
											</select>
										</div>
     </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">The Date Of Book Publishment</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="Please Full In The Book's Publishment Date" name="book.publishdate">
        </div>
      </div>
       
        <div class="form-group ">
          <label for="exampleInputFile">Upload The Front Cover of The Book</label>
          <span id="files"><input type="file" id="exampleInputFile" class="form-control" check-type="required" name="myfile"></span>
          <p class="help-block">Example block-level help text here.</p>
        </div>

      
       <div class="form-group">
        <label for="vercode" class="col-sm-2 control-label">Brief Description</label>
        <div class="col-sm-6">
          <textarea  class="form-control" id="vercode" check-type="required" rows="3" name="book.brief"></textarea>
          
        </div>
      </div> 
       
<div class="form-group">
        <label for="vercode" class="col-sm-2 control-label"> Description In Detail</label>
        <div class="col-sm-6">
          <textarea  class="form-control" id="vercode" check-type="required" rows="3" name="book.descp"></textarea>
          
        </div>
      </div> 

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" id="submit1" class="btn btn-primary col-sm-4">Submit</button>
          <button type="reset"  class="btn btn-primary col-sm-4">Reset</button>
        </div>
      </div>


    </form>
    
    
    
                <!-- Add book end -->
                
            </div>
        </div>
    </div>
</div><!--/row-->


    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

        </div>

    </div>
    <!-- Ad ends -->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
                Usman</a> 2012 - 2015</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>
