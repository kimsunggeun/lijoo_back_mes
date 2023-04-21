package kr.co.igns.business.mat.model.mat0050;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "입고정보 조회")
@Data
public class Mat0012ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "품번코드")
	private String partNo;
	@Schema(description = "입고상태")
	private String inStatus;
	@Schema(description = "입고구분")
	private String inType;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "조회시작일")
	private String workFrDate;
	@Schema(description = "조회종료일")
	private String workDate;
	@Schema (description = "반품번호")
	private String retNo;
	
}
