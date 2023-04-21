package kr.co.igns.business.mat.model.mat0030;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "구매 입고등록")
@Data
public class Mat0030ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "품명")
	private String partName;
	@Schema(description = "입고구분")
	private String inType;
	@Schema(description = "발주번호")
	private String ordNo;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "입고일")
	private String regiDate;
	@Schema(description = "입고번호(일련번호)")
	private String ilNo;	
	@Schema(description = "일련번호 순번")
	private String serialNo;
	@Schema(description = "구매입고 전산번호")
	private String lotDetail;
}
