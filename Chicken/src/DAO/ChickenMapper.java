package DAO;

import java.util.ArrayList;

import VO.ChickenVO;

public interface ChickenMapper {
	
	//치킨등록
	public void insertChicken(ChickenVO vo);
	//치킨리스트 가져오기
	public ArrayList<ChickenVO> chickenList();
	//치킨삭제
	public void deleteChicken(ChickenVO vo);
}
