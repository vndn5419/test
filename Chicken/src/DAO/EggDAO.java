package DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.EggVO;

public class EggDAO {

	// 마이바티스 클래스의 객체, MybatisConfig.class에서 생성되어 전달됨
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 계란 등록
	public void insertEgg(EggVO vo) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();

			EggMapper mapper = session.getMapper(EggMapper.class);
			mapper.insertEgg(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
