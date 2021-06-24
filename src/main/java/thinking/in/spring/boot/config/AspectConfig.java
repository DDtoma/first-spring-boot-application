package thinking.in.spring.boot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@ComponentScan({
        "thinking.in.spring.boot.aspect"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {
}
