<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script src="./js/bootstrap.min.js"></script>
  <script src="./js/jquery.min.js"></script>
  <title>驴吧</title>
</head>

<body>

  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand brand-lg" href="index.jsp">驴吧</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li class="active">
            <a href="index.jsp">首页</a>
          </li>
          <li>
            <a href="#">寻找旅伴</a>
          </li>
          <li>
            <a href="#">个人中心</a>
          </li>
          <li>
            <a href="#">旅游小组</a>
          </li>
          <li>
            <a href="#">出行攻略</a>
          </li>
          <li>
            <a href="#">通知</a>
          </li>
          <!-- <li class="dropdown"> 
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                    Java <b class="caret"></b> 
                </a> 
                <ul class="dropdown-menu"> 
                    <li><a href="#">jmeter</a></li> 
                    <li><a href="#">EJB</a></li> 
                    <li><a href="#">Jasper Report</a></li> 
                    <li class="divider"></li> 
                    <li><a href="#">分离的链接</a></li> 
                    <li class="divider"></li> 
                    <li><a href="#">另一个分离的链接</a></li> 
                </ul> 
            </li>  -->
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signin-button">
            <a href="#">登陆</a>
          </li>
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signup-button">
            <a href="#">注册</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

</body>

</html>