package JUL;

import lombok.extern.java.Log;
/**
 * LombokLog 类演示了如何使用 Lombok 提供的 @Log 注解来简化日志记录功能。
 * 通过使用 @Log 注解，Lombok 自动生成了一个名为 log 的 Logger 对象，使日志记录更加简洁。
 * 注意：在使用 @Log 注解时，我们无需手动创建 Logger 对象，Lombok 会自动为我们生成。
 */
@Log
public class LombokLog {
    public static void main(String[] args) {
        System.out.println("自动生成的Logger名称："+log.getName());
        log.info("我是日志信息");
    }
}
