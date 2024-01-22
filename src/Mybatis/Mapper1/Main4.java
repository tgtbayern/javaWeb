package Mybatis.Mapper1;

import Mybatis.Mapper.MyBatisUtil;
import Mybatis.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String args[]){
        //用MyBatisUtil来包装之前Main1的工厂类，更简单地得到连接
        try(SqlSession sqlSession = MyBatisUtil.getSession(true)){
            //获取接口的实现类
            UserMapper testMapper = sqlSession.getMapper(UserMapper.class);
            //通过接口来实现sql语句
            List<User> user = testMapper.selectUser();

            //这行代码使用了 Java 8 引入的新特性之一，称为方法引用（Method Reference）。
            // 具体来说，System.out::println 是一个静态方法引用，用于将 println 方法关联到 System.out 对象上。
            //在这里，System.out::println 等效于 lambda 表达式 (s) -> System.out.println(s)。
            // 它表示将遍历 student 集合的每个元素，并将每个元素传递给 System.out.println 方法，实现在控制台上打印每个元素的效果。
            user.forEach(System.out::println);
        }
    }
}
