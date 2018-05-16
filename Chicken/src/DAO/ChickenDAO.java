package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.ChickenVO;

public class ChickenDAO {
	// ���̹�Ƽ�� Ŭ������ ��ü, MybatisConfig.class���� �����Ǿ� ���޵�
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// ġŲ���
	public void insertChicken(ChickenVO vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();

			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			mapper.insertChicken(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// ġŲ ����Ʈ ��������
	public ArrayList<ChickenVO> chickenList() {
		SqlSession session = null;
		ArrayList<ChickenVO> result = null;
		try {
			session = factory.openSession();

			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			result=mapper.chickenList();
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	// ġŲ ����
	public void deleteChicken(ChickenVO vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();

			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			mapper.deleteChicken(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
