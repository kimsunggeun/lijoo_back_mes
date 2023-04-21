package kr.co.igns.business.ProdManage.model.pro0010;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "생산계획 조회")
@Data
public class Pro0010ReqDto {
	
	@Schema(description = "회사코드")
	private String comCode;
	
	@Schema(description = "공장코드")
	private String facCode;
	
	@Schema(description = "일련번호")
	private String ilno;
	
	@Schema(description = "품번코드")
	private String partNo;
	
	@Schema(description = "계획일 from")
	private String frPlanDate;
	
	@Schema(description = "계획일 to")
	private String toPlanDate;
}
