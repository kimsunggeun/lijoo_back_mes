<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/tag.jsp" %>
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/igns.css?ver=1.0.1">
	<link href="${pageContext.request.contextPath}/css/styles.css?ver=1.0.1" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/login.css?ver=1.0.1" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<div class="container h-100">
			<div class="row h-100 justify-content-center align-items-center">
		  		<div class="login-box w-100">
		  			<div class="pt-4 pb-3">
		  				<div class="col-12 pb-4 text-center">
			  				<div>
			  					<img src="${pageContext.request.contextPath}/img/login-logo-green.png" alt="logo image" class="login-logo">
			  				</div>				
			  			</div>
			  			<form class="col-12 pb-3" id="loginForm" name="loginForm">
			  				<div class="row">
			  					<div class="col-md-9">
			  						<div class="form-group">
										<div class="input-icon">
											<span class="input-icon-addon">
												<i class="fa fa-user"></i>
											</span>
											<input type="text" class="form-control" id="userEmail" placeholder="id" required="required">
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<span class="input-icon-addon">
												<i class="fa fa-key"></i>
											</span>
											<input type="password" class="form-control" id="userPw" placeholder="password" required="required">
										</div>
									</div>
			  					</div>
			  					<div class="col-md-3">
			  						<div style="" class="form-group w-100 h-100">
			  							<button class="btn btn-hrms w-100 h-100 login-btn" id="login-button"><span data-lang="login">[login]</span></button>
			  						</div>  						
			  					</div>
			  				</div> 				
						</form>
		  			</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/core/jquery.3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/js/core/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/core/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugin/sweetalert/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/js/igns.js"></script>
<script src="${pageContext.request.contextPath}/js/components/login.js"></script>
<script src="${pageContext.request.contextPath}/js/components/i18n.js"></script>
<script type="text/javascript">	
	// handle links with @href started with '#' only
	$(document).on('click', 'a[href^="#"]', function(e) {
		// target element id
		var id = $(this).attr('href');

		// target element
		var $id = $(id);
		if ($id.length === 0) {
			return;
		}

		// prevent standard hash navigation (avoid blinking in IE)
		e.preventDefault();

		// top position relative to the document
		var pos = $id.offset().top - 80;

		// animated top scrolling
		$('body, html').animate({scrollTop: pos});
	});
</script>
</html>