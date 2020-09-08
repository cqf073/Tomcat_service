package day01.util;

import day01.pojo.Response;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/718:06
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public class poolAction2 {
    public static void getThread(ExecutorService Threadpool, Response response, Socket socket, String filename) {
        Threadpool.execute(() -> {
            try {
                StringBuffer stringBuffer = null;
                String contexttype = null;
                BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());

                //System.out.println(filename);
                bf.write((response.getArgement() + " ").getBytes());
                bf.write((StateCode.OK.getId() + " " + response.getStateCode().toString() + "\r\n").getBytes());
//                Set<Map.Entry<String, String>> entries = response.getMap().entrySet();
//                for (Map.Entry e : entries
//                        ) {
//                    contexttype = e.getValue() + " " + e.getValue() + "\r\n";
//                }
                bf.write("ContextType= text/html,charset =utf-8\r\n".getBytes());
                bf.write("\r\n".getBytes());
                bf.write("successful login".getBytes() );
//                FileInputStream fileInputStream = new FileInputStream(filename);
//                byte[] bytes = new byte[1024];
//                int hasread = -1;
//                while ((hasread = fileInputStream.read(bytes)) != -1) {
//                    bf.write(bytes, 0, hasread);
//                }
               // fileInputStream.close();
                bf.flush();
              //  fileInputStream.close();
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
