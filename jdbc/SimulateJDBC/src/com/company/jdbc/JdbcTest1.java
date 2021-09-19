package com.company.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcTest1
 * @company 公司
 * @Description JDBC编程六步
 * 第一步: 注册驱动 (作用:告诉Java程序,即将要连接的是哪个品牌的数据库)
 * 第二步: 获取连接 (表示JVM的进程和数据库的进程之间通道打开了,这属于进程之间通信,重要级的,使用完后一定要关闭)
 * 第三步: 获取数据库连接对象(专门执行sql语句的对象)
 * 第四步: 执行sql语句(DQL DML)
 * 第五步: 处理查询结果集(只有当第四执行的是select语句的时候,才能有这第五步处理查询结果集)
 * 第六步: 释放资源(使用完资源后之后一定要关闭资源。Java和数据库属于进程间的通信,开启之后一定要关闭)
 *
 *
 * URL: 统一资源定位符(网络中某个资源绝对路径)
 * https://www.baidu.com 这就是URL
 * URL包括哪几个部分？
 * 协议 IP  Port 资源名
 * http://182.101.200.78:80/index.html
 * http://  通信协议
 * 182.101.200.78 服务器IP地址
 * 80 服务器软件端口
 * index.html 服务器⬆️某个资源
 *
 *
 * 注册驱动两种方式
 * 第一种注册驱动  Class.forName("com.mysql.jdbc.Driver");
 * 第二种注册驱动 DriverManager.registerDriver(com.mysql.jdbc.Driver);
 *
 * 说明:  localhost和127.0.0.1都是本机IP地址
 *
 * idea
 * Project Structure->Moudles->Dependencies->JARs or directories找到
 * mysql-connector-java-8.0.26.jar 点击ok，然后勾上mysql-connector-java-8.0.26.jar就可以了
 * 这里是为了不报没有这个驱动的错误
 *
 * @createTime 2021年09月19日 13:28:28
 */
public class JdbcTest1 {

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
           String sql = "INSERT INTO student(name,age,email) VALUES('猫2',31,'112@qq.com')";
           //获取查询结果集
           int count = stmt.executeUpdate(sql);
           System.out.println("新增:"+((count == 1)?1:0)+"数据成功");
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
