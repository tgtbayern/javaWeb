package JUL;
/**
 * MybatisLogger 类演示了如何使用 Java Util Logging（JUL）来记录 MyBatis 框架的日志。
 * 在该类中，我们使用 JUL 记录 MyBatis 操作的日志。通过读取配置文件 "mybatisLogger.properties" 来配置日志记录器。
 * mybatisLogger.properties设置了mybatis日志的默认输出级别
 * 注意：为了使用 JUL 记录 MyBatis 的日志，我们需要在 MyBatis 的配置文件中指定日志实现为 JUL。(mybatis_config.xml的settings)
 */

import Mybatis.Mapper.UserMapper;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

@Log
public class MybatisLogger {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 在每个测试方法之前执行，用于初始化 SqlSessionFactory 和配置日志记录器。
     */
    @Before
    public void before()  {
        try {
            // 从 mybatis_config.xml 文件中构建 SqlSessionFactory
            // 也可以用一个类来包装这个SqlSessionFactory，详见Mapper.Main2
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis_config.xml"));

            // 读取并配置日志记录器
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(new FileInputStream("mybatisLogger.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试方法，用于执行 MyBatis 操作并记录日志。
     */
    @Test
    public void test(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 获取 UserMapper 接口的实例
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 记录查询用户信息的日志
            log.info(mapper.selectUser().toString());
            log.info(mapper.selectUser().toString());
        }
    }
}
