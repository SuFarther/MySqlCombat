package com.company.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcLogin4
 * @company 公司
 * @Description prepareStatement完成增删改
 * @createTime 2021年09月20日 20:51:51
 */
public class JdbcLogin4 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
//            String sql = "INSERT INTO student(id,name,age,email) values(?,?,?,?)";
//            //获取预编译数据库操作对象
//            ps = con.prepareStatement(sql);
//            //执行sql语句
//            ps.setInt(1,9);
//            ps.setString(2,"李保国");
//            ps.setInt(3,49);
//            ps.setString(4,"123@qq.com");
            //获取查询结果集
//            int  count = ps.executeUpdate();
//            System.out.println((count == 1)?("新增"+count+"条数据成功"):("新增"+count+"条数据失败"));


            //修改数据
//            String sql = "UPDATE student SET  name = ?,age = ?, email = ? WHERE id = 10";
//            //获取预编译数据库操作对象
//            ps = con.prepareStatement(sql);
//            //执行sql语句
//            ps.setString(1,"秋名山车神");
//            ps.setInt(2,26);
//            ps.setString(3,"166@qq.com");
//            //获取查询结果集
//            int  count = ps.executeUpdate();
//            System.out.println((count == 1)?("修改"+count+"条数据成功"):("修改"+count+"条数据失败"));

            //删除数据
            String sql = "DELETE  FROM student WHERE id = ?";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //执行sql语句
            ps.setInt(1 ,10);
            //获取查询结果集
            int  count = ps.executeUpdate();
            System.out.println((count == 1)?("删除"+count+"条数据成功"):("删除"+count+"条数据失败"));
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
