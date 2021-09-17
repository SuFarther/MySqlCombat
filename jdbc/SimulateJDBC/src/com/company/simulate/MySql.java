package com.company.simulate;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MySql
 * @company 公司
 * @Description MYSQL驱动
 * @createTime 2021年09月18日 06:18:18
 */
public class MySql implements Jdbc {
    @Override
    public void getConnection() {
        System.out.println("Mysql创建了连接");
    }
}
