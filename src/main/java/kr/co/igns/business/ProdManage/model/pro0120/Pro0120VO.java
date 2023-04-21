package kr.co.igns.business.ProdManage.model.pro0120;

import lombok.Data;

@Data
public class Pro0120VO {
	private String comCode;    			//회사코드
	private String facCode;    			//공장코드
	private String ilno;				//일련번호
	private String workNo;    			//작업지시번호
	private String proType;				//생산 구분 코드
	private String defCode;				//불량코드
	private String preProCode;    		//이전 공정 코드
	private String proCode;    			//현재 공정코드
	private String preWorkCode;    		//이전  작업장 코드
	private String workCode;    		//현재 작업장 코드
	private String preWorkDecode;    	//이전 작업반코드
	private String workDecode;    		//현재 작업반코드
	private String workDename;
	private String preWhCode;    		//이전 창고코드
	private String whCode;    			//현재 창고코드
	private String eventCd;    			//작업명 코드(이벤트)
	private String stockType;    		//재공종류
	private String partNo;    			//품번
	private String partName; 			//품명
	private String qty;    				//수량
	private String partSpec;			//품목 규격
	private String preLotNo;    		//이전 LOT
	private String preLotDetail;    	//이전 전산번호
	private String lotNo;    			//공정실적 LOT
	private String lotDetail;    		//공정실적 전산번호
	private String calcelFlag;    		//작업취소 유무
	private String userFlag;    		//사용유무
	private String makeDate;    		//등록일
	private String maker;    			//등록자
	private String editDate;    		//수정일
	private String editor;    			//수정자
	
	private boolean __created__;
	private boolean __modified__;
}
