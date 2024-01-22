package Mybatis.annotation;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;


public class MyBatisUtil1 {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try{
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(new FileInputStream("C:\\Users\\86136\\projects\\IdeaProjects\\javaWeb\\src\\Mybatis\\annotation\\configuration.xml"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 获取一个新的会话
     * @param autoCommit 是否开启自动提交（跟JDBC是一样的，如果不自动提交，则会变成事务操作）
     * @return SqlSession对象
     */
    public static SqlSession getSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }
}
