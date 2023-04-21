package kr.co.igns.framework.comm.model;

import lombok.*;

@Getter
@Setter
@Data
public class DashboardInfoVO {
	private String comCode;
	private String dbCode;
	private String dbName;
	private String dbUrl;
	private String autoTime;
	private String no;
	private String userFlag;
    private String makeDate;
    private String maker;
    private String editDate;
    private String editor;
}
