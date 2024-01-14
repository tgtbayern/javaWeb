package jdbc;

import java.sql.*;

public class Database {
    public static void main(String args[]){
        try(
                //创建一个连接
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","020809");
                //创建一个对象来执行sql语句
                Statement statement=connection.createStatement();
                //这两个东西都需要关闭，所以写进try里,自动关闭
           )
        {
            //存放sql执行完毕的结果，执行的是sql的DQL语句
            ResultSet resultSet=statement.executeQuery("select * from accounting_ledger.ledger");
            //打印
            while(resultSet.next()){
                //打印第二行的数据
                System.out.println(resultSet.getString(2));
            }

            //执行DML
            int i = statement.executeUpdate("INSERT INTO accounting_ledger.user VALUES ('lyx', '12345');");
            System.out.println("lines changed "+i);

            //一次执行多条语句
            statement.addBatch("INSERT INTO accounting_ledger.user VALUES ('lyx', '12345');");
            statement.addBatch("INSERT INTO accounting_ledger.user VALUES ('lyx1', '12345');");
            statement.addBatch("INSERT INTO accounting_ledger.user VALUES ('lyx2', '12345');");
            statement.addBatch("INSERT INTO accounting_ledger.user VALUES ('lyx3', '12345');");
            statement.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
