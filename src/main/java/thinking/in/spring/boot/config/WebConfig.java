package thinking.in.spring.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * WebConfig
 */
@Configuration
@EnableWebFlux
@ComponentScan(basePackages = {
        "thinking.in.spring.boot.control"
})
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("https://llight.me")
                .allowedMethods("PUT", "DELETE", "GET", "POST").allowCredentials(true).maxAge(3600);
    }
}
