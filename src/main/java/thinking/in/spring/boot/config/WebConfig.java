package thinking.in.spring.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * WebConfig
 */
@Configuration
@ComponentScan(basePackages = {
        "thinking.in.spring.boot.control"
})
public class WebConfig {
}
