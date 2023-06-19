package com.springlec.base.dao.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.main.NDProductListDto;

public class NDMainDaoImpl implements NDMainDao {
	
	
	SqlSession sqlSession;//DB와 상호작용하는 MyBatis의 객체.
	public static String namespace = "com.springlec.base.dao.main.NDMainDao";//namespace변수 선언
	

	//NDProductDaoImpl은 'listDao()메서드를 오버라이딩을 통해 구현한다.
	//SqlSession객체의 selectList()메서드를 호출해 MyBatis매퍼파일인 xml파일에서 정의한 SQL쿼리 실행, 결과를 List<NDProductDto>형태로 반환.
	@Override
	public List<NDProductListDto> NDTakeAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDMainDao");
	}
	
	// 	이 클래스를 사용하려면 NDProductDao의 인터페이스를 참조해 객체를 생성하고 메서드를 호출하면 된다. 
}
