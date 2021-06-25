package thinking.in.spring.boot.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // KryoRedisSerializer 替换默认序列化
        KryoRedisSerializer kryoRedisSerializer = new KryoRedisSerializer(Object.class);
        redisTemplate.setValueSerializer(kryoRedisSerializer);
        redisTemplate.setKeySerializer(kryoRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
