package thinking.in.spring.boot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(1)
@Lazy
@Slf4j
public class LogAspect {

    @Pointcut("execution(* thinking.in.spring.boot.control..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint jp) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        javax.servlet.http.HttpServletRequest request = requestAttributes.getRequest();
//        String methodName = request.getMethod();
//        log.info("{}", methodName);
//        System.out.println("aspect doBefore");
    }
}
