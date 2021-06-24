package thinking.in.spring.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import thinking.in.spring.boot.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity thinking.in.spring.boot.pojo.User
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}