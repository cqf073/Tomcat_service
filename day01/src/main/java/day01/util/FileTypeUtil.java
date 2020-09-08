package day01.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/717:00
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public class FileTypeUtil {
    public static Map<String, String> map = null;

    static {
        map = new HashMap<>();
        map.put("txt", "text/html,charset =utf-8");
        map.put("html", "text/html,charset =utf-8");
        map.put("jpg", "image/jpeg,charset =utf-8");
        map.put("pdf", "application/pdf,charset =utf-8");
        map.put("png", "image/png,charset =utf-8");


    }

}
