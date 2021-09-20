package com.company.login;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcLogin2
 * @company 公司
 * @Description 解决sql语句注入问题
 * 密码: fdsa '  or '1' = '1
 *
 *  导致SQL语句注入原因:
 *  以上正好完成sql语句的拼接,以下代码含义是,发送sql语句给DBMS,DBMS进行编译,正好将用户提供的"非法信息"编译进去。导致了原sql语句的含义被扭曲了
 *  用户输入的信息中含有sql语句的关键字，并且这些关键字参与Sql语句的编译过程,导致sql语句的原意被扭曲,进而达到sql语句的编译过程,导致sql语句的原意
 *  被扭曲，进而达到sql注入
 *
 *  只要用户信息不参与SQL编译,那么使用java.sql.PreparedStatement,PreparedStatement接口继承了java.sql.Statement
 *  PreparedStatement原理是: 预先对SQL框架进行编译,然后再给SQL语句传值
 *
 *
 * @createTime 2021年09月19日 21:57:57
 */
public class JdbcLogin2 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        //输出结果
        System.out.println(loginSuccess ? "登陆成功":"登陆失败");
    }

    private static boolean login(Map<String, String> userLoginInfo) {
        //定义标记
        boolean loginSuccess = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
            //执行sql语句
            //SQL语句的框子。其中一个？,代表一个占位符,一个？将来接收一个值"",注意占位符不能用单括号括起来
            String sql = "SELECT * FROM user where username=? AND password= ?";
            //获取预编译数据库操作对象
            //程序执行到此处，会发送sql语句到DBMS,然后DBMS进行sql语句进行预编译
            ps = con.prepareStatement(sql);
            //给占位符？传值（第一个问号是1,第二个问号下标是2,JDBC所有下标从1开始;
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //获取查询结果集
            rs = ps.executeQuery();
            //因为要获取一次账号密码一次,不要循环遍历
            if(rs.next()){
                loginSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                   rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(ps!=null){
                    ps.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(con!=null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  loginSuccess;
    }


    private static Map<String, String> initUI() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("用户名: ");
        String loginName = scanner.nextLine();
        System.out.print("密码:  ");
        String loginPwd = scanner.nextLine();
        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);
        return userLoginInfo;
    }
}
