package kr.co.igns.business.sales.model.sal0140;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "출하등록 내용을 수정하기위한 조회조건")
@Data
public class Sal0120CountReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "수주순번")
	private String ordTurn;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "순번")
	private String no;
}
