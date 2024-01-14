package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public static void main(String args[]){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","020809");
            Statement statement=connection.createStatement();
            Scanner scanner=new Scanner(System.in);){
            ResultSet resultSet = statement.executeQuery("select * from accounting_ledger.user where username='"+scanner.nextLine()+"'and password='"+scanner.nextLine()+"';");
            while(resultSet.next()){
                String name = resultSet.getString(1);
                System.out.println(name+"login successfully!");
                }
            }catch(Exception e){
            e.printStackTrace();
        }
    }
}
