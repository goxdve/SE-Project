<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
<%--   <s:a href="SchemeInfo.action?schemeid=%{#var.schemeID}"> --%>
<%-- 								<s:property value="%{#var.schemeTitle}" /></s:a> --%>
  <div class="container-fluid">
        <div class="row">
            <div class="span2  col-xs-12 col-sm-3 col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li><s:a href="OtherSpace.action?username=%{username}">首页</s:a></li>
                    <li><s:a href="OtherInformation.action?username=%{username}">个人信息</s:a></li>
                    <li class="active"><s:a href="OtherSchemes.action?username=%{username}">发布计划</s:a></li>
                    <li><s:a href="OtherGroups.action?username=%{username}">参与小组</s:a></li>
                    <li><s:a href="OtherNotes.action?username=%{username}">发表攻略</s:a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-9 col-md-10">
            	<div style="padding: 5px" class="page-header">
				      <h1 style="font-size: 2em"><s:property value="username"/>的计划</h1>
				</div>
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
						<s:iterator value="allotherSchemes" id="var" status="st">
							<tr>
								<td style="width: 150px;"><s:a href="SchemeInfo.action?schemeid=%{#var.schemeID}" >
								<s:property value="#var.schemeTitle" /></s:a>
								</td>
								<td style="width: 150px;"><s:property value="#var.beginDate" /></td>
								<td style="width: 150px;"><s:property value="#var.postDate" /> <s:property value="#var.postTime" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
            </div>
        </div>
    </div>
</body>
</html>
