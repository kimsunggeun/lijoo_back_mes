package kr.co.igns.business.mat.model.mat0091;
import java.util.ArrayList;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "자재소요량(생산계획기준)")
@Data
public class Mat0091ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "품번코드")
	private String partNo;
	private ArrayList<String> partNoArray;
	@Schema(description = "경로구분")
	private String pathType;
	@Schema(description = "산출 시작일")
	private String fromDate;
	@Schema(description = "산출 종료일")
	private String toDate;
	@Schema(description = "산출일")
	private String regiDate;
	@Schema(description = "등록자")
	private String maker;
	@Schema(description = "수정자")
	private String editor;
	
	private boolean __created__;
	private boolean __modified__;
}
