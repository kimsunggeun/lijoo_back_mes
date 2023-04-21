package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Schema(description = "회사정보 Dto")
public class CompanyReqDto {
	
	@Schema(description = "회사코드")
    private String comCode;
}
