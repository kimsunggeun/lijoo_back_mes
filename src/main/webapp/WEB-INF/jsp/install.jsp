<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/tag.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>H!-Maintenance</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="icon" href="${pageContext.request.contextPath}/img/install/icon.ico" type="image/x-icon"/>
		<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/img/install/icon.ico" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/install/icon.ico" />
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
		<script>
		function fnGoLogin(){
			window.location.href="/";
		}
		</script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/install/mobile_install.css">
	</head>
<body>
	<div id="wrap">            
            <div id="contents">
            	<div class="pad-r-l-15">
	                <div class="hrms_title">
	                    <img class="hrms_logo" alt="HRMS PRO 2.0" src="${pageContext.request.contextPath}/img/login-logo.png">
	                </div>
                </div>
                <div class="hrms_form" >
                    <form name="login_form" class="login_form" method="POST" action="javascript:fnGoLogin();">
						<input type="hidden" name="x-thingworx-session" value="true">
						<input type="hidden" name="OrganizationName" value="Everyone">
						<input type="hidden" name="x-thingworx-session" value="true">
                        <div class="table ma-0 w-100" >
                            <div class="table_cell i_padding" >							
								<div class="widget-content install-main">
									<div>										
										<div class="install-main-title">
											<div class="install-main-title-text" >
												<script>
													var userAgent = navigator.userAgent.toLowerCase(); // 접속 핸드폰 정보 
													if(userAgent.match('iphone') || userAgent.match('ipad') || userAgent.match('ipod')) { 
														//alert('iphone');
														document.write('IOS 바로가기 추가 안내');
													} else if(userAgent.match('android')) { 
														//alert('android');
														document.write('안드로이드 바로가기 추가 안내');
													} else {
														document.write('모바일 바로가기 추가 안내');
													}
												</script>
											</div>
										</div>										
										<div class="pad-r-l-15">										
										<div>
											<div class="install-main-indicator-content">
												<div class="install-main-indicator-content-title-01">
													<span>브라우저 즐겨찾기 안내</span>
												</div>
												<div class="install-main-indicator-content-value-01">
													<div class="pad-content">														
														<div id="ios">
															<div class="warning-msg">
																<span>- 기본 브라우저인 'Safari' 기준으로 설명합니다.</span>
															</div>
															<div class="card">
																1) 하단 중앙의 공유하기 버튼을 터치합니다.
																<img src="${pageContext.request.contextPath}/img/install/ios_step_1.png" alt="step1"/>
															</div>
															<div class="card">
																2) 공유하기 메뉴에서 <b>'홈 화면에 추가'</b> 옵션을 선택합니다.
																<img src="${pageContext.request.contextPath}/img/install/ios_step_2.png" alt="step2"/>
															</div>
															<div class="card">
																3) 이름과 홈페이지  주소를 입력할 수 있습니다. 수정 후 <b>'추가'</b> 버튼을 터치합니다.
																<img src="${pageContext.request.contextPath}/img/install/ios_step_3.png" alt="step3"/>
															</div>
															<div class="card card-last">
																4) 홈 화면에 바로가기가 추가됩니다.
																<img src="${pageContext.request.contextPath}/img/install/ios_step_4.png" alt="step4"/>
															</div>
														</div>
														<div id="android">
															<div class="warning-msg">
																<span>- '크롬(Chrome)' 기준으로 설명합니다.</span>
															</div>
															<div class="card">
																1) 우측 상단의 세로 점 세개를 터치합니다.
																<img src="${pageContext.request.contextPath}/img/install/and_step_1.png" alt="step1"/>
															</div>
															<div class="card">
																2) 메뉴에서 <b>'홈 화면에 추가'</b> 옵션을 선택합니다.
																<img src="${pageContext.request.contextPath}/img/install/and_step_2.png" alt="step2"/>
															</div>
															<div class="card">
																3) 이름을 입력할 수 있습니다. 수정 후 <b>'추가'</b> 버튼을 터치합니다.
																<img src="${pageContext.request.contextPath}/img/install/and_step_3.png" alt="step3"/>
															</div>
															<div class="card">
																4) <b>'자동으로 추가'</b>를 터치합니다.
																<img src="${pageContext.request.contextPath}/img/install/and_step_4.png" alt="step4"/>
															</div>
															<div class="card  card-last">
																5) 홈 화면에 바로가기가 추가됩니다.
																<img src="${pageContext.request.contextPath}/img/install/and_step_5.png" alt="step5"/>
															</div>															
														</div>
													</div>												
												</div>
											</div>
											<div class="w-100 hrms_backcolor">
												<input class="login_btn" type="submit" name="Login" value="로그인 화면 이동">
											</div>
										</div>
										</div>
									</div>
								</div>
                            </div>
                        </div>                        
                    </form>
                </div>
            </div>
        </div>
	</body>
	<script>
		var userAgent = navigator.userAgent.toLowerCase(); // 접속 핸드폰 정보 
		if(userAgent.match('iphone') || userAgent.match('ipad') || userAgent.match('ipod')) { 
			document.getElementById('ios').classList.remove('dis-grid');
			document.getElementById('android').classList.remove('dis-grid');

			document.getElementById('ios').classList.remove('dis-none');
			document.getElementById('android').classList.add('dis-none');
		} else if(userAgent.match('android')) { 
			document.getElementById('ios').classList.remove('dis-grid');
			document.getElementById('android').classList.remove('dis-grid');
			
			document.getElementById('ios').classList.add('dis-none');
			document.getElementById('android').classList.remove('dis-none');
		} else {
			document.getElementById('ios').classList.add('dis-grid');
			document.getElementById('android').classList.add('dis-grid');
		}
	</script>
</html>