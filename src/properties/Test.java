package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Test 类演示了如何使用 Properties 类来读取和操作属性文件。
 * 在该类中，我们创建了一个 Properties 对象，并使用 load() 方法从配置文件 "test.properties" 中读取属性。
 * 然后，我们打印了整个 Properties 对象以及特定属性的值，并演示了如何向 Properties 对象添加新的键值对，并将其输出到 System.out。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        // 创建一个 Properties 对象
        Properties properties = new Properties();

        // 读取配置文件 "test.properties"
        properties.load(new FileInputStream("test.properties"));

        // 打印整个 Properties 对象
        System.out.println("Properties Contents: " + properties);

        // 获取并打印属性 "name" 的值
        System.out.println("Value of 'name' property: " + properties.getProperty("name"));

        // 获取属性 "xname" 的值，如果不存在则打印默认值 "xxx"
        System.out.println("Value of 'xname' property (default: 'xxx'): " + properties.getProperty("xname", "xxx"));

        System.out.println();
        // 添加一个键值对到 Properties 对象
        properties.put("Key", "Value");

        // 打印更新后的 Properties 对象
        System.out.println("Updated Properties Contents: " + properties);

        // 将 Properties 对象输出到 System.out，同时添加注释 "this is properties"
        properties.store(System.out, "this is properties");
    }
}
