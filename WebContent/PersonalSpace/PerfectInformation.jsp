<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/11/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<html>

<head>
<title>PerfectInformation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
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
        <li><a href="<%=request.getContextPath() %>/Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li class="active"><a href="#">个人中心</a></li>
        <li><a href="#">旅游小组</a></li>
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
            <li><a href="#">退出</a></li>
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
          <form class="form-group" action="Login">
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
  <h2>cccc</h2>
  <div class="container-fluid">
        <div class="row">
            <div class="span2  col-xs-12 col-sm-3 col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">首页</a></li>
                    <li class="active"><a href="<%=request.getContextPath() %>/PersonalSpace/PerfectInformation.jsp">个人信息</a></li>
                    <li><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalSchemes.jsp">发布计划</a></li>
                    <li><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalGroups.jsp">参与小组</a></li>
                    <li><a href="<%=request.getContextPath() %>/PersonalSpace/PersonalNotes.jsp">发表攻略</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-9 col-md-10">
            	<s:bean name="Bean.PersonalInformation" var="Information">
  				</s:bean>
			  	<form class="form-horizontal" role="form" method="post" action="PerfectInformation">
			        <div class="form-group">
			          <label for="newpassword" class="col-lg-1 control-label">密码</label>
			          <div class="col-lg-3">
			            <input type="text" class="form-control" name="newpassword"
							value="<s:property value="%{#Information.password}"/>" required />
			          </div>
			        </div>
			        
			        <div class="form-group">
			          <label for="newage" class="col-lg-1 control-label">年龄</label>
			          <div class="col-lg-3">
			            <input type="text" class="form-control" name="newage" 
			            value="<s:property value="%{#Information.age}"/>" required>
			          </div>
			        </div>
			
			        <div class="form-group">
				        <label for="newsex" class="col-lg-1 control-label">性别</label>
				        <div class="col-lg-3">
				          <input type="radio" name="newsex" value=0 />男 &nbsp;&nbsp; <input type="radio" name="newsex" value=1 />女
				        </div>
			       </div>
			        
			        <div class="form-group">
			          <label for="newtelephone" class="col-lg-1 control-label">电话号码</label>
			          <div class="col-lg-3">
			            <input type="text" class="form-control" name="newtelephone" 
			            value="<s:property value="%{#Information.telephone}"/>" required>
			          </div>
			        </div>
			        
					<div class="form-group">
			          <label for="newsignature" class="col-lg-1 control-label">签名</label>
			          <div class="col-lg-5">
			            <textarea class="form-control" rows="5" name="newsignature"><s:property value="%{#Information.signature}"/></textarea>
			          </div>
        			</div>
			        <!-- 按钮 -->
			        <div class="row">
			          <div class="col-lg-1"></div>
			          <div class="col-lg-1">
			            <button type="submit" class="btn btn-block">提交</button>
			          </div>
			          <div class="col-lg-1"></div>
			        </div>
			     
			     </form>
            </div>
        </div>
    </div>
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>
