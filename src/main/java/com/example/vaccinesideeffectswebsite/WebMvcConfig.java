package com.example.vaccinesideeffectswebsite;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.vaccinesideeffectswebsite"})
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/js/**"})
                .addResourceLocations(new String[]{"classpath:/static/js/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/css/**"})
                .addResourceLocations(new String[]{"classpath:/static/css/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/vendor/**"})
                .addResourceLocations(new String[]{"classpath:/static/vendor/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/icons/**"})
                .addResourceLocations(new String[]{"classpath:/static/icons/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/images/**"})
                .addResourceLocations(new String[]{"classpath:/static/images/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/xml/**"})
                .addResourceLocations(new String[]{"classpath:/static/xml/"})
                .setCachePeriod(Integer.valueOf(20));



        registry.addResourceHandler(new String[]{"/demo/**"})
                .addResourceLocations(new String[]{"classpath:/static/demo/"})
                .setCachePeriod(Integer.valueOf(20));
    }
}