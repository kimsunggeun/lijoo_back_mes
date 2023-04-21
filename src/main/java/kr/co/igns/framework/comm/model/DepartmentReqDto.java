package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "부서관리")
@Data
public class DepartmentReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "부서코드")
	private String depCode;
}
