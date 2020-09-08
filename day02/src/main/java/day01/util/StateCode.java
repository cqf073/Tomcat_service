package day01.util;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/715:51
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public enum StateCode {
    OK(200, "OK"), Not_found(404, "not_found");

    private int id;
    private String msg;

    private StateCode(int id, String state) {
        this.id = id;
        this.msg = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
