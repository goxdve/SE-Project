<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/time/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/my_navbar.css" />
<title>注册</title>
</head>

<body>
  <s:bean name="Bean.CheckNewMessage" var="checknewmessage"></s:bean>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="<%=request.getContextPath() %>/index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath() %>/index.jsp">首页</a></li>
        <li><a href="<%=request.getContextPath() %>/Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalSpace.jsp">个人中心</a></li>
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">旅游小组<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/Groups/AllGroups.jsp">所有小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/NewGroup.jsp">创建小组</a></li>
            <li><a href="<%=request.getContextPath() %>/Groups/MyGroups.jsp">我的小组</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">出行攻略<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="allTravelNotes">查看所有攻略</a></li>
            <li><a href="<%=request.getContextPath() %>/travelNotes/editTravelNotes.jsp">写攻略</a></li>
          </ul>
        </li>
        <s:if test="%{#checknewmessage.messageNumber==0}">  
        <li><a href="<%=request.getContextPath() %>/Other/Message.jsp">通知</a></li>
        </s:if>
        <s:else>
        <li><a href="<%=request.getContextPath() %>/Other/Message.jsp">通知(${checknewmessage.messageNumber})</a></li>
        </s:else>
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">私信<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/Privateletter/ReceivedPrivateletter.jsp">收信箱</a></li>
            <li><a href="<%=request.getContextPath() %>/Privateletter/SendedPrivateletter.jsp">已发送</a></li>
            <li><a href="<%=request.getContextPath() %>/Privateletter/SendPrivateletter.jsp">发私信</a></li>
          </ul>
        </li>
        <li><a href="<%=request.getContextPath() %>/Route/Route.jsp">路线推荐</a></li>
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
              <label for="username">用户名</label> <input class="form-control" type="text" id="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label> <input class="form-control" type="password" id="password" required>
            </div>
            <div class="text-right">
              <button class="btn btn-primary" id="LoginButton">登录</button>
              <button class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
            <a href="<%=request.getContextPath()%>/Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">注册</h1>
    </div>
    <div class="panel panel-primary">
      <div class="panel-heading"></div>
      <div class="panel-body">
        <form class="form-horizontal" role="form" method="post">
          <h3>基本资料</h3>
          <br/>
          <!-- 用户名 -->
          <div class="form-group">
            <label for="username" class="col-lg-1 control-label">用户名</label>
            <div class="col-lg-3">
              <input type="text" class="form-control" name="username" id="RegisterUsername" onblur="checkusername()" required />
            </div>
            <div class="col-lg-3" id="UsernameError"></div>
          </div>
          <!-- 密码 -->
          <div class="form-group">
            <label for="password1" class="col-lg-1 control-label">密码</label>
            <div class="col-lg-3">
              <input type="password" class="form-control" name="password1" id="password1" onblur="checkpassword()" required />
            </div>
          </div>
          <!-- 确认密码 -->
          <div class="form-group">
            <label for="password2" class="col-lg-1 control-label">确认密码</label>
            <div class="col-lg-3">
              <input type="password" class="form-control" name="password2" id="password2" onblur="checkpassword()" required />
            </div>
            <div class="col-lg-3" id="pwdnotmatch"></div>
          </div>
          <!-- 性别 -->
          <div class="form-group">
            <label for="sex" class="col-lg-1 control-label">性别</label>
            <div class="col-lg-3">
              <input type="radio" name="sex" value=0 selected />男 &nbsp;&nbsp; <input type="radio" name="sex" value=1 />女
            </div>
          </div>
          <!-- 出生年月 -->
          <div class="form-group">
            <label for="birthday" class="col-lg-1 control-label">出生年月</label>
            <div class="col-lg-3">
              <div class='input-group date' id='datetimepicker'>
                <input type="text" class="form-control" name="birthday" placeholder="出生年月" required/> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
                </span>
              </div>
            </div>
          </div>

          <hr/>

          <h3>详细信息</h3>
          <br/>
          <!-- 联系方式 -->
          <div class="form-group">
            <label for="telephone" class="col-md-1 control-label">联系方式</label>
            <div class="col-md-3">
              <input type="text" class="form-control" name="telephone" />
            </div>
          </div>
          <!-- 个人说明 -->
          <div class="form-group">
            <label for="signature" class="col-md-1 control-label">个人说明</label>
            <div class="col-md-5">
              <textarea class="form-control" rows="5" name="signature"></textarea>
            </div>
          </div>

          <!-- 按钮 -->
          <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-1">
              <button class="btn btn-block" onclick="register()">注册</button>
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

  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/time/bootstrap-datetimepicker.js"></script>
  <script src="<%=request.getContextPath() %>/js/time/moment-with-locales.js"></script>
  <script src="<%=request.getContextPath() %>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
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
  <script type="text/javascript">
    $(document).ready(function() {
      $("#LoginButton").bind("click", function() {
        if ($("#RegisterUsername").val != "") {
          $.ajax({
            async: false,
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
        }
      });
    });
  </script>
  <script type="text/javascript">
    function checkusername() {
      if ($("#RegisterUsername").val != "") {
        $.ajax({
          async: false,
          type: "post",
          url: "RegisterCheckUsername.action",
          data: {
            username: $("#RegisterUsername").val(),
          },
          dataType: "json",
          success: function(data) {
            var d = eval("(" + data + ")");
            if (d.RegisterResult == 1) {
              document.getElementById("UsernameError").innerHTML = "用户名已存在";
            } else {
              document.getElementById("UsernameError").innerHTML = "用户名可用";
            }
          },
          error: function() {
          }
        });
      }
    }
  </script>
  <script type="text/javascript">
    function checkpassword() {
      if ($("#password1").val() != "" || $("#password2").val() != "") {
        $.ajax({
          async: false,
          type: "post",
          url: "RegisterCheckPWD.action",
          data: {
            pwd1: $("#password1").val(),
            pwd2: $("#password2").val()
          },
          dataType: "json",
          success: function(data) {
            var d = eval("(" + data + ")");
            if (d.RegisterResult == 1) {
              document.getElementById("pwdnotmatch").innerHTML = "两次密码不一致";
            } else {
              document.getElementById("pwdnotmatch").innerHTML = "";
            }
          },
          error: function() {
          }
        });
      } else {
        document.getElementById("pwdnotmatch").innerHTML = "";
      }
    }
  </script>
  <script type="text/javascript">
    function register() {
      var submitdata = $("form").serialize();
      submitdata = decodeURIComponent(submitdata, true);
      submitdata = encodeURI(encodeURI(submitdata));
      $.ajax({
        async : false,
        type : "post",
        url : "Register.action",
        data : submitdata,
        dataType : "json",
        success : function(data) {
          var d = eval("(" + data + ")");
          if (d.RegisterResult == 1) {
            alert("注册成功");
          } else if (d.RegisterResult == 2) {
            alert("用户名已存在");
          } else {
            alert("两次密码不一致");
          }
        },
        error : function() {
          window.alert("系统异常，请稍后重试");
        }
      });
    }
  </script>

</body>

</html>
