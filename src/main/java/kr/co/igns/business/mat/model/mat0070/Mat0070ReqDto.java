package kr.co.igns.business.mat.model.mat0070;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "구매발주 생성")
@Data
public class Mat0070ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처")
	private String custName;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품목")
	private String partNo;
	@Schema(description = "발주번호")
	private String ordNo;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "입고번호(일련번호)")
	private String ilno;
	@Schema(description = "입고일")
	private String regidate;
	@Schema(description = "조회시작일")
	private String reqDtFrom;
	@Schema(description = "조회종료일")
	private String reqDtTo;
	
}





