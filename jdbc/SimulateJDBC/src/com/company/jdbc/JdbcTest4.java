package com.company.jdbc;



import java.sql.*;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcTest4
 * @company 公司
 * @Description 处理查询结果集
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
 * 说明:  localhost和127.0.0.1都是本机IP地址
 *
 * idea
 * Project Structure->Moudles->Dependencies->JARs or directories找到
 * mysql-connector-java-8.0.26.jar 点击ok，然后勾上mysql-connector-java-8.0.26.jar就可以了
 * 这里是为了不报没有这个驱动的错误
 *
 * @createTime 2021年09月19日 13:28:28
 */
public class JdbcTest4 {

    public static void main(String[] args) {
       Statement stmt = null;
       Connection con = null;
       ResultSet  rs = null;

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
           String sql = "SELECT  * FROM student";
           //获取查询结果集
           rs = stmt.executeQuery(sql);
           //循环遍历
           while (rs.next()){
               //getString()方法的特点是: 不管数据库的数据类型是什么,都以String形成取出,JDBC所有下标都从1开始
               String id = rs.getString(1);
               String name = rs.getString(2);
               String age = rs.getString(3);
               String email = rs.getString(4);

               System.out.println(id+","+name+","+age+","+ email);


               //用列名比较好,这个不是以列的下标获取,以列的名字获取,如果字段重名后,列名字不是表中的列名字
//               String id2 = rs.getString("id");
//               String name2 = rs.getString("name");
//               String age2 = rs.getString("age");
//               String email2 = rs.getString("email");
//
//               System.out.println(id2+","+name2+","+age2+","+ email2);

               //除了可以以String类型取出之外,还可以以特定的类型取出
//               int id3 = rs.getInt("id");
//               String name3 = rs.getString("name");
//               int age3 = rs.getInt("age");
//               String email3 = rs.getString("email");
           }

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
               if (rs != null){
                   rs.close();
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
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
