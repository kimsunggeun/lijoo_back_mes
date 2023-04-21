package kr.co.igns.business.baseInfo.bas0220.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.igns.business.baseInfo.bas0220.model.Bas0220Dto;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_ITEM;
import kr.co.igns.business.baseInfo.bas0220.model.Bas0220VO_BOM;

@Mapper
public interface Bas0220Dao {
	//품목선택 조회
	List<Bas0220VO_ITEM> getItemSelect(Bas0220Dto dto);
	//BOM 정전개
	List<Bas0220VO_BOM> getBomExplosion(Bas0220Dto dto);

}
