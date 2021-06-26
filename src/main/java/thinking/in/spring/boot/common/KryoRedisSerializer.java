package thinking.in.spring.boot.common;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import thinking.in.spring.boot.pojo.Address;
import thinking.in.spring.boot.pojo.User;

import java.io.ByteArrayOutputStream;

@Slf4j
public class KryoRedisSerializer<T> implements RedisSerializer<T> {

    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(KryoFactory::newInstance);
    private Class<T> clazz;

    public KryoRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }
        Kryo kryo = kryos.get();
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return EMPTY_BYTE_ARRAY;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        Kryo kryo = kryos.get();
        try (Input input = new Input(bytes)) {
            return (T) kryo.readClassAndObject(input);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("llight");
        user.setCode("1111");
        Address address = new Address();
        address.setLocal("aaaa");
        user.setAddress(address);
        KryoRedisSerializer<User> userKryoRedisSerializer = new KryoRedisSerializer<>(User.class);
        byte[] serialize = userKryoRedisSerializer.serialize(user);
        User deserialize = userKryoRedisSerializer.deserialize(serialize);
        System.out.println(deserialize.getAddress().getLocal());
    }
}
