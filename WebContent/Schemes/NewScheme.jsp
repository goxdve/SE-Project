<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/time/bootstrap-datetimepicker.min.css" />
  <title>驴吧</title>
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
        <li class="active"><a href="#">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li class="dropdown">
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
              <label for="username">用户名</label> <input class="form-control" type="text" id="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label> <input class="form-control" type="password" id="password" required>
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
      <h1 style="font-size: 2em">
        征集队友 <small>发布你的组队意向</small>
      </h1>
    </div>
    <div class="row"></div>
    <form class="form-horizontal" role="form" action="NewScheme" method="post">
      <div class="form-group">
        <label for="schemeTitle" class="col-lg-1 control-label">标题</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="schemeTitle" placeholder="请输入标题" required/>
        </div>
      </div>
      <div class="form-group">
        <label for="destination" class="col-lg-1 control-label">目的地</label>
        <div class="col-lg-3">
          <input type="text" class="form-control" name="destination" placeholder="请输入目的地" required>
        </div>
      </div>

      <div class="form-group">
        <label for="beginDate" class="col-lg-1 control-label">起始日期</label>
        <div class="col-lg-3">
          <div class='input-group date' id='datetimepicker'>
            <input type="text" class="form-control" name="beginDate"
             placeholder="请选择起始日期"  pattern="^\d{4}-\d{1,2}-\d{1,2}" required/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
          </div>
        </div>
      </div>

      <div class="form-group">
        <label for="duration" class="col-lg-1 control-label">持续时间</label>
        <div class="col-lg-3">
          <select class="fomr-control" name="duration" style="height:30px;">
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


  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
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
      $("#NewSchemeSubmit").bind("click", function() {
        var submitdata = $("form").serialize();
        submitdata = decodeURIComponent(submitdata, true);
        submitdata = encodeURI(encodeURI(submitdata));
        $.ajax({
          async: false,
          type: "post",
          url: "NewScheme.action",
          data: submitdata,
          dataType: "json",
          success:function(data) {
            var d = eval("(" + data + ")");
            if (d.success == "true") {
              alert("提交成功");
            } else {
              window.alert("提交失败，请重新提交");
            }
          },
          error:function() {
            window.alert("系统异常，请稍后重试");
          }
        });
      });
    });
  </script>
  <script type="text/javascript">
    $(document).ready(function() {
      $("#LoginButton").bind("click", function() {
        if ($("#username").val != "") {
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
        }
      });
    });
  </script>
</body>

</html>
