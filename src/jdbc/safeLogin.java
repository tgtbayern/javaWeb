package jdbc;

import java.sql.*;
import java.util.Scanner;

public class safeLogin {
    public static void main(String args[]){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","020809");
            //?是占位符
            PreparedStatement statement = connection.prepareStatement("select * from accounting_ledger.user where username= ? and password=?;");
            Scanner scanner=new Scanner(System.in)){
            //传入的参数的位置和传入的内容
            statement.setString(1, scanner.nextLine());
            statement.setString(2, scanner.nextLine());
            System.out.println(statement);    //打印查看一下最终执行的
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                System.out.println(name+" login successfully!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
