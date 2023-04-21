package kr.co.igns.business.qat.model.qat0120;

import lombok.Data;

@Data
public class Qat0120VO {
	private String sysCode; //불량코드
	private String sysName; //불량코드이름	
	private String defCnt; //불량수량
	private String facCode; //공장코드
	private String comCode; //회사코드
	private String partNo; //품번
	private String partName; // 품명
	private String defCode; //불량코드
	private String workDename; //작업반명
	private String workName; //작업장명
	private String defShape; //형상불량
	private String defDimension; //치수불량
	private String defSetting; //셋팅불량
	private String toolDamage; //공구파손
	private String defIntroduction; //소개불량
	private String defStamping; //찍힘불량
	private String defOther; //기타불량
	private String reqDtFrom; //시작일
	private String reqDtTo; //종료일
	private String regiDate; // 등록일
	private String workCode; //작업장 코드
	private String workDecode; // 작업반 코드
	private String prodType; // 생산유형
	private String lotNo; // 불량LOT
	private String lotDetail; // 불량 전산번호
	private String selectType; // 불량선별 코드
	private String defOkCnt; //불량선별 양품수량
	private String defNgCnt; //불량선별 불량수량
	private String remark; //비고
	private String userFlag; // 사용유무
	private String makeDate; //등록일
	private String maker; //등록자
}
