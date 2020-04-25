package kr.co.mvcboard.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.mvcboard.beans.UserBean;
import kr.co.mvcboard.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Resource
	@Lazy
	private UserBean loginUserBean;
	
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
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2=userDao.getLoginUserInfo(tempLoginUserBean);
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUserLogin(true);
		}
	}
}