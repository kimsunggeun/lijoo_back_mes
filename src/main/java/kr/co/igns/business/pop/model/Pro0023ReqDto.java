package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "pop화면")
public class Pro0023ReqDto {
	@Schema(description="회사")
	private String comCode;
	@Schema(description="공장")
	private String facCode;
	@Schema(description="품번")
	private String partNo;	
	@Schema(description="전산번호")
	private String lotDetail;
	@Schema(description="작업장코드")	
	private String workCode;
	@Schema(description="작업반코드")
	private String workDecode;
	@Schema(description="창고코드")
	private String whCode;
	@Schema(description="경로코드")
	private String pathCode;
	@Schema(description="작업코드")
	private String ilno;
	@Schema(description="작업지시번호")
	private String workNo;
	@Schema(description="작업자")
	private String userId;
	@Schema(description="산입유형")
	private String workType;
	@Schema(description="수량")
	private String qty;
	@Schema(description="양품/불량구분")
	private String proType;
	@Schema(description="실적수량합")
	private String proSumQty;
}
