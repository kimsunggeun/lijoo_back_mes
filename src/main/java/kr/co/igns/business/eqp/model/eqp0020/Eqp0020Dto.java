package kr.co.igns.business.eqp.model.eqp0020;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "eqp0010")
@Data
public class Eqp0020Dto {
	@Schema(description = "회사코드")
	private String comCode;
	private String facCode;
	private String eqInsType;
	private String eqCode;
	private String eqInspNo;
	private String eqInsCode;
	private String userFlag;
}
