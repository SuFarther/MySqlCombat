package com.company.login;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcLogin
 * @company 公司
 * @Description 模拟用户名注册登陆
 * @createTime 2021年09月19日 21:57:57
 */
public class JdbcLogin {
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
        Statement stmt = null;
        ResultSet rs = null;


        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
            //获取数据库连接对象
            stmt = con.createStatement();
            //执行sql语句
            String sql = "SELECT * FROM user where username='"+loginName+"' AND password='"+loginPwd+"'";
            //获取查询结果集
            rs = stmt.executeQuery(sql);
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
                if(stmt!=null){
                    stmt.close();
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
