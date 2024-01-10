import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //if you run on your own computer, then you can use "localhost"
        //if you run in the local area network(LAN), use "ipconfig" to see your source
        try(Socket socket = new Socket("localhost",8080);
            Scanner scanner=new Scanner(System.in)){ //Scanner also need to close, so write scanner in try block

            // setKeepAlive(true) 是 Socket 类的一个方法，用于设置 TCP 连接的保持活动状态（keep-alive）。
            // 当启用 TCP 连接保持活动状态时，系统将定期发送小的探测数据包（keep-alive 消息）到远程主机，以确保连接仍然保持活跃。
            socket.setKeepAlive(true);
            //here we use construct method to connect to the server
            // but if we want to connect manually
            // we can use connect method(the following line is not necessary)
            socket.connect(new InetSocketAddress("localhost",8080),1000);

            System.out.println("Already connected to the server!");
            System.out.println("write something that I can send to server:");
            //this is a convert stream
            // it is more convenient than socket.getOutputStream()
            OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());
            writer.write(scanner.nextLine()+"\n");
            //flush and client will send it to server
            writer.flush();
            //here is the same way as Server, "socket" should close and I write it in try block
            System.out.println("data already sent");



            //这行代码创建了一个BufferedReader对象，该对象连接到给定的套接字（socket1）的输入流
            // 以便以字符流的方式从套接字中读取数据B
            //其实InputStreamReader就已经可以接收到数据了，但是不好打印
            //所以我们又嵌套了一层BufferedReader
            //因为输入的时候不需要打印，所以直接用OutputStreamWriter就行，少了一层嵌套
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("data sent form server "+reader.readLine());
        }catch(IOException e){
            System.out.println("fail to connect to server");
            e.printStackTrace();
        }
    }
}