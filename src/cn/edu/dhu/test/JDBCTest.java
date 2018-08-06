package cn.edu.dhu.test;

import org.junit.Test;

import java.sql.*;

/**
 *
*/
public class JDBCTest {
    @Test
    public static void testJDBC() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jsbc:mysql://localhost:3306/wenda", "root", "2171821");
        //3.编写sql语句
        String sql = "select * from tb_user where username=? and password=?";
        //4.创建预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.设置参数（给占位符）
        preparedStatement.setString(1,"zhansan");
        preparedStatement.setString(2,"123456");
        //6.执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        //7.对结果集进行处理并且注意不要忘记关闭资源
        if (resultSet.next()) {
            System.out.println(sql);

        } else {
            System.out.println("账号或密码错误！");
        }
//        注意不要忘记关闭资源
        if (resultSet != null) resultSet.close();
        if (preparedStatement != null) preparedStatement.close();
        if (connection != null) connection.close();
    }
}
