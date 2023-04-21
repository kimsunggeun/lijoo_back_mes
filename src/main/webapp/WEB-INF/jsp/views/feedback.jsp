<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>평가피드백</h4>
					<p class="mb-0 op-7">조치 결과에 대한 평가 피드백 등록.</p>
				</div>
				<div class="card-body">
					<div class="row justify-content-center align-items-center">
						<div class="col-md-10 mb-3">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">전송 데이터</span>
								</div>
								<textarea class="form-control" rows="18" id="fdbkJson">
{
	"fdbk_id": 299,
	"fdbk_lst": [
		{
			"fdbk_type": 1,
			"work_rslt": 1,
			"part": "기타 배선",
			"action": "수정"
		},
		{
			"fdbk_type": 1,
			"work_rslt": -1,
			"part": "기타 배선",
			"action": "체결 확인"									
		}
	]
}</textarea>
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="feedbackBtn">
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
<!-- 									&lt;!-- URL --&gt; 		10.100.79.62/api/search/feedback -->
<!-- 									&lt;!-- 메소드 --&gt; 		POST -->
<!-- 									&lt;!-- HTTP 헤더 --&gt;  Content-Type: application/json -->
									
<!-- 									&lt;!-- 요청(body) --&gt; -->
<!-- 										- fdbk_id  [리스트] : 조치가이드 검색 응답에서 제공된 피드백 아이디 -->
<!-- 										- fdbk_lst [리스트] : 평가 피드백 객체 리스트 -->
										
<!-- 									&lt;!-- 요청예시 --&gt; -->
<!-- 									&lt;script&gt; -->
<!-- 										{ -->
<!-- 											"fdbk_id": 299, -->
<!-- 											"fdbk_lst": [ -->
<!-- 												{ -->
<!-- 													"fdbk_type": 1, -->
<!-- 													"work_rslt": 1, -->
<!-- 													"part": "기타 배선", -->
<!-- 													"action": "수정" -->
<!-- 												}, -->
<!-- 												{ -->
<!-- 													"fdbk_type": 1, -->
<!-- 													"work_rslt": -1, -->
<!-- 													"part": "기타 배선", -->
<!-- 													"action": "체결 확인"									 -->
<!-- 												} -->
<!-- 											] -->
<!-- 										} -->
<!-- 									&lt;/script&gt; -->
											
<!-- 									&lt;!-- 응답 --&gt;				 -->
<!-- 									&lt;script&gt; -->
<!-- 										{ -->
<!-- 											"result_code": 2, -->
<!-- 											"result_msg": "피드백 처리 성공" -->
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
<script type="module" src="${pageContext.request.contextPath}/js/components/feedback.js"></script>
<%@ include file="../layout/footer.jsp" %>