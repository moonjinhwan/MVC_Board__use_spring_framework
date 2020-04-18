package kr.co.mvcboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mvcboard.beans.BoardInfoBean;
import kr.co.mvcboard.dao.TopMenuDao;

@Repository
public class TopMenuService {
	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
		return topMenuList;
	}
}
