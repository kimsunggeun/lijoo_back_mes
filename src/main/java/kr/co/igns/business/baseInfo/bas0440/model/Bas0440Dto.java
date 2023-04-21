package kr.co.igns.business.baseInfo.bas0440.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "계측기 마스터")
@Data
public class Bas0440Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "게측기그룹")
	private String meaGr;
	@Schema(description = "계측기명")
	private String meaName;	
	@Schema(description = "구입일자 from")
	private String frPurDate;
	@Schema(description = "구입일자 to")
	private String toPurDate;
}
