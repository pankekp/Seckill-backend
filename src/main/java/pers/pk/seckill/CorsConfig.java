package pers.pk.seckill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author panke
 * @date created in 18-8-1 下午2:35
 */

@Configuration
public class CorsConfig {

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 允许任何域名使用
//        corsConfiguration.addAllowedOrigin("http://localhost:4200");
//        // 允许任何头
//        corsConfiguration.addAllowedHeader("*");
//        // 允许任何方法
//        corsConfiguration.addAllowedMethod("*");
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }
}
