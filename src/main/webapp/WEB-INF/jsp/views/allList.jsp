<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card shadow-none">
				<div class="card-header bg-hrms-gradient text-white bubble-shadow hsub-title sub-title-fixed">
					<span data-lang="all_subtitle">[all_subtitle]</span>
					<p>
						<span class="mb-0 op-7" data-lang="version">[version]</span>&nbsp;<span class="mb-0 op-7">:</span>&nbsp;
						<span class="mb-0 op-7" id="version-text"></span>
					</p>
				</div>
			</div>
			<div class="card-body pt-fixed-no-search prepare-msg">
				<div class="text-center prepare-msg" data-lang="prepare">[prepare]</div>
			</div>
		</div>
	</div>
</div>
</div>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/components/ecode.js?ver=1.0.0"></script>
<%@ include file="../layout/footer.jsp" %>