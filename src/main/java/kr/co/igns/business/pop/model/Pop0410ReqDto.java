package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "POP 계획출하")
@Data
public class Pop0410ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")	
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "출하일")
	private String outDate; 
}
