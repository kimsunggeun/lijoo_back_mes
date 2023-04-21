package kr.co.igns.business.pop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "로트분할 조회조건")
@Data
public class Pop0310ReqDto {
	private String lotDetail; //전산번호
	private String comCode; //회사코드
	private String facCode; // 공장코드
	private String partNo; //품목코드
	private String locCode; // 창고코드
	private String work; //작업반명
	private String location; //위치(공정)
	
}


