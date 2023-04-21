package kr.co.igns.business.sales.model.sal0150;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "매출확정")
@Data
public class Sal0150ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "출하전산번호")
	private String lotDetail;
}
