package kr.co.igns.business.pop.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Pop0310VO {
		private String comCode; //회사코드
		private String facCode; //공장코드
		private String partNo; //품목코드
		private String partName; //품명
		private String locCode; //저장위치코드
		private String locName; //저장위치이름
		private String lotNo; //저장위치
		private String regiDate; // 입고일
		private String whName; //창고명
		private String whCode; //창고코드
		private String stockType; //재고구분
		private String stockAmount; //재고금액
		private String workCode; // 작업장코드
		private String workDecode; // 작업반코드
		private String workDename; // 작업반명
		private String lotDetail; //전산번호
		private String stockQty; //현재고량 
		private String processName; //공정
		private String partCode; // 품목 코드
		private String lotSize; //로트크기
		private String lot_No; //LOT번호
		private String lotNumber;
		private String lotAmount; //LOT수량
		private String workDetail; //작업반
		private String qty; // 수량
		private String unitPrice; //단가
		private String eventCd; //이벤트코드
		private String userFlag; //사용유무
		private String proCode; // 현재 공정코드
		private String makeDate; // 재공등록일(입고일)
		private String sumQty; //합계수량
		private String sumAmount; //합계금액
		private String oldLotDetail; //병합전 전산번호
		private String oldQty; // 병합전 수량
		private String oldAmount; // 병합전 금액
		private String amount; //재고금액
		private String popLotDetail; //새로운 전산번호
		private String maker;		//등록자
		
		private boolean __created__;
		
}

