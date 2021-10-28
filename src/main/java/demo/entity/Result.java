package demo.entity;

/**
 * Result
 *
 * @author duanwei
 * @date 2020/8/27 10:12
 */
public class Result<T> {

    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.setStatus(200);
        result.setMsg("SUCCESS");
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail(int status, String msg) {
        Result<T> result = new Result<T>();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<T>();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }

    public boolean isSuccess() {
        return this.status == 200;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}