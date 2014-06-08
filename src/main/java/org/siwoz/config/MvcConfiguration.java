package org.siwoz.config;

import org.siwoz.service.calendar.CalendarManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "org.siwoz")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource("classpath:/spring_security.xml")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/siwoz");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("password");
		return driverManagerDataSource;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/src/main/resources/**")
				.addResourceLocations("/src/main/resources/");
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

//	@Bean(name = "calendarManager")
//	public CalendarManager calendarManager() {
//		CalendarManager calendarManager = new CalendarManager();
//		calendarManager.connect();
//		return calendarManager;
//	}
}
