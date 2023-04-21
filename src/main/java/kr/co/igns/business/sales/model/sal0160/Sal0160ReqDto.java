package kr.co.igns.business.sales.model.sal0160;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.igns.business.sales.model.sal0160.Sal0160ReqDto;
import lombok.*;

@Schema(description = "반품등록")
@Data
public class Sal0160ReqDto {
	private String comCode;
	private String partNo;
	private String custCode;
	private String startDate;
	private String endDate;
}
