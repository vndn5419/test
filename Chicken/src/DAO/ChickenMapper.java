package DAO;

import java.util.ArrayList;

import VO.ChickenVO;

public interface ChickenMapper {
	
	//ġŲ���
	public void insertChicken(ChickenVO vo);
	//ġŲ����Ʈ ��������
	public ArrayList<ChickenVO> chickenList();
	//ġŲ����
	public void deleteChicken(ChickenVO vo);
}
