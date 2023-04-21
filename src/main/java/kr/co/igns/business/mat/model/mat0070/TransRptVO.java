package kr.co.igns.business.mat.model.mat0070;

import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Data
public class TransRptVO {
	private String comCode;
	private String facCode;
	private String ilno;
	private String regiDate;
	private String comName;
	private String ceoName;
	private String comNum;
	private String comAddr;
	private String custCode;
	private String custName;
	private String custCeoName;
	private String custNum;
	private String custAddr;
	private int amount;
    private int vat;
	private int total;
	private String totalHangl;
	private String keeper;
			
	private JRBeanCollectionDataSource detailData;
}
