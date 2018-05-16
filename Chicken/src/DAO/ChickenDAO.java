package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.ChickenVO;

public class ChickenDAO {
	// 마이바티스 클래스의 객체, MybatisConfig.class에서 생성되어 전달됨
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 치킨등록
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
	
	// 치킨 리스트 가져오기
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
	
	// 치킨 삭제
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
