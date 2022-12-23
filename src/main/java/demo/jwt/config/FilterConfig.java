package demo.jwt.config;

import demo.jwt.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);

        //provide endpoints which needs to be restricted.
        //All Endpoints would be restricted if unspecified
        filter.addUrlPatterns(
                "/api/v1/blog/restricted"
                //"/api/v1/hello-hello"
        );
        //filter.addUrlPatterns("/api/v1/*");


        return filter;
    }
}
