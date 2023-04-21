package kr.co.igns.framework.comm.model;

import lombok.*;

@Getter
@Setter
@Data
public class MenuStatisticsVO {
	private int id;
	private String comCode;
	private String cnntDate;
	private String userId;
	private String userName;
	private String menuCode;
	private String menuName;
	private int cnntCnt;
	private String insertDate;
	private String updateDate;
}
                   