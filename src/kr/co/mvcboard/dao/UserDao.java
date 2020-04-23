package kr.co.mvcboard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mvcboard.beans.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		return sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	public void addUserInfo(UserBean userBean) {
		sqlSessionTemplate.insert("user.addUserInfo", userBean);
	}
}