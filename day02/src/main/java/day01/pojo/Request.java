package day01.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/715:41
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
@Data
public class Request implements Serializable {

    //设置请求方式
    private String requestMethod;
    //获取请求的资源
    private String requestresourse;
    //存放请求的电脑的信息


}
