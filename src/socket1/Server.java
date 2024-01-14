package socket1;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String args[]){
        try(ServerSocket server = new ServerSocket(8080);) {
            //accept() will block the thread until the clint send a request
            // accept() will return a socket represent the client
            System.out.println("connecting...");

            while (true){
                //这里接受的并不是唯一的客户端，任何多个客户端都可以通过8080端口连接服务器
                Socket socket1=server.accept();
                //如果通过 socket1 的"输入流"进行读取时，在 3 秒内没有可读取的数据，将抛出 SocketTimeoutException 异常。
                //socket1.setSoTimeout(3000);
                System.out.println("IP address:"+socket1.getInetAddress().getHostAddress());
                System.out.println("reading data...");
                //这行代码创建了一个BufferedReader对象，该对象连接到给定的套接字（socket1）的输入流
                // 以便以字符流的方式从套接字中读取数据B
                BufferedReader reader=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                //socket need to close and did not write in try block
                //so need to close here
                String str=reader.readLine();
                System.out.println(str);


                // 这行代码创建了一个OutputStreamWriter对象，该对象连接到给定的套接字（socket）的输出流
                // 以便将字符数据写入该套接字，所以我可以向OutputStreamWriter写入数据
                // 写的数据会被放到套接字（socket）的输出流。
                OutputStreamWriter writer=new OutputStreamWriter(socket1.getOutputStream());
                writer.write("as a client, you have sent "+str);
                writer.flush();
                socket1.close();
            }
            //If you do not close the server, the port will be occupied and you are not able to use the port
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}