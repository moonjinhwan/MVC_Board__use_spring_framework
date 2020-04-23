package kr.co.mvcboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mvcboard.beans.UserBean;
import kr.co.mvcboard.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean checkuserIdExist(String user_id) {
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		}else {
			return false;
		}
	}
	public void addUserInfo(UserBean userBean) {
		userDao.addUserInfo(userBean);
	}
}