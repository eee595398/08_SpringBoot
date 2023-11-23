package edu.kh.project.common.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

@Component
public class ChattingHandshakeInterceptor implements HandshakeInterceptor {

	// WebSockeHandler가 동작하기 전
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		if(request instanceof ServletServerHttpRequest) {
			
			//ServerHttpRequest 얘가 ServletServerHttpRequest의 부모고
			// 맞는지 확인하는 작업 
			ServletServerHttpRequest servletRequest =(ServletServerHttpRequest)request;
			
			// 웹 소켓에 접속한 클라이언의 세션을 얻어옴
			HttpSession session =   servletRequest.getServletRequest().getSession();
			
			//Map<String, Object> attributes getServletRequest().getSession();
			// WebSocketHandler의 WebSocketSession에 담을 내용 값을 세팅하는 Map
			
			attributes.put("session", session);
			
		}
		
		
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}

}
