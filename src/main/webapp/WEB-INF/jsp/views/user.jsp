<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>사용자 관리</h4>
					<p class="mb-0 op-7">HRMaintenance 관련 사용자를 관리하는 기능.</p>
				</div>
				<div class="card-body">
					<div class="row justify-content-center align-items-center">
						<div class="col-md-10 mb-3">
							<div class="input-group" style="height: 42px;">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">No.</span>
								</div>
								<input type="text" class="form-control" placeholder="회원번호" aria-label="msrl" aria-describedby="basic-addon1" id="msrl">
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<button class="btn w-100" style="height: 42px; background: #8c8c8c; color: #fff;" id="userBtn">
								<span class="btn-label">
									<i class="fa fa-search"></i>
								</span>
								검색
							</button>
						</div>
					</div>
					<div class="table-responsive">
						<table id="basic-datatables" class="display table table-striped table-hover" >
							<thead>
								<tr class="text-center">
									<th width="10%">회원번호</th>
									<th width="30%">이름</th>
									<th width="40%">이메일</th>
									<th width="20%">권한</th>
								</tr>
							</thead>
							<tbody id="userList"/>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/components/user.js"></script>
<%@ include file="../layout/footer.jsp" %>