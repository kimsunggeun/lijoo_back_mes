package kr.co.igns.business.out.model.out0040;

import java.util.List;

import lombok.Data;

@Data
public class MatOutputRptVO {
	private String comCode;		//회사코드
	private String facCode;		//공장코드
	private String facName;		//공장명
	private String inIlno;		//납품번호(일련번호)
	private String lotDetail;	//공정실적 전산번호
	private String inDate;		//납품일자
	private String comName;		//출고처
	private String custName;	//거래처
	private int total;			//합계
}
