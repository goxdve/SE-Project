<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示路线</title>
<script src="http://api.map.baidu.com/api?v=1.2"></script>
</head>
<body>
<div id="container" style="width:400px;height:248px"></div>
<div id="panel" style="position:absolute;left:420px;top:10px"></div>
<%-- <input type="hidden" value="<s:property value="start"/>" id="s"/> --%>
<%-- <input type="hidden" value="<s:property value="end"/>" id="e"/> --%>
<!-- <input type="hidden" value=<s:property value="mean"/> id="m"/> -->
<s:hidden name="start" id="s"/>
<s:hidden name="end" id="e"/>
<s:hidden name="mean" id="m"/>

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" language="javascript">
var map =new BMap.Map("container");
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
var start=$("#s").val();
var end=$("#e").val();
var mean=$("#m").val();
var driving;
if(mean=='0')
{
		driving =new BMap.DrivingRoute(map, {
	    renderOptions: {
	        map: map,
	        panel: "panel"
	    }
	});
	driving.search(start, end);
}
else if(mean=='1')
{
		driving =new BMap.TransitRoute(map, {
	    renderOptions: {
	        map: map,
	        panel: "panel"
	    }
	});
	driving.search(start, end);
}
else
{
		driving =new BMap.WalkingRoute(map, {
	    renderOptions: {
	        map: map,
	        panel: "panel"
	    }
	});
	driving.search(start, end);
}
	
</script>
</body>
</html>
