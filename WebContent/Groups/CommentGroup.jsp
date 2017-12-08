<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/time/bootstrap-datetimepicker.min.css" />
<title>小组评价</title>
<style>
.table th, .table td {
  text-align: center;
  vertical-align: middle !important;
}
</style>
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
        <li class="dropdown active">
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
  <s:bean name="Bean.CommentGroup" var="content"></s:bean>
  <div class="container">
  
    <div style="padding: 5px" class="page-header"></div>
    
    <div class="panel panel-primary">
      <div class="panel-heading">组员评价</div>
      <div class="panel-body">
        <s:iterator value="%{#content.users}" var="u">
          <s:if test="%{#u.username!=#session.username}">
            <div class="row">
              <div class="col-sm-2">
                <input type="hidden" name="membername" value="<s:property value="#u.username" />"/>
                  <s:property value="#u.username" />
              </div>
              <div class="col-sm-2"><button id="GreatButton" class="btn btn-block">给ta点赞</button></div>
            </div>
            <hr/>
          </s:if>
        </s:iterator>
      </div>
    </div>
    
    <div class="panel panel-primary">
      <div class="panel-heading">小组评价</div>
      <div class="panel-body">
        <form class="form-horizontal" role="form" method="post">
          <div class="row">
            <div class="col-sm-2">小组:</div>
            <div class="col-sm-5"><s:property value="#content.group.groupname" /></div>
            <input type="hidden" name="groupid" value="<s:property value="#content.group.groupid" />"/>
            <input type="hidden" name="messageid" value="<s:property value="#content.messageid" />"/>
          </div>
          <hr/>
          
          <div class="row">
            <div class="col-sm-2">对小组进行评分:</div>
            <div class="col-sm-5">
              <select name="score">
                <option value="5">★★★★★</option>
                <option value="4">★★★★</option>
                <option value="3">★★★</option>
                <option value="2">★★</option>
                <option value="1">★</option>
              </select>
            </div>
          </div>
          <hr/>
            
          <div class="row">
            <div class="col-sm-2">评价:</div>
            <div class="col-sm-5">
              <textarea name="comment" rows="5" cols="100"></textarea>
            </div>
          </div>
          <hr/>
          
          <!-- 按钮 -->
          <div class="row">
            <div class="col-lg-1"></div>
            <div class="col-lg-1">
              <button onclick="SubmitComment()" class="btn btn-block">提交</button>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-1">
              <button type="reset" class="btn btn-block">重置</button>
            </div>
          </div>
     	</form>
        
      </div>
    </div>
    
  </div>
  
  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function SubmitComment() {
      var submitdata = $("form").serialize();
      submitdata = decodeURIComponent(submitdata, true);
      submitdata = encodeURI(encodeURI(submitdata));
      $.ajax({
        async : false,
        type : "post",
        url : "NewComment.action",
        data : submitdata,
        dataType : "json",
        success : function(data) {
          var d = eval("(" + data + ")");
          if (d.success == "true") {
            alert("评价成功");
          } else {
            alert("提交失败，请重新提交");
          }
        },
        error : function() {
          window.alert("系统异常，请稍后重试");
        }
      });
    }
  </script>
  <script type="text/javascript">
    $(document).ready(function() {
      $("#LoginButton").bind("click", function() {
        if ($("#username").val != "") {
          $.ajax({
            async: false,
            type : "post",
            url : "Login.action",
            data : {
              username : $("#username").val(),
              password : $("#password").val()
            },
            dataType : "json",
            success : function(data) {
              var d = eval("(" + data + ")");
              if (d.LoginResult == 1) {
                location.reload();
              } else if (d.LoginResult == 2) {
                $("LoginError").html("密码错误!");
                alert("密码错误!");
              }
            },
            error : function() {
              alert("系统异常，请稍后再试");
            }
          });
        }
      });
    });
  </script>
</body>
</html>