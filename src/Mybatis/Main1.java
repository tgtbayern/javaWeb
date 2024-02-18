package Mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * 我们已经配置好了myBatis，当我们希望使用myBatis的时候，
 * 我们就会创建一个SqlSessionFactory类，在这个类里使用myBatis的各种功能。
 * 目前这个类无法使用，因为已经把selectUser方法移到了UserMapper.xml中，需要通过和UserMapper.xml对应的接口才能调用
 */
public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        //寻找配置文件,参数就是配置文件的路径，这里是相对路径
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(new FileInputStream("myBatis_config.xml"));

        //sqlSession就像之前的statement一样，创建一个连接，执行sql语句，它也需要关闭，所以写进try
        //参数true代表开启自动提交，如果不自动提交，就类似与之前说的mysql的事务模式
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){

            //这里的参数是mapper里指定的那个sql语句的名称
            //也就是UserMapper.xml里的id字段的名称
            List<User> student = sqlSession.selectList("selectUser");

            //这行代码使用了 Java 8 引入的新特性之一，称为方法引用（Method Reference）。
            // 具体来说，System.out::println 是一个静态方法引用，用于将 println 方法关联到 System.out 对象上。
            //在这里，System.out::println 等效于 lambda 表达式 (s) -> System.out.println(s)。
            // 它表示将遍历 student 集合的每个元素，并将每个元素传递给 System.out.println 方法，实现在控制台上打印每个元素的效果。
            student.forEach(System.out::println);
        }
    }
}
