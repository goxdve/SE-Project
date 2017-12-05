<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/time/bootstrap-datetimepicker.min.css" />
  <title>驴吧</title>
</head>

<body>

  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand brand-lg" href="../index.jsp">驴吧</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li>
            <a href="../index.jsp">首页</a>
          </li>
          <li>
            <a href="../Schemes/NewScheme.jsp">寻找旅伴</a>
          </li>
          <li>
            <a href="#">个人中心</a>
          </li>
          <li class="dropdown active">
            <a href="" class="dropdown-toggle" data-toggle="dropdown">旅游小组
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="./AllGroups.jsp">所有小组</a>
              </li>
              <li>
                <a href="./NewGroup.jsp">创建小组</a>
              </li>
              <li>
                <a href="./MyGroups.jsp">我的小组</a>
              </li>
            </ul>
          </li>
          <li>
            <a href="#">出行攻略</a>
          </li>
          <li>
            <a href="#">通知</a>
          </li>
          <li class="dropdown active"><a href="" class="dropdown-toggle" data-toggle="dropdown">私信<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="<%=request.getContextPath()%>/Privateletter/ReceivedPrivateletter.jsp">收信箱</a></li>
              <li><a href="<%=request.getContextPath()%>/Privateletter/SendedPrivateletter.jsp">已发送</a></li>
              <li><a href="<%=request.getContextPath()%>/Privateletter/SendPrivateletter.jsp">发私信</a></li>
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <%
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> session1 = ac.getSession();
            if (session1.containsKey("username")) {
        %>
            <li class="dropdown">
              <a href="" class="dropdown-toggle" data-toggle="dropdown">
                <s:property value="#session.username" />
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="#">个人中心</a>
                </li>
                <li>
                  <a href="#">消息</a>
                </li>
                <li>
                  <a href="#">退出</a>
                </li>
              </ul>
            </li>
            <%
            } else {
        %>
              <li>
                <a data-toggle="modal" data-target="#login" href="">
                  <span class="glyphicon glyphicon-log-in"></span> 登录
                </a>
              </li>
              <li>
                <a href="../Other/Register.jsp">
                  <span class="glyphicon glyphicon-user"></span> 注册</a>
              </li>
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
              <label for="username">用户名</label>
              <input class="form-control" type="text" name="username" required>
            </div>
            <div class="form-group">
              <label for="password">密码</label>
              <input class="form-control" type="password" name="password" required>
            </div>
            <div class="text-right">
              <button class="btn btn-primary" type="submit">登录</button>
              <button class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
            <a href="../Other/Register.jsp">还没有账号？点我注册</a>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div style="padding: 5px" class="page-header">
      <h1 style="font-size: 2em">所有小组</h1>
    </div>
    <div class="row"></div>
    <s:bean name="Bean.Groups" var="content"></s:bean>
    <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr><th>组名</th><th>目的地</th><th>出发日期</th><th>人数/人数上限</th><th>组长</th><th>操作</th></tr>
      </thead>
      <tbody>
      <s:iterator value="%{#content.groups}" var="var">
        <tr>
        <td><s:property value="#var.groupname" /></td>
        <td><s:property value="#var.destination" /></td>
        <td><s:property value="#var.begindate" /></td>
        <td><s:property value="#var.membercount" />/<s:property value="#var.maxmembercount" /></td>
        <td><s:property value="#var.manager" /></td>
        <td>
          <form action="JoinGroup">
            <input type="hidden" value="%{var.groupid}" name="joingroupid" />
            <button type="submit" class="btn btn-primary">申请加入</button>
          </form>
        </td>
        </tr>
      </s:iterator>
      </tbody>
    </table>
    <form action="SkipGroupPage">
      <input class="input" type="number" min="1" step="1" max="1000" name="topage" pattern="^[0-9]*[1-9][0-9]*$"/>
      <button type="submit" class="btn btn-default">跳转</button>
    </form>

  </div>

  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/time/bootstrap-datetimepicker.js"></script>
  <script src="../js/time/moment-with-locales.js"></script>
  <script src="../js/time/bootstrap-datetimepicker.zh-CN.js"></script>
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
</body>

</html>
