package kr.co.igns.business.eqp.model.eqp0030;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "eqp0030")
@Data
public class Eqp0030Dto {
	@Schema(description = "회사코드")
	private String comCode;
	private String facCode;
	private String inspDate;
	private String eqInsType;
	private String eqCode;
	private String eqInspNo;
	private String eqInsCode;
}
