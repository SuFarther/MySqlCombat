package com.company.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcAffair
 * @company 公司
 * @Description JDBC事务机制
 * JDBC事务机制:
 *  1、JDBC的事务是自动提交的,什么是自动提交？
 *  只要执行任意一条DML语句,则自动提交一次,这是JDBC默认的事务行为
 *  但是在实际的业务中,通常都是N条DML语句共同联合才能完成的,必须保证他们这些DML语句在同一个事务中同时成功或同时失败
 *  2、以下程序先来验证一下JDBC的事务是否是自动提交机制！
 *
 *  测试结果: JDBC只要执行任意一条DML语句,就提交一次
 * @createTime 2021年09月20日 21:19:19
 */
public class JdbcAffair {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");

            //修改数据
            String sql = "UPDATE student SET name = ? WHERE  id = ?";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //执行sql语句
            ps.setString(1 ,"鬼见愁");
            ps.setInt(2,9);
            //获取查询结果集
            int  count = ps.executeUpdate();
            System.out.println((count == 1)?("修改"+count+"条数据成功"):("修改"+count+"条数据失败"));



            //执行sql语句
            ps.setString(1 ,"雪花女神龙");
            ps.setInt(2,8);
            //获取查询结果集
            int  count2 = ps.executeUpdate();
            System.out.println((count2 == 1)?("修改"+count2+"条数据成功"):("修改"+count2+"条数据失败"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
}
