<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/26
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<s:form action="Login">
  <s:textfield value="" name="username" label="用户名"></s:textfield>
  <s:textfield value="" name="password" label="密码"></s:textfield>
    <s:submit value="登陆"></s:submit>
</s:form>
<s:form action="GotoRegister">
    <s:submit value="注册"></s:submit>
</s:form>
</body>
</html>
