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
          <li class="active"><a href="#">寻找旅伴</a></li>
          <li><a href="#">个人中心</a></li>
          <li><a href="#">旅游小组</a></li>
          <li><a href="#">出行攻略</a></li>
          <li><a href="#">通知</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signin-button">
            <a href="../Other/Login.jsp">登陆</a>
          </li>
          <li data-toggle="modal" data-target="#signin-signup-tab" id="signup-button">
            <a href="../Other/Register.jsp">注册</a>
          </li>
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
    <div class="row">
    </div>
    <form class="form-horizontal" role="form" action="NewScheme" method="post">
      <div class="form-group">
        <label for="schemeTitle" class="col-lg-1 control-label">标题</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="schemeTitle" placeholder="请输入标题">
        </div>
      </div>
      <div class="form-group">
        <label for="destination" class="col-lg-1 control-label">目的地</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="destination" placeholder="请输入目的地">
        </div>
      </div>
      
      <div class="form-group">
        <label for="beginDate" class="col-lg-1 control-label">起始日期</label>
        <div class="col-lg-3">
          <div class='input-group date' id='datetimepicker'>
            <input type="text" class="form-control" name="beginDate" placeholder="请选择起始日期"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
          </div>
        </div>
      </div>
      
      <div class="form-group">
        <label for="duration" class="col-lg-1 control-label">持续时间</label>
        <div class="col-lg-3">
          <select class="fomr-control" name="duration">
            <option value=1>1-3天</option>
            <option value=2>4-7天</option>
            <option value=3>7天以上</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="description" class="col-lg-1 control-label">详情</label>
        <div class="col-lg-5">
          <textarea class="form-control" rows="5" name="description"></textarea>
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
      $(function () {
        $('#datetimepicker').datetimepicker({
          language: 'zh-CN',
          format: 'yyyy-mm-dd',
          minView: "month",
          locale: moment.locale('zh-cn')
        });
      });
  </script>
</body>

</html>