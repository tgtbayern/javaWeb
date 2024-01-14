package socket3_browser_to_socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]){
        try(ServerSocket socket=new ServerSocket(8080)){
            System.out.println("waiting for client...");
            Socket socket1=socket.accept();
            System.out.println("already connected, ip address:"+socket1.getInetAddress().getHostAddress());
            InputStream inputStream=socket1.getInputStream();
            System.out.println("data received:");

            //BufferedReader是Reader类的装饰器，用于缓冲字符输入。它提供了缓冲功能，可以一次读取多个字符，以提高读取性能。
            //InputStreamReader是Reader类的子类，它是用于读取字符流的桥梁，将字节流转换为字符流。
            //InputStream是用于读取字节流的抽象类。它是所有字节输入流类的父类。
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            //如果读到的字符串不为空，就打印。为空，则跳出循环
            while(!((line=bufferedReader.readLine()).isEmpty())){
                System.out.println(line);
            }
            OutputStreamWriter writer=new OutputStreamWriter(socket1.getOutputStream());

            //"HTTP/1.1 200 Accepted\r\n" 是 HTTP 协议中的响应头。
            //"HTTP/1.1" 表示使用的是 HTTP 1.1 版本。
            //"200" 是响应状态码，表示请求被成功处理。
            //"Accepted" 是状态码的描述，表示请求已被接受。
            //最后的 "\r\n" 是回车和换行符，表示行结束符，HTTP 协议要求在头部信息的每一行末尾使用这个组合。
            writer.write("HTTP/1.1 200 Accepted\r\n");

            //在响应头写完后一定要再换行才能写我们的响应体（在浏览器上展示的部分）
            writer.write("\r\n");
            //响应的内容
            writer.write("lyjnb");
            writer.flush();
            socket1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
