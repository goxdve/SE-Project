<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="./css/bootstrap.min.css" />
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
          <li class="active"><a href="#">首页</a></li>
          <li><a href="./Schemes/NewScheme.jsp">寻找旅伴</a></li>
          <li><a href="#">个人中心</a></li>
          <li><a href="#">旅游小组</a></li>
          <li><a href="#">出行攻略</a></li>
          <li><a href="#">通知</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <% ActionContext ac=ActionContext.getContext();
              Map<String, Object> session1=ac.getSession();
              if(session1.containsKey("username")){
          %>
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signin-button">
            <a href="./Other/Login.jsp">登陆2</a>
          </li>
          <%}else{ %>
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signin-button">
            <a href="./Login.jsp">登陆</a>
          </li>
          <li><a href="./Other/Register.jsp">注册</a></li>
          <%} %>
        </ul>
      </div>
    </div>
  </nav>
  <div class="header">
  </div>
  <div class="container">
    <div style="padding:5px" class="page-header">
      <h1 style="font-size:2em">征集队友
        <small>发布你的组队意向</small>
      </h1>
    </div>
  </div>

  <script src="./js/bootstrap.min.js"></script>
  <script src="./js/jquery.min.js"></script>
</body>

</html>