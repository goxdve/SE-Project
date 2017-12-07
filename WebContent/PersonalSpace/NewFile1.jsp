<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<script src="<%=request.getContextPath() %>/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/navigation.css" />
</head>
<body>
<div class="row">
<div class="col-md-2 side-nav">
  <div class="panel-group" id="accordion">
    <div class="panel-heading panel">
      <a href="" class="side-nav-item item-title">
      	首页
      </a>
      <div class="item-body collapse">
      </div>
    </div>

    <div class="panel-heading panel">
      <a data-toggle="collapse" data-parent="#accordion" href="#item-cangku" id="headcangku" class="side-nav-item item-title">
      仓库管理
      </a>
      <div id="item-cangku" class="panel-collapse collapse in">
        <div class="item-body">
          <ul class="list-unstyled">
            <li class="item-second"><a href="">产品库存</a></li>
            <li class="item-second"><a href="">原料库存</a></li>
          </ul>
        </div>
      </div>
    </div>

    <div class="panel-heading panel">
      <a data-toggle="collapse" data-parent="#accordion" href="#item-caiwu" id="headcaiwu" class="side-nav-item item-title collapsed">
      财务管理
      </a>
      <div id="item-caiwu" class="panel-collapse collapse">
        <div class="item-body">
          222
        </div>
      </div>
    </div>
    
    <div class="panel-heading panel">
      <a data-toggle="collapse" data-parent="#accordion" href="#item-renshi" id="headrenshi" class="side-nav-item item-title collapsed">
      人事管理
      </a>
      <div id="item-renshi" class="panel-collapse collapse">
        <div class="item-body">
          333
        </div>
      </div>
    </div>
  </div>
</div>
<div class="col-md-10" >
	
</div>
</div>
</body>
</html>