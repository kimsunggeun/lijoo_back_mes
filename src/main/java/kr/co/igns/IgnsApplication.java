package kr.co.igns;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import kr.co.igns.framework.config.IgnsConfiguration;

/**
 * 
 * @ 프로젝트   	: igns
 * @ 패키지		: com.web.framework.igns
 * @ 파일명		: IgnsApplication.java
 * @ 기능명 		: 프레임워크 기본 설정
 * @ 작성자 		: 김성준
 * @ 최초생성일 	: 2020. 9. 10.
 */
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@EnableCaching
@SpringBootApplication
@Import(IgnsConfiguration.class)
@EnableScheduling

public class IgnsApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(IgnsApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(IgnsApplication.class, args);
//		String separator = File.separator;
//		new SpringApplicationBuilder(IgnsApplication.class)
//			.properties(
//						"spring.config.location=" + 
//						"optional:"+separator+"application.yml" +
//						", file:"+separator+"usr"+separator+"local"+separator+"tomcat"+separator+"application.yml"
//						)
//			.run(args);
	}
}

//war 파일 빌드시 주석제거
//public class IgnsApplication extends SpringBootServletInitializer {
//	
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(IgnsApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(IgnsApplication.class, args);
//    }
//}





