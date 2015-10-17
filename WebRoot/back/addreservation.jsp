<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
                         <li><a class="ajax-link" href="reservation.jsp"><i class="glyphicon glyphicon-eye-open"></i><span> Reservation</span></a>
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
            <a href="#">Form</a>
        </li>
    </ul>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-star-empty"></i> Form</h2>

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
                 
     <form class="form-horizontal"  id="form1" action="" role="form" enctype="multipart/form-data" method="post">
     

      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Seat No.</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" placeholder="Seat No." >
        </div>
      </div>
       
       <div class="form-group">
        <label for="name" class="col-sm-2 control-label">User ID</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" placeholder="User ID" >
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Status</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" placeholder="Status" name="book.publishment">
        </div>
      </div>
      <div class="form-group">
       <label for="name" class="col-sm-2 control-label">Library</label>
       <div class="col-sm-6">
         <select class="form-control">
         <c:forEach var="liblist" items="${liblist}">
			<option>${liblist.name }</option>
		 </c:forEach>
       </select>
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Period</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" placeholder="Period" >
        </div>
      </div>
  	  <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Date</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" placeholder="Date" >
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" id="submit1" class="btn btn-primary col-sm-4">Submit</button>
          <button type="reset"  class="btn btn-primary col-sm-4">Reset</button>
        </div>
      </div>


    </form>
    
    
    
   <!-- Add end -->
                
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
    
    
    
  </body>
</html>
