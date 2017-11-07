<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PerfectInformation</title>
</head>
<body>
<s:action name="PersonalInformation"></s:action>
<s:form action="PerfectInformation">
<s:textfield value="formerrightname" name="rightname" label="真实姓名"></s:textfield>
<s:radio value="former" name="sex" label="性别" list="{'男','女'}"></s:radio>
<s:textfield value="formerage" name="age" label="年龄"></s:textfield>
<s:textfield value="formertelephone" name="telephone" label="电话号码"></s:textfield>
<s:submit value="修改个人信息"></s:submit>
</s:form>
</body>
</html>
