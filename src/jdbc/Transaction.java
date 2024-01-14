package jdbc;
//数据库的事务
import java.sql.*;

public class Transaction {
    public  static void main(String args[]){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","020809");
            Statement statement=connection.createStatement()){
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO accounting_ledger.user VALUES ('lyx', '12345');");
            //设置回滚点
            Savepoint savepoint=connection.setSavepoint();
            statement.executeUpdate("INSERT INTO accounting_ledger.user VALUES ('lyx1', '12345');");
            statement.executeUpdate("INSERT INTO accounting_ledger.user VALUES ('lyx2', '12345');");

            //将会回滚到第一条sql语句执行后
            connection.rollback(savepoint);
            //提交事务，只会执行第一条sql语句
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
