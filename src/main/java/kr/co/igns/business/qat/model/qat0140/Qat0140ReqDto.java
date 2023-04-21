package kr.co.igns.business.qat.model.qat0140;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "반품등록")
@Data
public class Qat0140ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "출하순번")
	private String no;
	@Schema(description = "반품 전산번호")
	private String retLotDetail;
}
