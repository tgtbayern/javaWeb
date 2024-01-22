package JUL;

import com.sun.tools.javac.Main;

import java.util.logging.Logger;

public class test {
    public static void main(String[] args) {
        // 首先获取日志打印器
        Logger logger = Logger.getLogger(Main.class.getName());
        // 调用info来输出一个普通的信息，直接填写字符串即可
        logger.info("我是普通的日志");
    }
}
