package day01.util;

import day01.pojo.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/717:24
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public class socketto {
    public static Request gterequse(Socket socket) throws IOException {
        Request request = new Request();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String[] split = bReader.readLine().split(" ");
//        System.out.println(Arrays.toString(split));
        request.setRequestMethod(split[0]);
        request.setRequestresourse(split[1]);
//        System.out.println(request.getRequestresourse());
//        System.out.println(request.getRequestMethod());
//        String hasread =null;
//        while((hasread=bReader.readLine())!=null) {
//            String[] split1 = hasread.split(": ");
//            request.getRequestMap().put(split1[0],split1[1]);
//            System.out.println("----------------");
//        }

        socket.shutdownInput();
        return request;
    }
}
