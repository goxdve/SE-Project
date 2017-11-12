<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<title>驴吧</title>
<style>
.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
}
</style>
</head>

<body>
  <s:bean name="Bean.MyGroups" var="content"></s:bean>
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
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">我的小组</h1>
    </div>
    <div class="row"></div>
    <s:if test="%{#content.loggedin==false}">
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
      <div class="panel-group col-sm-8" id="accordion">
        <div class="panel panel-info">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#ManagedGroups"> 我管理的小组</a>
            </h4>
          </div>

          <div id="ManagedGroups" class="panel-collapse collapse">
            <div class="panel-body">
              <ul>
                <s:iterator value="%{#content.allmygroups}" var="var">
                  <s:if test="%{#var.isManaged==true}">
                    <li>
                      <s:a href="ManageGroup.action?groupid=%{#var.groupid}" target="_blank">
                        <s:property value="#var.groupname" />
                      </s:a>
                    </li>
                  </s:if>
                </s:iterator>
              </ul>
            </div>
          </div>
        </div>

        <div class="panel panel-info">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#JoinedGroups"> 我加入的小组</a>
            </h4>
          </div>
          <div id="JoinedGroups" class="panel-collapse collapse">
            <div class="panel-body">
              <s:iterator value="%{#content.allmygroups}" var="var">
                <s:if test="%{#var.isManaged==false}">
                  <li>
                    <s:a href="ManageGroup.action?groupid=%{#var.groupid}" target="_blank">
                      <s:property value="#var.groupname" />
                    </s:a>
                  </li>
                </s:if>
              </s:iterator>
            </div>
          </div>
        </div>
      </div>

    </s:else>
  </div>
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script type="text/javascript">
			$(function() {
				$('#ManagedGroups').collapse('toggle')
			});
			$(function() {
				$('#JoinedGroups').collapse('toggle')
			});
		</script>
</body>

</html>
