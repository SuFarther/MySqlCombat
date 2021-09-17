package com.company.simulate;
import java.util.ResourceBundle;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JavaProgram
 * @company 公司
 * @Description JDBC不需要关心各大数据厂商如何实现的，
 * @createTime 2021年09月18日 06:21:21
 */
public class JavaProgram {

    public static void main(String[] args) throws Exception {
        //反射解决
//        Class<?> aa = Class.forName("com.company.Oracle");
//        Jdbc jdbc = (Jdbc) aa.newInstance();
//        jdbc.getConnection();


        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String className = bundle.getString("className");
        Class<?> cc = Class.forName(className);
        Jdbc jdbc = (Jdbc) cc.newInstance();
        jdbc.getConnection();
//        jdbc.getConnection();
    }

}
