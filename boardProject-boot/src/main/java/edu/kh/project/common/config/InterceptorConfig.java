package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		
		return new BoardTypeInterceptor();
		// bean 등록 
	}
	
	
//	@Bean
//	public BoardTypeInterceptor boardTypeInterceptor() {
//		
//		return new BoardTypeInterceptor();
//		// bean 등록 
//	}

	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(boardTypeInterceptor ())
		// 웹에서 사용할 수 있게 등록
		
		.addPathPatterns("/**") // 가로책 경로 지정(여러개 작성시 ,로 구분)
		.excludePathPatterns("/css/**", "/images/**", "/js/**"); // 가로채지 않을 경로 
		// css,images,js는 가로채지 않아도 되기 때문
		
		
//		registry.addInterceptor(다른인터셉터 ())
//		 추가할 경우 이런식으로 등록 가능 
//		
	
		
	}
	
	
	
}
