package kr.co.igns.framework.comm.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "매뉴")
@Data
public class MenuStatisticsReqDto {

	@Schema(description = "회사코드")
	private String comCode;
	@Schema(description = "사용자ID")
    private String userId;
	@Schema(description = "사용자명")
    private String userName;
	@Schema(description = "메뉴코드")
	private String menuCode;
	@Schema(description = "메뉴명")
	private String menuName;
	@Schema(description = "일시")
	private String cnntDate;
	@Schema(description = "모듈코드")
	private String moduleCode;
	@Schema(description = "사용횟수")
	private int cnntCnt;
	@Schema(description = "최초 사용자ID")
	private String insertUserId;
	@Schema(description = "최초 사용시간")
	private String insertDate;
	@Schema(description = "마지막 사용자ID")
	private String updateUserId;
	@Schema(description = "마지막 사용시간")
	private String updateDate;
	@Schema(description = "MAC주소")
	private String macAdrs;
	@Schema(description = "조회일 From")
	private String dateFrom;
	@Schema(description = "조회일 To")
	private String dateTo;
	@Schema(description = "언어코드")
	private String lanCode;
	
	
}
