package com.atguigu.cms.dao;

import com.atguigu.cms.javabean.Customer;
import com.atguigu.cms.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 赵伟风
 * Description: customer对应的数据库方法
 */
public class CustomerDao extends BaseDao {



    /**
     * 查询数据库客户集合
     * @return 返回数据库的数据对象集合
     */
    public List<Customer> findAll() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        return executeQuery(Customer.class, "select * from t_customer");
    }

    /**
     * 添加客户的方法
     * @param customer 客户对象
     */
    public void addCustomer(Customer customer) throws SQLException {

        String sql = "insert into t_customer(name,gender,age,salary,phone) values(?,?,?,?,?);";

        executeUpdate(sql, customer.getName(), customer.getGender(),
                customer.getAge(), customer.getSalary(), customer.getPhone());
    }


    /**
     * 修改对象信息
     * @param customer 客户对象
     * @return 影响行数
     */
    public  int updateById(Customer customer) throws SQLException {

        String sql = "update t_customer set name=?,gender=?,age=?,salary =? , phone = ? where id = ? ;";

        return executeUpdate(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getSalary(),
                customer.getPhone(), customer.getId());
    }

    /**
     * 根据id查询客户信息
     * @param id 索引
     * @return 客户
     */
    public Customer findById(int id) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        String sql = "select * from t_customer where id = ?;";

        List<Customer> customerList = executeQuery(Customer.class, sql, id);

        if (customerList != null && customerList.size() > 0) {
            return customerList.get(0);
        }

        return null;
    }

    public int removeById(int id) throws SQLException {

        String sql = "delete from t_customer where id = ?;";

        return executeUpdate(sql, id);
    }
}
