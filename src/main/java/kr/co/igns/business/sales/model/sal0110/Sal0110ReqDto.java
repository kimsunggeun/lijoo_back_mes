package kr.co.igns.business.sales.model.sal0110;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "출하계획등록")
@Data
public class Sal0110ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "수주일")
	private String ordDate;	
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "거래처명")
	private String custName;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "품목군 코드")
	private String itemType;
	@Schema(description = "제품군 코드")
	private String partType;
	@Schema(description = "납기예정일 to")
	private String toDeliDate;
	@Schema(description = "납기예정일 from")
	private String frDeliDate;
	
}
