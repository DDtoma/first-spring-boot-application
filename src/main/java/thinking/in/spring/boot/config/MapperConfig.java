package thinking.in.spring.boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({
        "thinking.in.spring.boot.mapper"
})
public class MapperConfig {
}
