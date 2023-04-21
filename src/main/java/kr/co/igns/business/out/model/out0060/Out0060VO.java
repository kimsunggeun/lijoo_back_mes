package kr.co.igns.business.out.model.out0060;

import java.util.List;

import kr.co.igns.business.mat.model.mat0070.Mat0018VO;
import lombok.Data;

@Data
public class Out0060VO{
	private String id;
	private String comCode;    		
	private String facCode;    			
	private String ordNo;			
	private String no;    			
	private String regiDate;    		
	private String ilno;			
	private String partNo;	
	private String partName;		
	private String qty;			
	private String inQty;				
	private String makeQty;		
	private String boxQty;    			
	private String inPrice;		
	private String inAmount;				   		
	private String remQty;				
	private String remark;			
	private String printType;			
	private String userFlag;    	
	private String makeDate;    	
	private String maker;    		
	private String editDate;    	
	private String editor;    		
	private String inStatus;    		
	private String inType;    		
	private String retAmount;    		
	
	private List<Mat0018VO> detailData;
	
}
