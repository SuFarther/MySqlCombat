package com.company.login;

import java.sql.*;
import java.util.Scanner;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcLogin
 * @company 公司
 * @Description 演示Statement用途,京东分页
 * @createTime 2021年09月19日 21:57:57
 */
public class JdbcLogin3 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("输入desc或asc,desc是升序,asc是降序");
        System.out.print("请输入:");
        String keyword = scanner.nextLine();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
            //获取数据库连接对象
            stmt = con.createStatement();
            //执行sql语句
            String sql = "SELECT  * FROM student ORDER BY age "+keyword;
            //获取查询结果集
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while (rs.next()){
                System.out.println(rs.getString("age"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
