package kr.co.igns.business.sales.model.sal0140;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Mat0020Dto {
	private String id;          //아이디
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String locCode;		//창고위치코드
	private String locName;		//창고위치명
	private String stockType;	//재고구분
	private String eventCd;		//재고이벤트명
	private String partNo;		//품번코드
	private String partName;	//품명
	private String stockQty;	//재고수량
	private String stockAmount;	//재고금액
	private String regiDate;	//재고등록일
	private String lotNo;		//LOT NO
	private String lotDetail;	//전산번호
	private String retLotDetail;//반품전산번호
	private String userFlag;	//사용유무
	private String makeDate;	//등록일
	private String maker;		//등록자
	private String editDate;	//수정일
	private String editor;		//수정자
}
