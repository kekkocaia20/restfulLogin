package springPJrestfuls.restfulLogin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer{
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
		registry.addViewController("/index").setViewName("index.html");
		registry.addViewController("/login").setViewName("login.html");
		registry.addViewController("/register").setViewName("register.html");
		registry.addViewController("/success").setViewName("success.html");
		registry.addViewController("/forgot-password").setViewName("forgot-password.html");
	}
}
