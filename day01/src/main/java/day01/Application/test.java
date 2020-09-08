package day01.Application;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @Author：cqf
 * @2020/9/718:20
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 **/
public class test {
    public static void main(String[] args) {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")));
            System.out.println(bReader.readLine());
            System.out.println("---------------");
            String s = null;
            while ((s = bReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        File file = new File("1.txt");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            ServerSocket ss = new ServerSocket(801);
//            Socket socket = ss.accept();
//            BufferedReader bReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String hasread =null;
//            while((hasread=bReader.readLine())!=null) {
//                System.out.println(hasread);
//            }
//            socket.shutdownInput();
//
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("服务器内部错误"+e.getMessage());
//        }
    }
}
