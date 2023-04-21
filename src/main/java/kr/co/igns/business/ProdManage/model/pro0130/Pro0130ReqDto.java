package kr.co.igns.business.ProdManage.model.pro0130;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "불량실적등록")
@Data
public class Pro0130ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "등록일")
	private String workFrDate;
	@Schema(description = "종료일")
	private String workDate;
	@Schema(description = "작업장 코드")
	private String workCode;
	@Schema(description = "작업반 코드")
	private String workDecode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "불량코드")
	private String defCode;
}
