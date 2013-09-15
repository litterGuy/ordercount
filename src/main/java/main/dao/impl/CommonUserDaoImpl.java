package main.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.dao.CommonUserDao;
import main.model.CommonUser;

@Repository
public class CommonUserDaoImpl implements CommonUserDao {
	
	private final String USER_LOGIN = "userLogin";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public CommonUser userLogin(CommonUser commonuser) {
		return sqlSessionTemplate.selectOne(USER_LOGIN, commonuser);
	}

}
