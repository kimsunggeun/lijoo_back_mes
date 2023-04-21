<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="main-header">
	<!-- [사이드바] 우측 경우 nav를 먼저 작성 -->	
	<div class="logo-header" data-background-color="hrms">
		<a href="#" class="logo">
			<img src="${pageContext.request.contextPath}/img/header-logo.png" alt="navbar brand" class="navbar-brand">
		</a>
		<button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon">
				<i class="icon-menu"></i>
			</span>
		</button>
		<button class="topbar-toggler more"><i class="icon-options-vertical"></i></button>
		<div class="nav-toggle">
			<button class="btn btn-toggle toggle-sidebar">
				<i class="icon-menu"></i>
			</button>
		</div>
	</div>
	<nav class="navbar navbar-header navbar-expand-lg" data-background-color="hrms">
		<%@ include file="../nav/profile.jsp" %>
	</nav>
</div>