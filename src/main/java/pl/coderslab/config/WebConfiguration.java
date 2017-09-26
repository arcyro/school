package pl.coderslab.config;

import org.h2.server.web.WebServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

import java.util.Locale;

@Configuration
public class WebConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }



    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("pl"));
        return slr;
    }

//    @Bean
//    ServletRegistrationBean h2servletRegistration(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }
}