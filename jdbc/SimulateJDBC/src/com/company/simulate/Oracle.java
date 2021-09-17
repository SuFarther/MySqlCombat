package com.company.simulate;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Oracle
 * @company 公司
 * @Description Oracle驱动
 * @createTime 2021年09月18日 06:18:18
 */
public class Oracle implements Jdbc {
    @Override
    public void getConnection() {
        System.out.println("Oracle创建了连接");
    }
}
