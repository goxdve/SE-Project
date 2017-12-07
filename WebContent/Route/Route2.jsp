<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<title>展示路线</title>
<script src="http://api.map.baidu.com/api?v=1.3"></script>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
<div class="container">
	<br/>
	<div class="row">
        <div class="form-group">
          <label for="s" class="col-lg-1 control-label">起点</label>
          <div class="col-lg-3">
            <input id="s" type="text" class="form-control" name="s" placeholder="请输入起点地点" required>
          </div>
          <label for="e" class="col-lg-1 control-label">终点</label>
          <div class="col-lg-3">
            <input id="e" type="text" class="form-control" name="e" placeholder="请输入终点地点" required>
          </div>
          <label for="m" class="col-lg-1 control-label">方式</label>
          <div class="col-lg-2">
            <select id="m" class="fomr-control" name="m" style="height: 30px;" required>
              <option value=0>驾车</option>
              <option value=1>公交</option>
              <option value=2>步行</option>
            </select>
          </div>
          <div class="col-lg-1">
          		<button onclick="ShowRoute2()">查询</button>
          </div>
        </div>
	</div>
	<br/>
	<div class="row">
		<div id="container2" style="width:400px;height:300px"></div>
	</div>
	<div class="row">
		<div id="panel"></div>
	</div>
</div>
<script type="text/javascript" language="javascript">
var map =new BMap.Map("container2");
map.centerAndZoom("北京", 12);
function ShowRoute2()
{
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
	else if(mean=='2')
	{
			driving =new BMap.WalkingRoute(map, {
		    renderOptions: {
		        map: map,
		        panel: "panel"
		    }
		});
		driving.search(start, end);
	}
}
</script>
</body>
</html>
