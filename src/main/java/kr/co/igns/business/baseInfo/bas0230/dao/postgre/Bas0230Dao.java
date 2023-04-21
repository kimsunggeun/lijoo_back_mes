package kr.co.igns.business.baseInfo.bas0230.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0230.model.Bas0230Dto;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_BOM;
import kr.co.igns.business.baseInfo.bas0230.model.Bas0230VO_ITEM;

@Mapper
public interface Bas0230Dao {
	//품목선택
	List<Bas0230VO_ITEM> getItemSelect(Bas0230Dto dto);
	//BOM 역전개
	List<Bas0230VO_BOM> getBomImplosion(Bas0230Dto dto);

}
