<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/31
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form>
<s:form action="Register">
    <s:textfield value="" name="username" label="用户名"></s:textfield>
    <s:textfield value="" name="password" label="密码"></s:textfield>
    <s:textfield value="" name="passworaagain" label="重新输入密码"></s:textfield>
    <s:submit value="注册"></s:submit>
</s:form>
</form>
</body>
</html>
