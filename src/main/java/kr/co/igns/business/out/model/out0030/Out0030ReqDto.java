package kr.co.igns.business.out.model.out0030;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Out0030ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "외주처코드")
	private String custCode;
	@Schema(description = "작업 일련번호")
	private String ilno;
	@Schema(description = "공정실적 전산번호")
	private String lotDetail;
	@Schema(description = "작업지시번호")
	private String workNo;
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
	@Schema(description = "출고 시작일")
	private String startDate;
	@Schema(description = "출고 종료일")
	private String endDate;
	@Schema(description = "납품번호(일련번호)")
	private String inIlno;
	@Schema(description = "납품일")
	private String inDate;
}
