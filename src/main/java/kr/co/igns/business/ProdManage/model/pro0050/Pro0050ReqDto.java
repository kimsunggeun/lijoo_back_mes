package kr.co.igns.business.ProdManage.model.pro0050;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "작업지시관리 조회")
@Getter
@Setter
public class Pro0050ReqDto {
	
	@Schema(description = "회사코드")
	private String comCode;    //회사코드
	
	@Schema(description = "공장코드")
	private String facCode;    //공장코드
	
	@Schema(description = "작업지시번호")
	private String workNo;    //작업지시번호
	
	@Schema(description = "작업장코드")
	private String workCode;    //작업지시번호
	
	@Schema(description = "작업장명")
	private String workName;    //작업장명
	
	@Schema(description = "작업지시상태")
	private String orderState;    //작업지시상태
	
	@Schema(description = "작업지시상태 버튼")
	private String btnOrderState;    //작업지시상태 버튼
	
	@Schema(description = "계획일")
	private String planDate; 
	
	@Schema(description = "시작일")
	private String frPlanDate;
	
	@Schema(description = "종료일")
	private String toPlanDate;
	
	@Schema(description = "경로유형")
	private String pathCode;
}
