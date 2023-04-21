package kr.co.igns.business.eqp.model.eqp0140;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "계측기 조회")
@Data
public class Eqp0140Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "계측기그룹")
	private String meaGr;
	@Schema(description = "계측기명")
	private String meaName;
	@Schema(description = "검교정일")
	private String corrDate;
}
