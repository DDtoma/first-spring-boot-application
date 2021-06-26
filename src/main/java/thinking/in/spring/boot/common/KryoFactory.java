package thinking.in.spring.boot.common;

import com.esotericsoftware.kryo.Kryo;
import thinking.in.spring.boot.pojo.Address;
import thinking.in.spring.boot.pojo.User;

public class KryoFactory {
    public static Kryo newInstance() {
        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
        kryo.register(User.class);
        kryo.register(Address.class);
        return kryo;
    }
}
