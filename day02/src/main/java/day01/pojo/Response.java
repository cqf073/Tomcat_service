package day01.pojo;

import day01.util.StateCode;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/715:42
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
@Data
public class Response implements Serializable {
    //响应头
    private String argement = "HTTP/1.1";
    //状态码
    private StateCode stateCode;
    //响应体的封装
    private Map<String, String> map = new HashMap<>();


}
