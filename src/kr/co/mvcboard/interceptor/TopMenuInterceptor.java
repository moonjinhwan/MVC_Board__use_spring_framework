package kr.co.mvcboard.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.mvcboard.beans.BoardInfoBean;
import kr.co.mvcboard.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	@Autowired
	private TopMenuService topMenuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		return true;
	}
}
