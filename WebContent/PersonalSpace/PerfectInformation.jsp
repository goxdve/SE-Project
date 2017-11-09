<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/11/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PerfectInformation</title>
</head>
<body>
<s:bean name="Bean.PersonalInformation" var="Information">

</s:bean>

<s:form action="PerfectInformation">
    <s:textfield value="%{#Information.password}" name ="newpassword" label="密码"></s:textfield>
    <s:textfield value="%{#Information.age}" name ="newage" label="年龄"></s:textfield>
    <s:radio value="%{#Information.sex}"  name="newsex" label="性别" list="{'男','女'}"></s:radio>
    <s:submit value="修改个人信息"></s:submit>
</s:form>
</body>
</html>
