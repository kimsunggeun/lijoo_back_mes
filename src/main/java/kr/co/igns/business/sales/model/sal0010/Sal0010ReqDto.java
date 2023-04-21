package kr.co.igns.business.sales.model.sal0010;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "고객주문등록")
@Data
public class Sal0010ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호(일련번호)")
	private String ordNo;
	@Schema(description = "납기일")
	private String deliDate;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "발주상태")
	private String ordState;
	@Schema(description = "수주시작일")
	private String startDate;
	@Schema(description = "수주종료일")
	private String endDate;
}
