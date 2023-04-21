package kr.co.igns.business.baseInfo.bas0120.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "공장정보/창고정보/작업장정보/설비정보/경로정보")
@Data
public class Bas0120Dto {	
	@Schema(description = "회사코드")
	private String comCode;  //회사코드
	private String facCode;  //공장코드
	private String whCode;  // 창고코드
	private String workCode; // 작업장코드
	private String pathCode; //경로코드
}
