package kr.co.igns.business.sales.model.sal0110;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Bas0081VO {
	@JsonProperty("comCode")
	private String comCode;
	@JsonProperty("facCode")
	private String facCode;
	@JsonProperty("workDate")
	private String workDate;
	@JsonProperty("week")
	private String week;
	@JsonProperty("holiType")
	private String holiType;
}
