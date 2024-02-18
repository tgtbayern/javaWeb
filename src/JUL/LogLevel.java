package JUL;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * LogLevel 类演示了记录不同级别的日志消息，
 * 修改日志级别，使用自定义日志处理器以及将日志输出到本地文件。
 *
 * 在该类中，我们记录不同级别的日志消息，
 * 包括 SEVERE、WARNING、INFO 和 CONFIG。我们还修改了日志级别，添加了自定义的控制台处理器和文件处理器。
 *
 * 注意：为了演示日志级别的效果，我们设置了不同级别的日志消息，并修改了日志记录器的级别和处理器的级别。
 */
public class LogLevel {
    public static void main(String[] args) throws IOException {
        // 首先获取日志打印器
        Logger logger = Logger.getLogger(Main.class.getName());
        // 调用info来输出一个普通的信息，直接填写字符串即可
        logger.info("我是普通的日志");
        logger.log(Level.SEVERE, "严重的错误", new IOException("我就是错误"));
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");


        //修改日志级别
        logger.setLevel(Level.CONFIG);
        //不使用父日志处理器
        logger.setUseParentHandlers(false);
        //使用自定义日志处理器
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.CONFIG);
        logger.addHandler(handler);

        //添加输出到本地文件
        FileHandler fileHandler = new FileHandler("test.log");
        fileHandler.setLevel(Level.WARNING);
        logger.addHandler(fileHandler);

        logger.log(Level.SEVERE, "严重的错误", new IOException("我就是错误"));
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");
    }
}
