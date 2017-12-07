<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/time/bootstrap-datetimepicker.min.css" />
<title>驴吧</title>
<style>
.table th, .table td {
  text-align: center;
  vertical-align: middle !important;
}
</style>
</head>
<body>
  <s:bean name="Bean.CommentGroup" var="content"></s:bean>
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
      <h1 style="font-size: 2em">小组评价</h1>
    </div>
    <div class="row"></div>
    
    <div class="panel-group col-sm-8" id="accordion">
      <div class="panel panel-info">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#GroupInfo"> 小组整体评价</a>
          </h4>
        </div>
        
        <div id="GroupInfo" class="panel-collapse collapse">
          <div class="panel-body">
            <form class="form-horizontal" role="form" method="post">
              <input type="hidden" id="groupid" name="groupid" value="<s:property value="#parameters.groupid"/>" />
              
              <!-- 组名 -->
              <div class="form-group">
                <label for="groupname" class="col-sm-2 control-label">组名</label>
                <div class="col-sm-4">
<!--                   <input type="text" class="form-control" name="groupname" style="height:33px; width:210px" -->
<%--                    value="<s:property value="#content.group.groupname" />" required /> --%>
                  <label class="col-sm-2 control-label"><s:property value="#content.group.groupname" /></label>
                </div>
              </div>
              <!-- 打分 -->
              <div class="form-group">
                <label class="col-sm-2 control-label">为您的本次出行打分</label>
                <div class="col-sm-4">
                  <label for="departureprovince"></label>
                  <select class="form-control" id="departureprovince" name="departureprovince" style="height:33px; width:210px" required></select>
                </div>
                <div class="col-sm-4">
                  <label for="departurecity"></label>
                  <select class="form-control" id="departurecity" name="departurecity" style="height:33px; width:210px" required></select>
                </div>
              </div>
              <!-- 评价 -->
              <div class="form-group">
                <label class="col-sm-2 control-label">朋友一生一起走</label>
                <div class="col-sm-4">
                  <label for="departureprovince"></label>
                  <select class="form-control" id="departureprovince" name="departureprovince" style="height:33px; width:210px" required></select>
                </div>
                <div class="col-sm-4">
                  <label for="departurecity"></label>
                  <select class="form-control" id="departurecity" name="departurecity" style="height:33px; width:210px" required></select>
                </div>
              </div>
            </form>
          </div>
        </div>  
      </div>    
    </div>
  </div>
</body>
</html>