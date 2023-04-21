<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>로봇모델 자동완성</h4>
<!-- 					<p class="mb-0 op-7">입력 텍스트로 시작하는 로봇 모델 리스트 정보를 자동완성 기능으로 제공.</p> -->
				</div>
				<div class="card-body">
					<div class="row justify-content-center align-items-center">
						<div class="col-md-10 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">E</span>
								</div>
								<input type="text" class="form-control" placeholder="입력" aria-label="rRmodel" aria-describedby="basic-addon1" id="rRmodel">
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="rmodelBtn">
								<span class="btn-label">
									<i class="fa fa-search"></i>
								</span>
								확인
							</button>
						</div>
					</div>
<!-- 					<div class="row"> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<pre id="json" class="language-markup"> -->
<!-- 								<code class="language-markup"> -->
<!-- 									&lt;!-- URL --&gt; 		10.100.79.62/api/autocomplete/rmodel -->
<!-- 									&lt;!-- 메소드 --&gt; 		GET -->
<!-- 									&lt;!-- HTTP 헤더 --&gt;  Content-Type: application/json -->
									
<!-- 									&lt;!-- 파라미터 --&gt; -->
<!-- 										- q 	 [필수] : 사용자 입력 -->
										
<!-- 									&lt;!-- 응답 --&gt;		 -->
<!-- 									&lt;script&gt; -->
<!-- 										{ -->
<!-- 											"rmodel_list" : [ -->
<!-- 												{ -->
<!-- 													"created_at": "Sat, 04 Apr 2020 17:10:03 GMT", -->
<!-- 													"desc": null, -->
<!-- 													"robot_model": "HA006", -->
<!-- 													"robot_type": 1 -->
<!-- 												}, -->
<!-- 												{ -->
<!-- 													"created_at": "Sat, 04 Apr 2020 17:10:03 GMT", -->
<!-- 													"desc": null, -->
<!-- 													"robot_model": "HA006", -->
<!-- 													"robot_type": 1 -->
<!-- 												} -->
<!-- 											] -->
<!-- 										} -->
<!-- 									&lt;/script&gt; -->
<!-- 								</code> -->
<!-- 							</pre> -->
<!-- 						</div> -->
<!-- 					</div>	 -->
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/components/rmodel.js"></script>
<%@ include file="../layout/footer.jsp" %>