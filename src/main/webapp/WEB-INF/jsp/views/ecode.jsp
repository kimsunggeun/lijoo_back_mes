<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card shadow-none">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow hsub-title sub-title-fixed">
					<span data-lang="ecode_subtitle">[ecode_subtitle]</span>
					<p>
						<span class="mb-0 op-7" data-lang="version">[version]</span>&nbsp;<span class="mb-0 op-7">:</span>&nbsp;
						<span class="mb-0 op-7" id="version-text"></span>
					</p>
				</div>
				<div class="card-body fixed-sub-mt p-0">
					<div class="row justify-content-center align-items-center search-panel-fixed">
						<div class="col-md-12 p-0 resize-search">
							<div class="col-md-3 d-flex pr-1 pl-1 pb-1">
								<div class="w-100">
									<div class="input-group h-30p">
										<input type="text" autocomplete="on" class="form-control" placeholder="robot-model" aria-label="rModel" aria-describedby="basic-addon1" id="rModel" data-lang="robot_model">
									</div>
								</div>
							</div>
							<div class="col-md-9 d-flex pr-1 pl-1 pb-1">
								<div class="w-40 pr-1">
									<select class="form-control form-control-sm" id="cmodelSelect" name="cmodelSelect">
										<option value="Hi4">Hi4</option>
										<option value="Hi5">Hi5</option>
										<option value="Hi5a">Hi5a</option>
									</select>
								</div>
								<div class="w-40 pr-1">
									<div class="input-group h-30p">
										<div class="input-group-prepend">
											<span class="input-group-text error-type h-30p" id="basic-addon1">E</span>
										</div>
										<input type="number" pattern="\d*" autocomplete="on" class="form-control" placeholder="code" aria-label="eEcode" aria-describedby="basic-addon1" id="eEcode" data-lang="error_code">
									</div>
								</div>
								<div class="w-20">
									<button class="btn w-100 search-btn" id="ecodeBtn">
										<span class="btn-label">
											<i class="fa fa-search mr-0 ml-0"></i>
										</span>
	<!-- 									<span data-lang="search">[search]</span> -->
									</button>
								</div>							
							</div>
						</div>
						<div class="col-md-3 d-flex pr-1 pl-1 pb-1 common-msg-div">
							<div class="fixed-msg w-100 common-msg" id="errorMsg">
							</div>
						</div>
						<div class="col-md-9 d-flex pr-1 pl-1 pb-1 common-msg-div">
							<div class="fixed-msg w-100 common-msg" id="causeMsg">
							</div>
						</div>
					</div>
				</div>
				<div class="card-body pt-fixed-no">					
					<div class="row">
						<div class="col-md-12">
							<div class="card mb-3 hrms-card-border">
								<div class="card-body text-center">
									<img src="${pageContext.request.contextPath}/img/history.png" alt="History" class="accodian-img"><span class="act-title" data-lang="history">[history]</span>
									<div class="accordion" id="accordionH">
										<div class="search-msg" data-lang="no_data">[no_data]</div>
									</div>
								</div>
							</div>
							<div class="card mb-5 hrms-card-border">
								<div class="card-body text-center">
									<img src="${pageContext.request.contextPath}/img/menual.png" alt="Menual" class="accodian-img"><span class="act-title" data-lang="manual">[manual]</span>
									<div class="accordion" id="accordionM">
										<div class="search-msg" data-lang="no_data">[no_data]</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="footMenu d-flex">
		<div class="w-50 border-r-w"><h3 class="ecode-comment" id="textError"></h3></div>
		<div class="w-50"><h3 class="ecode-comment" id="textMsg"></h3></div>
	</div>
</div>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/components/ecode.js?ver=1.0.0"></script>
<%@ include file="../layout/footer.jsp" %>