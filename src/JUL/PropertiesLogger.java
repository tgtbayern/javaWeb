package JUL;

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
/**
 * PropertiesLogger 类演示了如何通过读取自定义的日志配置文件来配置 Java 的日志记录器。
 * 在该类中，我们使用 LogManager 类读取自定义的配置文件 "Logger.properties"，然后获取日志记录器并记录日志消息。
 * 注意：通过自定义配置文件，我们可以修改日志记录器的行为，例如设置不同的日志级别。
 */
public class PropertiesLogger {
    public static void main(String[] args) throws IOException {
        //获取日志管理器
        LogManager manager = LogManager.getLogManager();
        //读取我们自己的配置文件
        manager.readConfiguration(new FileInputStream("Logger.properties"));
        //再获取日志打印器
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.WARNING, "我是一条日志信息");   //通过自定义配置文件，我们发现默认级别不再是INFO了
        logger.log(Level.SEVERE, "我是一条严重的日志信息");
    }
}
