package kr.co.igns.business.sales.model.sal0210;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "수주진행현황")
@Data
public class Sal0210ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처명")
	private String custName;
	@Schema(description = "품명")
	private String partName;
	@Schema(description = "품목군")
	private String itemType;
	@Schema(description = "제품군")
	private String partType;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "주문상태")
	private String ordState;
	@Schema(description = "시작일")
	private String startDate;
	@Schema(description = "종료일")
	private String endDate;	 
}
