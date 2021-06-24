package thinking.in.spring.boot.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thinking.in.spring.boot.pojo.Result;

@RestController
public class IndexController {

    @GetMapping("/")
    public Result<String> index() {
        return Result.ok("hello spring");
    }
}
