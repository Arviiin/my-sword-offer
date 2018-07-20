package cn.edu.dhu.other.test;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    @Test
    public void login2(/*String username,String password*/) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//异常谁调用谁处理，此处我们选择抛出去，谁调用谁try，catch
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sharebike", "root", "2171821");
        //3.编写sql语句
        String sql = "select * from history_bike_status";//注意占位符如果是中文状态的会报错
        //4.创建预处理对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //5.设置参数（给占位符）
//        pstmt.setString(1, username);
//        pstmt.setString(2, password);
        //6.执行查询操作
        ResultSet rs = pstmt.executeQuery();
        //7.对结果集进行处理并且注意不要忘记关闭资源
        if (rs.next()) {
            System.out.println(sql);

        } else {
            System.out.println("账号或密码错误！");

        }
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();

    }
}
