<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="main-panel">
	<div class="content content-documentation">
		<div class="container-fluid">
			<div class="card mb-0">				
				<div class="card-header bg-hrms-gradient text-white bubble-shadow">
					<h4>전체목록</h4>
<!-- 					<p class="mb-0 op-7">코드 전체 목록 정의.</p> -->
				</div>
				<div class="col-md-12 table-content p-0">
					<div class="card mb-0">
						<div class="card-body p-0">
						<!-- 						<div class="col-md-6 mb-2 p-0">							 -->
<!-- 							<div class="selectgroup w-100"> -->
<!-- 								<label class="selectgroup-item"> -->
<!-- 									<input type="radio" name="eCmodel" value="Hi4" class="selectgroup-input"> -->
<!-- 									<span class="selectgroup-button hrms-group-btn">Hi4</span> -->
<!-- 								</label> -->
<!-- 								<label class="selectgroup-item"> -->
<!-- 									<input type="radio" name="eCmodel" value="Hi5" class="selectgroup-input"> -->
<!-- 									<span class="selectgroup-button hrms-group-btn">Hi5</span> -->
<!-- 								</label> -->
<!-- 								<label class="selectgroup-item"> -->
<!-- 									<input type="radio" name="eCmodel" checked="checked" value="Hi5a" class="selectgroup-input"> -->
<!-- 									<span class="selectgroup-button hrms-group-btn">Hi5a</span> -->
<!-- 								</label> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-md-4 mb-3"> -->
<!-- 									<div class="selectgroup w-100"> -->
<!-- 										<label class="selectgroup-item"> -->
<!-- 											<input type="radio" name="eCmodel" value="Hi4" class="selectgroup-input" style="height: 42px;"> -->
<!-- 											<span class="selectgroup-button" style="height: 42px;">Hi4</span> -->
<!-- 										</label> -->
<!-- 										<label class="selectgroup-item"> -->
<!-- 											<input type="radio" name="eCmodel" value="Hi5" class="selectgroup-input" style="height: 42px;"> -->
<!-- 											<span class="selectgroup-button" style="height: 42px;">Hi5</span> -->
<!-- 										</label> -->
<!-- 										<label class="selectgroup-item"> -->
<!-- 											<input type="radio" name="eCmodel" value="Hi5a" class="selectgroup-input" style="height: 42px;"> -->
<!-- 											<span class="selectgroup-button" style="height: 42px;">Hi5a</span> -->
<!-- 										</label> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-4 mb-3"> -->
<!-- 									<div class="selectgroup w-100"> -->
<!-- 										<label class="selectgroup-item"> -->
<!-- 											<input type="radio" name="eCmodel2" value="Hi4" class="selectgroup-input" style="height: 42px;"> -->
<!-- 											<span class="selectgroup-button" style="height: 42px;">에러</span> -->
<!-- 										</label> -->
<!-- 										<label class="selectgroup-item"> -->
<!-- 											<input type="radio" name="eCmodel2" value="Hi5" class="selectgroup-input" style="height: 42px;"> -->
<!-- 											<span class="selectgroup-button" style="height: 42px;">경고</span> -->
<!-- 										</label> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-4 mb-3"> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="table-responsive">
								<table id="basic-datatables" class="display table table-striped table-hover" >
									<thead>
										<tr class="text-center">
											<th width="5%">코드</th>
											<th width="*">내용</th>
											<th width="15%"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class='text-center'>E0001</td>
											<td>정전검출</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0002</td>
											<td>하드웨어 리밋스위치 작동중</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0003</td>
											<td>브레이크전원 과부하</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0004</td>
											<td>Arm간섭 리밋스위치 작동</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0005</td>
											<td>Main보드의 Flash ROM에  DSP 버전이 없음</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0006</td>
											<td>충돌센서 작동중</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0007</td>
											<td>용착 검출</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0008</td>
											<td>모터온도 상승 (Hard-wiring)</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0009</td>
											<td>Main보드의 Flash ROM에  DSP 버전이 없음</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0010</td>
											<td>충돌센서 작동중</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0011</td>
											<td>용착 검출</td>
											<td class='text-center'></td>
										</tr>
										<tr>
											<td class='text-center'>E0012</td>
											<td>모터온도 상승 (Hard-wiring)</td>
											<td class='text-center'></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>	
				<!-- 하단 고정 메뉴 -->
				<div class="row fixed-footer-menu">
					<div class="col-md-12 pl-0 pr-0">
						<div class="selectgroup w-100">
							<label class="selectgroup-item">
								<input type="radio" name="eCmodel2" value="Hi4" class="selectgroup-input" style="height: 42px;">
								<span class="selectgroup-button" style="height: 42px;">에러</span>
							</label>
							<label class="selectgroup-item">
								<input type="radio" name="eCmodel2" value="Hi5" class="selectgroup-input" style="height: 42px;">
								<span class="selectgroup-button" style="height: 42px;">경고</span>
							</label>
						</div>
					</div>
				</div>		
			</div>
		</div>
	</div>
</div>
</div>
</body>
<%@ include file="../layout/footer.jsp" %>