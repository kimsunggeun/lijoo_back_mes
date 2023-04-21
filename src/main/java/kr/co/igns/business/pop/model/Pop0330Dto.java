package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "pop0330")
@Data
public class Pop0330Dto {
	@Schema(description = "asd")
	private String comCode; 
	private String facCode;
	private String proCode; 
	private String workDecode;
	private String lotDetail;
	private String defCode;
	
}



