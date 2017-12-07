<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<title>消息通知</title>
</head>
<body>
  <s:bean name="Bean.CheckLoginState" var="checkloginstate"></s:bean>
  <s:bean name="Bean.CheckNewMessage" var="checknewmessage"></s:bean>
  <s:bean name="Bean.Message" var="allmessages"></s:bean>
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
        <s:if test="%{#checknewmessage.messageNumber==0}">  
        <li class="active"><a href="<%=request.getContextPath() %>/Other/Message.jsp">通知</a></li>
        </s:if>
        <s:else>
        <li class="active"><a href="<%=request.getContextPath() %>/Other/Message.jsp">通知(${checknewmessage.messageNumber})</a></li>
        </s:else>
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
  <div class="container page-header" style="padding: 20px">
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
      <% int i=1; %>
      <s:iterator value="%{#allmessages.messages}" var="var">
        <div id=<%=i %>>
          <input type="hidden" value="<s:property value="%{#var.messageid}"/>" id="messageid"/>
          <input type="hidden" value="<s:property value="%{#var.groupid}"/>" id="groupid"/>
          <input type="hidden" value="<s:property value="%{#var.sender}"/>" id="username"/>
        </div>
        <s:if test="%{#var.type==0}">
          <s:property value="#var.sender" />请求加入你的小组
          <s:a href="ManageGroup.action?groupid=%{#var.groupid}">
          <s:property value="#var.groupname" /></s:a>
          <button onclick="AcceptMember(<%=i %>)">同意</button><button onclick="RefuseMember(<%=i %>)">拒绝</button>
          <br>
        </s:if>
        <s:if test="%{#var.type==1}">
          <s:property value="#var.sender" />同意了你加入
          <s:a href="ManageGroup.action?groupid=%{#var.groupid}">
          <s:property value="#var.groupname" /></s:a>的申请
          <button onclick="isRead(<%=i %>)">我知道了</button>
          <br>
        </s:if>
        <s:if test="%{#var.type==2}">
          <s:property value="#var.sender" />拒绝了你加入
          <s:a href="ManageGroup.action?groupid=%{#var.groupid}">
          <s:property value="#var.groupname" /></s:a>的申请
          <button onclick="isRead(<%=i %>)">我知道了</button>
          <br>
        </s:if>
        <s:if test="%{#var.type==3}">
          <s:property value="#var.sender" />的小组
          <s:a href="ManageGroup.action?groupid=%{#var.groupid}">
          <s:property value="#var.groupname" /></s:a>行程已结束，请您点击<s:a href="CommentGroup.action?groupid=%{#var.groupid}">这里</s:a>对本次行程做出评价
          <br>
        </s:if>
        <s:if test="%{#var.type==4}">
          <s:property value="#var.sender" />的小组
          <s:a href="ManageGroup.action?groupid=%{#var.groupid}">
          <s:property value="#var.groupname" /></s:a>已将您移出
          <button onclick="isRead(<%=i %>)">我知道了</button>
          <br>
        </s:if>
        <% ++i; %>
      </s:iterator>
    </s:else>
  </div>
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
  <script type="text/javascript" language="javascript">
  	function AcceptMember(num)
  	{
  		var mark="#"+num;
  		var groupid=$(mark).find("#groupid").val();
  		var messageid=$(mark).find("#messageid").val();
  		var username=$(mark).find("#username").val();
  		var url="AcceptMemberMessage.action";
  		var params={"groupid":groupid,"messageid":messageid,"username":username};
  		$.ajax
  		(
  				{
  					type:"POST",
  					url:url,
  					data:params,
  					dataType:"json",
  					success:function(data)
  					{
  						alert("操作成功");
  					},
  					error:function()
  					{
  						alert("操作失败，请稍后再试");
  					}
  				}
  		)
  	}
  	function RefuseMember(num)
  	{
  		var mark="#"+num;
  		var groupid=$(mark).find("#groupid").val();
  		var messageid=$(mark).find("#messageid").val();
  		var username=$(mark).find("#username").val();
  		var url="RefuseMemberMessage.action";
  		var params={"groupid":groupid,"messageid":messageid,"username":username};
  		$.ajax
  		(
  				{
  					type:"POST",
  					url:url,
  					data:params,
  					dataType:"json",
  					success:function(data)
  					{
  						alert("操作成功");
  					},
  					error:function()
  					{
  						alert("操作失败，请稍后再试");
  					}
  				}
  		)
  	}
  	function isRead(num)
  	{
  		var mark="#"+num;
  		var groupid=$(mark).find("#groupid").val();
  		var messageid=$(mark).find("#messageid").val();
  		var username=$(mark).find("#username").val();
  		var url="IsRead.action";
  		var params={"groupid":groupid,"messageid":messageid,"username":username};
  		$.ajax
  		(
  				{
  					type:"POST",
  					url:url,
  					data:params,
  					dataType:"json",
  					success:function(data)
  					{
  						alert("操作成功");
  					},
  					error:function()
  					{
  						alert("操作失败，请稍后再试");
  					}
  				}
  		)
  	}
  </script>
</body>
</html>
