package DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.EggVO;

public class EggDAO {

	// ���̹�Ƽ�� Ŭ������ ��ü, MybatisConfig.class���� �����Ǿ� ���޵�
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// ��� ���
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
