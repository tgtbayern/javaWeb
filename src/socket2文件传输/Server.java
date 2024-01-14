package socket2文件传输;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//public class Server {
//    public static void main(String args[]){
//        try(ServerSocket server = new ServerSocket(8080);) {
//            Socket socket=server.accept();
//            InputStream inStream=socket.getInputStream();
//            FileOutputStream outStream=new FileOutputStream("C:\\Users\\86136\\projects\\IdeaProjects\\javaWeb\\src\\socket2文件传输\\text2.txt");
//            byte[] bytes=new byte[1024];
//            int i;
//            while((i=inStream.read(bytes))!=-1){
//                outStream.write(bytes,0,i);
//            }
//            outStream.flush();
//            outStream.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//}
//


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {
        try (ServerSocket server = new ServerSocket(8080)) {
            Socket socket = server.accept();
            InputStream inStream = socket.getInputStream();

            try (FileOutputStream outStream = new FileOutputStream("C:\\Users\\86136\\projects\\IdeaProjects\\javaWeb\\src\\socket2文件传输\\text2.txt")) {
                // Use transferTo to transfer data directly from input stream to output stream
                inStream.transferTo(outStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
