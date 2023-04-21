package kr.co.igns.business.eqp.model.eqp0060;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "계측기 조회")
@Data
public class Eqp0060Dto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "설비코드")
	private String eqCode;	
	@Schema(description = "수리번호") 
	private String repNo;	
	@Schema(description = "등록일")
	private String regDate;	
	@Schema(description = "발생일")
	private String occDate;	
	@Schema(description = "조치일")
	private String actDate;	
	@Schema(description = "수리내역")
	private String repRemark;	
	@Schema(description = "수리업체")
	private String repCust;	
	@Schema(description = "작업자")
	private String worker;	
	@Schema(description = "수리금액")
	private String repAmount;	
	@Schema(description = "비고")
	private String remark;
}
