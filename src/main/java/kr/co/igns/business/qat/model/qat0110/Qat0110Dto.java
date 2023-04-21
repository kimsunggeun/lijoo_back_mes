package kr.co.igns.business.qat.model.qat0110;

import lombok.Data;

@Data
public class Qat0110Dto {
	private String comCode;
	private String facCode;
	private String partNo;
	private String inStatus;
	private String ordNo;    //발주번호
	private String no;       //순번
	private String ilno;     //일련번호
	private String regiDate;
	private String inQty;
	private String makeQty;
	private String boxQty;
	private String inAmount;
	private String insCode;
	private String frRegiDate;
	private String toRegiDate;
	private String partName;
	private String custCode;

}
