<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/time/bootstrap-datetimepicker.min.css" />
<title>驴吧</title>
</head>

<body>

  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="../index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="#">首页</a></li>
        <li><a href="../Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li><a href="#">旅游小组</a></li>
        <li><a href="#">出行攻略</a></li>
        <li><a href="#">通知</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <%
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> session1 = ac.getSession();
            if (session1.containsKey("username")) {
        %>
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">
            <s:property value="username"/>
            <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">个人中心</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="#">退出</a></li>
          </ul>
        </li>
        <%
            } else {
        %>
        <li><a data-toggle="modal" data-target="#login" href=""> <span class="glyphicon glyphicon-log-in"></span> 登录
        </a></li>
        <li><a href="./Other/Register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
        <%
            }
        %>
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
            <a href="./Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">注册</h1>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        基本信息
      </div>
      <div class="panel-body">
        <form class="form-horizontal" role="form" action="register" method="post">
          <div class="form-group">
            <label for="username" class="col-lg-1 control-label">用户名</label>
            <div class="col-lg-3">
              <input type="text" class="form-control" name="username" placeholder="请输入用户名" required>
            </div>
          </div>
          <div class="form-group">
            <label for="password1" class="col-lg-1 control-label">密码</label>
            <div class="col-lg-3">
              <input type="password" class="form-control" name="password1" required>
            </div>
          </div>
          <div class="form-group">
            <label for="password2" class="col-lg-1 control-label">确认密码</label>
            <div class="col-lg-3">
              <input type="password" class="form-control" name="password2" required>
            </div>
          </div>

          <div class="form-group">
            <label for="sex" class="col-lg-1 control-label">性别</label>
            <div class="col-lg-3">
              <input type="radio" name="sex" value=0 />男 &nbsp;&nbsp; <input type="radio" name="sex" value=1 />女
            </div>
          </div>

          <div class="form-group">
            <label for="birthday" class="col-lg-1 control-label">出生日期</label>
            <div class="col-lg-3">
              <div class='input-group date' id='datetimepicker'>
                <input type="text" class="form-control" name="birthday" placeholder="出生日期" required/> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
                </span>
              </div>
            </div>
          </div>

          <!-- 按钮 -->
          <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-1">
              <button type="submit" class="btn btn-block">提交</button>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-1">
              <button type="reset" class="btn btn-block">重置</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div> 
  <div class="panel panel-default">
    <div class="panel-heading">
      详细资料
    </div>
    <div class="panel-body">
      <form class="form-horizontal" role="form" action="register" method="post" enctype="multipart/form-data">
        <div class="form-group">
          <label for="username" class="col-md-1 control-label">用户名</label>
          <div class="col-lg-3">
            <input type="text" class="form-control" name="username" placeholder="请输入用户名" required>
          </div>
        </div>
        <div class="form-group">
          <label for="password1" class="col-lg-1 control-label">密码</label>
          <div class="col-lg-3">
            <input type="password" class="form-control" name="password1" required>
          </div>
        </div>
        <div class="form-group">
          <label for="password2" class="col-lg-1 control-label">确认密码</label>
          <div class="col-lg-3">
            <input type="password" class="form-control" name="password2" required>
          </div>
        </div>

        <div class="form-group">
          <label for="sex" class="col-lg-1 control-label">性别</label>
          <div class="col-lg-3">
            <input type="radio" name="sex" value=0 />男 &nbsp;&nbsp; <input type="radio" name="sex" value=1 />女
          </div>
        </div>

        <div class="form-group">
          <label for="birthday" class="col-lg-1 control-label">出生日期</label>
          <div class="col-lg-3">
            <div class='input-group date' id='datetimepicker'>
              <input type="text" class="form-control" name="birthday" placeholder="出生日期" required/> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
              </span>
            </div>
          </div>
        </div>

        <!-- 按钮 -->
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-1">
            <button type="submit" class="btn btn-block">提交</button>
          </div>
          <div class="col-md-1"></div>
          <div class="col-md-1">
            <button type="reset" class="btn btn-block">重置</button>
          </div>
        </div>
      </form>
    </div>
  </div>

  


  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/time/bootstrap-datetimepicker.js"></script>
  <script src="../js/time/moment-with-locales.js"></script>
  <script src="../js/time/bootstrap-datetimepicker.zh-CN.js"></script>
  <script type="text/javascript">
    $(function() {
      $('#datetimepicker').datetimepicker({
        language : 'zh-CN',
        format : 'yyyy-mm-dd',
        minView : "month",
        locale : moment.locale('zh-cn')
      });
    });
  </script>

</body>

</html>
