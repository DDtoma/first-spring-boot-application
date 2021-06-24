package thinking.in.spring.boot.repository;

import thinking.in.spring.boot.pojo.User;

public interface IUserRepository {
    int saveUser(User user);
    User findUserByCode(String code);
}
