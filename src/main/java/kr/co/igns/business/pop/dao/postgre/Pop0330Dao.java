package kr.co.igns.business.pop.dao.postgre;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.igns.business.pop.model.Pop0330Dto;
import kr.co.igns.business.pop.model.Pop0330PopUpVO;
import kr.co.igns.business.pop.model.Pop0330VO;


@Mapper
public interface Pop0330Dao {
	 List<Pop0330VO> getPop0330(Pop0330Dto dto);
	 
	 List<Pop0330PopUpVO>getPopup0330(Pop0330Dto dto);
	
}
