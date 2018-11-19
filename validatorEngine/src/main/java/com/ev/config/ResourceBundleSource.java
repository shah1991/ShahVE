package com.ev.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Component
public class ResourceBundleSource {

	@Bean
    public LocaleResolver localeResolver() {
       SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
       sessionLocaleResolver.setDefaultLocale(Locale.US);
       return sessionLocaleResolver;
    }
    
    @Bean 
    public ResourceBundleMessageSource getSource(){
    	ResourceBundleMessageSource rs=new ResourceBundleMessageSource();
    	rs.setBasename("messages");
    	rs.setUseCodeAsDefaultMessage(true);
    	return rs;
    }
}
