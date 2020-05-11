package kr.co.mvcboard.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.mvcboard.beans.ContentBean;
import kr.co.mvcboard.beans.UserBean;
import kr.co.mvcboard.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		
		ContentBean contentbean =  boardService.getContentInfo(content_idx);
		if(contentbean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/board/not_writer");
			return false;
		}
		return true;
	}
}
