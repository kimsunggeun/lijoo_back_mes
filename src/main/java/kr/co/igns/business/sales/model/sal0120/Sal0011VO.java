package kr.co.igns.business.sales.model.sal0120;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sal0011VO {
	private String comCode;
	private String facCode;
	private String ordNo;
	private String no;
	private String outQty;
	private String nowQty;
}
