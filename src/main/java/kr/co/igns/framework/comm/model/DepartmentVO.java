package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "부서관리")
@Data
public class DepartmentVO {
	private String id;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "부서코드")
	private String depCode;
	@Schema(description = "부서명")
	private String depName;
	@Schema(description = "상위부서코드")
	private String paDecode;
	@Schema(description = "사용유무")
	private String userFlag;
	@Schema(description = "비고")
	private String remark;
	@Schema(description = "등록일")
	private String makeDate;
	@Schema(description = "등록자")
	private String maker;
	@Schema(description = "수정일")
	private String editDate;
	@Schema(description = "수정자")
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
}
