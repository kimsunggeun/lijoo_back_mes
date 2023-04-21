package kr.co.igns.framework.comm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "권한메뉴")
@Data
public class AuthMenuVO {
	
	private String id;
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "시스템구분")
	private String sysType;
	@Schema(description = "모듈코드")
	private String moduleCode;
	@Schema(description = "권한그룹(코드)")
	private String perCode;
	@Schema(description = "메뉴코드")
	private String menuCode;
	@Schema(description = "메뉴명")
	private String menuName;
	@Schema(description = "부모메뉴코드")
	private String paCode;
	@Schema(description = "프로그램코드")
	private String pgCode;
	@Schema(description = "사용유무")
	private String userFlag;
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
