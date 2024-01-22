在这个包里，Main2通过MyBatisUtil重新封装了Main的工厂类，简化了操作

Main3在Main2的基础上，通过将UserMapperWithInterface.xml和接口绑定，实现了从接口用抽象方法完成由sql到java类的映射

同时由于在myBatis_config.xml中加入了
<typeAliases>
    <package name="Mybatis"/>
 </typeAliases>
在UserMapperWithInterface.xml中的
     <select id="selectUser" resultType="Mybatis.User"> 变成了
        <select id="selectUser" resultType="User">

同时我们还实现了需要传参数的查询（通过用户名查询用户信息）