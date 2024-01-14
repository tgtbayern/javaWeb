package Mybatis;

import lombok.Data;

@Data
//这里的@Data注释表明：在编译时，lombok框架会自动将这个类重新编译，
// 添加一些常用方法，如 toString、equals、hashCode、以及所有字段的 getter 和 setter 方法。
public class User {
    String username;//名称最好和数据库字段名称保持一致，不然可能会映射失败导致查询结果丢失
    String password;
}
