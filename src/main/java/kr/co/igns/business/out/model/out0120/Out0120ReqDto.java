package kr.co.igns.business.out.model.out0120;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "기간별공정외주입고현황")
@Data
public class Out0120ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "외주처코드")
	private String custCode;
	@Schema(description = "납품번호(일련번호)")
	private String inIlno;
	@Schema(description = "납품 순번")
	private String inNo;
	@Schema(description = "공정실적 전산번호")
	private String lotDetail;
	@Schema(description = "품번 코드")
	private String partNo;
	@Schema(description = "공통코드")
	private String proType;
	@Schema(description = "시작일자")
	private String startDate;
	@Schema(description = "마지막일자")
	private String endDate;
}
