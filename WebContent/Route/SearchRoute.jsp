<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索路线</title>
</head>
<body>
<s:form action="GetRoute" method="post" enctype="multipart/form-data">
<s:textfield name="start" label="起点"></s:textfield>
<s:textfield name="end" label="终点"></s:textfield>
<s:radio name="mean" label="方式" list="%{#{'0':'驾车','1':'公交','2':'步行'}}"></s:radio>
<s:submit value="展示路线"></s:submit>
</s:form>
</body>
</html>
