package com.company.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcTest2
 * @company 公司
 * @Description JBC执行删除和更新
 * 第一步: 注册驱动 (作用:告诉Java程序,即将要连接的是哪个品牌的数据库)
 * 第二步: 获取连接 (表示JVM的进程和数据库的进程之间通道打开了,这属于进程之间通信,重要级的,使用完后一定要关闭)
 * 第三步: 获取数据库连接对象(专门执行sql语句的对象)
 * 第四步: 执行sql语句(DQL DML)
 * 第五步: 处理查询结果集(只有当第四执行的是select语句的时候,才能有这第五步处理查询结果集)
 * 第六步: 释放资源(使用完资源后之后一定要关闭资源。Java和数据库属于进程间的通信,开启之后一定要关闭)
 *
 *
 * 注册驱动两种方式
 * 第一种注册驱动  Class.forName("com.mysql.jdbc.Driver");
 * 第二种注册驱动 DriverManager.registerDriver(com.mysql.jdbc.Driver);
 *
 *
 *
 * idea
 * Project Structure->Moudles->Dependencies->JARs or directories找到
 * mysql-connector-java-8.0.26.jar 点击ok，然后勾上mysql-connector-java-8.0.26.jar就可以了
 * 这里是为了不报没有这个驱动的错误
 *
 *
 *
 * @createTime 2021年09月19日 13:28:28
 */
public class JdbcTest2 {

    public static void main(String[] args) {
       Statement stmt = null;
       Connection con = null;

       try{
           //注册驱动
           Class.forName("com.mysql.cj.jdbc.Driver");
           //获取连接
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
           if (con!=null){
               System.out.println("数据库连接对象"+con);
           }
           //获取数据库连接对象
          stmt = con.createStatement();
           //执行sql语句
//           String sql = "DELETE  FROM student WHERE id = 6";
           String sql = "UPDATE student SET name='赵日天' WHERE id = 7";
           //获取查询结果集
           int count = stmt.executeUpdate(sql);
//           System.out.println(count == 1?("删除"+count+"条数据成功"):("删除"+count+"条数据失败"));
           System.out.println(count == 1?("修改"+count+"条数据成功"):("修改"+count+"条数据失败"));
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
               if (stmt != null){
                   stmt.close();
               }
           }catch (SQLException e){
               e.printStackTrace();
           }

           try {
               if (con != null){
                   con.close();
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
       }
    }
}
