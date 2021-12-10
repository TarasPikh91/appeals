package com.appeals.appeals.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

   @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
       CookieLocaleResolver resolver = new CookieLocaleResolver();
       resolver.setCookieDomain("cookie_lang");
       resolver.setCookieMaxAge(3600);
       return resolver;
   }

   @Bean(name = "messageSource")
   public MessageSource getMessageSource() {
       ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
       source.setBasename("classpath:i18n/messages");
       source.setDefaultEncoding("UTF-8");
       return source;
   }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
       localeChangeInterceptor.setParamName("lang");
       registry.addInterceptor(localeChangeInterceptor);
    }
}
