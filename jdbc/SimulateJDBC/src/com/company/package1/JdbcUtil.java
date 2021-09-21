package com.company.package1;

import java.sql.*;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcUtil
 * @company 公司
 * @Description JDBC工具类的封装
 * @createTime 2021年09月21日 08:19:19
 */
public class JdbcUtil {
    /**
     *
     *  工具类的构造方法是私有化的
     *  因为工具类当中的方法都是静态的，不需要new对象,直接采用类名调用
     *
     */
    private JdbcUtil(){}

    /**
     * 静态方法在类中只执行一次
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库操作对象
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
    }

    public void  close(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(ps != null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


class JdbcUtilTest{
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取数据库连接对象
            con = JdbcUtil.getConnection();
            String sql = "SELECT name FROM student WHERE name like ?";
            //处理预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //给占位符？设置
            ps.setString(1,"雪_%");
            //处理sql语句
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}