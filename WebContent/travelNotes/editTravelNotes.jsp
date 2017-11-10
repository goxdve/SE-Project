<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/time/bootstrap-datetimepicker.min.css" />
  <link href="../utf8-jsp/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
  <title>驴吧</title>
</head>
<body>
  <h2>cccc</h2>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="../index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="../index.jsp">首页</a></li>
        <li><a href="../Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li><a href="#">旅游小组</a></li>
        <li><a href="">出行攻略</a></li>
        <li><a href="#">通知</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a data-toggle="modal" data-target="#login" href="#"> <span class="glyphicon glyphicon-log-in"></span> 登录</a>
        </li>
        <li><a href="../Other/Register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
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
          <form class="form-group" action="Login">
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
            <a href="../Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>
  <form action="note.jsp" method="post" target="_blank">
    <script type="text/plain" id="travelNote" style="width:1000px;height:240px;"></script>
    <input type="submit" value="提交">
  </form>
  <script type="text/javascript" charset="utf-8" src="../utf8-jsp/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="../utf8-jsp/ueditor.all.min.js"></script>
  <script type="text/javascript" src="../utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  <script type="text/javascript">
  var ue = UE.getEditor('travelNote',{toolbars:[[
      'undo','redo','insertunorderedlist','insertorderedlist','cleardoc','|',
      'emotion','simpleupload','snapscreen','map','insertvideo','horizontal','|',
      'indent','italic','underline','strikethrough','fontfamily','fontsize','forecolor',
      ]]});
  </script>
  <button name="postNote">发表</button>
</body>
</html>