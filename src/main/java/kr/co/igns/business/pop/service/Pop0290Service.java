package kr.co.igns.business.pop.service;

import java.util.List;

import javax.transaction.Transactional;

import kr.co.igns.business.pop.dao.postgre.Pop0290Dao;

import kr.co.igns.business.pop.model.Pop0290ReqDto;
import kr.co.igns.business.pop.model.Pop0290StopReqDto;
import kr.co.igns.business.pop.model.Pop0290VO;
import kr.co.igns.business.pop.model.Pop0291VO;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Pop0290Service {

	private final Pop0290Dao pop0290Dao;

	// 설비 가동 조회
	public List<Pop0290VO> getEqp0010(Pop0290ReqDto reqDto) {
		return pop0290Dao.getEqp0010(reqDto);
	}
	
	public List<Pop0290VO> getEqp0010Main(Pop0290ReqDto reqDto) {
		return pop0290Dao.getEqp0010Main(reqDto);
	}
	//스탑타임
	public List<Pop0290VO> getStopTime(Pop0290StopReqDto reqDto) {
		return pop0290Dao.getStopTime(reqDto);
	}

	// 설비 기동/비가동 수정
	@Transactional
	public int setOperating(List<Pop0290VO> voList) {
		for (Pop0290VO vo : voList) {

			if (vo.is__order__()) {
				pop0290Dao.startOperating(vo);

			} else {
				pop0290Dao.stopOperating(vo);
			}
		}
		return 0;
	}
	// 공정검사 조회
	public List<Pop0290VO> getProcess(Pop0290ReqDto reqDto) {
		return pop0290Dao.getProcess(reqDto);
	}
	
	// 공정검사저장
	@Transactional
	public int setProcess(List<Pop0291VO> voList) {
		for (Pop0291VO vo : voList) {
			if (vo.is__created__()) {
				pop0290Dao.insertProcess(vo);

			} else {
				pop0290Dao.updateProcess(vo);
			}
		}
		return 0;
	}
}
