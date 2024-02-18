package JUL;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * LogFilter 类演示了如何使用 Java 的日志记录 API 来根据自定义条件过滤日志消息。
 * 它设置了一个 Logger 对象，并应用了一个过滤器来排除包含"普通"字样的日志消息。
 * 该类记录不同级别的消息：SEVERE、WARNING 和 INFO，展示了过滤器的工作原理。
 * SEVERE 和 WARNING 消息会被记录，而包含"普通"的 INFO 消息会被过滤掉。
 */
public class LogFilter {
    public static void main(String[] args) throws IOException {
        // 获取 Logger 对象，与 Main 类相关联
        Logger logger = Logger.getLogger(Main.class.getName());

        // 自定义过滤规则，只记录消息不包含"普通"的日志记录
        logger.setFilter(record -> !record.getMessage().contains("普通"));

        // 记录严重级别的日志，附带异常信息
        logger.log(Level.SEVERE, "严重的错误", new IOException("我就是错误"));

        // 记录警告级别的日志
        logger.log(Level.WARNING, "警告的内容");

        // 记录信息级别的日志，由于过滤规则，不会记录包含"普通"的日志信息
        logger.log(Level.INFO, "普通的信息");
    }
}
