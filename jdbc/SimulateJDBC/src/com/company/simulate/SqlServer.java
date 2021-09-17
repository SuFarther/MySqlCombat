package com.company.simulate;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SqlServer
 * @company 公司
 * @Description SqlServer驱动
 * @createTime 2021年09月18日 06:18:18
 */
public class SqlServer implements Jdbc {
    @Override
    public void getConnection() {
        System.out.println("SqlServer创建了连接");
    }
}
