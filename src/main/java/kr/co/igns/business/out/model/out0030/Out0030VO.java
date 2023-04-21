package kr.co.igns.business.out.model.out0030;

import lombok.Data;

@Data
public class Out0030VO {
	private String comCode;    			//회사코드
	private String facCode;    			//공장코드
	private String ilno;				//일련번호
	private String custCode;			//거래처코드
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
	private String outYn;    			//공정입고유무
	private String userFlag;    		//사용유무
	private String remark;				//비고
	private String printType;			//라벨출력 구분
	private String makeDate;    		//등록일
	private String maker;    			//등록자
	private String editDate;    		//수정일
	private String editor;    			//수정자
	
	private String outDate;				//공정외주 출고일자
	private String outQty;				//공정외주 출고수량
	private String outDeliQty;			//공정외주 납품수량
	private String outNonDeliQty;		//공정외주 납품잔량
	private String outWaitDeliQty;		//공정외주 납품대기수량
	
	private String inDate;				//납품일자
	private String inIlno;				//납품번호(일련번호)
	private String inNo;				//납품 순번
	private String nextProcNo;			//다음 공정명
	private String outLotDetail;		//공정외주 입고 전산번호
	private String inPrice;				//가공비 단가
	private String inAmount;			//가공비 금액
	private String outInspCode;			//공정외주검사 진행상태 코드
	private String inQty;				//입고량
	private String makeQty;				//구성량
	private String boxQty;				//박스 수량
	
	private String lotSize;				//구성량
	private String proCost;				//단가(가공비) bas0042
	private String supInsp;				//공급처출하검사여부
}
