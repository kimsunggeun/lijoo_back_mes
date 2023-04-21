package kr.co.igns.business.out.model.out0020;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "공정외주 납품등록")
@Data
public class Out0020ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "발주번호(일련번호)")
	private String ilno;
	@Schema(description = "발주 순번")
	private String no;
	@Schema(description = "입고번호(일련번호)")
	private String inIlno;
	@Schema(description = "입고 순번")
	private String inNo;
	@Schema(description = "공정외주 입고 전산번호")
	private String lotDetail;
	
}
