package thinking.in.spring.boot.pojo;

import lombok.Data;

@Data
public class Result<T> {
    public String message;
    public T data;

    public static Result<String> ok() {
        Result<String> result = new Result<>();
        result.setData("success");
        result.setMessage("success");
        return result;
    }

    public static <T> Result<T> ok(T t) {
        Result<T> objectResult = new Result<>();
        objectResult.setMessage("success");
        objectResult.setData(t);
        return objectResult;
    }
}
