package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Pop0020ReqDto {
	private String comCode;
	private String facCode;
	private String custCode;
	private String ilno;
	private String ordNo;
}
