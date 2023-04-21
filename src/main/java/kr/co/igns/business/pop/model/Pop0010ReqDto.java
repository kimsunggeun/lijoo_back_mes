package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Pop0010ReqDto {
	private String comCode;
	private String facCode;
	private String custCode;
	private String partNo;
	private String lotDetail;
	private String ilno;
	
}
