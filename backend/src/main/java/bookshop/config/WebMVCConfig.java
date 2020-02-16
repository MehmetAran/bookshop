package bookshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer{
private final long MAX_AGE_SECS = 3600;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
         .allowedOrigins("*")
         .allowedMethods("*")
         .maxAge(MAX_AGE_SECS);
    }

}
