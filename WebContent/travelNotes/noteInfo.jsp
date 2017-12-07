<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.Reader"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="Class.Note" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<title>攻略详情</title>
</head>
<body>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="<%=request.getContextPath() %>/index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath() %>/index.jsp">首页</a></li>
        <li><a href="<%=request.getContextPath() %>/Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">旅游小组<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/Groups/AllGroups.jsp">所有小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/NewGroup.jsp">创建小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/MyGroups.jsp">我的小组</a></li>
          </ul>
        </li>
        <li class="dropdown active">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">出行攻略 <b class="caret"></b>
        </a>
          <ul class="dropdown-menu">
            <li><a href="allTravelNotes">查看所有攻略</a></li>
            <li><a href="<%=request.getContextPath() %>/travelNotes/editTravelNotes.jsp">写攻略</a></li>
          </ul>
        </li>
        <li><a href="#">通知</a></li>
        <li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">私信<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/Privateletter/ReceivedPrivateletter.jsp">收信箱</a></li>
            <li><a href="<%=request.getContextPath()%>/Privateletter/SendedPrivateletter.jsp">已发送</a></li>
            <li><a href="<%=request.getContextPath()%>/Privateletter/SendPrivateletter.jsp">发私信</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <% ActionContext ac=ActionContext.getContext();
          Map<String, Object> session1=ac.getSession();
          if(session1.containsKey("username")){
        %>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <s:property value="#session.username"/>
            <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/PersonalSpace/PerfectInformation.jsp">个人中心</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="Logout.action">退出</a></li>
          </ul>
        </li>
        <%}else{ %>
        <li><a data-toggle="modal" data-target="#login" href=""> <span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
        <li><a href="<%=request.getContextPath() %>/Other/Register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
        <%} %>
      </ul>

    </div>
  </div>
  </nav>
  
  <!-- 登陆模态框 -->
  <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
          <button class="close" data-dismiss="modal">
            <span>&times;</span>
          </button>
          <div class="modal-title">
            <h2 class="text-center">登录</h2>
          </div>
          <form class="form-group" action="Login" method="post">
            <div class="form-group">
              <label for="username">用户名</label> <input class="form-control" type="text" name="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label> <input class="form-control" type="password" name="password" required>
            </div>
            <div class="text-right">
              <button class="btn btn-primary" type="submit">登录</button>
              <button class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
            <a href="<%=request.getContextPath() %>/Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>
  
  <div class="container">
    <s:iterator value="aNote" status="st">
      <form class="form-horizontal" role="form" method="post">
        <div style="padding: 5px" class="page-header">
          <h1 style="font-size: 2em"><s:property value="noteTitle" /></h1>
        </div>
        <div class="page-header">
          <h4><s:property value="ownerName" /></h4>
        </div>
        <input type="hidden" name="noteID" value='<s:property value="noteID"/>'>
        <input type="hidden" name="noteTitle" value='<s:property value="noteTitle"/>'>
        <s:property escape="false" value="travelNote" />
        <div class="row">
          <div class="col-lg-1"></div>
          <div class="col-lg-1">
            <button id="deleteButton" class="btn btn-block">删除</button>
          </div>
        </div>
      </form>
    </s:iterator>
  </div>
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $("#deleteButton").bind("click", function() {
        var submitdata = $("form").serialize();
        submitdata = decodeURIComponent(submitdata, true);
        submitdata = encodeURI(encodeURI(submitdata));
        $.ajax({
          async: false,
          type: "post",
          url: "deleteNote.action",
          data: submitdata,
          dataType: "json",
          success:function(data) {
            var d = eval("(" + data + ")");
            if (d.success == "true") {
              alert("删除成功");
            } else {
              window.alert("删除失败，请重新删除");
            }
          },
          error:function() {
            window.alert("系统异常，请稍后重试");
          }
        });
      });
    });
  </script>
</body>
</html>
