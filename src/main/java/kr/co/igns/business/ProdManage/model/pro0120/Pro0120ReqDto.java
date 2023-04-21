package kr.co.igns.business.ProdManage.model.pro0120;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "생산실적현황 조회")
@Data
public class Pro0120ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "작업지시번호")
	private String workNo;
//	@Schema(description = "생산일")
//	private String workDate;
//	@Schema(description = "생산순번")
//	private String no;
	@Schema(description = "현재 공정코드")
	private String proCode;
	@Schema(description = "현재 작업장 코드")
	private String workCode;
	@Schema(description = "현재 작업반 코드")
	private String workDecode;
	@Schema(description = "현재 작업반명")
	private String workDename;
	@Schema(description = "품번")
	private String partNo;
	
}
