<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>조치 가이드</h4>
					<p class="mb-0 op-7">입력 검색 조건에 따라 조치 가이드 결과 제공.</p>
				</div>
				<div class="card-body">
					<div class="row justify-content-center align-items-center">
						<div class="col-md-6 mb-3">
							<div class="selectgroup w-100">
								<label class="selectgroup-item">
									<input type="radio" name="gCmodel" value="Hi4" class="selectgroup-input" style="height: 42px;">
									<span class="selectgroup-button" style="height: 42px;">Hi4</span>
								</label>
								<label class="selectgroup-item">
									<input type="radio" name="gCmodel" value="Hi5" class="selectgroup-input" style="height: 42px;">
									<span class="selectgroup-button" style="height: 42px;">Hi5</span>
								</label>
								<label class="selectgroup-item">
									<input type="radio" name="gCmodel" value="Hi5a" class="selectgroup-input" style="height: 42px;">
									<span class="selectgroup-button" style="height: 42px;">Hi5a</span>
								</label>
							</div>
						</div>
						<div class="col-md-6 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">E</span>
								</div>
								<input type="text" class="form-control" placeholder="에러번호" aria-label="gEcode" aria-describedby="basic-addon1" id="gEcode">
							</div>
						</div>
					</div>
					<div class="row justify-content-center align-items-center">
						<div class="col-md-4 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">R</span>
								</div>
								<input type="text" class="form-control" placeholder="로봇모델" aria-label="gRmodel" aria-describedby="basic-addon1" id="gRmodel">
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<select class="form-control" id="axis">
								<option>1축</option>
								<option>2축</option>
								<option>3축</option>
								<option>4축</option>
								<option>5축</option>
							</select>
						</div>
						<div class="col-md-2 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">S</span>
								</div>
								<input type="text" class="form-control" placeholder="고장증상 1" aria-label="sym1" aria-describedby="basic-addon1" id="sym1">
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">S</span>
								</div>
								<input type="text" class="form-control" placeholder="고장증상 2" aria-label="sym2" aria-describedby="basic-addon1" id="sym2">
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="guideBtn">
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
<!-- 									&lt;!-- URL --&gt; 		10.100.79.62/api/search/guide -->
<!-- 									&lt;!-- 메소드 --&gt; 		GET -->
<!-- 									&lt;!-- HTTP 헤더 --&gt;  Content-Type: application/json -->
									
<!-- 									&lt;!-- 파라미터 --&gt; -->
<!-- 										- cmodel [필수] : 제어기 모델명 (예. Hi4, Hi5, Hi5a) -->
<!-- 										- ecode  [필수] : 에러 코드 (예. E0117) -->
<!-- 										- rmodel [선택] : 로봇 모델 (예. HS200) -->
<!-- 										- axis	 [선택] : 에러발생 축 (예. 4축) -->
<!-- 										- sym1	 [선택] : 고장증상 레벨 1 카테고리 이름 (예. 로봇정지) -->
<!-- 										- sym2	 [선택] : 고장증상 레벨 2 카테고리 이름 2 (예. 부팅 불능) -->
									
<!-- 									&lt;!-- 응답 --&gt; -->
<!-- 									&lt;script&gt; -->
<!-- 										{ -->
<!-- 											"fdbk_id": 297, -->
<!-- 											"svc_history_lst" : [ -->
<!-- 												{ -->
<!-- 													"action": "수정", -->
<!-- 													"causes": "조립불량", -->
<!-- 													"part": "기타 배선", -->
<!-- 													"pct": 50.0 -->
<!-- 												}, -->
<!-- 												{ -->
<!-- 													"action": "체결확인", -->
<!-- 													"causes": "조립불량", -->
<!-- 													"part": "기타 배선", -->
<!-- 													"pct": 50.0 -->
<!-- 												} -->
<!-- 											], -->
<!-- 											"svc_manual_lst": [ -->
<!-- 												{ -->
<!-- 													"part": "고장부위명", -->
<!-- 													"action": "조치방법", -->
<!-- 													"doc_type": "문서타입", -->
<!-- 													"cause": "원인", -->
<!-- 													"ecode": "에러코드", -->
<!-- 													"msg": "에러메시지", -->
<!-- 													"desc1": "원인", -->
<!-- 													"desc2": "조치", -->
<!-- 													"title": "타이틀", -->
<!-- 													"section_text": "원인 및 점검방법" -->
<!-- 												}								 -->
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
<script type="module" src="${pageContext.request.contextPath}/js/components/guide.js"></script>
<%@ include file="../layout/footer.jsp" %>