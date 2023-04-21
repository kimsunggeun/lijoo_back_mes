package kr.co.igns.business.mat.model.mat0040;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "입고등록(기타/사급자재)")
@Data
public class Mat0040ReqDto {
	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "공장코드")
	private String facCode;
	@Schema(description = "등록일")
	private String regiDate;
	@Schema(description = "일련번호")
	private String ilno;
	@Schema(description = "거래처코드")
	private String custCode;
	@Schema(description = "입고구분")
	private String inType;
	@Schema(description = "입고유형")
	private String inCate;
	@Schema(description = "순번")
	private String no;
	@Schema(description = "기타입고 전산번호")
	private String lotDetail;
	@Schema(description = "품번")
	private String partNo;
	@Schema(description = "입고시작일")
	private String startDate;
	@Schema(description = "입고종료일")
	private String endDate;
}
