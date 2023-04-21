package kr.co.igns.business.ProdManage.model.pro0160;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "공정실적현황 조회")
@Data
public class Pro0160ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "작업지시번호")
	private String workNo;
	@Schema(description = "생산구분")
	private String proType;
	@Schema(description = "현재공정코드")
	private String proCode;
	@Schema(description = "작업장코드")
	private String workCode;
	@Schema(description = "작업장명")
	private String workName;
	@Schema(description = "작업반코드")
	private String workDecode;
	@Schema(description = "작업반명")
	private String workDename;
	@Schema(description = "품번코드")
	private String partNo;
	@Schema(description = "전산번호")
	private String lotDetail;
	@Schema(description = "from날짜")
	private String startDate;
	@Schema(description = "to날짜")
	private String endDate;
	@Schema(description = "불량코드")
	private String defCode;

}
