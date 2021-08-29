/**
*   基础查询
*   进阶1: 基础查询
*  语法:
*  select 查询列表 from 表名
*  特点:  
*  1、查询的列表可以是： 表中的字段、常量值、表达式、函数
*  2、查询的是一个虚拟的表格
* 员工表 employees 数据库名 myemployees
*
*/

# 1、查询表中的单个字段
SELECT last_name FROM employees;

# 2、查询表中的多个字段
SELECT last_name,salary,email FROM employees;
# 3、 查询表中的所有字段 
SELECT last_name,first_name,last_name,email,phone_number,job_id,salary,commission_pct,manager_id,
department_id,hiredate FROM employees;

SELECT * FROM employees;
# 4、指定数据库
USE myemployees;

# 22 MYSQL基础,查询常量、表达数、函数 
#查询常量值 
SELECT 100;
SELECT 'John';

#查询常量
SELECT 100%98;

#查询函数 
SELECT VERSION();

/**
* 23 MYSQL起别名
* 1、便于理解
* 2、如果要查询的字段有重名的情况1,使用别名可以区分开来
*/

# 方式一 使用as
SELECT 100%98 AS 结果;
SELECT last_name AS 姓,first_name AS 名 FROM employees;

#方式二  使用空格
SELECT last_name 姓,first_name 名 FROM employees;


#24  MYSQL 基础_去重
# 案例: 查询员工表中涉及的部分编号 
SELECT DISTINCT department_id FROM employees;

/**
*
* 25 MYSQL基础+号作用 
*  MYSQL中的+号: 仅仅只有一个功能:运算符
*/

# 两个操作数都为整数型,则做加法运算  
SELECT 100+90;

# 其中一方为字符型,试图将字符型数值转换成数值型,如果转换成狗,则继续做加法运算
SELECT '123'+90;

# 如果转换失败,则将字符型数值转换成0 
SELECT 'join'+90;

# 只要其中一方为null,则结果肯定为null
 
 
# 27 MYSQL基础_使用concat实现连接
# 案例: 查询员工名和姓连接成一个字段并显示为姓名
SELECT CONCAT(last_name,first_name) AS 姓名 FROM employees;


# 测试
SELECT last_name,job_id,salary AS sal FROM employees;

select * from employees;

SELECT employee_id,last_name,salary*12 "ANNUAL SALARY" FROM employees;


#显示表 departments 的结构，并查询其中的全部数据
DESC departments;
SELECT * FROM departments;

# 显示出表 employees 中的全部 job_id（不能重复）
SELECT DISTINCT job_id FROM employees;


# 显示出表 employees 的全部列，各个列之间用逗号连接，列头显示成 OUT_PUT（我简写3个）
SELECT CONCAT(last_name,',',first_name) AS OUT_PUT FROM employees;