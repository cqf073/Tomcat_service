package day01.Application;

import day01.pojo.Request;
import day01.pojo.Response;
import day01.util.FileTypeUtil;
import day01.util.StateCode;
import day01.util.poolAction;
import day01.util.socketto;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/717:22
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public class Application {
    public static void main(String[] args) throws IOException {
        //创建服务端
        ServerSocket serverSocket = new ServerSocket(9999);
        ExecutorService Threadpool = Executors.newCachedThreadPool();
        Request request = null;
        while (true) {
            Socket socket = serverSocket.accept();
            //把socket转为对象
            request = socketto.gterequse(socket);
            String filename1 = request.getRequestresourse();///1.txt
            Response response = new Response();
            String filename = filename1.substring(1);
            System.out.println("filename" + filename + "&&&&&&&&");
            File file = new File(filename);
            if (file.exists()) {
                response.setStateCode(StateCode.OK);
            } else {
                response.setStateCode(StateCode.Not_found);
            }
            String suff = filename.substring(filename.lastIndexOf(".") + 1);
            response.getMap().put("ContentType: ", FileTypeUtil.map.get(suff));
//            System.out.println(response.toString());
//            System.out.println(request.toString());
//            System.out.println("--------"+suff);
            //多线程处理对象
            poolAction.getThread(Threadpool, response, socket, filename);

        }

    }
}
