package edu.kh.project.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		// 다운 캐스팅해서 session을 얻어 올려고 
		
		HttpServletResponse resp=(HttpServletResponse)response;
		
		
		
		HttpSession session = req.getSession();
		
		// 로그인 됐는지 안됐는지 확인 
		
		if(session.getAttribute("loginMember") == null) { // 로그인이 되어있지 않은 경우
			
			resp.sendRedirect("/loginError");
			
		}else {
			
			chain.doFilter(request, response);
			// 다음 필터 또는 컨트롤러로 이동 
			
			
		}
		
	}

}
