package thinking.in.spring.boot.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import thinking.in.spring.boot.mapper.UserMapper;
import thinking.in.spring.boot.pojo.User;
import thinking.in.spring.boot.repository.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Cacheable(sync = true, value = "user")
    @Override
    public User findUserByCode(String code) {
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda()
                .eq(User::getCode, code)
        );
        return user;
    }
}
