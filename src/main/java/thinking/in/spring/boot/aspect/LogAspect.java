package thinking.in.spring.boot.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspect {

    @Pointcut("execution(* thinking.in.spring.boot.control..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        javax.servlet.http.HttpServletRequest request = requestAttributes.getRequest();
        String methodName = request.getMethod();
        Object[] args = jp.getArgs();
        log.info("\n{}: {}\nargs: {}", methodName, request.getRequestURI(), JSONUtil.toJsonStr(args));
    }
}
