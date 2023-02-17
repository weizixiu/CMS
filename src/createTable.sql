-- 员工表
use atguigu;
CREATE TABLE t_customer(
                           id INT PRIMARY KEY AUTO_INCREMENT COMMENT '客户主键',
                           NAME VARCHAR(20)  COMMENT '客户名称',
                           gender VARCHAR(4) COMMENT '客户性别',
                           age INT  COMMENT '客户年龄',
                           salary DOUBLE(8,1) COMMENT '客户工资',
  phone VARCHAR(11) COMMENT '客户电话')