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
<link href="<%=request.getContextPath()%>/utf8-jsp/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
<title>驴吧</title>
</head>
<body>
  <s:bean name="Bean.editNote" var="content"></s:bean>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand-lg" href="<%=request.getContextPath()%>/index.jsp">驴吧</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
        <li><a href="<%=request.getContextPath()%>/Schemes/NewScheme.jsp">寻找旅伴</a></li>
        <li><a href="#">个人中心</a></li>
        <li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">旅游小组<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/Groups/AllGroups.jsp">所有小组</a></li>
            <li><a href="<%=request.getContextPath()%>/Groups/NewGroup.jsp">创建小组</a></li>
            <li><a href="<%=request.getContextPath()%>/Groups/MyGroups.jsp">我的小组</a></li>
          </ul></li>
        <li class="dropdown active"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> 出行攻略 <b class="caret"></b>
        </a>
          <ul class="dropdown-menu">
            <li><a href="allTravelNotes">查看所有攻略</a></li>
            <li><a href="<%=request.getContextPath()%>/travelNotes/editTravelNotes.jsp">写攻略</a></li>
          </ul></li>
        <li><a href="#">通知</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <%
            ActionContext ac = ActionContext.getContext();
        			Map<String, Object> session1 = ac.getSession();
        			if (session1.containsKey("username")) {
        %>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <s:property value="#session.username" /> <b class="caret"></b>
        </a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/PersonalSpace/PerfectInformation.jsp">个人中心</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="Logout.action">退出</a></li>
          </ul></li>
        <%
            } else {
        %>
        <li><a data-toggle="modal" data-target="#login" href=""> <span class="glyphicon glyphicon-log-in"></span> 登录
        </a></li>
        <li><a href="<%=request.getContextPath()%>/Other/Register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
        <%
            }
        %>
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
            <a href="<%=request.getContextPath()%>/Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">编辑旅游攻略</h1>
    </div>

    <s:if test="%{#content.loggedin==false}">
      <div style="font-size: 110%">
        <p>您尚未登录</p>
        <ul>
          <li><a data-toggle="modal" data-target="#login" href=""> 登录</a></li>
          <li><a href="<%=request.getContextPath()%>/Other/Register.jsp">还没有账号？点击此处注册</a></li>
          <li><a href="<%=request.getContextPath()%>/index.jsp">再看看</a></li>
        </ul>
      </div>
    </s:if>
    <s:else>

      <form class="form-horizontal" role="form" method="post" action="saveNote">
        <div class="form-group">
          <label for="noteTitle" class="col-sm-1 control-label">标题</label>
          <div class="col-sm-3">
            <input type="text" class="form-control" name="noteTitle" required />
          </div>
        </div>
        <input type="hidden" name="ownerName" value='<s:property value="#session.username"/>'>
        <script id="travelNote" type="text/plain" style="width:800px;height:240px;"></script>
        &nbsp;
        <div class="row">
          <div class="col-sm-1">
            <button type="submit" class="btn btn-block">上传</button>
          </div>
        </div>

      </form>
    </s:else>
  </div>




  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/utf8-jsp/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/utf8-jsp/ueditor.all.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script type="text/javascript">
			var ue = UE.getEditor('travelNote',
					{
						toolbars : [ [ 'undo', 'redo', 'insertunorderedlist',
								'insertorderedlist', 'cleardoc', '|',
								'emotion', 'simpleupload', 'snapscreen', 'map',
								'insertvideo', 'horizontal', '|', 'indent',
								'italic', 'underline', 'strikethrough',
								'fontfamily', 'fontsize', 'forecolor', ] ]
					});
		</script>
</body>
</html>
