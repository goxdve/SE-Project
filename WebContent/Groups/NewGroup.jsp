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
  <s:bean name="Bean.CheckLoginState" var="checkloginstate"></s:bean>
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
        <li class="dropdown active">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">旅游小组<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/Groups/AllGroups.jsp">所有小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/NewGroup.jsp">创建小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/MyGroups.jsp">我的小组</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                     出行攻略
            <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="allTravelNotes">查看所有攻略</a></li>
            <li><a href="<%=request.getContextPath() %>/travelNotes/editTravelNotes.jsp">写攻略</a></li>
          </ul>
        </li>
        <li><a href="#">通知</a></li>
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
          <form class="form-group" method="post">
            <div class="form-group">
              <label for="username">用户名</label> <input class="form-control" type="text" name="username" id="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label> <input class="form-control" type="password" name="password" id="password" required>
            </div>
            <div class="text-right">
              <button class="btn btn-primary" id="LoginButton">登录</button>
              <button class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
            <a href="<%=request.getContextPath() %>/Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">创建小组</h1>
    </div>
    <div class="row"></div>
    <s:if test="%{#checkloginstate.loggedin==false}">
      <div style="font-size: 110%">
        <p>您尚未登录</p>
        <ul>
          <li><a data-toggle="modal" data-target="#login" href=""> 登录</a></li>
          <li><a href="../Other/Register.jsp">还没有账号？点击此处注册</a></li>
          <li><a href="../index.jsp">再看看</a></li>
        </ul>
      </div>
    </s:if>
    <s:else>
    <form class="form-horizontal" role="form" method="post">
      <div class="form-group">
        <label for="groupname" class="col-xs-1 control-label">组名</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="groupname" placeholder="请输入组名" required>
        </div>
      </div>
      <div class="form-group">
        <label for="destination" class="col-lg-1 control-label">目的地</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="destination" placeholder="请输入目的地" required>
        </div>
      </div>

      <div class="form-group">
        <label for="begindate" class="col-lg-1 control-label">出发日期</label>
        <div class="col-lg-3">
          <div class='input-group date' id='datetimepicker'>
            <input type="text" class="form-control" name="begindate" placeholder="请选择出发日期" / required>
            <span class="input-group-addon">
              <span class="glyphicon glyphicon-calendar"></span>
            </span>
          </div>
        </div>
      </div>

      <div class="form-group">
        <label for="maxmembercount" class="col-lg-1 control-label">人数上限</label>
        <div class="col-lg-3">
          <input class="input" type="number" min="1" step="1" max="1000" name="maxmembercount" pattern="^[0-9]*[1-9][0-9]*$"/ required>
        </div>
      </div>

      <!-- 按钮 -->
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-1">
          <button id="NewGroup" class="btn btn-block">提交</button>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-1">
          <button type="reset" class="btn btn-block">重置</button>
        </div>
      </div>
    </form>
    </s:else>
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
  <script>
    $(document).ready(function() {
      $("#LoginButton").bind("click", function() {
        $.ajax({
          type: "post",
          url: "Login.action",
          data: {
            username: $("#username").val(),
            password: $("#password").val()
          },
          dataType: "json",
          success: function(data) {
            var d = eval("(" + data + ")");
            if (d.LoginResult == 1) {
              location.reload();
            }
            else if (d.LoginResult == 2) {
              $("LoginError").html("密码错误!");
              alert("密码错误!");
            }
          },
          error: function() {
            alert("系统异常，请稍后再试");
          }
        });
      });
    });
  </script>
  <script type="text/javascript">
    $(document).ready(function() {
      $("#NewGroup").bind("click", function() {
        var submitdata = $("form").serialize();
        submitdata = decodeURIComponent(submitdata, true);
        submitdata = encodeURI(encodeURI(submitdata));
        $.ajax({
          async: false,
          type: "post",
          url: "NewGroup.action",
          data: submitdata,
          dataType: "json",
          success:function(data) {
            var d = eval("(" + data + ")");
            if (d.success == "true") {
              alert("创建小组成功");
            } else {
              window.alert("创建小组失败，请重新创建");
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