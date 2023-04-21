package kr.co.igns.business.baseInfo.bas0230.model;

import lombok.Data;

@Data
//BOM정보
public class Bas0230VO_BOM {
	private String parentId;		// 부모아이디
	private String id;			  	// 아이디
	private String comCode;       	// 회사코드
	private String facCode;			// 공장코드
	private String paPartNo;		// 부모품번
	private String pathType;		// 경로유형
	private String pathCode;		// 경로코드
	private String pathName;		// 경로명
	private String proNo;			// 공정순서
	private String proCode;			// 공정코드
	private String proName;			// 공정명
	private String level;			// 레벨
	private String dispNo;			// 표시순서	
	private String partNo;			// 품번
	private String partName;		// 품명
	private String spec;			// 스펙
	private String unit;			// 단위
	private String unitName;
	private String amount;			// 소요량
	
	private boolean __created__;
	private boolean __modified__;
	
	public Bas0230VO_BOM() {
	}
	
	public Bas0230VO_BOM(Bas0230VO_BOM origin) {
		this.parentId = origin.parentId;
		this.id = origin.id;
		this.comCode = origin.comCode;
		this.facCode = origin.facCode;
		this.paPartNo = origin.paPartNo;
		this.pathType = origin.pathType;
		this.pathCode = origin.pathCode;
		this.pathName = origin.pathName;
		this.proNo = origin.proNo;
		this.proCode = origin.proCode;
		this.proName = origin.proName;
		this.level = origin.level;
		this.dispNo = origin.dispNo;
		this.partNo = origin.partNo;
		this.partName = origin.partName;
		this.spec = origin.spec;
		this.unit = origin.unit;
		this.unitName = origin.unitName;
		this.amount = origin.amount;
		this.__created__ = origin.__created__;
		this.__modified__ = origin.__modified__;
	}
}


