package test;

import java.sql.*;

/**
 * @Author: Wdz
 * @Date 2020/9/9 14:39
 * @Description:
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://124.71.182.139:3306/school?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "issme108@";

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.向数据库发送SQL的对象Statement,PreparedStatement : CRUD
        Statement statement = connection.createStatement();

        //4.编写SQL
        String sql = "select * from student";

        //5.执行查询SQL，返回一个 ResultSet  ： 结果集
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            //student表
            System.out.print("id:" + rs.getObject("std_id"));
            System.out.print(" name:" + rs.getObject("std_name"));
            System.out.print(" sex:" + rs.getObject("std_sex"));
            System.out.print(" birth:" + rs.getObject("std_birth"));
            System.out.print(" in:" + rs.getObject("std_in"));
            System.out.println(" address:" + rs.getObject("std_address"));
        }

        //6.关闭连接，释放资源（一定要做） 先开后关
        rs.close();
        statement.close();
        connection.close();
    }

}
