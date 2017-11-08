<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <li><a href="../index.jsp">首页</a></li>
        <li><a href="../Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li><a href="#">旅游小组</a></li>
        <li><a href="#">出行攻略</a></li>
        <li><a href="#">通知</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li data-toggle="modal" data-target="#signin-signup-tab" id="signin-button"><a href="#">登陆</a></li>
        <li><a href="#">注册</a></li>
      </ul>
    </div>
  </div>
  </nav>
  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">注册</h1>
    </div>
    <div class="row"></div>
    <form class="form-horizontal" role="form" action="register" method="post">
      <div class="form-group">
        <label for="username" class="col-lg-1 control-label">用户名</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="username" placeholder="请输入用户名">
        </div>
      </div>
      <div class="form-group">
        <label for="password1" class="col-lg-1 control-label">密码</label>
        <div class="col-lg-3">
          <input type="password" class="form-control" name="password1">
        </div>
      </div>
      <div class="form-group">
        <label for="password2" class="col-lg-1 control-label">确认密码</label>
        <div class="col-lg-3">
          <input type="password" class="form-control" name="password2">
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
            <input type="text" class="form-control" name="birthday" placeholder="出生日期" /> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
          </div>
        </div>
      </div>

      <!-- 按钮 -->
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-1">
          <button type="submit" class="btn btn-block">提交</button>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-1">
          <button type="reset" class="btn btn-block">重置</button>
        </div>
      </div>
    </form>
  </div>

  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/jquery.min.js"></script>
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