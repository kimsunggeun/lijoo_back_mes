<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>	
	<title>H!-Maintenance</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="icon" href="${pageContext.request.contextPath}/img/icon.ico" type="image/x-icon"/>
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/img/hrms-logo.png" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/hrms-logo.png" />
	<script src="${pageContext.request.contextPath}/js/plugin/webfont/webfont.min.js"></script>	
	<script>
		function getContextPath(){
			var hostIndex = location.href.indexOf( location.host ) + location.host.length;
			return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
		};
		var path = getContextPath();
		var baseUrl = path + '/css/fonts.min.css';
		WebFont.load({
			google: {"families":["Lato:300,400,700,900"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: [baseUrl]},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/igns.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-toggle.min.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/prism/prism.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tagsinput.css?ver=1.0.3"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home-add.css?ver=1.0.3"/>
	<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js?ver=1.0.3"></script>	
</head>
<body>
	<div class="wrapper">
		<div id="loading">
			<div id="loadingImg" class="loader loader-lg"></div>
		</div>
<%@ include file="../layout/nav/mainHeader.jsp" %>
<%@ include file="../layout/nav/sidebar.jsp" %>