package kr.co.igns.business.eqp.model.eqp0010;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "eqp0010")
@Data
public class Eqp0010Dto {
	@Schema(description = "회사코드")
	private String comCode;

	private String jobType;
	
	private String eqInsType;
	
	private String eqInsCode;
}
