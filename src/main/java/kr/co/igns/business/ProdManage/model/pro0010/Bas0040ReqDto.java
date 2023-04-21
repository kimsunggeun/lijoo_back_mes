package kr.co.igns.business.ProdManage.model.pro0010;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "작지대상품목  제품군,품목군 조회")
@Data
public class Bas0040ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	
	@Schema(description = "품번")
	private String partNo;

}
