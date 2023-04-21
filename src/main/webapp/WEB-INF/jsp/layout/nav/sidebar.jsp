<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar sidebar-style-2">
	<div class="sidebar-background"></div>
	<div class="sidebar-wrapper scrollbar scrollbar-inner">
		<div class="sidebar-content">
			<ul class="nav nav-info">
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/ecode">
						<i class="fas fa-keyboard"></i>
						<p data-lang="menu_error">[menu_error]</p>
					</a>
				</li>				
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/allList">
						<i class="fas fa-list-ol"></i>
						<p data-lang="menu_all_list">[menu_all_list]</p>
					</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/video">
						<i class="fab fa-youtube"></i>
						<p data-lang="menu_video">[menu_video]</p>
					</a>
				</li>
				<li class="nav-item">
					<a data-toggle="collapse" href="#sidebarLayouts">
						<i class="fas fa-language"></i>
						<p data-lang="menu_locale">[menu_locale]</p>
						<span class="caret"></span>
					</a>
					<div class="collapse" id="sidebarLayouts">
						<ul class="nav nav-collapse">
							<li>
								<a href="#" onclick="changeLang('ko')">
									<span class="sub-item" data-lang="ko">[ko]</span>
								</a>
							</li>
							<li>
								<a href="#" onclick="changeLang('en')">
									<span class="sub-item" data-lang="en">[en]</span>
								</a>
							</li>
<!-- 							<li> -->
<!-- 								<a href="#" onclick="changeLang('cn')"> -->
<!-- 									<span class="sub-item" data-lang="cn">[cn]</span> -->
<!-- 								</a> -->
<!-- 							</li> -->
						</ul>
					</div>					
				</li>
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="#" onclick="homeDown();"> -->
<!-- 						<i class="fas fa-download"></i> -->
<!-- 						<p data-lang="add_home_icon">[add_home_icon]</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/googleMail"> --%>
<!-- 						<i class="fas fa-envelope"></i> -->
<!-- 						<p>Gmail SMTP</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/kakaoMsg"> --%>
<!-- 						<i class="far fa-comment"></i> -->
<!-- 						<p>카카오 메세지 API</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/menu002"> --%>
<!-- 						<i class="fas fa-th-list"></i> -->
<!-- 						<p>전체목록</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="javascript:alert('링크예정');"> -->
<!-- 						<i class="fas fa-video"></i> -->
<!-- 						<p>보수 동영상</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/rmodel"> --%>
<!-- 						<i class="fab fa-android"></i> -->
<!-- 						<p>로봇모델 자동완성</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/guide"> --%>
<!-- 						<i class="fas fa-code-branch"></i> -->
<!-- 						<p>조치 가이드</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/feedback"> --%>
<!-- 						<i class="far fa-thumbs-up"></i> -->
<!-- 						<p>평가 피드백</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<%-- 					<a href="${pageContext.request.contextPath}/version"> --%>
<!-- 						<i class="fas fa-desktop"></i> -->
<!-- 						<p>버전정보</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="#" onclick="changeLangToggle()"> -->
<!-- 						<i class="fas fa-language"></i> -->
<!-- 						<p> -->
<!-- 						<span data-lang="menu_locale">[menu_locale]&nbsp;&nbsp;&nbsp;</span> -->
<!-- 						<input checked id="toggle-lang" type="checkbox" data-toggle="toggle" data-on="KOR" data-off="ENG" data-size="xs" data-onstyle="hrms" data-offstyle="hrms"> -->
<!-- 						</p> -->
<!-- 					</a>					 -->
<!-- 				</li>	 -->
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="/swagger-ui.html" target="_blank"> -->
<!-- 						<i class="fas fa-code"></i> -->
<!-- 						<p>Swagger</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="/user"> -->
<!-- 						<i class="fas fa-user-friends"></i> -->
<!-- 						<p>사용자목록</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
			</ul>
		</div>
	</div>
</div>