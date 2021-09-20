package com.company.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JdbcAffair2
 * @company 公司
 * @Description JDBC账号转账演示事务
 *
 *  con.setAutoCommit(false);
 *  con.commit();
 *  con.rollback();
 *
 *  而批处理是：累积到一定数量，再一次性提交到数据库，减少了与数据库的交互次数，所以效率会大大提高
 *
 * 至于事务：事务指逻辑上的一组操作，组成这组操作的各个单元，要不全部成功，要不全部不成功，默认是关闭事务的。
 *
 * @createTime 2021年09月20日 21:45:45
 */
public class JdbcAffair2 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","123456");
            //将自动提交机制改为手动提交
            con.setAutoCommit(false);

            //修改数据
            String sql = "UPDATE  act SET  money = ? WHERE id = ?";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //给？占位符赋值
            ps.setDouble(1,1000);
            ps.setInt(2,1);
            int  count  = ps.executeUpdate();

            //给？重新赋值
            ps.setDouble(1,1000);
            ps.setInt(2,2);
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "转账成功" : "转账失败");

            //程序能够走到这里说明以上程序没有异常,事务结束,手动提交数据
            //提交事务
            con.commit();
        }catch (Exception e){
          if(con != null){
              try {
                  //如果连接出错,手动回滚异常
                  con.rollback();
              }catch (Exception e1){
                  e1.printStackTrace();
              }
          }
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
