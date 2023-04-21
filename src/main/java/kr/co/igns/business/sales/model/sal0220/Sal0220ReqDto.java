package kr.co.igns.business.sales.model.sal0220;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "기간별출하현황")
@Data
public class Sal0220ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "품목군")
	private String itemType;
	@Schema(description = "제품군")
	private String partType;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "시작일")
	private String startDate;
	@Schema(description = "종료일")
	private String endDate;
}
