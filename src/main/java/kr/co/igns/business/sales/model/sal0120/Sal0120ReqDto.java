package kr.co.igns.business.sales.model.sal0120;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "출하등록")
@Data
public class Sal0120ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "수주번호")
	private String ordNo;
	@Schema(description = "수주순번")
	private String ordTurn;	
	@Schema(description = "출하일련번호")
	private String ilno;
	@Schema(description = "출하순번")
	private String no;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "시작일")
	private String startDate;
	@Schema(description = "종료일")
	private String endDate;
}
