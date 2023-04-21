package kr.co.igns.business.ProdManage.model.pro0130;

import lombok.Data;

@Data
public class Pro0130GridVO {
	private String comCode;    			//회사코드
	private String facCode;    			//공장코드
	private String regiDate;    		//등록일
	private String workCode;    		//작업장 코드
	private String workDecode;    		//작업반 코드
	private String partNo;    			//품번
	private String partName;			//품명
	private String prodType;    		//생산유형
	private String defCode;    			//불량코드
	private String defCnt;    			//불량수량
	private String lotNo;    			//불량 LOT
	private String lotDetail;    		//불량 전산번호
	private String selectType;    		//불량선별 코드
	private String defOkCnt;    		//불량선별 양품수량
	private String defNgCnt;    		//불량선별 불량수량
	private String remark;    			//비고
	private String userFlag;    		//사용유무
	private String makeDate;    		//등록일
	private String maker;    			//등록자
	private String editDate;    		//수정일
	private String editor;    			//수정자
}
