<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
    <meta charset="utf-8">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

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

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDxVxdhRxPd1wzPV_iPQVHH63zYq0jypBE&callback=initMap"
        async defer></script>
    
    <script >
     var library = [['SciLibrary', -33.889299, 151.191307],
                    ['FisherLibrary', -33.886572, 151.190478],
                    ['LawLibrary', -33.887147, 151.190724],
                    ['MedicalLibrarry', -33.889700, 151.184768]];
     var map;
     function initMap() {
    	 var directionsService = new google.maps.DirectionsService(); 
 	     var directionsDisplay = new google.maps.DirectionsRenderer();
       
       if(navigator.geolocation){
    	   navigator.geolocation.getCurrentPosition(function (position) {
               var coords = position.coords;
            
               //
               var location = new google.maps.LatLng(coords.latitude, coords.longitude);
               var myOptions = {
                   zoom: 14,    
                   center: location,  
                   mapTypeId: google.maps.MapTypeId.ROADMAP
               };
               // create map
               map = new google.maps.Map(document.getElementById('map'), myOptions);
       
               directionsDisplay.setMap(map);
               
               var start = new google.maps.LatLng(coords.latitude, coords.longitude);
               
               var end = new google.maps.LatLng(-33.889299, 151.191307);
               // libray address
               
               
               
               
               
               
               
               var request = {
              	        origin : start,
              	        destination : end,
              	        travelMode : google.maps.TravelMode.WALKING
              	    };
              	    
              	    directionsService.route(request, function(response, status) {
              	        if (status == google.maps.DirectionsStatus.OK) {
              	            directionsDisplay.setDirections(response);
              	        }else{
              	        	alert("Direction request failed");
              	        }
              	    });
               
               var marker = new google.maps.Marker({
                   position: location,    
                   map: map 
               });

               var infoWindow = new google.maps.InfoWindow({
                   content: "position：<br/>longitude：" + location.lat() + "<br/>latitude：" + location.lng()   //提示窗体内的提示信息
               });
       
               infoWindow.open(map, marker);
              
               
           }, function (error) {
  
               switch (error.code) {
                   case 1:
                       alert("serveice refused。");
                       break;
                   case 2:
                       alert("can not get information");
                       break;
                   case 3:
                       alert("time out");
                       break;
                   default:
                       alert("unkown");
                       break;
               }
           }, null);
    	   
    	   document.getElementById('mode').addEventListener('change', function() {
   		    calculateAndDisplayRoute(directionsService, directionsDisplay);
   		  });
    	   
           
    	   var end = new google.maps.LatLng(-33.889299, 151.191307);
    	   
    	   var selectedMode = document.getElementById('mode').value;
    	   
    	   
   	    
       }else{
    	   alert("not support");
    	   }
	   
   
     } 
     
  
     </script>

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
                       <!-- <li><a class="ajax-link" href="icon.jsp"><i
                                    class="glyphicon glyphicon-star"></i><span> Icons</span></a></li>
                        <li><a href="error.jsp"><i class="glyphicon glyphicon-ban-circle"></i><span> Error Page</span></a>
                        </li>
                          <li><a href="login.jsp"><i class="glyphicon glyphicon-lock"></i><span> Login Page</span></a>
                        </li>-->
                    </ul>
                    <!--  <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>-->
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
            



<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-star-empty"></i> Library Information</h2>

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
                <!-- Library detail start -->
                <form action="Library_showAllLibrary.action" method="post">
                 <div class="row">
                   <h3><p class="center">Welcome To  ${lib.name }</p></h3>
                     <div class="col-md-3">
                     
                    <img src="${lib.attachment }" width="160px" height="200px" class="center"/>
                    </div>
                  <div class="col-md-9">
                    
                    <p class="text-left"><strong>Open Time:</strong> ${lib.opentime }</p>
                    <p class="text-left">${lib.description }</p>
                    <p class="text-justify"><strong>Location:</strong> ${lib.location }</p>
     
     				<!-- MAP Start -->
                    <div id="map" style="width: 500px; height: 300px;">  
             
        			</div>
        			<br>  
                    
                    <!-- MAP End -->
                    <button type="submit" class="btn btn-info" >Return</button>
                  </div>
                    </div>
                    
                    </form>
                <!-- Library detail end -->
            </div>
        </div>
    </div>
</div><!--/row-->


    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>
            <script>
                (adsbygoogle = window.adsbygoogle || []).push({});
            </script>
        </div>
        <div class="col-md-2 col-lg-3 col-sm-12 col-xs-12 email-subscription-footer">
            <div class="mc_embed_signup">
                <form action="//halalit.us3.list-manage.com/subscribe/post?u=444b176aa3c39f656c66381f6&amp;id=eeb0c04e84" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
                    <div>
                        <label>Keep up with my work</label>
                        <input type="email" value="" name="EMAIL" class="email" placeholder="Email address" required>

                        <div class="power_field"><input type="text" name="b_444b176aa3c39f656c66381f6_eeb0c04e84" tabindex="-1" value=""></div>
                        <div class="clear"><input type="submit" value="Subscribe" name="subscribe" class="button"></div>
                    </div>
                </form>
            </div>

            <!--End mc_embed_signup-->
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
