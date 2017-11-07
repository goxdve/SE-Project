<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PersonalSchemes</title>
</head>
<body>
<s:action name="PersonalSchemes"></s:action>
<s:iterator value="personalSchemes">
	<s:property value="id"/>
	,<s:property value="Username"/>
	,<s:property value="date"/>
	,<s:property value="price"/>
	,<s:property value="location"/>
	,<s:property value="duration"/>
	,<s:property value="content"/>
</s:iterator>
</body>
</html>



<!--
private Date id;//发帖日期
	    private String Username;//发帖用户名
	    private Date date;//旅游开始时间
	    private int price;//驴友消费
	    private String location;//旅游地点（大致地点）
	    private int duration;//旅行总时间（暂且认为是天数）
	    private String content;//详情 
 -->