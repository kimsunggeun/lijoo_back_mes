<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
	<li class="nav-item dropdown hidden-caret">
		<a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#" aria-expanded="false">
			<div class="avatar-sm">
				<img src="${pageContext.request.contextPath}/img/user.png" alt="..." class="avatar-img rounded-circle">
			</div>
		</a>
		<ul class="dropdown-menu dropdown-user animated fadeIn">
			<div class="dropdown-user-scroll scrollbar-outer">
				<li>
					<div class="user-box">
						<div class="avatar-lg"><img src="${pageContext.request.contextPath}/img/user.png" alt="image profile" class="avatar-img rounded"></div>
						<div class="u-text">
							<h4>admin</h4>
							<p class="text-muted">admin@i-gns.co.kr</p><a href="#" class="btn btn-xs btn-hrms btn-sm" data-lang="my_page">[my_page]</a>
						</div>
					</div>
				</li>
				<li class="drop-list">
<!-- 					<div class="dropdown-divider"></div> -->
<!-- 					<a class="dropdown-item" href="#" data-lang="my_page">[my_page]</a> -->
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/signout" data-lang="my_logout">[my_logout]</a>
				</li>
			</div>
		</ul>
	</li>
</ul>