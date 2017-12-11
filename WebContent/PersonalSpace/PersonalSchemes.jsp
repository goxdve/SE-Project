<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/my_navbar.css" />
<title>个人发布的计划</title>
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
        <li class="active"><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalSpace.jsp">个人中心</a></li>
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

  <h2>cccc</h2>
  <div class="container-fluid">
    <div class="row">
      <div class="span2  col-xs-12 col-sm-3 col-md-2">
        <ul class="nav nav-pills nav-stacked">
          <li><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalSpace.jsp">首页</a></li>
          <li><a href="<%=request.getContextPath()%>/PersonalSpace/PerfectInformation.jsp">个人信息</a></li>
          <li class="active"><a href="<%=request.getContextPath()%>/PersonalSpace/PersonalSchemes.jsp">发布计划</a></li>
          <li><a href="<%=request.getContextPath()%>/PersonalSpace/PersonalGroups.jsp">参与小组</a></li>
          <li><a href="<%=request.getContextPath()%>/PersonalSpace/PersonalNotes.jsp">发表攻略</a></li>
        </ul>
      </div>
      <div class="col-xs-12 col-sm-9 col-md-10">
        <table class="table table-striped table-hover cos-sm-12">
          <thead>
            <tr>
              <th style="width: 150px;">标题</th>
              <th style="width: 150px;">开始日期</th>
              <th style="width: 150px;">发布时间</th>
              <th style="width: 150px;"></th>
            </tr>
          </thead>
          <tbody>
            <%
                int i = 1;
            %>
            <s:bean name="Bean.MySchemes" var="content"></s:bean>
            <s:iterator value="%{#content.allmyschemes}" var="var" status="st">
              <tr>
                <td style="width: 150px;"><s:a href="SchemeInfo.action?schemeid=%{#var.schemeID}">
                    <s:property value="%{#var.schemeTitle}" />
                  </s:a></td>
                <td style="width: 150px;"><s:property value="%{#var.beginDate}" /></td>
                <td style="width: 150px;"><s:property value="%{#var.postDate}" /> <s:property value="%{#var.postTime}" /></td>
                <td style="width: 150px;" id=<%=i%>><input type="hidden" value="<s:property value="%{#var.schemeID}"/>" id="schemeid" />
                  <button type="button" class="btn btn-primary" onclick="cancelscheme(<%=i++%>)">撤销此计划</button></td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
  </div>



  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
  <script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
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
  <script type="text/javascript" language="javascript">
  function cancelscheme(num) {
      var r = confirm("您确定要删除吗");
      if (r == false)
        return;
	  var mark="#"+num;
	  var schemeid=$(mark).find("#schemeid").val();
	  var url="CancelScheme.action";
	  var params={"schemeID":schemeid};
	  $.ajax
	  (
			  {
				  type : "POST",
	              url : url,
	              data : params,
	              dataType:"json",
	              success:function(data)
	              {
	                  alert("撤销成功！");
	                  window.location.reload();
	              },
	              error:function()
	              {
 	                  
	                  window.location.reload();
	              }
	  		  }
	  )
  }
  </script>

</body>
</html>
