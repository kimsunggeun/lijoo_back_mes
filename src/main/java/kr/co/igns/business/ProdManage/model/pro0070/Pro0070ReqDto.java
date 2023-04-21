package kr.co.igns.business.ProdManage.model.pro0070;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "생산계획 조회")
@Data
public class Pro0070ReqDto {
	
	@Schema(description = "회사코드")
	private String comCode;
	
	@Schema(description = "공장코드")
	private String facCode;
	
	@Schema(description = "비가동 코드")
	private String stopCode;

	@Schema(description = "작업장명")
	private String workCode;

	@Schema(description = "작업반 명")
	private String workDecode;
	
	@Schema(description = "순서")
	private String no;
	

	@Schema(description = "설비코드")
	private String eqCode;
	
	
	@Schema(description = "비가동 일자")
	private String workDate;
	
	@Schema(description = "비가동 일련번호")
	private String nonIlno;
}
