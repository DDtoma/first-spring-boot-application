package thinking.in.spring.boot.control;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import thinking.in.spring.boot.pojo.Result;
import thinking.in.spring.boot.pojo.User;
import thinking.in.spring.boot.repository.IUserRepository;


@RestController("/user")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/{code}")
    public Mono<Result<User>> user(@PathVariable("code") String code) {
        User user = userRepository.findUserByCode(code);
        return Mono.just(Result.ok(user));
    }

    @PostMapping("/add")
    public Result<String> addUser(@RequestBody User user) {
        user.setCode(IdUtil.simpleUUID());
        userRepository.saveUser(user);
        return Result.ok();
    }
}
