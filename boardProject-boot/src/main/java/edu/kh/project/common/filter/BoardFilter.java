package edu.kh.project.common.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		// 다운 캐스팅해서 session을 얻어 올려고 
		
		// /board/1  스필릿 사용하면? -> {"","board","1"} 공백 포함해서 나옴
		// /board2/1/insert
		// /board2/1/update
		
		// getRequestURI() : /board2/1/update 형식으로 요청주소가 온다
		String[] arr=req.getRequestURI().split("/");
		
		try {
			
			String boardCode = arr[2];
			
			// boardtyintersector에서 만든걸 가져와서 다운캐스팅해서  
			List<Map<String, Object>> boardTypeList
			= (List<Map<String, Object>>)(req.getServletContext().getAttribute("boardTypeList"));
			
			for(Map <String,Object> boardType : boardTypeList) {
				
				
				//여기서 BOARD_CODE는 int가 아니라 bigInteger임
				// 다시 int로 바뀌기 어려워 "" 사용해 String 형태로 만들어 비교함
				// 그리고 그걸 boarName에 다시 세팅함
				if((boardType.get("BOARD_CODE") + "").equals(boardCode)) {
					req.setAttribute("boardName", boardType.get("BOARD_NAME"));
				}
			}

			
			 
		}catch (Exception e) {}
		
	
		chain.doFilter(request, response);

		
	}

}
