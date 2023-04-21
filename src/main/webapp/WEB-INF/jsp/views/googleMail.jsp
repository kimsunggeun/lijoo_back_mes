<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card">
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>메일 전송</h4>
					<p class="mb-0 op-7">Gmail SMTP를 활용한 메일 전송 (HTML Template) + 파일첨부 기능 제공.</p>
				</div>
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group form-inline">
									<input type="text" class="form-control" data-role="tagsinput" name="tags" id="mailMultiTo">
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group form-inline">
									<label for="inlineinput" class="col-md-3 col-form-label">받는사람</label>
									<div class="col-md-9 p-0">
										<input type="text" class="form-control input-full" id="mailTo" placeholder="받으실 메일 주소를 입력해주세요">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group form-inline">
									<label for="inlineinput" class="col-md-3 col-form-label">제목</label>
									<div class="col-md-9 p-0">
										<input type="text" class="form-control input-full" id="mailTitle" placeholder="제목을 입력해주세요">
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-group form-inline">
									<textarea class="form-control w-100" rows="18" id="ckeditorMail"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
<!-- 							<div class="col-md-2"> -->
<!-- 								<div class="form-group form-inline"> -->
<!-- 									<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="docxTest"> -->
<!-- 										<span class="btn-label"> -->
<!-- 											<i class="fas fa-file-alt"></i> -->
<!-- 										</span> -->
<!-- 										워드 파일 테스트 -->
<!-- 									</button>									 -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="col-md-10">
								<div class="form-group form-inline">
									<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="mailSendBtnTest">
										<span class="btn-label">
											<i class="fas fa-paper-plane"></i>
										</span>
										JSON TEST
									</button>									
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group form-inline">
									<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="mailSendBtn">
										<span class="btn-label">
											<i class="fas fa-paper-plane"></i>
										</span>
										전송
									</button>									
								</div>
							</div>
						</div>
						<div class="row">
							<div id="wordArea"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/components/googleMail.js"></script>
<%@ include file="../layout/footer.jsp" %>