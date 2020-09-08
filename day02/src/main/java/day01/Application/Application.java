package day01.Application;

import day01.pojo.Request;
import day01.pojo.Response;
import day01.util.*;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
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

/***
 * http://127.0.0.1:9999/1.html ?user=1213&pwd=123
 */
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
            Map<String,String> infoClient= new HashMap<>();
//            user=15101234374&pwd=123
            Map<String,String> infoserver= new HashMap<>();
            infoserver.put("user", "15101234374");
            infoserver.put("pwd","123" );

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
            if (filename1.contains("?")){
                //filename为http://localhost:9999/1.html?user=15101234374&pwd=123
                String checkString = filename1.substring(filename1.indexOf("?")+1);
                String[] split = checkString.split("&");
                for (String s:split) {
                    String[] split1 = s.split("=");
                    infoClient.put(split1[0],split1[1]);
                }
                if (infoClient.equals(infoserver)){
                    poolAction2.getThread(Threadpool,response,socket ,filename );
                }
            }
            poolAction.getThread(Threadpool, response, socket, filename);

        }

    }
}
