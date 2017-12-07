<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<title>展示路线</title>
<script src="http://api.map.baidu.com/api?v=1.3"></script>
</head>
<body>
    <div class="container">
    	<div class="row">
			<div class="form-group">
			  <div class="col-lg-2">
           		<button onclick="getLocation()">查询自己的位置</button>
         	  </div>
         	  <label for="p" class="col-lg-1 control-label">自身位置</label>
	          <div class="col-lg-3">
	            <input id="demo" type="text" class="form-control" name="p">
	          </div>
			</div>
		</div>
		<br/>
		<div class="row">
			<div class="form-group">
				<label for="k1" class="col-lg-1 control-label">要查询的地址</label>
	            <div class="col-lg-3">
	              <input id="text_" type="text" class="form-control" name="k1" placeholder="请输入地址" required>
	            </div>
	            <label for="k2" class="col-lg-1 control-label">查询结果(经纬度)</label>
	            <div class="col-lg-3">
	              <input id="result_" type="text" class="form-control" name="k2">
	            </div>
	            <div class="col-lg-2">
           			<button onclick="searchByStationName()">查询</button>
         	    </div>
			</div>
		</div>
		<div class="row">
			<div id="container" style="
                margin-top:30px; 
                width: 730px; 
                height: 590px; 
                border: 1px solid gray;
                overflow:hidden;">
			</div>
		</div>
		<br/>
		<div class="row">
	        <div class="form-group">
	          <label for="s" class="col-lg-1 control-label">起点</label>
	          <div class="col-lg-3">
	            <input id="s" type="text" class="form-control" name="s" placeholder="请输入起点经纬度，如xxx.xxx,xxx.xxx" required>
	          </div>
	          <label for="e" class="col-lg-1 control-label">终点</label>
	          <div class="col-lg-3">
	            <input id="e" type="text" class="form-control" name="e" placeholder="请输入终点经纬度，如xxx.xxx,xxx.xxx" required>
	          </div>
	          <label for="m" class="col-lg-1 control-label">方式</label>
	          <div class="col-lg-2">
	            <select id="m" class="fomr-control" name="m" style="height: 30px;" required>
	              <option value=1>驾车</option>
	              <option value=2>公交</option>
	              <option value=3>步行</option>
	            </select>
	          </div>
	          <div class="col-lg-1">
           		<button onclick="ShowRoute()">查询</button>
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
</body>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/time/moment-with-locales.js"></script>
<script src="<%=request.getContextPath()%>/js/time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    var map = new BMap.Map("container");
    map.centerAndZoom("北京", 12);
    map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
    map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

    map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
    map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
    map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开

    var localSearch = new BMap.LocalSearch(map);
    localSearch.enableAutoViewport(); //允许自动调节窗体大小
function searchByStationName() {
    map.clearOverlays();//清空原来的标注
    var keyword = document.getElementById("text_").value;
    localSearch.setSearchCompleteCallback(function (searchResult) {
        var poi = searchResult.getPoi(0);
        document.getElementById("result_").value = poi.point.lng + "," + poi.point.lat;
        map.centerAndZoom(poi.point, 13);
        var marker = new BMap.Marker(new BMap.Point(poi.point.lng, poi.point.lat));  // 创建标注，为要查询的地方对应的经纬度
        map.addOverlay(marker);
        var content = document.getElementById("text_").value + "<br/><br/>经度：" + poi.point.lng + "<br/>纬度：" + poi.point.lat;
        var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
        marker.addEventListener("click", function () { this.openInfoWindow(infoWindow); });
        // marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    });
    localSearch.search(keyword);
}
</script>
<script>
var map2 =new BMap.Map("container2");
map2.centerAndZoom("北京", 12);
function ShowRoute()
{
	var start=$("#s").val();
	var end=$("#e").val();
	start=start.split(",");
	end=end.split(",");
	var start_x=parseFloat(start[0]);
	var start_y=parseFloat(start[1]);
	var end_x=parseFloat(end[0]);
	var end_y=parseFloat(end[1]);
	var mean=$("#m").val();
	var driving;
	if(mean=="1")
	{
			driving =new BMap.DrivingRoute(map, {
		    renderOptions: {
		        map: map2,
		        panel: "panel"
		    }
		});
		driving.search(new BMap.Point(start_x,start_y), new BMap.Point(end_x,end_y));
	}
	else if(mean=="2")
	{
			driving =new BMap.TransitRoute(map, {
		    renderOptions: {
		        map: map2,
		        panel: "panel"
		    }
		});
		driving.search(new BMap.Point(start_x,start_y), new BMap.Point(end_x,end_y));
	}
	else if(mean=="3")
	{
			driving =new BMap.WalkingRoute(map, {
		    renderOptions: {
		        map: map2,
		        panel: "panel"
		    }
		});
		driving.search(new BMap.Point(start_x,start_y), new BMap.Point(end_x,end_y));
	}
}
</script>
<script>
function getLocation()
  {
  if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
  else{document.getElementById("demo").value="Geolocation is not supported by this browser.";}
  }
function showPosition(position)
  {
	document.getElementById("demo").value = position.coords.longitude +"," + position.coords.latitude;
  }
function showError(error)
  {
  switch(error.code) 
    {
    case error.PERMISSION_DENIED:
    	document.getElementById("demo").value="User denied the request for Geolocation."
      break;
    case error.POSITION_UNAVAILABLE:
    	document.getElementById("demo").value="Location information is unavailable."
      break;
    case error.TIMEOUT:
    	document.getElementById("demo").value="The request to get user location timed out."
      break;
    case error.UNKNOWN_ERROR:
    	document.getElementById("demo").value="An unknown error occurred."
      break;
    }
  }

</script>
</html>
