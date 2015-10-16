<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 're.jsp' starting page</title>
     <script type="text/javascript" src="js/jquery-1.10.2.min.js" ></script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    

<script type="text/javascript" src="js/bootstrap3-validation.js"></script>
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
  
    <h1><a href="https://github.com/mrlong/bootstrap3-validation.js">bootstrap3 of validation</a></h1>

    <!-- 水平排列的表单 -->
    <div class="container">
    <div class="page-header">
      <h1>水平表单 <small>Subtext for header</small></h1>
    </div>
    
     <form class="form-horizontal"  id="form1" action="User_uploadUser.action" role="form">
      <div class="form-group">
        <label for="mail" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="mail" placeholder="xxxx@qq.com" check-type="mail required" name="user.email">
        </div>
        <div class="col-sm-offset-2 col-sm-10">
          <span class="help-block" style="color: #000000;padding-top: 10px;">请填写真实的邮箱，在注册之前会将验证码发送到你的邮箱内.</span>
        </div>
      </div>

      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="请填写你的大名。" name="user.name">
        </div>
      </div>
       
       <div class="form-group">
        <label for="name" class="col-sm-2 control-label">你的手机</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="mobile" name="user.tel">
        </div>
      </div>
       
       

      <div class="form-group">
        <label for="pw1" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="pw1" check-type="required" minlength="6" name="user.password">
        </div>
      </div>

     

       
       <div class="form-group">
        <label for="vercode" class="col-sm-2 control-label">备注</label>
        <div class="col-sm-6">
          <textarea  class="form-control" id="vercode" check-type="required" rows="3" name="user.description"></textarea>
          
        </div>
      </div> 
       
<div class="form-group ">
													<label for="exampleInputFile"
														class="col-sm-4 control-label">Upload The Photo</label>

													<div class="col-md-6 col-sm-6">
														<input type="file" id="exampleInputFile"
															class="form-control" check-type="required" name="myfile">
													</div>
												</div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" id="submit1" class="btn btn-primary col-sm-4">注册</button>
          <button type="reset"  class="btn btn-primary col-sm-4">重置</button>
        </div>
      </div>


    </form>
  </div>

<!-- 基本表单 -->
<div class="container">
<div class="page-header">
    <h1>基本表单 <small>Subtext for header</small></h1>
</div>
<form role="form" id="form2">
  <div class="form-group has-error">
    <label for="exampleInputEmail1" >Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" check-type="required">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" >Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" check-type="required">
  </div>
  <div class="form-group ">
    <label for="exampleInputFile">File input</label>
    <input type="File" id="exampleInputFile" class="form-control" check-type="required">
    <p class="help-block">Example block-level help text here.</p>
  </div>

  <div class="checkbox ">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>

    <button type="submit" id="submit2" class="btn btn-primary col-sm-4">提交</button>
</form>
</div>

<div class="container">
<div class="page-header">
    <h1>内联表单 <small>Subtext for header</small></h1>
</div>
<form class="form-inline" role="form" id="form3">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail2">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email" check-type="required">
  </div>
  <div class="form-group">
    <label class="sr-only" for="exampleInputPassword2">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" check-type="required">
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" > Remember me<span>ssss</span>
    </label>
  </div>
  <button type="submit" class="btn btn-primary" id="submit3">确定</button>
</form>
</div>


  </body>

</html>
