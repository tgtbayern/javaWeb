package socket2文件传输;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket=new Socket("localhost",8080)){
            //将需要读取的文件变成可输出的流
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\86136\\projects\\IdeaProjects\\javaWeb\\src\\socket2文件传输\\text1.txt");
            //把socket的输出流和io的输出流绑定，使得io操作更方便
            OutputStream stream=socket.getOutputStream();
            //从需要读取的文件读取内容后，需要暂时存放在这个数组里
            byte[] bytes=new byte[1024];
            int i;
            //将需要读取的文件的可输出流写入数组，i表示写入的数据数量，当i==-1的时候表示什么都没有读取到
            while((i=fileInputStream.read(bytes))!=-1){
                //从数组里读取内容，写入io输出流中（也就是写入了socket的输出流）
                //0表示从0开始读取
                //i表示一次读取i位
                stream.write(bytes,0,i);
            }
            stream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
