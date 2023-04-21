package kr.co.igns.business.out.model.out0030;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Out0030DelDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "입고량")
	private String inQty;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "작업지시번호")
	private String workNo;
	@Schema(description = "로트번호")
	private String lotDetail;
	@Schema(description = "납품번호(일련번호)")
	private String inIlno;
	@Schema(description = "등록자")
	private String maker;
}
