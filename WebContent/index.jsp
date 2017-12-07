<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<title>驴吧</title>
<style>
  .table th, .table td {
  	text-align: center;
  	vertical-align: middle !important;
  }
</style>
</head>

<body>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="<%=request.getContextPath() %>/index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="<%=request.getContextPath() %>/index.jsp">首页</a></li>
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
        <li><a href="#">通知</a></li>
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">私信<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath() %>/Privateletter/ReceivedPrivateletter.jsp">收信箱</a></li>
            <li><a href="<%=request.getContextPath() %>/Privateletter/SendedPrivateletter.jsp">已发送</a></li>
            <li><a href="<%=request.getContextPath() %>/Privateletter/SendPrivateletter.jsp">发私信</a></li>
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
          <button class="close" data-dismiss="modal" id="CloseLoginModal">
            <span>&times;</span>
          </button>
          <div class="modal-title">
            <h2 class="text-center">登录</h2>
          </div>
          <form class="form-group" method="post">
            <div class="form-group">
              <label for="username">用户名</label>
              <input class="form-control" type="text" name="username" id="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label>
              <input class="form-control" type="password" name="password" id="password" required>
              <label id="LoginError"></label>
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
      <!-- <h1 style="font-size: 2em">寻找队友</h1> -->
    </div>
    <form class="form-inline" role="form" method="post">
      <div class="col-1-sm"></div>
      <div class="form-group">
        <label>出发地</label>
        <label for="departureprovince"></label>
        <select class="form-control" id="departureprovince" name="departureprovince" style="height:33px; width:115px" required></select>
        <label for="departurecity"></label>
        <select class="form-control" id="departurecity" name="departurecity" style="height:33px; width:115px" required></select>
      </div>
      <div class="form-group" style="margin:0 auto">
        <label>目的地</label>
        <label for="destprovince"></label>
        <select class="form-control" id="destprovince" name="destprovince" style="height:33px; width:115px" required></select>
        <label for="destcity"></label>
        <select class="form-control" id="destcity" name="destcity" style="height:33px; width:115px" required></select>
      </div>
      <div class="form-group">
        <label for="beginDate">日期</label>
        <div class='input-group date' id='datetimepicker'>
          <input type="text" class="form-control" id="beginDate" style="height:33px; width:125px" name="beginDate"
          placeholder="请选择起始日期" pattern="^\d{4}-\d{1,2}-\d{1,2}" required />
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
          </span>
        </div>
      </div>
      &nbsp;&nbsp;&nbsp;
      <!-- 持续时间 -->
      <div class="form-group">
        <label for="duration">持续时间</label>
        <select class="fomr-control" id="duration" name="duration" style="height: 33px; width: 72px">
          <option value=1>1-3天</option>
          <option value=2>4-7天</option>
          <option value=3>7天以上</option>
        </select>
      </div>
      <!-- 预计开销 -->
      <div class="form-group">
        <label for="expenses">预计开支</label>
        <select class="fomr-control" id="expenses" name="expenses" style="height: 33px; width: 85px" required>
          <option value=1>0-500</option>
          <option value=2>500-1000</option>
          <option value=3>1000-2000</option>
          <option value=4>2000以上</option>
        </select>
      </div>
      <button id="SearchSchemeButton" class="btn btn-primary">查询</button>
    </form>

    <s:bean name="Bean.AllSchemes" var="content"></s:bean>
    <table class="table table-striped table-hover cos-sm-9">
      <thead>
        <tr>
          <th style="width: 300px;">标题</th>
          <th style="width: 200px;"></th>
          <th style="width: 125px;">作者</th>
          <th style="width: 125px;">发表时间</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="%{#content.schemes}" var="var">
          <tr>
            <td style="width: 300px;">
              <s:a href="SchemeInfo.action?schemeid=%{#var.schemeID}">
                <s:property value="#var.schemeTitle" />
              </s:a>
            </td>
            <td style="width: 200px;"></td>
            <td style="width: 125px;"><s:property value="ownerName" /></td>
            <td style="width: 125px;"><s:property value="postDate" /> <s:property value="postTime" /></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>
    <form action="SkipSchemePage">
      <input class="input" type="number" min="1" step="1" max="1000" name="topage" pattern="^[0-9]*[1-9][0-9]*$"
        style="height: 30px;width: 66px" value="${content.page}"/>
      <button type="submit" class="btn btn-default">跳转
      </button>
    </form>
  </div>


  
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
  <script src="<%=request.getContextPath()%>/js/provincecity.js"></script>
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
        if ($("#username").val != "") {
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
    $(function() {
      $("#SearchSchemeButton").bind("click", function() {
        var submitdata = $("form").serialize();
        submitdata = decodeURIComponent(submitdata, true);
        submitdata = encodeURI(encodeURI(submitdata));
        $.ajax({
          async: false,
          type: "post",
          url: "SearchScheme.action",
          data: submitdata,
          dataType: "json",
          success: function(data) {
            location.reload();
          },
          error: function() {
            alert("网络异常，请稍后再试");
          }
        });
      });
    });
  </script>
  <script type="text/javascript">
    $(function() {
      CreateProvinceCity('departureprovince', 'departurecity');
    	CreateProvinceCity('destprovince', 'destcity');
    });
  </script>
</body>

</html>